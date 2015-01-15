/**
 * @version $Id$
 * Create date: Sep 2, 2014
 * Create by: daniellee
 * Copyright (c) 2013 UniqueSoft.
 * All rights reserved.
 */
package com.farkas.template;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 * @author daniellee
 * 
 */
public abstract class ExcelTemplate implements IExcelTemplate {

    private HSSFWorkbook workbook = null;
    private HSSFSheet sheet = null;
    private HSSFRow row = null;
    private HSSFCell cell = null;
    // Row numbers we need to create for excel template
    private int rowNum = 0;

    /**
     * set sheet title
     * 
     * @param title
     *            excel title
     * @return CreateExcel
     */
    public abstract ExcelTemplate setTitle(String title);

    /**
     * set header content
     * 
     * @return CreateExcel
     */
    public abstract ExcelTemplate setHead();

    /**
     * set cells data
     * 
     * @param datas
     *            tempate cell data
     * @return CreateExcel
     */
    public abstract ExcelTemplate setCellData(List<?> datas) throws Exception;

    /**
     * @return the sheet
     */
    public HSSFSheet getSheet() {
        return sheet;
    }

    /**
     * @param sheet
     *            the sheet to set
     */
    public void setSheet(HSSFSheet sheet) {
        this.sheet = sheet;
    }

    /**
     * @return the row
     */
    public HSSFRow getRow() {
        return row;
    }

    /**
     * @param row
     *            the row to set
     */
    public void setRow(HSSFRow row) {
        this.row = row;
    }

    /**
     * @return the cell
     */
    public HSSFCell getCell() {
        return cell;
    }

    /**
     * @param cell
     *            the cell to set
     */
    public void setCell(HSSFCell cell) {
        this.cell = cell;
    }

    /**
     * @return the workbook
     */
    public HSSFWorkbook getWorkbook() {
        return workbook;
    }

    /**
     * @param workbook
     *            the workbook to set
     */
    public void setWorkbook(HSSFWorkbook workbook) {
        this.workbook = workbook;
    }

    /**
     * @return the rowNum
     */
    public int getRowNum() {
        return rowNum;
    }

    /**
     * @return the rowNum
     */
    public int setRowNumIncrease() {
        return this.rowNum++;
    }

}
