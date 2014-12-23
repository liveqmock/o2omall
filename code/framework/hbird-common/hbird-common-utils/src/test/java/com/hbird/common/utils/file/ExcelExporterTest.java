package com.hbird.common.utils.file;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.util.Assert;

/**
 * ExcelExporterTest
 * 
 * @author ljz
 * @version 2014-12-13 下午5:07:13
 */
public class ExcelExporterTest {
    private static final int PAGE_SIZE = 10000;
    private static final int MAX_PAGE = 20;

    // @Test
    public void testExcelExporter() {
        String sheetName = "Sheet测试";
        String[] cellNames = { "编号", "名字", "年龄", "级别", "分数", "是否可用", "创建时间" };
        List<MyObject> dataList = new ArrayList<MyObject>();
        for (int i = 0; i < PAGE_SIZE; i++) {
            dataList.add(new MyObject(10000000L + i, "名字" + i, 23, (short) 3, 5.07D, true, new Date()));
        }
        String[] fieldNames = { "id", "name", "age", "degree", "score", "available", "createTime" };
        OutputStream outputStream = null;

        try {
            outputStream = new FileOutputStream("D:/tmp/a.xlsx");
            ExcelExporter excelExporter = new ExcelExporter(sheetName, cellNames, fieldNames, outputStream);
            for (int i = 0; i < MAX_PAGE; i++) {
                excelExporter.append(dataList);
            }

            excelExporter.write();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testExcelExporterFailure() {
        String sheetName = "Sheet测试";
        String[] cellNames = { "编号", "名字", "年龄", "级别", "分数", "是否可用", "创建时间" };
        String[] fieldNames = { "id", "name", "age", "degree", "score", "available", "createTime" };
        OutputStream outputStream = null;// 空
        try {
            new ExcelExporter(sheetName, cellNames, fieldNames, outputStream);
        } catch (Exception e) {
            Assert.notNull(e);
        }
    }
}
