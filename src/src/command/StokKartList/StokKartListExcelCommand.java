package src.command.StokKartList;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import javax.swing.SwingUtilities;
import javax.swing.table.TableModel;
import javax.xml.crypto.Data;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hibernate.jdbc.Expectations;

import src.command.Command;
import src.view.StokKartList;

public class StokKartListExcelCommand implements Command {

	StokKartList frame;

	public StokKartListExcelCommand(StokKartList frame) {
		this.frame = frame;
	}

	void toXML() throws Exception {
		TableModel model = frame.stokKartTable.getModel();
		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet();
		Row row;
		CellStyle cellStyle = workbook.createCellStyle();
		Cell cell;
		CreationHelper createHelper = workbook.getCreationHelper();
				// write the column headers
		row = sheet.createRow(0);
		for (int c = 0; c < model.getColumnCount(); c++) {
			cell = row.createCell(c);
			cell.setCellValue(model.getColumnName(c));
		}

		// write the data rows
		for (int r = 0; r < model.getRowCount(); r++) {
			row = sheet.createRow(r + 1);
			for (int c = 0; c < model.getColumnCount(); c++) {
				cell = row.createCell(c);
				Object value = model.getValueAt(r, c);
				if(value instanceof String) {
					cell.setCellValue((String)value);
				}
				else if(value instanceof Double) {
					cell.setCellValue((Double)value);
				}
				else if(value instanceof Integer) {
					cell.setCellValue((Integer)value);
				}
				else if(value instanceof Date) {
					cell.setCellValue(((Date)value).toString());
				}
			}
		}

		FileOutputStream out = new FileOutputStream("deneme.xlsx");
		workbook.write(out);
		out.close();
		Desktop desktop = Desktop.getDesktop();
		workbook.close();
		desktop.open(new File("deneme.xlsx"));

	}

	@Override
	public void execute() {
		try {
			toXML();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
