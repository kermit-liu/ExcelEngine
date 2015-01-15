/**
 * @version $Id$
 * Create date: Aug 18, 2014
 * Create by: daniellee
 * Copyright (c) 2013 UniqueSoft.
 * All rights reserved.
 */
package com.farkas.entity;

import java.util.Comparator;

/**
 * @author daniellee
 * 
 */
public class ComparatorExcelField implements Comparator<ExcelExportEntity> {

    public int compare(ExcelExportEntity o1, ExcelExportEntity o2) {
        return o1.getOrderNum() - o2.getOrderNum();
    }

}
