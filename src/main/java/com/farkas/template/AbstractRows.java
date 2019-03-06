package com.farkas.template;

import org.apache.poi.ss.usermodel.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

public abstract class AbstractRows {

    Workbook wb = null;

    AbstractRows(Workbook wb) {
        this.wb = wb;
    }

    public final void create(List<String> cellValues, int index) {
        Row row = createRow(index);
        for (int i = 0; i < cellValues.size(); i++) {
            createCell(row, cellValues.get(i), i);
        }
    }

    public final void create(List<String> fieldList, List<Map<String, Object>> dataList) {
        for (int n = 0; n < dataList.size(); n++) {
            Row row = createRow(n);
            Map<String, Object> dataMap = dataList.get(n);
            for (int i = 0; i < fieldList.size(); i++) {
                createCell(row, objToString(dataMap.get(fieldList.get(i))), i);
            }
        }
    }

    public abstract Row createRow(int index);

    public abstract Cell createCell(Row row, String cellValue, int index);

    public CellStyle getStyle() {
        return wb.createCellStyle();
    }
    public CellStyle getCellStyle() {
        return wb.createCellStyle();
    }

    public Font getFont() {
        Font font = wb.createFont();
        return font;
    }

    private static String objToString(Object obj) {
        if (obj == null) {
            return "";
        } else {
            if (obj instanceof String) {
                return (String) obj;
            } else if (obj instanceof Date) {
                // DateUtil.dateToString((Date)
                // obj,DateUtil.DATESTYLE_SHORT_EX);
                return null;
            } else {
                return obj.toString();
            }
        }
    }

}
