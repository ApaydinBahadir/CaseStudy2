package src;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import src.controller.MainFrameController;
import src.model.StokKart;
import src.util.HibernateUtil;
import src.view.MainFrame;

public class Main {

	public static void main(String[] args) {
		HibernateUtil.getSessionFactory();
		MainFrameController mainframe = new MainFrameController(new MainFrame());
	}

}