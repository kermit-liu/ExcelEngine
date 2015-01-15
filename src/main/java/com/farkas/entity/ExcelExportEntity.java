/**
 * @version $Id$
 * Create date: Aug 18, 2014
 * Create by: daniellee
 * Copyright (c) 2013 UniqueSoft.
 * All rights reserved.
 */
package com.farkas.entity;

import java.lang.reflect.Method;
import java.util.List;

/**
 * @author daniellee
 * 
 */
public class ExcelExportEntity {

    private int width;

    private int height;

    private String exportName;

    private int orderNum;

    private boolean isWrap;

    private boolean needMerge;

    private int type;

    private String databaseFormat;

    private String exportFormat;

    private Method getMethod;

    private List<Method> getMethods;

    private List<ExcelExportEntity> list;

    /**
     * @return the width
     */
    public int getWidth() {
        return width;
    }

    /**
     * @param width
     *            the width to set
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * @return the height
     */
    public int getHeight() {
        return height;
    }

    /**
     * @param height
     *            the height to set
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * @return the exportName
     */
    public String getExportName() {
        return exportName;
    }

    /**
     * @param exportName
     *            the exportName to set
     */
    public void setExportName(String exportName) {
        this.exportName = exportName;
    }

    /**
     * @return the orderNum
     */
    public int getOrderNum() {
        return orderNum;
    }

    /**
     * @param orderNum
     *            the orderNum to set
     */
    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }

    /**
     * @return the isWrap
     */
    public boolean isWrap() {
        return isWrap;
    }

    /**
     * @param isWrap
     *            the isWrap to set
     */
    public void setWrap(boolean isWrap) {
        this.isWrap = isWrap;
    }

    /**
     * @return the needMerge
     */
    public boolean isNeedMerge() {
        return needMerge;
    }

    /**
     * @param needMerge
     *            the needMerge to set
     */
    public void setNeedMerge(boolean needMerge) {
        this.needMerge = needMerge;
    }

    /**
     * @return the type
     */
    public int getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(int type) {
        this.type = type;
    }

    /**
     * @return the databaseFormat
     */
    public String getDatabaseFormat() {
        return databaseFormat;
    }

    /**
     * @param databaseFormat
     *            the databaseFormat to set
     */
    public void setDatabaseFormat(String databaseFormat) {
        this.databaseFormat = databaseFormat;
    }

    /**
     * @return the exportFormat
     */
    public String getExportFormat() {
        return exportFormat;
    }

    /**
     * @param exportFormat
     *            the exportFormat to set
     */
    public void setExportFormat(String exportFormat) {
        this.exportFormat = exportFormat;
    }

    /**
     * @return the getMethod
     */
    public Method getGetMethod() {
        return getMethod;
    }

    /**
     * @param getMethod
     *            the getMethod to set
     */
    public void setGetMethod(Method getMethod) {
        this.getMethod = getMethod;
    }

    /**
     * @return the getMethods
     */
    public List<Method> getGetMethods() {
        return getMethods;
    }

    /**
     * @param getMethods
     *            the getMethods to set
     */
    public void setGetMethods(List<Method> getMethods) {
        this.getMethods = getMethods;
    }

    /**
     * @return the list
     */
    public List<ExcelExportEntity> getList() {
        return list;
    }

    /**
     * @param list
     *            the list to set
     */
    public void setList(List<ExcelExportEntity> list) {
        this.list = list;
    }

}
