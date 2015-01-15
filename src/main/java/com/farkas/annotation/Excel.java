/**
 * @version $Id$
 * Create date: Aug 18, 2014
 * Create by: daniellee
 * Copyright (c) 2013 UniqueSoft.
 * All rights reserved.
 */
package com.farkas.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * The <code>Annotation</code> represents excel column, It can be applied for class fields.
 * This annotation just can be retained in runtime.
 * 
 * @author daniellee
 * 
 * @see ExcelCollection
 * @see ExcelEntity
 * @see ExcelIgnore
 * @see ExcelTarget
 * @param exportName
 * @param exportFieldWidth
 * @param exportFieldHeight
 * @param orderNum
 * @param needMerge
 * @param isWrap
 * @param exportType
 * @param databaseFormat
 * @param exportFormat
 * @since JDK1.5
 * 
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Documented
public @interface Excel {

    public String exportName();

    public int exportFieldWidth() default 10;

    public int exportFieldHeight() default 10;

    public String orderNum() default "0";

    public boolean needMerge() default false;

    public boolean isWrap() default true;

    public int exportType() default 1;

    public String databaseFormat() default "yyyyMMddHHmmss";

    public String exportFormat() default "";

}
