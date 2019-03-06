
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
 * @param exportName
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
public @interface ExcelEntity {
    String exportName() default "";
}
