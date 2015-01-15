/**
 * @version $Id$
 * Create date: Aug 18, 2014
 * Create by: daniellee
 * Copyright (c) 2013 UniqueSoft.
 * All rights reserved.
 */
package com.farkas.entity;

import java.util.Map;

/**
 * @author daniellee
 * 
 */
public class ExcelCollectionParams {

    private String name;

    private Class<?> type;

    private Map<String, ExcelExportEntity> excelParams;

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the type
     */
    public Class<?> getType() {
        return type;
    }

    /**
     * @param type
     *            the type to set
     */
    public void setType(Class<?> type) {
        this.type = type;
    }

    /**
     * @return the excelParams
     */
    public Map<String, ExcelExportEntity> getExcelParams() {
        return excelParams;
    }

    /**
     * @param excelParams
     *            the excelParams to set
     */
    public void setExcelParams(Map<String, ExcelExportEntity> excelParams) {
        this.excelParams = excelParams;
    }
}
