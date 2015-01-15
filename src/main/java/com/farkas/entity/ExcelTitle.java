/**
 * @version $Id$
 * Create date: Aug 18, 2014
 * Create by: daniellee
 * Copyright (c) 2013 UniqueSoft.
 * All rights reserved.
 */
package com.farkas.entity;

import org.apache.poi.hssf.util.HSSFColor;

/**
 * @author daniellee
 * 
 */
public class ExcelTitle {

    public ExcelTitle() {

    }

    /**
     * @param title
     * @param secondTitle
     * @param sheetName
     */
    public ExcelTitle(String title, String secondTitle, String sheetName) {
        this.title = title;
        this.secondTitle = secondTitle;
        this.sheetName = sheetName;
    }

    private String title;

    private String secondTitle;

    private String sheetName;

    private short color = HSSFColor.WHITE.index;

    private short headerColor = HSSFColor.SKY_BLUE.index;

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title
     *            the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the secondTitle
     */
    public String getSecondTitle() {
        return secondTitle;
    }

    /**
     * @param secondTitle
     *            the secondTitle to set
     */
    public void setSecondTitle(String secondTitle) {
        this.secondTitle = secondTitle;
    }

    /**
     * @return the sheetName
     */
    public String getSheetName() {
        return sheetName;
    }

    /**
     * @param sheetName
     *            the sheetName to set
     */
    public void setSheetName(String sheetName) {
        this.sheetName = sheetName;
    }

    /**
     * @return the color
     */
    public short getColor() {
        return color;
    }

    /**
     * @param color
     *            the color to set
     */
    public void setColor(short color) {
        this.color = color;
    }

    /**
     * @return the headerColor
     */
    public short getHeaderColor() {
        return headerColor;
    }

    /**
     * @param headerColor
     *            the headerColor to set
     */
    public void setHeaderColor(short headerColor) {
        this.headerColor = headerColor;
    }

}
