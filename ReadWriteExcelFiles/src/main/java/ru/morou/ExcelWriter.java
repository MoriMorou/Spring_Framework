package ru.morou;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class ExcelWriter {

    private static String[] columns = {"Name", "Email", "Date Of Birth", "Salary"};

    private static List<Employee> employees =  new ArrayList<>();

    static {
        Calendar dateOfBirth = Calendar.getInstance();
        dateOfBirth.set(1992, 7, 21);
        employees.add(new Employee("Rajeev Singh", "rajeev@example.com",
                dateOfBirth.getTime(), 1200000.0));

        dateOfBirth.set(1965, 10, 15);
        employees.add(new Employee("Thomas cook", "thomas@example.com",
                dateOfBirth.getTime(), 1500000.0));

        dateOfBirth.set(1987, 4, 18);
        employees.add(new Employee("Steve Maiden", "steve@example.com",
                dateOfBirth.getTime(), 1800000.0));
    }

    public static void main(String[] args) throws IOException, InvalidFormatException {

        // Создаем рабочую книги
        Workbook workbook = new XSSFWorkbook();     // new HSSFWorkbook() for generating `.xls` file

        /* CreationHelper помогает нам создавать экземпляры для различных вещей, таких как DataFormat,
           Hyperlink, RichTextString etc in a format (HSSF, XSSF) independent way */
        CreationHelper createHelper = workbook.getCreationHelper();

        // Создаем страницу
        Sheet sheet = workbook.createSheet("Employee");

        // Задаем шрифт для оформления ячеек заголовка
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 14);
        headerFont.setColor(IndexedColors.RED.getIndex());

        // Задаем CellStyle со шрифтом
        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);

        // Задаем строку
        Row headerRow = sheet.createRow(0);

        // Задаем ячейки
        for(int i = 0; i < columns.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columns[i]);
            cell.setCellStyle(headerCellStyle);
        }

        // Стиль ячейки для форматирования даты
        CellStyle dateCellStyle = workbook.createCellStyle();
        dateCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd-MM-yyyy"));

        // Создаем другие строки и ячейки с данными сотрудников
        int rowNum = 1;
        for(Employee employee: employees) {
            Row row = sheet.createRow(rowNum++);

            row.createCell(0)
                    .setCellValue(employee.getName());

            row.createCell(1)
                    .setCellValue(employee.getEmail());

            Cell dateOfBirthCell = row.createCell(2);
            dateOfBirthCell.setCellValue(employee.getDateOfBirth());
            dateOfBirthCell.setCellStyle(dateCellStyle);

            row.createCell(3)
                    .setCellValue(employee.getSalary());
        }

        // Изменить размер всех столбцов в соответствии с размером содержимого
        for(int i = 0; i < columns.length; i++) {
            sheet.autoSizeColumn(i);
        }

        // Записываем данные в файл
        FileOutputStream fileOut = new FileOutputStream("poi-generated-file.xlsx");
        workbook.write(fileOut);
        fileOut.close();

        workbook.close();
    }


    // Пример для изменения существующего файла Excel
    private static void modifyExistingWorkbook() throws InvalidFormatException, IOException {
        // Получаем рабочую книгу из файла Excel
        Workbook workbook = WorkbookFactory.create(new File("existing-spreadsheet.xlsx"));

        // Получаем лист по индексу 0
        Sheet sheet = workbook.getSheetAt(0);

        // Получаем строку в индексе 1
        Row row = sheet.getRow(1);

        // Получаем ячейку по индексу 2 из приведенного выше ряда
        Cell cell = row.getCell(2);

        // Создаем ячейку, если она не существует
        if (cell == null)
            cell = row.createCell(2);

        // Обновляем значение ячейки
        cell.setCellType(CellType.STRING);
        cell.setCellValue("Updated Value");

        // Записываем данные в файл
        FileOutputStream fileOut = new FileOutputStream("existing-spreadsheet.xlsx");
        workbook.write(fileOut);
        fileOut.close();

        // Закнрываем книгу
        workbook.close();
    }
}
