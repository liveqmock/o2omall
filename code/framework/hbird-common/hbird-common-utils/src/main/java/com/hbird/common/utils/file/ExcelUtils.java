package com.hbird.common.utils.file;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.ObjectUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.springframework.util.Assert;

import com.hbird.common.utils.DateHelper;

/**
 * Excel助手类
 * 
 * @author ljz
 * @version 2014-8-18 下午8:26:56
 */
public class ExcelUtils {

    /**
     * 
     * @param sheetName
     *            Excel Sheet名
     * @param cellNames
     *            表头名
     * @param dataList
     *            数据
     * @param fieldNames
     *            数据属性集合，与表头一一对应
     * @param cellTypes
     *            单元格数据类型，与数据属性一一对应
     * @param outputStream
     *            输出流
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     * @throws NoSuchFieldException
     * @throws SecurityException
     * @throws IOException
     */
    public static <T> void exportFile(String sheetName, String[] cellNames, List<T> dataList, String[] fieldNames,
            int[] cellTypes, OutputStream outputStream) throws IllegalArgumentException, IllegalAccessException,
            NoSuchFieldException, SecurityException, IOException {
        Assert.notNull(sheetName, "sheetName must be not null");
        Assert.notNull(outputStream, "outputStream must be not null");
        Assert.notNull(cellNames, "cellNames must be not null");
        Assert.notNull(fieldNames, "fieldNames must be not null");
        Assert.isTrue(cellNames.length == fieldNames.length, "cellNames.length must be equal to fieldNames.length  ");

        if (ArrayUtils.isNotEmpty(cellTypes)) {
            Assert.isTrue(cellTypes.length == fieldNames.length,
                    "cellTypes.length must be equal to fieldNames.length  ");
        } else {
            cellTypes = new int[fieldNames.length];
            for (int i = 0; i < cellTypes.length; i++) {
                cellTypes[i] = Cell.CELL_TYPE_STRING;
            }
        }

        Assert.notEmpty(dataList, "dataList must be not empty");
        Assert.notNull(outputStream, "outputStream must be not null");

        // 构造工作薄
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
        HSSFCellStyle cellStyle = hssfWorkbook.createCellStyle();
        // 创建sheet
        HSSFSheet sheet = hssfWorkbook.createSheet(sheetName);
        // 表头
        HSSFRow headRow = sheet.createRow(0);

        for (int i = 0; i < cellNames.length; i++) {
            headRow.createCell(i).setCellValue(cellNames[i]);
        }

        // 表数据
        for (T data : dataList) {
            // 每一个store 就是一行数据
            HSSFRow dataRow = sheet.createRow(sheet.getLastRowNum() + 1);
            for (int i = 0; i < fieldNames.length; i++) {
                String fieldName = fieldNames[i];
                String cellValue = GetFiledValue(data, fieldName);
                HSSFCell cell = dataRow.createCell(i);
                cell.setCellType(cellTypes[i]);
                if (cellTypes[i] == 0) {
                    cell.setCellValue(Double.parseDouble(cellValue));
                    cellStyle.setDataFormat(hssfWorkbook.createDataFormat().getFormat("#,#0"));
                    cell.setCellStyle(cellStyle);
                } else {
                    cell.setCellValue(cellValue);
                }
            }
        }

        try {
            hssfWorkbook.write(outputStream);
        } finally {
            if (null != outputStream) {
                outputStream.close();
            }
        }
    }

    /**
     * GetFiledValue
     * 
     * @param data
     * @param fieldName
     * @return
     */
    private static <T> String GetFiledValue(T data, String fieldName) {
        String cellValue = "";
        try {
            Field field = data.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            Object value = field.get(data);
            if (null != value) {
                if (value instanceof Date) {
                    value = DateHelper.formatDateTime((Date) value);
                }
                cellValue = ObjectUtils.toString(value);
            }
        } catch (Exception egnore) {
        }
        return cellValue;
    }
}
