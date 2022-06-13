package pl.edu.agh.mwo.example;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.RegexFileFilter;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Parser {

    public static List<Employee> parser (String filePath) {
        List<Employee> employees = new LinkedList<>();

        Collection<File> listFile = printNameFile(filePath);

        for (File file: listFile) {


            String employeeName = getEmployeeName(String.valueOf(file));
            double timeWorkInProject = 0;

//            SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
            Date valueDate = null;
            double valueDateString = 0;

            try {
                Workbook wb = WorkbookFactory.create(new File(String.valueOf(file)));

                for (Sheet sheet : wb) {
                    String projectName = sheet.getSheetName();

                    int rowEnd = Math.max(1400, sheet.getLastRowNum());

                    for (int rowNum = 1; rowNum < rowEnd; rowNum++) {
                        Row row = sheet.getRow(rowNum);
                        if (row == null) {
                        } else {

                            Cell cell = row.getCell(2);

                            if (cell == null) {
                            } else {
                                CellType cellType = cell.getCellType();
                                if (cellType.equals(CellType.NUMERIC)) {
                                    timeWorkInProject = cell.getNumericCellValue();
                                }
                            }
                            if (cell == null) {

                            } else {
                                valueDate = row.getCell(0).getDateCellValue();
                            } employees.add(new Employee(employeeName, projectName, timeWorkInProject, valueDate));
                        }
                    }

                    timeWorkInProject = 0;
                }
            } catch (EncryptedDocumentException | IOException e) {
                e.printStackTrace();
            }
        } return employees;
    }

    public static String getEmployeeName(String filePath) {
        File file = new File(filePath);
        String fileName = file.getName();
        String employee = fileName.substring(fileName.lastIndexOf("/") + 1)
                .replace(".xls", "")
                .replace("_", " ");
        return employee;
    }

    public static Collection<File> printNameFile (String katalog) {
        File folder = new File(katalog);
        ArrayList<String > fileList = new ArrayList<>();

        Collection<File> filesList = FileUtils.listFiles(
                folder,
                new RegexFileFilter("^(.*?)" + ".xls"),
                DirectoryFileFilter.DIRECTORY);
        for (File file: filesList) {
            System.out.println("znaleziono plik .xls: " + file);
        }
        return filesList;

    }
}
