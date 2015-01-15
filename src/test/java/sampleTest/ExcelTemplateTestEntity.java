/**
 * @version $Id$
 * Create date: Sep 3, 2014
 * Create by: daniellee
 * Copyright (c) 2013 UniqueSoft.
 * All rights reserved.
 */
package sampleTest;

import java.util.Date;

import com.farkas.annotation.Excel;
import com.farkas.annotation.ExcelTarget;

/**
 * @author daniellee
 * 
 */
@ExcelTarget(id = "excelTarget")
public class ExcelTemplateTestEntity {

    @Excel(exportName = "index id1")
    private int index;
    @Excel(exportName = "name")
    private String name;
    @Excel(exportName = "age")
    private int age;
    @Excel(exportName = "date of birth")
    private Date date;
    @Excel(exportName = "comments")
    private String content;

    /**
     * @return the index
     */
    public int getIndex() {
        return index;
    }

    /**
     * @param index
     *            the index to set
     */
    public void setIndex(int index) {
        this.index = index;
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

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age
     *            the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content
     *            the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date
     *            the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

}
