package utils;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

//Universal Function to read data from Excel File
public class ExcelReading {
    static  Workbook workbook;
    static Sheet sheet;

    //opening Excel file
    public static void openExcel(String filePath){
        try {
            FileInputStream fileInputStream=new FileInputStream(filePath);
           workbook=new XSSFWorkbook(fileInputStream); // XSSFWorkbook for .xlsx file, and for .xls use HSSFWorkbook
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    //opening the sheet
    public static void getSheet(String sheetName){
        sheet=workbook.getSheet(sheetName);
    }
    //taking the total rows
    public static int getRowCount(){
        return sheet.getPhysicalNumberOfRows();
    }
    //taking the total column
    public static int getColsCount(int rowIndex){
        return sheet.getRow(rowIndex).getPhysicalNumberOfCells();
    }

    public static String getCellData(int rowIndex,int colIndex){//as data in String format
        return sheet.getRow(rowIndex).getCell(colIndex).toString();
    }
    //from Excel, we get data in terms of Maps(keys and values... every row returns a Map) and store them in List.
    public static List<Map<String,String>> excelIntoListMap(String filePath,String sheetName){
        openExcel(filePath);
        getSheet(sheetName);

        List<Map<String,String>> ListData=new ArrayList<>();
        //outer loop
        for(int row=1;row<getRowCount();row++){

            //creating a map for every row
            Map<String,String> map=new LinkedHashMap<>();

            //looping through values of all cell
            for (int col=0; col<getColsCount(row);col++){
                map.put(getCellData(0,col), getCellData(row,col));
            }
            ListData.add(map);//after every loop it adds the map of each row
        }
        return ListData;
    }
}
