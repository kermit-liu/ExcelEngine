
package com.farkas.utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;

import com.farkas.annotation.ExcelTarget;
import com.farkas.entity.ExcelExportEntity;

/**
 * @author daniellee
 * @see ExcelExportUtil
 * 
 */
public class ExcelExportByTemplate {

    /**
     * export excel template and annotation data set
     * 
     * @param wokbook
     * @param sheet
     * @param pojoClass
     * @param dataSet
     * @param map
     * @return
     */
    public static Workbook exportExcel(HSSFWorkbook wokbook, HSSFSheet sheet, Class<?> pojoClass,
                                       Collection<?> dataSet, Map<String, Object> map) {
        return createSheetInUserModel2FileByTemplate(wokbook, sheet, pojoClass, dataSet, map);
    }

    /**
     * Just export excel template
     * 
     * @param wb
     * @param sheet
     * @param map
     * @return
     */
    public static Workbook exportExcel(HSSFWorkbook wb, HSSFSheet sheet, Map<String, Object> map) {
        return createSheetInUserModel2FileByTemplate(wb, sheet, null, null, map);
    }

    /**
     * method description goes here
     * 
     * @param wb
     * @param sheet
     * @param pojoClass
     * @param dataSet
     * @param map
     * @return
     */
    private static Workbook createSheetInUserModel2FileByTemplate(HSSFWorkbook wb, HSSFSheet sheet, Class<?> pojoClass,
                                                                  Collection<?> dataSet, Map<String, Object> map) {
        try {
            // step 1.parase sheet
            parseTemplate(sheet, map);
            if (dataSet != null) {
                // step 5. set data to template
                addDataToSheet(pojoClass, dataSet, sheet, wb);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return wb;
    }

    /**
     * method description goes here
     * 
     * @param sheet
     * @param map
     * @throws Exception
     */
    private static void parseTemplate(Sheet sheet, Map<String, Object> map) throws Exception {
        int rowIndex = 0;
        for (rowIndex = 0; rowIndex < sheet.getLastRowNum() + 1; rowIndex++) {
            Row row = sheet.getRow(rowIndex);
            for (int i = row.getFirstCellNum(); i < row.getLastCellNum(); i++) {
                setValueForCellByMap(row.getCell(i), map);
            }
        }
    }

    /**
     * set value for cell
     * 
     * @param cell
     * @param map
     */
    private static void setValueForCellByMap(Cell cell, Map<String, Object> map) throws Exception {
        String oldString;
        try {// step 1. function existed in this cell ?
            oldString = cell.getStringCellValue();
        } catch (Exception e) {
            return;
        }
        if (oldString != null && oldString.indexOf("{{") != -1) {
            // setp 2. {{ existed in this cell
            String params;
            while (oldString.indexOf("{{") != -1) {
                params = oldString.substring(oldString.indexOf("{{") + 2, oldString.indexOf("}}"));

                oldString = oldString.replace("{{" + params + "}}", getParamsValue(params.trim(), map));
            }
            cell.setCellValue(oldString);
        }
    }

    /**
     * get param value
     * 
     * @param params
     * @param map
     * @return
     */
    private static String getParamsValue(String params, Map<String, Object> map) throws Exception {
        if (params.indexOf(".") != -1) {
            String[] paramsArr = params.split("\\.");
            return getValueDoWhile(map.get(paramsArr[0]), paramsArr, 1);
        }
        return map.containsKey(params) ? map.get(params).toString() : "";
    }

    /**
     * get value
     * 
     * @param object
     * @param paramsArr
     * @param index
     * @return
     * @throws Exception
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     * @throws IllegalArgumentException
     */
    @SuppressWarnings("rawtypes")
    private static String getValueDoWhile(Object object, String[] paramsArr, int index) throws Exception {
        if (object == null) {
            return "";
        }
        if (object instanceof Map) {
            object = ((Map) object).get(paramsArr[index]);
        } else {
            object = ExcelPublicUtil.getMethod(paramsArr[index], object.getClass()).invoke(object, new Object[] {});
        }
        return (index == paramsArr.length - 1) ? (object == null ? "" : object.toString()) : getValueDoWhile(object,
                paramsArr, ++index);
    }

    /**
     * set data to sheet
     * 
     * @param params
     * @param pojoClass
     * @param dataSet
     * @param workbook
     */
    private static void addDataToSheet(Class<?> pojoClass, Collection<?> dataSet, Sheet sheet, Workbook workbook)
            throws Exception {
        List<ExcelExportEntity> excelParams = new ArrayList<ExcelExportEntity>();
        // get all fields
        Field fileds[] = ExcelPublicUtil.getClassFields(pojoClass);
        ExcelTarget etarget = pojoClass.getAnnotation(ExcelTarget.class);
        String targetId = null;
        if (etarget != null) {
            targetId = etarget.id();
        }
        ExcelExportUtil.getAllExcelField(targetId, fileds, excelParams, pojoClass, null);
        ExcelExportUtil.sortAllParams(excelParams);
        Iterator<?> its = dataSet.iterator();
        int index = sheet.getLastRowNum() + 1;
        while (its.hasNext()) {
            Object t = its.next();
            index += createCells(index, t, excelParams, sheet, workbook);
        }
    }

    /**
     * create main cells
     * 
     * @param styles
     * @throws Exception
     */
    private static int createCells(int index, Object t, List<ExcelExportEntity> excelParams, Sheet sheet,
                                   Workbook workbook) throws Exception {
        ExcelExportEntity entity;
        Row row = sheet.createRow(index);
        row.setHeight((short) 350);
        int maxHeight = 1, cellNum = 0;
        for (int k = 0, paramSize = excelParams.size(); k < paramSize; k++) {
            entity = excelParams.get(k);
            if (entity.getList() != null) {
                Collection<?> list = (Collection<?>) entity.getGetMethod().invoke(t, new Object[] {});
                int listC = 0;
                for (Object obj : list) {
                    createListCells(index + listC, cellNum, obj, entity.getList(), sheet, workbook);
                    listC++;
                }
                cellNum += entity.getList().size();
                if (list != null && list.size() > maxHeight) {
                    maxHeight = list.size();
                }
            } else {
                Object value = getCellValue(entity, t);
                if (entity.getType() != 2) {
                    createStringCell(row, cellNum++, value.toString(), entity, workbook);
                } else {
                    // TODO for other type file for example: image
                }
            }
        }
        // merge cell
        cellNum = 0;
        for (int k = 0, paramSize = excelParams.size(); k < paramSize; k++) {
            entity = excelParams.get(k);
            if (entity.getList() != null) {
                cellNum += entity.getList().size();
            } else if (entity.isNeedMerge()) {
                sheet.addMergedRegion(new CellRangeAddress(index, index + maxHeight - 1, cellNum, cellNum));
                cellNum++;
            }
        }
        return maxHeight;

    }

    /**
     * method description goes here
     * 
     * @param patriarch
     * @param index
     * @param cellNum
     * @param obj
     * @param excelParams
     * @param sheet
     * @param workbook
     * @throws Exception
     */
    private static void createListCells(int index, int cellNum, Object obj, List<ExcelExportEntity> excelParams,
                                        Sheet sheet, Workbook workbook) throws Exception {
        ExcelExportEntity entity;
        Row row;
        if (sheet.getRow(index) == null) {
            row = sheet.createRow(index);
            row.setHeight((short) 350);
        } else {
            row = sheet.getRow(index);
        }
        for (int k = 0, paramSize = excelParams.size(); k < paramSize; k++) {
            entity = excelParams.get(k);
            Object value = getCellValue(entity, obj);
            if (entity.getType() != 2) {
                createStringCell(row, cellNum++, value == null ? "" : value.toString(), entity, workbook);
            } else {
                // TODO for other type file for example: image
            }
        }
    }

    private static void createStringCell(Row row, int index, String text, ExcelExportEntity entity, Workbook workbook) {
        Cell cell = row.createCell(index);
        switch (entity.getType()) {
            case 1:
                RichTextString Rtext = new HSSFRichTextString(text);
                cell.setCellValue(Rtext);
                break;
            case 2:
                // TODO for other type file for example: image
                break;
        }
    }

    private static Object getCellValue(ExcelExportEntity entity, Object obj) throws Exception {
        Object value = entity.getGetMethods() != null ? ExcelExportUtil.getFieldBySomeMethod(entity.getGetMethods(),
                obj) : entity.getGetMethod().invoke(obj, new Object[] {});
        // step 1 data format
        if (StringUtils.isNotEmpty(entity.getExportFormat()) && StringUtils.isNotEmpty(entity.getDatabaseFormat())) {
            Date temp = null;
            if (value instanceof String) {
                SimpleDateFormat format = new SimpleDateFormat(entity.getDatabaseFormat());
                temp = format.parse(value.toString());
            } else if (value instanceof Date) {
                temp = (Date) value;
            }
            if (temp != null) {
                SimpleDateFormat format = new SimpleDateFormat(entity.getExportFormat());
                value = format.format(temp);
            }
        }
        return value == null ? "" : value.toString();
    }
}
