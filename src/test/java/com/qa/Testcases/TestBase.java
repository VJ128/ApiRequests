package com.qa.Testcases;

import java.io.File;
import java.util.ResourceBundle;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class TestBase 
{
int StatusCode_200=200;
int StatusCode_201=201;
public String geturl() 
{
	ResourceBundle rb=ResourceBundle.getBundle("config");
	String url= rb.getString("url");
	return url;
}
public String geturl1() 
{
	ResourceBundle rb=ResourceBundle.getBundle("config");
	String url= rb.getString("url1");
	return url;
}
public String geturl2() 
{
	ResourceBundle rb=ResourceBundle.getBundle("config");
	String url= rb.getString("url2");
	return url;
}
public String geturl3() 
{
	ResourceBundle rb=ResourceBundle.getBundle("config");
	String url= rb.getString("url3");
	return url;
}
public String geturl4() 
{
	ResourceBundle rb=ResourceBundle.getBundle("config");
	String url= rb.getString("url4");
	return url;
}

//Get Excel data
public String[][] getTableArray(String xlFilePath, String sheetName, String tableName) throws Exception{
    String[][] tabArray=null;
    
        Workbook workbook = Workbook.getWorkbook(new File(xlFilePath));
        Sheet sheet = workbook.getSheet(sheetName); 
        int startRow,startCol, endRow, endCol,ci,cj;
        Cell tableStart=sheet.findCell(tableName);
        startRow=tableStart.getRow();
        startCol=tableStart.getColumn();

        Cell tableEnd= sheet.findCell(tableName, startCol+1,startRow+1, 100, 64000,  false);                

        endRow=tableEnd.getRow();
        endCol=tableEnd.getColumn();
     /*   System.out.println("startRow="+startRow+", endRow="+endRow+", " +
                "startCol="+startCol+", endCol="+endCol);*/
        tabArray=new String[endRow-startRow-1][endCol-startCol-1];
        ci=0;

        for (int i=startRow+1;i<endRow;i++,ci++){
            cj=0;
            for (int j=startCol+1;j<endCol;j++,cj++){
                tabArray[ci][cj]=sheet.getCell(j,i).getContents();
            }
        }
return(tabArray);
}
}
