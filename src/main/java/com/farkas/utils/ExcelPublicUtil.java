/**
 * @version $Id$
 * Create date: Aug 18, 2014
 * Create by: daniellee
 * Copyright (c) 2013 UniqueSoft.
 * All rights reserved.
 */
package com.farkas.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import com.farkas.annotation.Excel;
import com.farkas.annotation.ExcelCollection;
import com.farkas.annotation.ExcelEntity;
import com.farkas.annotation.ExcelIgnore;


/**
 * @author daniellee
 * 
 */
public class ExcelPublicUtil {

    public static String GET = "get";
    public static String SET = "set";

    /**
     * get all class field in recursive way
     * 
     * @param clazz
     * @return class and super class all fields field[]
     */
    public static Field[] getClassFields(Class<?> clazz) {
        List<Field> list = new ArrayList<Field>();
        Field[] fields;
        do {
            fields = clazz.getDeclaredFields();
            for (int i = 0; i < fields.length; i++) {
                list.add(fields[i]);
            }
            clazz = clazz.getSuperclass();
        } while (clazz != Object.class && clazz != null);
        return list.toArray(fields);
    }

    /**
     * Judge whether class is collection
     * 
     * @param clazz
     * @return
     */
    public static boolean isCollection(Class<?> clazz) {
        return clazz.isAssignableFrom(List.class) || clazz.isAssignableFrom(Set.class)
                || clazz.isAssignableFrom(Collection.class);
    }

    /**
     * method description goes here
     * 
     * @param field
     * @param targetId
     * @return
     */
    public static boolean isNotUserExcelUserThis(Field field, String targetId) {
        boolean boo = true;
        if (field.getAnnotation(ExcelIgnore.class) != null) {
            boo = true;
        } else if (boo && field.getAnnotation(ExcelCollection.class) != null
                && isUseInThis(field.getAnnotation(ExcelCollection.class).exportName(), targetId)) {
            boo = false;
        } else if (boo && field.getAnnotation(Excel.class) != null
                && isUseInThis(field.getAnnotation(Excel.class).exportName(), targetId)) {
            boo = false;
        } else if (boo && field.getAnnotation(ExcelEntity.class) != null
                && isUseInThis(field.getAnnotation(ExcelEntity.class).exportName(), targetId)) {
            boo = false;
        }
        return boo;
    }

    /**
     * Judge whether is use in this class
     * 
     * @param exportName
     * @param targetId
     * @return
     */
    private static boolean isUseInThis(String exportName, String targetId) {
        return targetId == null || exportName.equals("") || exportName.indexOf("_") < 0
                || exportName.indexOf(targetId) != -1;
    }

    /**
     * Judge whether is Java Base Class
     * 
     * @param field
     * @return
     */
    public static boolean isJavaClass(Field field) {
        Class<?> fieldType = field.getType();
        boolean isBaseClass = false;
        if (fieldType.isArray()) {
            isBaseClass = false;
        } else if (fieldType.isPrimitive() || fieldType.getPackage() == null
                || fieldType.getPackage().getName().equals("java.lang")
                || fieldType.getPackage().getName().equals("java.math")
                || fieldType.getPackage().getName().equals("java.util")) {
            isBaseClass = true;
        }
        return isBaseClass;
    }

    /**
     * Create a Object
     * 
     * @param clazz
     * @return
     */
    public static Object createObject(Class<?> clazz, String targetId) {
        Object obj = null;
        String fieldname;
        Method setMethod;
        try {
            obj = clazz.newInstance();
            Field[] fields = getClassFields(clazz);
            for (Field field : fields) {
                if (isNotUserExcelUserThis(field, targetId)) {
                    continue;
                }
                if (isCollection(field.getType())) {
                    ExcelCollection collection = field.getAnnotation(ExcelCollection.class);
                    fieldname = field.getName();
                    setMethod = getMethod(fieldname, clazz, field.getType());
                    setMethod.invoke(obj, ExcelPublicUtil.class.getClassLoader().loadClass(collection.type())
                            .newInstance());
                } else if (!isJavaClass(field)) {
                    fieldname = field.getName();
                    setMethod = getMethod(fieldname, clazz, field.getType());
                    setMethod.invoke(obj, createObject(field.getType(), targetId));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;

    }

    /**
     * get pojoClass method
     * 
     * @param name
     * @param pojoClass
     * @return
     * @throws Exception
     */
    public static Method getMethod(String name, Class<?> pojoClass) throws Exception {
        StringBuffer getMethodName = new StringBuffer(GET);
        getMethodName.append(name.substring(0, 1).toUpperCase());
        getMethodName.append(name.substring(1));
        return pojoClass.getMethod(getMethodName.toString(), new Class[] {});
    }

    /**
     * get pojoClass method
     * 
     * @param name
     * @param pojoClass
     * @param type
     * @return
     * @throws Exception
     */
    public static Method getMethod(String name, Class<?> pojoClass, Class<?> type) throws Exception {
        StringBuffer getMethodName = new StringBuffer(SET);
        getMethodName.append(name.substring(0, 1).toUpperCase());
        getMethodName.append(name.substring(1));
        return pojoClass.getMethod(getMethodName.toString(), new Class[] { type });
    }

}
