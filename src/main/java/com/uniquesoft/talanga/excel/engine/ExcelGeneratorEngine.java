/**
 * @version $Id: ExcelGeneratorEngine.java 8766 2014-09-02 03:51:23Z enixjin $
 * Create date: Aug 27, 2014
 * Create by: enixjin
 * Copyright (c) 2013 UniqueSoft.
 * All rights reserved.
 */
package com.uniquesoft.talanga.excel.engine;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import com.uniquesoft.talanga.excel.data.ColumnData;
import com.uniquesoft.talanga.excel.data.ExcelData;
import com.uniquesoft.talanga.excel.data.RowData;
import com.uniquesoft.talanga.excel.exceptions.GenericExcelGeneratorException;
import com.uniquesoft.talanga.excel.templates.ExcelTemplate;

/**
 * @author enixjin
 *
 */
public class ExcelGeneratorEngine {

    public static void generate(ExcelTemplate<?> excelTemplate, ExcelData excelDate)
            throws GenericExcelGeneratorException {
        HSSFWorkbook workbook = new HSSFWorkbook();

        // TODO where to get sheet info and name?
        Sheet sheet = workbook.createSheet("s1");

        // create header
        generateHeaders(sheet, excelTemplate);

        generateContents(sheet, excelDate);
    }

    /**
     * method description goes here
     * 
     * @param sheet
     * @param rows
     */
    private static void generateContents(Sheet sheet, ExcelData excelDate) {
        List<RowData> rows = excelDate.getData();

        for (int i = 0; i < rows.size(); i++) {
            Row eRow = sheet.createRow(i);
            List<ColumnData> currentColumns = rows.get(i).getColumn();
            for (int j = 0; j < currentColumns.size(); j++) {
                Cell eCell = eRow.createCell(j);
                eCell.setCellValue(currentColumns.get(j).getData());
            }
        }
    }

    /**
     * method description goes here
     * 
     * @param sheet
     * @param excelTemplate
     */
    private static void generateHeaders(Sheet sheet, ExcelTemplate<?> excelTemplate) {
        // TODO Auto-generated method stub

    }
}
