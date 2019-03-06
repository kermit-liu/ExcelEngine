
package com.farkas.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.poi.hssf.util.HSSFColor;

/**
 * @author daniellee
 * 
 */
@Data
@Builder
@NoArgsConstructor(force = true)
@AllArgsConstructor
public class ExcelTitle {

    private String title;

    private String secondTitle;

    private String sheetName;

    private short color = HSSFColor.WHITE.index;

    private short headerColor = HSSFColor.SKY_BLUE.index;


}
