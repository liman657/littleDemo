package com.learn.execute;

import java.io.File;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Comment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * 
 * @author liman
 * @createtime 2018年7月30日
 * @contract 15528212893
 * @comment:
 *   取出文件中的括号
 */
public class Execute_Cancel_brackets {
	
	private static final String EXCEL_FILE_TYPE_OLD = "xls";
	
	private static final String EXCEL_FILE_TYPE_NEW = "xlsx";
	
	public static void cancelBrackets(File file) {
		//文件名
		String fileName = "";
		//文件后缀
		String fileSuffix = "";
		
		if(file !=null) {
			fileName = file.getName();
			fileSuffix = fileName.substring(fileName.lastIndexOf('.')+1);
			
			if(fileSuffix.equals(EXCEL_FILE_TYPE_OLD)) {//HSSF类型的excel
				dealHSSFFile(file);
			}
			
			if(fileSuffix.equals(EXCEL_FILE_TYPE_NEW)) {//XSSF类型的excel
				dealXSSDFile(file);
			}
		}else {
			System.out.println("文件不能为空");
		}
	}
	
	public static void dealHSSFFile(File file) {
		try {
			Workbook workbook = WorkbookFactory.create(file);
			String sheetName = workbook.getSheetName(0);
		} catch (Exception e) {
			System.out.println("文件处理异常："+e.getMessage());
		}
	}
	
	
	public static void dealXSSDFile(File file) {
		try {
			Workbook workbook = WorkbookFactory.create(file);
			Sheet sheet = workbook.getSheetAt(0);
			System.out.println("行数："+sheet.getLastRowNum());
			long startTime = System.currentTimeMillis();
			for(Row row : sheet) {
				Cell cell = row.getCell(4);
				String cellValue = cell.getStringCellValue();
				String regex = "\\（(.*?)\\）";
				String replaceAll = cellValue.replaceAll(regex, "");
				cell.setCellType(CellType.STRING);
				cell.setCellValue(replaceAll);
			}
			
			long endTime = System.currentTimeMillis();
			
			System.out.println("总耗时:"+(endTime-startTime)+"ms");
			
			workbook.write(new FileOutputStream(new File("修改后的文件.xlsx")));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("文件处理异常："+e.getMessage());
		}
	}

}
