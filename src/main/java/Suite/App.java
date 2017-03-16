package Suite;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class App {

    public static void writeXLSXFile(int row, int col) throws IOException {
        try {
            FileInputStream file = new FileInputStream("C:\\Users\\ashwani.singh\\Downloads\\vernons_bingo\\BingoData\\Bingo_Core_SUITE.xlsx");

            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(1);
            Cell cell = null;

            //Retrieve the row and check for null
            XSSFRow sheetrow = sheet.getRow(row);
            if(sheetrow == null){
                sheetrow = sheet.createRow(row);
            }
            //Update the value of cell
            cell = sheetrow.getCell(col);
            if(cell == null){
                cell = sheetrow.createCell(col);
            }
            cell.setCellValue("NewPassword");

            file.close();

            FileOutputStream outFile =new FileOutputStream(new File("C:\\Users\\ashwani.singh\\Downloads\\vernons_bingo\\BingoData\\Bingo_Core_SUITE.xlsx"));
           workbook.write(outFile);
           outFile.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
       System.out.println("Started");
    	writeXLSXFile(5, 4);
    }

}