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
 * The <code>Annotation</code> represents object reference, It can be applied for class
 * fields.
 * This annotation just can be retained in runtime.
 * 
 * @author daniellee
 * @see ExcelCollection
 * @see ExcelEntity
 * @see ExcelIgnore
 * @see ExcelTarget
 * @param exportName
 * @since JDK1.5
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Documented
public @interface ExcelEntity {
    public String exportName() default "";
}
