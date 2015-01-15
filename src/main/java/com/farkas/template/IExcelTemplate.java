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
    public void createSheet(String sheetName);

    /**
     * create one row
     */
    public void createRow();

    /**
     * create one cell
     * 
     * @param cellNum
     *            cell position
     */
    public void createCell(int cellNum);

    /**
     * set content to cell
     * 
     * @param data
     *            cell content
     * @param cellNum
     *            cell position
     */
    public void setCell(String data, int cellNum);
}
