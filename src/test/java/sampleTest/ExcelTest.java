/**
 * @version $Id$
 * Create date: Aug 19, 2014
 * Create by: daniellee
 * Copyright (c) 2013 UniqueSoft.
 * All rights reserved.
 */
package sampleTest;

import com.farkas.entity.ExcelTitle;
import com.farkas.utils.ExcelExportUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.util.*;


/**
 * @author daniellee
 * 
 */
public class ExcelTest {

    private static List<Student> students = new ArrayList<Student>();

    private static List<Course> courses = new ArrayList<Course>();

    private static List<StudentBean> studentBeans = new ArrayList<StudentBean>();

    private static List<Map<String, Object>> objectMapList = new ArrayList<Map<String, Object>>();

    @BeforeClass
    public static void before() {

        // generate students
        Student student1 = new Student();
        student1.setId("s1");
        student1.setName("student1");
        student1.setSex("man");
        student1.setBirthday(new Date());
        students.add(student1);

        Student student2 = new Student();
        student2.setId("s2");
        student2.setName("student2");
        student2.setSex("woman");
        student2.setBirthday(new Date());
        students.add(student2);

        // generate teacher
        Teacher teacher1 = new Teacher();
        teacher1.setId("t1");
        teacher1.setName("Teacher Liu");

        Teacher teacher2 = new Teacher();
        teacher2.setId("t2");
        teacher2.setName("Teacher Wang");

        // generate course
        Course course1 = new Course();
        course1.setId("c1");
        course1.setName("English");
        course1.setStudents(students);
        course1.setTeacher(teacher1);
        courses.add(course1);

        Course course2 = new Course();
        course2.setId("c2");
        course2.setName("Math");
        course2.setStudents(students);
        course2.setTeacher(teacher2);
        courses.add(course2);

        // StudentBean
        StudentBean studentBean = new StudentBean();
        studentBean.setStudent(student1);
        studentBean.setExtra(student1.getId());
        studentBeans.add(studentBean);

        StudentBean studentBean1 = new StudentBean();
        studentBean1.setStudent(student2);
        studentBean1.setExtra(student2.getId());
        studentBeans.add(studentBean1);

        // generate map list for multiple sheet in one workbook
        Map<String, Object> studentMap = new HashMap<String, Object>();
        studentMap.put("data", students);

        ExcelTitle studentTitle = new ExcelTitle();
        studentTitle.setTitle("Student");
        studentTitle.setSheetName("Student");
        studentMap.put("title", studentTitle);
        studentMap.put("entity", Student.class);

        Map<String, Object> courseMap = new HashMap<String, Object>();
        courseMap.put("data", courses);
        ExcelTitle courseTitle = new ExcelTitle();
        courseTitle.setTitle("Course");
        courseTitle.setSheetName("Course");
        courseMap.put("title", courseTitle);
        courseMap.put("entity", Course.class);

        objectMapList.add(studentMap);
        objectMapList.add(courseMap);

    }

    @AfterClass
    public static void after() {

    }

    /**
     * test create excel for single bean
     */
    @Test
    public void testStudent() {
        ExcelTitle excelTitle = new ExcelTitle();
        excelTitle.setTitle("Student");
        excelTitle.setSecondTitle("SecondTitle");
        excelTitle.setSheetName("StudentSheet");
        HSSFWorkbook workbook = ExcelExportUtil.exportExcel(excelTitle, Student.class, students);

        File excelFile = new File("abc.xls");
        FileOutputStream fOut;
        try {
            fOut = new FileOutputStream(excelFile);
            workbook.write(fOut);
            fOut.flush();
            fOut.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * test create excel for reference bean and Collection
     */
    @Test
    public void tesCourse() {
        ExcelTitle excelTitle = new ExcelTitle();
        excelTitle.setTitle("Course");
        excelTitle.setSecondTitle("Second Quarter Courses");
        excelTitle.setSheetName("CourseSheet");
        HSSFWorkbook workbook = ExcelExportUtil.exportExcel(excelTitle, Course.class, courses);

        File excelFile = new File("E:\\course.xls");
        FileOutputStream fOut;
        try {
            fOut = new FileOutputStream(excelFile);
            workbook.write(fOut);
            fOut.flush();
            fOut.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * test create excel which is one bean for different excel styles
     */
    @Test
    public void testStudentBean() {

        ExcelTitle excelTitle = new ExcelTitle();
        excelTitle.setTitle("StudentBean");
        excelTitle.setSecondTitle("StudentBean");
        excelTitle.setSheetName("StudentBeanSheet");
        HSSFWorkbook workbook = ExcelExportUtil.exportExcel(excelTitle, StudentBean.class, studentBeans);

        File excelFile = new File("E:\\studentBean.xls");
        FileOutputStream fOut;
        try {
            fOut = new FileOutputStream(excelFile);
            workbook.write(fOut);
            fOut.flush();
            fOut.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    /**
     * create multiple sheet in workbook
     */
    @Test
    public void testMultipleSheet() {
        HSSFWorkbook workbook = ExcelExportUtil.exportExcel(objectMapList);

        File excelFile = new File("E:\\mapListExcel.xls");
        FileOutputStream fOut;
        try {
            fOut = new FileOutputStream(excelFile);
            workbook.write(fOut);
            fOut.flush();
            fOut.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
