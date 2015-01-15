/**
 * @version $Id: ExcelTemplate.java 8766 2014-09-02 03:51:23Z enixjin $
 * Create date: Aug 27, 2014
 * Create by: enixjin
 * Copyright (c) 2013 UniqueSoft.
 * All rights reserved.
 */
package com.uniquesoft.talanga.excel.templates;

import java.util.List;

/**
 * @author enixjin
 *
 */
public interface ExcelTemplate<T> {
    
    public int getHeight();
    
    public int getWidth();
    
    public int getDefaultCellHeight();
    
    public int getDefaultCellWidth();
    
    public List<String> getHeaders();

}
