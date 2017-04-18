/**
 * Created by zhaojin on 17/4/18.
 */

import java.io.*;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;


public class POIExcel {
    public POIExcel() {
    }

    public static void main(String[] args) throws IOException {
        try{
            File file = new File("./test_dir");
            readAllFiles(file.listFiles());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public static void readFile(String keyWord,File file) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            long count = 0;
            boolean found = false;

            while ((line = reader.readLine()) != null) {
                if (line.contains(keyWord)) {
                    found = true;
                    System.out.println(line);
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    private static void readAllFiles(File[] allFiles) {
        for (File file : allFiles) {
            if (file.isFile()) {
                if(file.getName().startsWith("PM")) continue;
                readFile("Hello",file);
            } else {
                System.out.println(file.isFile());
            }
        }
    }
    public static void readExcel(String excelName) throws IOException {
        FileInputStream fis = new FileInputStream(excelName);
        POIFSFileSystem fs = new POIFSFileSystem(fis);
        HSSFWorkbook wb = new HSSFWorkbook(fs);
        HSSFSheet sheet = wb.getSheetAt(0);
        if (sheet == null) {
            return;
        }
        // 遍历行

        Row row = null;
        Cell cell = null;
        for (int rowNum = 0; rowNum < sheet.getLastRowNum() + 1; rowNum++) {
            row = sheet.getRow(rowNum);
            if (row == null) {
                continue;
            }
            // 遍历单元格
            for (int cellNum = 0; cellNum < row.getLastCellNum(); cellNum++) {
                cell = row.getCell(cellNum);
                System.out.print(getCellDate(cell) + "  ");

            }
            System.out.println();
        }
        wb.close();
    }

    private static String getCellDate(Cell cell) {
        String return_string = null;
        switch (cell.getCellType()) {
            case HSSFCell.CELL_TYPE_STRING:
                return_string = cell.getStringCellValue();
                break;
            case HSSFCell.CELL_TYPE_NUMERIC:
                return_string = cell.getNumericCellValue() + "";
                break;
            case HSSFCell.CELL_TYPE_BOOLEAN:
                return_string = String.valueOf(cell.getBooleanCellValue());
            default:
                return_string = "";
                break;
        }
        return return_string;
    }

}