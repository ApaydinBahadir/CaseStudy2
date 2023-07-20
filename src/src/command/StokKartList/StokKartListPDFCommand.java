package src.command.StokKartList;

import java.awt.Frame;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.data.JRMapCollectionDataSource;
import net.sf.jasperreports.view.JRViewer;
import net.sf.jasperreports.view.JasperViewer;
import src.command.Command;
import src.model.StokKart;
import src.util.JasperUtil;
import src.view.StokKartList;

public class StokKartListPDFCommand implements Command {

	StokKartList frame;

	public StokKartListPDFCommand(StokKartList frame) {
		this.frame = frame;
	}

	public void execute() {
		showReport();
	}

	private void showReport() {
		JasperUtil.showPDF();
	}
}
