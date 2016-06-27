package com.spotify.test;
import java.io.File;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;


public class TestData {
	
	//Static method to read data from excel
	public static String[][] getTableArray(int sheetNumber){
		String[][] tabArray=null;
		try{
		
        
            Workbook workbook = Workbook.getWorkbook(new File("./testData/data.xls"));
            Sheet sheet = workbook.getSheet(sheetNumber); 
            int startRow,startCol, endRow, endCol,ci,cj;
            Cell tableStart=sheet.findCell("start");
            startRow=tableStart.getRow();
            startCol=tableStart.getColumn();
            Cell tableEnd= sheet.findCell("end");                

            endRow=tableEnd.getRow();
            endCol=tableEnd.getColumn();
            System.out.println("startRow="+startRow+", endRow="+endRow+", " +
                    "startCol="+startCol+", endCol="+endCol);
            tabArray=new String[endRow-startRow-1][endCol-startCol-1];
            ci=0;

            for (int i=startRow+1;i<endRow;i++,ci++){
                cj=0;
                for (int j=startCol+1;j<endCol;j++,cj++){
                    tabArray[ci][cj]=sheet.getCell(j,i).getContents();
                    System.out.println("tabArray["+ci+","+cj+"] = "+tabArray[ci][cj]);
                }
            }
            workbook.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
        return(tabArray);
    }
	
	//static method to return a first entry in valid creds sheets for login
	public static String[][] giveValidCreds(){
		String[][] tabArray=new String[1][2];
		try{
		
        
            Workbook workbook = Workbook.getWorkbook(new File("./testData/data.xls"));
            Sheet sheet = workbook.getSheet(0); 
            tabArray[0][0] = sheet.getCell(1, 1).getContents();
            tabArray[0][1] = sheet.getCell(2, 1).getContents();
            workbook.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return tabArray;
	}
	

	
	
	
}
