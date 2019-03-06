/**
 * @version $Id$
 * Create date: Sep 2, 2014
 * Create by: daniellee
 * Copyright (c) 2013 UniqueSoft.
 * All rights reserved.
 */
package com.farkas.template;

/**
 * create excel sheet template
 * 
 * @author daniellee
 * 
 */
public interface IExcelTemplate {
    /**
     * create a sheet
     * 
     * @param sheetName
     *            sheet name
     */
    void createSheet(String sheetName);

    /**
     * create one row
     */
    void createRow();

    /**
     * create one cell
     * 
     * @param cellNum
     *            cell position
     */
    void createCell(int cellNum);

    /**
     * set content to cell
     * 
     * @param data
     *            cell content
     * @param cellNum
     *            cell position
     */
    void setCell(String data, int cellNum);
}
