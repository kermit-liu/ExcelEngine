
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
 * @param exportName
 * @param exportFieldWidth
 * @param exportFieldHeight
 * @param orderNum
 * @param needMerge
 * @param isWrap
 * @param exportType
 * @param databaseFormat
 * @param exportFormat
 * @author daniellee
 * @see ExcelCollection
 * @see ExcelEntity
 * @see ExcelIgnore
 * @see ExcelTarget
 * @since JDK1.5
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Documented
public @interface Excel {

    String exportName();

    int exportFieldWidth() default 10;

    int exportFieldHeight() default 10;

    String orderNum() default "0";

    boolean needMerge() default false;

    boolean isWrap() default true;

    int exportType() default 1;

    String databaseFormat() default "yyyyMMddHHmmss";

    String exportFormat() default "";

}
