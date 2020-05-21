package net.vadique.khpi.vagonkadb.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.apache.poi.ss.usermodel.BuiltinFormats;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import net.vadique.khpi.vagonkadb.beans.Order;

public class ReportUtils {

	public static void generateReport(List<Order> orders) {
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("вагонка-заказы");
		CellStyle style = sheet.getWorkbook().createCellStyle();

		sheet.setDefaultColumnWidth(15);
		createHeaderRow(sheet);
		int rownum = 1;
		for (Order o : orders) {
			Row row = sheet.createRow(rownum++);
			Cell cell = row.createCell(0);
			cell.setCellValue(o.getOrderId());
			cell = row.createCell(1);
			cell.setCellValue(o.getCustomerName());
			cell = row.createCell(2);
			cell.setCellValue(o.getCustomerPhone());
			cell = row.createCell(3);
			cell.setCellValue(o.getCustomerEmail());
			cell = row.createCell(4);
			cell.setCellValue(o.getOrderInfo());
			cell = row.createCell(5);
			style.setDataFormat((short) BuiltinFormats.getBuiltinFormat("m/d/yy h:mm"));
			cell.setCellStyle(style);
			cell.setCellValue((Timestamp) o.getOrderDate());
		}

		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Сохранить список заказов");
		fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Microsoft Excel Documents", "xlsx"));
		fileChooser.setAcceptAllFileFilterUsed(true);

		int userSelection = fileChooser.showSaveDialog(null);

		if (userSelection == JFileChooser.APPROVE_OPTION) {
			File fileToSave = fileChooser.getSelectedFile();
			FileOutputStream out;
			try {
				out = new FileOutputStream(fileToSave);
				workbook.write(out);
				workbook.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void createHeaderRow(XSSFSheet sheet) {
//		font.setFontHeightInPoints((short) 16);
//		cellStyle.setFont(font);
		CellStyle cellStyle = sheet.getWorkbook().createCellStyle();
		Font font = sheet.getWorkbook().createFont();
		font.setBold(true);
		cellStyle.setFont(font);
		Row headerRow = sheet.createRow(0);
		Cell cell = headerRow.createCell(0);
		cell.setCellValue("Номер заказа");
		cell.setCellStyle(cellStyle);
		cell = headerRow.createCell(1);
		cell.setCellValue("Имя заказчика");
		cell.setCellStyle(cellStyle);
		cell = headerRow.createCell(2);
		cell.setCellStyle(cellStyle);
		cell.setCellValue("Телефон");
		cell.setCellStyle(cellStyle);
		cell = headerRow.createCell(3);
		cell.setCellStyle(cellStyle);
		cell.setCellValue("Эл. почта");
		cell.setCellStyle(cellStyle);
		cell = headerRow.createCell(4);
		cell.setCellStyle(cellStyle);
		cell.setCellValue("Текст заказа");
		cell.setCellStyle(cellStyle);
		cell = headerRow.createCell(5);
		cell.setCellStyle(cellStyle);
		cell.setCellValue("Время заказа");
	}

}
