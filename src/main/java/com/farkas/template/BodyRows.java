package com.farkas.template;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class BodyRows extends AbstractRows {

    HSSFWorkbook wb = null;

    public BodyRows(HSSFWorkbook workbook) {
        super(workbook);
        this.wb = workbook;
    }

    @Override
    public Row createRow(int index) {
        return wb.getSheetAt(0).createRow(index);
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

    @Override
    public HSSFCellStyle getStyle() {
        HSSFCellStyle hcsCellStyle = (HSSFCellStyle) getCellStyle();
        hcsCellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        hcsCellStyle.setFillBackgroundColor(HSSFColor.BLUE.index);

        HSSFFont font = (HSSFFont) getFont();
        font.setColor(HSSFColor.BLUE.index);
        hcsCellStyle.setFont(font);
        return hcsCellStyle;
    }
}
