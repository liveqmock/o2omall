package com.hbird.common.utils.file;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Date;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.util.Assert;

import com.hbird.common.utils.DateHelper;

/**
 * The Excel Exporter to export data to excel.
 * 
 * @author ljz
 * @version 2014-12-14 上午10:12:41
 */
public class ExcelExporter {
    private final String DEFAULT_SHEET_NAME = "Sheet1";
    private String sheetName = DEFAULT_SHEET_NAME;
    private String[] cellNames;
    private String[] fieldNames;
    private OutputStream outputStream;
    private final SXSSFWorkbook workbook;
    private final Sheet sheet;
    private final CellStyle cellStyle;
    private final DataFormat dataFormat;
    private static final Log LOG = LogFactory.getLog(ExcelExporter.class);

    /**
     * 构建ExcelExporter
     * 
     * @param sheetName
     *            Sheet名称
     * @param cellNames
     *            列标题的数组
     * @param fieldNames
     *            数据对象的属性数组
     * @param outputStream
     *            输出流
     * @throws IllegalArgumentException
     *             if the argument is null
     */
    public ExcelExporter(String sheetName, String[] cellNames, String[] fieldNames, OutputStream outputStream)
            throws IllegalArgumentException {
        setSheetName(sheetName);
        setCellNames(cellNames);
        setFieldNames(fieldNames);
        setOutputStream(outputStream);

        // 构造工作薄
        this.workbook = new SXSSFWorkbook();
        // 创建sheet
        this.sheet = this.workbook.createSheet(this.sheetName);
        this.cellStyle = this.workbook.createCellStyle();
        this.dataFormat = this.workbook.createDataFormat();
        // 初始化Sheet表头
        initSheetHead();
    }

    /**
     * 追加数据，写入sheet尾部
     * 
     * @param datas
     * @return
     * @throws IOException
     */
    public <T> ExcelExporter append(Collection<T> datas) throws IOException {
        for (T data : datas) {
            Row dataRow = this.sheet.createRow(this.sheet.getLastRowNum() + 1);
            for (int i = 0; i < this.fieldNames.length; i++) {
                Cell cell = dataRow.createCell(i);
                Object value = this.getFiledValue(data, this.fieldNames[i]);
                setCellValue(cell, value);
            }
        }
        return this;
    }

    /**
     * Write out this workbook to an Outputstream, then close Outputstream.
     * 
     * @throws IOException
     */
    public void write() throws IOException {
        try {
            this.workbook.write(this.outputStream);
            this.workbook.dispose();
        } finally {
            if (null != this.outputStream) {
                this.outputStream.close();
            }
        }
    }

    /**
     * 初始化Sheet表头
     */
    private void initSheetHead() {
        Row headRow = this.sheet.createRow(0);
        for (int i = 0; i < this.cellNames.length; i++) {
            headRow.createCell(i).setCellValue(this.cellNames[i]);
        }
    }

    /**
     * 设置单元格的值
     * 
     * @param cell
     * @param value
     */
    private void setCellValue(Cell cell, Object value) {
        if (null == cell) {
            return;
        }

        if (null == value) {
            cell.setCellValue("");
        } else {
            if ((value instanceof Double) || (value instanceof Float)) {
                if (value.toString().length() > 11) { // 避免显示科学计数法
                    cell.setCellValue(ObjectUtils.toString(value));
                } else {
                    cell.setCellType(Cell.CELL_TYPE_NUMERIC);
                    cellStyle.setDataFormat(this.dataFormat.getFormat("0.00"));
                    cell.setCellStyle(cellStyle);
                    Double cellValue = Double.parseDouble(value.toString());
                    cell.setCellValue(cellValue);
                }
            } else if (value instanceof Long) {
                if (value.toString().length() > 11) {// 避免显示科学计数法
                    cell.setCellValue(ObjectUtils.toString(value));
                } else {
                    cell.setCellType(Cell.CELL_TYPE_NUMERIC);
                    Double cellValue = Double.parseDouble(value.toString());
                    cell.setCellValue(cellValue);
                }
            } else if ((value instanceof Integer) || (value instanceof Short)) {
                cell.setCellType(Cell.CELL_TYPE_NUMERIC);
                Double cellValue = Double.parseDouble(value.toString());
                cell.setCellValue(cellValue);
            } else if (value instanceof Date) {
                String cellValue = DateHelper.formatDateTime((Date) value);
                cell.setCellValue(cellValue);
            } else if (value instanceof Boolean) {
                Boolean booleanValue = (Boolean) value;
                String cellValue = booleanValue ? "是" : "否";
                cell.setCellValue(cellValue);
            } else {
                cell.setCellValue(ObjectUtils.toString(value));
            }
        }
    }

    /**
     * 使用反射获取对象的属性的值
     * 
     * @param data
     * @param fieldName
     * @return
     */
    private <T> Object getFiledValue(T data, String fieldName) {
        Object value = null;
        try {
            Field field = data.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            value = field.get(data);
        } catch (Exception e) {
            LOG.warn("getFiledValue fail,", e);
        }
        return value;
    }

    /**
     * @param sheetName
     *            the sheetName to set
     */
    private void setSheetName(String sheetName) {
        if (null != sheetName) {
            this.sheetName = sheetName;
        } else {
            LOG.debug("using default sheetName 'Sheet1'");
        }
    }

    /**
     * @param cellNames
     *            the cellNames to set
     */
    private void setCellNames(String[] cellNames) {
        Assert.notNull(cellNames, "cellNames must be not null");
        this.cellNames = cellNames;
    }

    /**
     * @param fieldNames
     *            the fieldNames to set
     */
    private void setFieldNames(String[] fieldNames) {
        Assert.notNull(fieldNames, "fieldNames must be not null");
        Assert.isTrue(this.cellNames.length == fieldNames.length, "fieldNames.length must be equal to cellNames.length");
        this.fieldNames = fieldNames;
    }

    /**
     * @param outputStream
     *            the outputStream to set
     */
    private void setOutputStream(OutputStream outputStream) {
        Assert.notNull(outputStream, "outputStream must be not null");
        this.outputStream = outputStream;
    }

    /**
     * @return the sheetName
     */
    public String getSheetName() {
        return this.sheetName;
    }

    /**
     * @return the fieldNames
     */
    public String[] getFieldNames() {
        return this.fieldNames;
    }

    /**
     * @return the cellNames
     */
    public String[] getCellNames() {
        return this.cellNames;
    }

}
