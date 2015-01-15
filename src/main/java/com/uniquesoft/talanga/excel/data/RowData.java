/**
 * @version $Id: RowData.java 8766 2014-09-02 03:51:23Z enixjin $
 * Create date: Sep 1, 2014
 * Create by: enixjin
 * Copyright (c) 2013 UniqueSoft.
 * All rights reserved.
 */
package com.uniquesoft.talanga.excel.data;

import java.util.List;

/**
 * @author enixjin
 *
 */
public interface RowData {
    
    public List<ColumnData> getColumn();

}
