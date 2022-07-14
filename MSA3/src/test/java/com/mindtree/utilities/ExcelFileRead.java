package com.mindtree.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFileRead
{
	public String fetchCellData(int row, char col)
	{
		Logging l = new Logging();
		String temp = "";
		try
		{
			FileInputStream file = new FileInputStream("./Excel Files/TestCaseData.xlsx");
			XSSFWorkbook wbook = new XSSFWorkbook(file);
			int k = wbook.getNumberOfSheets();
			for (int i = 0; i < k; i++)
			{
				if (wbook.getSheetName(i).equals("Sheet1"))
				{
					XSSFSheet sheet = wbook.getSheetAt(i);
					Iterator<Row> itr = sheet.iterator();
					int ro = 1;
					while (itr.hasNext())
					{
						char co = 'A';
						Row r = itr.next();
						Iterator<Cell> itc = r.iterator();
						while (itc.hasNext())
						{
							Cell c = itc.next();
							if (ro == row && co == col)
							{
								temp = c.getStringCellValue(); 
							}
							co++;
						}
						ro++;
					}
				}
			}
		}
		catch (FileNotFoundException f)
		{
			l.error("Specified excel file not found");
			f.getMessage();
		}
		catch (IOException e)
		{
			l.error("Could not load the excel file");
			e.getMessage();
		}
		return temp;
	}
}
