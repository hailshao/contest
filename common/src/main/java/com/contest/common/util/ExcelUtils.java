package com.contest.common.util;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Closeable;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangsan
 */
public class ExcelUtils {
    private final static Logger logger = LoggerFactory.getLogger(ExcelUtils.class);

    private static CellStyle getTitleStyle(Workbook workbook) {
        CellStyle titleStyle = workbook.createCellStyle();
        Font fontTitle = workbook.createFont();
        fontTitle.setFontHeightInPoints((short) 10);
        fontTitle.setColor(HSSFColor.HSSFColorPredefined.BLACK.getIndex());
        fontTitle.setFontName("宋体");
        fontTitle.setBold(true);
        titleStyle.setFont(fontTitle);
        titleStyle.setAlignment(HorizontalAlignment.CENTER);
        titleStyle.setFillForegroundColor(IndexedColors.LIME.getIndex());
        titleStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        titleStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        //设置自动换行
        titleStyle.setWrapText(true);
        //下边框
        titleStyle.setBorderBottom(BorderStyle.THIN);
        titleStyle.setBorderLeft(BorderStyle.THIN);
        titleStyle.setBorderTop(BorderStyle.THIN);
        titleStyle.setBorderRight(BorderStyle.THIN);
        titleStyle.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        titleStyle.setLeftBorderColor(IndexedColors.BLACK.getIndex());
        titleStyle.setTopBorderColor(IndexedColors.BLACK.getIndex());
        titleStyle.setRightBorderColor(IndexedColors.BLACK.getIndex());
        return titleStyle;
    }

    /**
     * 导出Excel
     *
     * @param sheetName sheet名称
     * @param titles    标题
     * @param values    内容
     * @return
     */
    public static HSSFWorkbook getHssfWorkbook(String sheetName, String[][] titles, String[][] values) {

        // 第一步，创建一个HSSFWorkbook，对应一个Excel文件
        HSSFWorkbook wb = new HSSFWorkbook();

        // 第二步，在workbook中添加一个sheet,对应Excel文件中的sheet
        HSSFSheet sheet = wb.createSheet(sheetName);

        // 第四步，创建单元格，并设置值表头 设置表头居中
        CellStyle style = getTitleStyle(wb);

        // 声明列对象
        HSSFCell cell;

        for (int i = 0; i < titles.length; i++) {
            String[] title = titles[i];
            // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制
            HSSFRow row = sheet.createRow(i);
            // 创建标题
            for (int j = 0; j < title.length; j++) {
                cell = row.createCell(j);
                cell.setCellValue(title[j]);
                cell.setCellStyle(style);
            }
        }

        int titleTotalRow = titles.length;
        // 创建内容
        for (int i = 0; i < values.length; i++) {
            HSSFRow row = sheet.createRow(i + titleTotalRow);
            for (int j = 0; j < values[i].length; j++) {
                //将内容按顺序赋给对应的列对象
                row.createCell(j).setCellValue(values[i][j]);
            }
        }
        return wb;
    }

    /**
     * 导出Excel
     *
     * @param sheetName sheet名称
     * @param titles    标题
     * @param values    内容
     * @return
     */
    public static HSSFWorkbook getHssfWorkbook(String sheetName, String[] titles, String[][] values) {
        return getHssfWorkbook(sheetName, new String[][]{titles}, values);
    }

    /**
     * 合并单元格
     *
     * @param sheet     所在的sheet
     * @param startRow  开始行
     * @param endRow    结束行
     * @param startCell 开始列
     * @param endCell   结束列
     */
    public static void mergeCells(Sheet sheet, int startRow, int endRow, int startCell, int endCell) {
        sheet.addMergedRegion(new CellRangeAddress(startRow, endRow, startCell, endCell));
    }

    /**
     * 合并单元格
     *
     * @param sheet              所在的sheet
     * @param cellRangeAddresses 合并单元格范围
     */
    public static void mergeCells(Sheet sheet, List<CellRangeAddress> cellRangeAddresses) {
        for (CellRangeAddress cellRangeAddress : cellRangeAddresses) {
            sheet.addMergedRegion(cellRangeAddress);
        }
    }

    public static void writeDisk(Workbook wb, String filepath, String filename) {
        FileOutputStream output = null;
        try {
            //输出Excel文件1
            output = new FileOutputStream(filepath + filename);
            //写入磁盘
            wb.write(output);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        } finally {
            close(output);
        }
    }

    private static void close(Closeable output) {
        if (output != null) {
            try {
                output.close();
            } catch (IOException e) {
                logger.error(e.getMessage(), e);
            }
        }
    }

    public static void main(String[] args) {
        String[][] titles = new String[2][5];
        titles[0] = new String[]{"第一行1", "第一行1", "第一行2", "第一行3", "第一行4"};
        titles[1] = new String[]{"第二行1", "第二行2", "第二行3", "第二行4", "第二行5"};
        String[][] values = new String[][]{new String[]{"123", "456", "第一行", "第一行", "第一行"}, new String[]{"123", NumberUtils.doubleToString(777), "第一行", "第一行", "第一行"}};
        HSSFWorkbook workbook = ExcelUtils.getHssfWorkbook("测试", titles, values);
        List<CellRangeAddress> addressList = new ArrayList<>(16);
        //表头合并单元格
        CellRangeAddress addresses = new CellRangeAddress(0, 0, 0, 1);
        addressList.add(addresses);
        //第一行数据合并单元格
        addresses = new CellRangeAddress(2, 3, 0, 0);
        addressList.add(addresses);
        ExcelUtils.mergeCells(workbook.getSheetAt(0), addressList);
        ExcelUtils.writeDisk(workbook, "D:\\", "1.xls");
    }
}