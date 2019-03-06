
package com.farkas.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Method;
import java.util.List;

/**
 * @author daniellee
 * 
 */
@Data
@Builder
@NoArgsConstructor(force = true)
@AllArgsConstructor
public class ExcelExportEntity {

    private int width;

    private int height;

    private String exportName;

    private int orderNum;

    private boolean isWrap;

    private boolean needMerge;

    private int type;

    private String databaseFormat;

    private String exportFormat;

    private Method getMethod;

    private List<Method> getMethods;

    private List<ExcelExportEntity> list;
}
