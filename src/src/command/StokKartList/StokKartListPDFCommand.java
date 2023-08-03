package src.command.StokKartList;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRMapCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;
import src.command.Command;
import src.view.StokKartListView;

public class StokKartListPDFCommand implements Command {

	StokKartListView frame;

	public StokKartListPDFCommand(StokKartListView frame) {
		this.frame = frame;
	}

	public void execute() {
		showReport();
	}

	private void showReport() {
		try {

			List<Map<String, ?>> listProducts = new ArrayList<Map<String, ?>>();

			for (int count = 0; count < frame.table.getModel().getRowCount(); count++) {
				Map<String, Object> m = new HashMap<String, Object>();

				m.put("Stok Kodu", frame.table.getModel().getValueAt(count, 0).toString());
				m.put("Stok Adi", frame.table.getModel().getValueAt(count,1));
				m.put("Stok Tipi", frame.table.getModel().getValueAt(count,2));
				m.put("Stoktipi Adi", frame.table.getModel().getValueAt(count,3));
				m.put("StokTipi Aciklama", frame.table.getModel().getValueAt(count,4));
				m.put("Birim", frame.table.getModel().getValueAt(count,5));
				m.put("Barkod", frame.table.getModel().getValueAt(count,6));
				m.put("KDV Tipi", frame.table.getModel().getValueAt(count,7));
				m.put("KDV Adi", frame.table.getModel().getValueAt(count,8));
				m.put("KDV Aciklama", frame.table.getModel().getValueAt(count,9));
				m.put("Aciklama", frame.table.getModel().getValueAt(count,10));
				m.put("Olusturma Tarihi",
						new SimpleDateFormat("yyyy/MM/dd").format(frame.table.getModel().getValueAt(count,11)));

				listProducts.add(m);
			}

			JRDataSource dataSource = new JRMapCollectionDataSource(listProducts);
			String sourceName = "src/src/util/JasperReport.jrxml";

			JasperReport report = JasperCompileManager.compileReport(sourceName);
			JasperPrint filledReport = JasperFillManager.fillReport(report, null, dataSource);
			JasperViewer.viewReport(filledReport);

		} catch (Exception e) {
			JOptionPane.showConfirmDialog(null, e.getMessage());
		}
	}
}
