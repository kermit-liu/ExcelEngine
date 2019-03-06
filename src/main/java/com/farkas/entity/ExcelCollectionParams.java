
package com.farkas.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * @author daniellee
 * 
 */
@Data
@Builder
@NoArgsConstructor(force = true)
@AllArgsConstructor
public class ExcelCollectionParams {

    private String name;

    private Class<?> type;

    private Map<String, ExcelExportEntity> excelParams;
}
