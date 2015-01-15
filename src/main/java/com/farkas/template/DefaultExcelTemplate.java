/**
 * @version $Id$
 * Create date: Sep 2, 2014
 * Create by: daniellee
 * Copyright (c) 2013 UniqueSoft.
 * All rights reserved.
 */
package com.farkas.template;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 * @author daniellee
 * 
 */
public class DefaultExcelTemplate extends ExcelTemplate {

    public DefaultExcelTemplate() {
        setWorkbook(new HSSFWorkbook());
    }

    @Override
    public void createSheet(String sheetName) {
        setSheet(getWorkbook().createSheet(sheetName));
    }

    @Override
    public void createRow() {
        setRow(getSheet().createRow(getRowNum()));
        setRowNumIncrease();
    }

    @Override
    public void createCell(int cellNum) {
        setCell(getRow().createCell(cellNum));
    }

    @Override
    public DefaultExcelTemplate setTitle(String title) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public DefaultExcelTemplate setHead() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public DefaultExcelTemplate setCellData(List<?> datas) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setCell(String data, int cellNum) {
        createCell(cellNum);
        HSSFCellStyle cellStyle = getWorkbook().createCellStyle();
        cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        getCell().setCellStyle(cellStyle);
        getCell().setCellValue(data);
    }
}
