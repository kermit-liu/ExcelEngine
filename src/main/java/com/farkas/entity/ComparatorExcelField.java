
package com.farkas.entity;

import java.util.Comparator;

/**
 * @author daniellee
 * 
 */
public class ComparatorExcelField implements Comparator<ExcelExportEntity> {

    @Override
    public int compare(ExcelExportEntity o1, ExcelExportEntity o2) {
        return o1.getOrderNum() - o2.getOrderNum();
    }

}
