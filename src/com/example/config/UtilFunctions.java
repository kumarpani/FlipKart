package com.example.config;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class UtilFunctions {

public static void takeScreenshot(String snapshotName) {
		try {
			Toolkit tool = Toolkit.getDefaultToolkit();
			Dimension d = tool.getScreenSize();
			Rectangle rect = new Rectangle(d);
			Robot robot = new Robot();
			Thread.sleep(2000);
			File f = new File(snapshotName + ".jpg");
			BufferedImage img = robot.createScreenCapture(rect);
			ImageIO.write(img, "jpeg", f);
			tool.beep();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void MouseHover(WebDriver driver, WebElement element) throws InterruptedException {
		Actions builder = new Actions(driver);
		builder.moveToElement(element);
		builder.perform();
		Thread.sleep(5000);
}
	
	
	public static String[][] getTabledata(String xlPath, String sheetName, String tableName){
        String[][] tabArray=null;
        try{
            Workbook workbook = Workbook.getWorkbook(new File(xlPath));
            Sheet sheet = workbook.getSheet(sheetName);
            int startRow,startCol, endRow, endCol,ci,cj;
            Cell tableStart=sheet.findCell("Start "+tableName);
            startRow=tableStart.getRow();
            startCol=tableStart.getColumn();
            Cell tableEnd= sheet.findCell("End "+ tableName, startCol+1,startRow+1, 100, 64000,  false);                               
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
                }
            }
        }
        catch (Exception e)    {
            System.out.println("error in getTableArray()");
        }

        return(tabArray);
    }

}
