package com.farkas.template;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class HeaderRows extends AbstractRows {

    HSSFWorkbook workbook = null;

    public HeaderRows(HSSFWorkbook workbook) {
        super(workbook);
        this.workbook = workbook;
    }

    @Override
    public Row createRow(int index) {
        return workbook.getSheetAt(0).createRow(index);
    }

    @Override
    public Cell createCell(Row row, String cellValue, int index) {
        HSSFRow hssfRow = (HSSFRow) row;
        HSSFCell cell = hssfRow.createCell(index);

        cell.setCellValue(cellValue);
        cell.setCellType(HSSFCell.CELL_TYPE_STRING);
        cell.setCellStyle(getStyle());
        return cell;
    }

}
