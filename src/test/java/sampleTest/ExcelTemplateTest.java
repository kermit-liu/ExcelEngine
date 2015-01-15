/**
 * @version $Id$
 * Create date: Sep 3, 2014
 * Create by: daniellee
 * Copyright (c) 2013 UniqueSoft.
 * All rights reserved.
 */
package sampleTest;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.farkas.utils.ExcelExportByTemplate;

/**
 * @author daniellee
 * 
 */
public class ExcelTemplateTest {
    private static List<ExcelTemplateTestEntity> entities = new ArrayList<ExcelTemplateTestEntity>();
    private static Map<String, Object> entityMap = new HashMap<String, Object>();

    @BeforeClass
    public static void before() {
        ExcelTemplateTestEntity a1 = new ExcelTemplateTestEntity();
        a1.setIndex(1);
        a1.setName("zhang");
        a1.setDate(new Date());
        a1.setContent("content1");
        a1.setAge(20);
        entities.add(a1);

        Map<String, Object> m1 = new HashMap<String, Object>();
        m1.put("index", "001");
        m1.put("name", "li1");
        m1.put("age", "10");
        m1.put("content", "content1");
        m1.put("date", new Date());
        entityMap.put("ExcelTemplateTestEntity1", m1);

        ExcelTemplateTestEntity a2 = new ExcelTemplateTestEntity();
        a2.setIndex(2);
        a2.setName("wang");
        a2.setDate(new Date());
        a2.setContent("content2");
        a2.setAge(22);
        entities.add(a2);

        Map<String, Object> m2 = new HashMap<String, Object>();
        m2.put("index", "002");
        m2.put("name", "li2");
        m2.put("age", "12");
        m2.put("content", "content2");
        m2.put("date", new Date());
        entityMap.put("ExcelTemplateTestEntity2", m2);

        Map<String, Object> m3 = new HashMap<String, Object>();
        m3.put("index", "003");
        m3.put("name", "li3");
        m3.put("age", "13");
        m3.put("content", "content3");
        m3.put("date", new Date());
        entityMap.put("ExcelTemplateTestEntity3", m3);

    }

    @AfterClass
    public static void after() {

    }

    @Test
    public void test() throws Exception {
        TempTest tt = new TempTest();

        ExcelExportByTemplate.exportExcel(tt.wb, tt.wb.getSheetAt(0), ExcelTemplateTestEntity.class, entities,
                entityMap);

        File excelFile = new File("E:\\ExcelTemplate2.xls");
        FileOutputStream fOut;
        try {
            fOut = new FileOutputStream(excelFile);
            tt.wb.write(fOut);
            fOut.flush();
            fOut.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
