/**
 * @version $Id$
 * Create date: Aug 19, 2014
 * Create by: daniellee
 * Copyright (c) 2013 UniqueSoft.
 * All rights reserved.
 */
package sampleTest;

import java.io.Serializable;

import com.farkas.annotation.Excel;


/**
 * @author daniellee
 * 
 */
public class Teacher implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private java.lang.String id;
    /** name */
    @Excel(exportName = "Teacher Name", orderNum = "2", needMerge = true)
    private String name;

    /**
     * @return the id
     */
    public java.lang.String getId() {
        return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(java.lang.String id) {
        this.id = id;
    }

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
}
