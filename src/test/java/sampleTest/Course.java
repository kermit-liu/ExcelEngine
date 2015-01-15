/**
 * @version $Id$
 * Create date: Aug 19, 2014
 * Create by: daniellee
 * Copyright (c) 2013 UniqueSoft.
 * All rights reserved.
 */
package sampleTest;

import java.io.Serializable;
import java.util.List;

import com.farkas.annotation.Excel;
import com.farkas.annotation.ExcelCollection;
import com.farkas.annotation.ExcelEntity;


/**
 * @author daniellee
 * 
 */
public class Course implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private String id;

    @Excel(exportName = "Course Name", orderNum = "1", needMerge = true)
    private String name;

    @ExcelEntity()
    private Teacher teacher;

    @ExcelCollection(exportName = "Student", orderNum = "4")
    private List<Student> students;

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
     * @return the teacher
     */
    public Teacher getTeacher() {
        return teacher;
    }

    /**
     * @param teacher
     *            the teacher to set
     */
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    /**
     * @return the students
     */
    public List<Student> getStudents() {
        return students;
    }

    /**
     * @param students
     *            the students to set
     */
    public void setStudents(List<Student> students) {
        this.students = students;
    }

}
