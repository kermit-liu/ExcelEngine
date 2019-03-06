package com.farkas.template;

import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.util.List;
import java.util.Map;

public final class DefaultExcelWorkbookTemplate {

    protected HSSFWorkbook workbook = null;

    protected HSSFSheet sheet = null;

    private String sheetName = null;

    private AbstractRows header = null;

    private AbstractRows body = null;

    /**
     * @return the header
     */
    public AbstractRows getHeader() {
        return header;
    }

    /**
     * @param header
     *            the header to set
     */
    public void setHeader(AbstractRows header) {
        this.header = header;
    }

    /**
     * @return the body
     */
    public AbstractRows getBody() {
        return body;
    }

    /**
     * @param body
     *            the body to set
     */
    public void setBody(AbstractRows body) {
        this.body = body;
    }

    public final void create(List<String> headList, List<String> fieldList, List<Map<String, Object>> dataList) {
        createWorkbook();
        createSheet();
        createHeader(headList, header);
        createBody(fieldList, dataList, body);
    }

    private void createWorkbook() {
        if (null == workbook) {
            workbook = new HSSFWorkbook();
        }
    }

    private void createSheet() {
        if (null == sheetName) {
            sheet = workbook.createSheet();
        } else {
            sheet = workbook.createSheet(sheetName);
        }
    }

    /**
     * @param headList
     * @param abstractRows
     */
    public void createHeader(List<String> headList, AbstractRows abstractRows) {
        if (null != abstractRows) {
            abstractRows.create(headList, 0);
        }
    }

    /**
     * @param fieldList
     * @param dataList
     * @param abstractRows
     */
    public void createBody(List<String> fieldList, List<Map<String, Object>> dataList, AbstractRows abstractRows) {
        abstractRows.create(fieldList, dataList);
    }

    // public HSSFCellStyle getStyle() {
    // return workbook.createCellStyle();
    // };

    public void setSheetName(String name) {
        sheetName = name;
    }

    public String getSheetName() {
        return sheetName;
    }

    public HSSFWorkbook getWorkbook() {
        return workbook;
    }

    public HSSFRow getRow(int index) {
        return sheet.createRow(index);
    }

    // public HSSFCellStyle getCellStyle() {
    // return workbook.createCellStyle();
    // }

    public HSSFFont getFont() {
        return workbook.createFont();
    }
}
