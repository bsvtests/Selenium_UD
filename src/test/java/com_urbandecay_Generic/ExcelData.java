package com_urbandecay_Generic;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelData implements AutoConstant {

	public static String getData(String filepath,String sheet_name,int rn,int cn)
	{
		try
		{
			FileInputStream fis = new FileInputStream(new File(filepath));
			String data = WorkbookFactory.create(fis).getSheet(sheet_name).getRow(rn).getCell(cn).getStringCellValue();
			System.out.println("row and column in try block"+rn+" "+ cn);
			return data;
		}
		catch (Exception e) 
		{
			System.out.println("row and column"+rn+" "+ cn);
			System.out.println(e.getLocalizedMessage());
			return null;
		}
	}
	public static int getRowCount(String filepath,String sheet_name)
	{
		try
		{
			FileInputStream fis = new FileInputStream(new File(filepath));
			int rc = WorkbookFactory.create(fis).getSheet(sheet_name).getLastRowNum();
			return rc;
		}
		catch (Exception e) 
		{
			return 0;
		}

	}
	public static int getCellCount(String filepath, String sheet_name, int rn)
	{
		try
		{
			FileInputStream fis = new FileInputStream(new File(filepath));
			int cc = WorkbookFactory.create(fis).getSheet(sheet_name).getRow(rn).getLastCellNum();
			return cc ;
		}
		catch (Exception e) 
		{
			return 0;
		}


	}

}