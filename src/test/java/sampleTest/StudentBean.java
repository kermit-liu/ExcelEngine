/**
 * @version $Id$
 * Create date: Aug 19, 2014
 * Create by: daniellee
 * Copyright (c) 2013 UniqueSoft.
 * All rights reserved.
 */
package sampleTest;

import com.farkas.annotation.Excel;
import com.farkas.annotation.ExcelEntity;

/**
 * @author daniellee
 * 
 */
public class StudentBean {

    @Excel(exportName = "BeanExtends")
    private String extra;

    @ExcelEntity()
    private Student student;

    /**
     * @return the extra
     */
    public String getExtra() {
        return extra;
    }

    /**
     * @param extra
     *            the extra to set
     */
    public void setExtra(String extra) {
        this.extra = extra;
    }

    /**
     * @return the student
     */
    public Student getStudent() {
        return student;
    }

    /**
     * @param student
     *            the student to set
     */
    public void setStudent(Student student) {
        this.student = student;
    }

}
