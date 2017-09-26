package com.pradeep.test.hashmap;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.google.common.collect.HashBasedTable;

public class guavatable 
{
	
	 private static XSSFWorkbook myWorkBook;
	 private static XSSFSheet mySheet;
	 private static String temp;
	 
	 
    public static HashBasedTable<String,String,String> datatable( String shname) throws IOException
    {
    	 
    	 HashBasedTable<String,String,String> hashMap = HashBasedTable.create();
    	// String shname="Sheet 1";
    	    String f1="/src/test/test.xlsx";	
    	    String workingDirectory = System.getProperty("user.dir");
    		System.out.println("workingDirectory is: "+workingDirectory);
    			String  fileName=workingDirectory+f1;
    			 System.out.println("absolute path of file is: "+fileName);
    			   FileInputStream myInput = new FileInputStream(fileName);
    	            myWorkBook = new XSSFWorkbook(myInput);
    	          
    	            
    	           for (int shn=0;shn<myWorkBook.getNumberOfSheets();shn++) 
    	           {
    	           
    	            String mySheetname = myWorkBook.getSheetName(shn);
    	            if (shname.equalsIgnoreCase(mySheetname))
    	            {
    	            	System.out.println("mySheetname:"+mySheetname);
    	            	mySheet=myWorkBook.getSheetAt(shn);
    	            	break;
    	            }
    	            
    	           }

    	           Iterator rowIter = mySheet.rowIterator();
    	            int rowNum1 = mySheet.getLastRowNum() + 1;
    	            int HEAD = mySheet.getRow(0).getLastCellNum();
    	        	String[] arr=new String[HEAD];
    	          
    	        	//header for Result
    	            XSSFRow rowh = mySheet.getRow(0);
    	            for (int jh = 0 ; jh < HEAD ; jh++) 
    	            {
    	            		XSSFCell cellh = rowh.getCell(jh);
    	                 String valueh = cellh.toString();
    	               arr[jh]=valueh;
    	              // System.out.println ("arr[jh]::::"+arr[jh]);
    	 }

    	            while(rowIter.hasNext())
    	            {
    	            		XSSFRow myRow = (XSSFRow) rowIter.next();
    	                Iterator cellIter = myRow.cellIterator();
    	               int row_entry=0;
    	               int cnt_col=0;
    	                		while(cellIter.hasNext())
    	                		{
    	                			
	                    XSSFCell cell = (XSSFCell) cellIter.next();
	                   // System.out.println (cell.toString());
	                   if (cnt_col==0)
                        {
                        	temp=cell.toString();
                        	cnt_col++;
                        }
	                   else
                        {
	                	   
	                	   //enter hashmap data
                        	hashMap.put(temp, arr[row_entry],cell.toString());
                        }
	                   row_entry++;
    	                }	 
    }
    	           // System.out.println ("GUAVA::::"+hashMap.get("TC_2", "CC"));
    	            System.out.println (hashMap);
    	            System.out.println ("hash Map for sheet '"+shname+"' is created");
    	            return hashMap;
    }
    }
