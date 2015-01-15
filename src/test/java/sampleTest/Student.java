/**
 * @version $Id$
 * Create date: Aug 19, 2014
 * Create by: daniellee
 * Copyright (c) 2013 UniqueSoft.
 * All rights reserved.
 */
package sampleTest;

import java.io.Serializable;
import java.util.Date;

import com.farkas.annotation.Excel;


/**
 * @author daniellee
 * 
 */
public class Student implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private String id;
    @Excel(exportName = "Student Name")
    private String name;

    @Excel(exportName = "Student Sex")
    private String sex;

    @Excel(exportName = "Day of birth", exportFormat = "yyyy-MM-dd")
    private Date birthday;

    private Course course;

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(String id) {
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

    /**
     * @return the sex
     */
    public String getSex() {
        return sex;
    }

    /**
     * @param sex
     *            the sex to set
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * @return the birthday
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * @param birthday
     *            the birthday to set
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * @return the course
     */
    public Course getCourse() {
        return course;
    }

    /**
     * @param course
     *            the course to set
     */
    public void setCourse(Course course) {
        this.course = course;
    }
}
