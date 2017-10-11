package com.hellozjf.test.poi;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * Hello world!
 *
 */
public class App {
    
    public static final Log LOG = LogFactory.getLog(App.class);
    
    public static void read2() throws Exception {
        File file = new File("Contract.xls");
        FileInputStream in = new FileInputStream(file);
        Workbook workbook = WorkbookFactory.create(in);
        int sheetCount = workbook.getNumberOfSheets();
        if (sheetCount != 1) {
            LOG.debug("sheetCount != 1");
        }
        
        Sheet sheet = workbook.getSheetAt(0);
        List<Example> list = new ArrayList<>();
        int rowCount = sheet.getPhysicalNumberOfRows();
        LOG.debug("rowCount=" + rowCount);
        for (int r = 1; r < rowCount; r++) {
            Row row = sheet.getRow(r);
            System.out.println(row.getCell(0).getStringCellValue());
        }
    }
    
    public static void read() throws Exception {
        
        SimpleDateFormat fmt = new SimpleDateFormat("MM/dd/yyyy");
        File file = new File("Example.xls");
        FileInputStream in = new FileInputStream(file);
        Workbook workbook = WorkbookFactory.create(in);
        int sheetCount = workbook.getNumberOfSheets();
        if (sheetCount != 1) {
            LOG.debug("sheetCount != 1");
        }
        
        Sheet sheet = workbook.getSheetAt(0);
        List<Example> list = new ArrayList<>();
        int rowCount = sheet.getPhysicalNumberOfRows();
        for (int r = 1; r < rowCount; r++) { 
            Row row = sheet.getRow(r);
            Example example = new Example();
            example.setId(row.getCell(0).getStringCellValue());
            example.setName(row.getCell(1).getStringCellValue());
            example.setDate(fmt.parse(row.getCell(2).getStringCellValue()));
            example.setValue(row.getCell(3).getNumericCellValue());
            example.setCombo(row.getCell(4).getStringCellValue());
            example.setString(row.getCell(5).getStringCellValue());
            list.add(example);
        }
        
        LOG.debug(list);
    }
    
    public static void writeHeader(HSSFSheet sheet) throws Exception {
        HSSFRow row = sheet.createRow((int) 0);
        HSSFCell cellID = row.createCell(0);
        HSSFCell cellName = row.createCell(1);
        HSSFCell cellDate = row.createCell(2);
        HSSFCell cellValue = row.createCell(3);
        HSSFCell cellCombo = row.createCell(4);
        HSSFCell cellString = row.createCell(5);
        cellID.setCellValue("ID");
        cellName.setCellValue("Name");
        cellDate.setCellValue("Date");
        cellValue.setCellValue("Value");
        cellCombo.setCellValue("Combo");
        cellString.setCellValue("String");
    }
    
    public static void writeBody1(HSSFSheet sheet) throws Exception {
        HSSFRow row = sheet.createRow((int) 1);
        HSSFCell cellID = row.createCell(0);
        HSSFCell cellName = row.createCell(1);
        HSSFCell cellDate = row.createCell(2);
        HSSFCell cellValue = row.createCell(3);
        HSSFCell cellCombo = row.createCell(4);
        HSSFCell cellString = row.createCell(5);
        cellID.setCellValue("1");
        cellName.setCellValue("A");
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(GregorianCalendar.YEAR, 2017);
        gregorianCalendar.set(GregorianCalendar.MONTH, 9 - 1);
        gregorianCalendar.set(GregorianCalendar.DAY_OF_MONTH, 27);
        Date date = gregorianCalendar.getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("M/d/yyyy");
        cellDate.setCellValue(simpleDateFormat.format(date));
        cellValue.setCellValue(19.99);
        cellCombo.setCellValue("甲");
        cellString.setCellValue("甲A\n甲AA");
    }
    
    public static void writeBody2(HSSFSheet sheet) throws Exception {
        HSSFRow row = sheet.createRow((int) 2);
        HSSFCell cellID = row.createCell(0);
        HSSFCell cellName = row.createCell(1);
        HSSFCell cellDate = row.createCell(2);
        HSSFCell cellValue = row.createCell(3);
        HSSFCell cellCombo = row.createCell(4);
        HSSFCell cellString = row.createCell(5);
        cellID.setCellValue("2");
        cellName.setCellValue("B");
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(GregorianCalendar.YEAR, 2017);
        gregorianCalendar.set(GregorianCalendar.MONTH, 10 - 1);
        gregorianCalendar.set(GregorianCalendar.DAY_OF_MONTH, 1);
        Date date = gregorianCalendar.getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("M/d/yyyy");
        cellDate.setCellValue(simpleDateFormat.format(date));
        cellValue.setCellValue(37.58);
        cellCombo.setCellValue("乙");
        cellString.setCellValue("乙A\n甲AA");
    }
    
    public static void write() throws Exception {
        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet = wb.createSheet("sheet 1");
        writeHeader(sheet);
        writeBody1(sheet);
        writeBody2(sheet);
        FileOutputStream fos = new FileOutputStream("Example2.xls");
        wb.write(fos);
        fos.close();
    }
    
    public static void main(String[] args) throws Exception {
        read2();
    }
}
