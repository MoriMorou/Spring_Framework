package ru.morou;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

/**
 * Created by rajeevkumarsingh on 18/12/17.
 */

public class ExcelReader {
//    public static final String SAMPLE_XLS_FILE_PATH = "./sample-xls-file.xls";
    public static final String SAMPLE_XLSX_FILE_PATH = "./Book.xlsx";

    public static void main(String[] args) throws IOException, InvalidFormatException {

        // Создание рабочей книги из файла Excel (.xls или .xlsx)
        Workbook workbook = WorkbookFactory.create(new File(SAMPLE_XLSX_FILE_PATH));

        // Получение количества листов в рабочей книге
        System.out.println("Workbook has " + workbook.getNumberOfSheets() + " Sheets : ");

/**
 * Перебор всех листов в книге (несколько способов)
 */
        // 1. Мы можем использовать SheetIterator
        Iterator<Sheet> sheetIterator = workbook.sheetIterator();
        System.out.println("Retrieving Sheets using Iterator");
        while (sheetIterator.hasNext()) {
            Sheet sheet = sheetIterator.next();
            System.out.println("=> " + sheet.getSheetName());
        }

        // 2. Или мы можем использовать цикл
        System.out.println("Retrieving Sheets using for-each loop");
        for(Sheet sheet: workbook) {
            System.out.println("=> " + sheet.getSheetName());
        }

        // 3. Или мы можем использовать Java 8 forEach с лямбдой
        System.out.println("Retrieving Sheets using Java 8 forEach with lambda");
        workbook.forEach(sheet -> {
            System.out.println("=> " + sheet.getSheetName());
        });

/**
 * Перебор всех строк и столбцов на листе (несколькими способами)
 */

        // Получение листа по нулевому индексу
        Sheet sheet = workbook.getSheetAt(0);

        // Создать DataFormatter для форматирования и получить значение каждой ячейки в виде строки
        DataFormatter dataFormatter = new DataFormatter();

        // 1. Мы можем получить rowIterator и columnIterator и перебрать их
        System.out.println("\n\nIterating over Rows and Columns using Iterator\n");
        Iterator<Row> rowIterator = sheet.rowIterator();
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();

            // Теперь давайте переберем столбцы текущей строки
            Iterator<Cell> cellIterator = row.cellIterator();

            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                String cellValue = dataFormatter.formatCellValue(cell);
                System.out.print(cellValue + "\t");
            }
            System.out.println();
        }

        // 2. Или мы можем использовать цикл for-each для перебора строк и столбцов.
        System.out.println("\n\nIterating over Rows and Columns using for-each loop\n");
        for (Row row: sheet) {
            for(Cell cell: row) {
                String cellValue = dataFormatter.formatCellValue(cell);
                System.out.print(cellValue + "\t");
            }
            System.out.println();
        }

        // 3. Или мы можем использовать Java 8 forEach с лямбдой
        System.out.println("\n\nIterating over Rows and Columns using Java 8 forEach with lambda\n");
        sheet.forEach(row -> {
            row.forEach(cell -> {
                printCellValue(cell);
            });
            System.out.println();
        });

        // закрываем файл (книгу)
        workbook.close();
    }

    /**
     * Метод отвечает за печать данных
     * @param cell
     */
    private static void printCellValue(Cell cell) {
        switch (cell.getCellTypeEnum()) {
            case BOOLEAN:
                System.out.print(cell.getBooleanCellValue());
                break;
            case STRING:
                System.out.print(cell.getRichStringCellValue().getString());
                break;
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    System.out.print(cell.getDateCellValue());
                } else {
                    System.out.print(cell.getNumericCellValue());
                }
                break;
            case FORMULA:
                System.out.print(cell.getCellFormula());
                break;
            case BLANK:
                System.out.print("");
                break;
            default:
                System.out.print("");
        }

        System.out.print("\t");
    }
}