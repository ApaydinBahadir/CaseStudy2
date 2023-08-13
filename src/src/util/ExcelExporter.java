package src.util;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;

import javax.swing.table.TableModel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import src.view.baseViews.BaseListFrame;

public class ExcelExporter {

	public static void toXML(BaseListFrame frame) throws Exception {
		TableModel model = frame.table.getModel();
		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet();
		Row row;
		Cell cell;
		row = sheet.createRow(0);
		for (int c = 0; c < model.getColumnCount(); c++) {
			cell = row.createCell(c);
			cell.setCellValue(model.getColumnName(c));
		}

		for (int r = 0; r < model.getRowCount(); r++) {
			row = sheet.createRow(r + 1);
			for (int c = 0; c < model.getColumnCount(); c++) {
				cell = row.createCell(c);
				Object value = model.getValueAt(r, c);
				if (value instanceof String) {
					cell.setCellValue((String) value);
				} else if (value instanceof Double) {
					cell.setCellValue((Double) value);
				} else if (value instanceof Integer) {
					cell.setCellValue((Integer) value);
				} else if (value instanceof Date) {
					cell.setCellValue(((Date) value).toString());
				}
			}
		}

		FileOutputStream out = new FileOutputStream(frame.baseModel.getClass().getSimpleName() + ".xlsx");
		workbook.write(out);
		out.close();
		Desktop desktop = Desktop.getDesktop();
		workbook.close();
		desktop.open(new File(frame.baseModel.getClass().getSimpleName() + ".xlsx"));

	}

}
