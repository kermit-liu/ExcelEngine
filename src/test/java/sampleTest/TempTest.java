/**
 * @version $Id$
 * Create date: Sep 3, 2014
 * Create by: daniellee
 * Copyright (c) 2013 UniqueSoft.
 * All rights reserved.
 */
package sampleTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;

import com.farkas.template.DefaultExcelWorkbookTemplate;
import com.farkas.template.BodyRows;
import com.farkas.template.HeaderRows;

/**
 * @author daniellee
 * 
 */
public class TempTest {

    public HSSFWorkbook wb = null;

    public TempTest() throws Exception {
        this.wb = TempTest.createExcel1(getHeadList(), getFieldList(), getDataList());

    }

    private List<Map<String, Object>> getDataList() {

        List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
        Map<String, Object> map1 = new HashMap<String, Object>();
        map1.put("index", "{{ExcelTemplateTestEntity1.index}}");
        map1.put("name", "{{ExcelTemplateTestEntity1.name}}");
        map1.put("age", "{{ExcelTemplateTestEntity1.age}}");
        map1.put("content", "{{ExcelTemplateTestEntity1.content}}");
        map1.put("date", "{{ExcelTemplateTestEntity1.date}}");
        dataList.add(map1);

        Map<String, Object> map2 = new HashMap<String, Object>();
        map2.put("index", "{{ExcelTemplateTestEntity2.index}}");
        map2.put("name", "{{ExcelTemplateTestEntity2.name}}");
        map2.put("age", "{{ExcelTemplateTestEntity2.age}}");
        map2.put("content", "{{ExcelTemplateTestEntity2.content}}");
        map2.put("date", "{{ExcelTemplateTestEntity2.date}}");
        dataList.add(map2);

        return dataList;
    }

    /**
     * test
     * 
     * @return
     */
    private List<String> getHeadList() {
        List<String> headList = new ArrayList<String>();
        headList.add("index id");
        headList.add("name");
        headList.add("age");
        headList.add("date of birth");
        headList.add("comments");

        return headList;
    }

    private List<String> getFieldList() {
        List<String> fieldList = new ArrayList<String>();
        fieldList.add("index");
        fieldList.add("name");
        fieldList.add("age");
        fieldList.add("date");
        fieldList.add("content");

        return fieldList;
    }

    public static HSSFWorkbook createExcel1(List<String> headList, List<String> fieldList,
                                            List<Map<String, Object>> dataList) throws Exception {

        DefaultExcelWorkbookTemplate wbTemplate = new DefaultExcelWorkbookTemplate();
        wbTemplate.setSheetName("Test");
        wbTemplate.setHeader(new HeaderRows(wbTemplate.getWorkbook()));
        wbTemplate.setBody(new BodyRows(wbTemplate.getWorkbook()));
        wbTemplate.create(headList, fieldList, dataList);

        return wbTemplate.getWorkbook();
    }

    public static HSSFWorkbook createExcel(List<String> headList, List<String> fieldList,
                                           List<Map<String, Object>> dataList) throws Exception {
        HSSFWorkbook workbook = new HSSFWorkbook();

        HSSFSheet sheet = workbook.createSheet();
        HSSFRow row = sheet.createRow(0);
        // ===============================================================
        for (int i = 0; i < headList.size(); i++) {
            HSSFCell cell = row.createCell(i);
            cell.setCellType(HSSFCell.CELL_TYPE_STRING);
            cell.setCellValue(headList.get(i));
        }
        // ===============================================================

        for (int n = 0; n < dataList.size(); n++) {
            HSSFRow row_value = sheet.createRow(n + 1);
            Map<String, Object> dataMap = dataList.get(n);
            // ===============================================================
            for (int i = 0; i < fieldList.size(); i++) {
                HSSFCell cell = row_value.createCell(i);
                cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                HSSFCellStyle hcsCellStyle = workbook.createCellStyle();
                hcsCellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
                hcsCellStyle.setFillBackgroundColor(HSSFColor.BLUE.index);
                HSSFFont font = workbook.createFont();
                font.setColor(HSSFColor.BLUE.index);
                hcsCellStyle.setFont(font);
                cell.setCellStyle(hcsCellStyle);
                cell.setCellValue(objToString(dataMap.get(fieldList.get(i))));
            }
            // ===============================================================
        }

        return workbook;
    }

    private static String objToString(Object obj) {
        if (obj == null) {
            return "";
        } else {
            if (obj instanceof String) {
                return (String) obj;
            } else if (obj instanceof Date) {
                return null;// DateUtil.dateToString((Date)
                            // obj,DateUtil.DATESTYLE_SHORT_EX);
            } else {
                return obj.toString();
            }
        }
    }

}
