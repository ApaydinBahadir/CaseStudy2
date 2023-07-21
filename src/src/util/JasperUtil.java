package src.util;

import java.io.ByteArrayOutputStream;
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
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRMapCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;
import src.model.StokKart;

public class JasperUtil {

	static StokKart stokModel = new StokKart();

	public static void showPDF() {
		try {

			List<List<String>> deneme = stokModel.getAllRows();
			List<Map<String, ?>> listProducts = new ArrayList<Map<String, ?>>();

			
			for(List<String> obj : stokModel.getAllRows()) {
				for(Object obje : obj) {
					System.out.println(obje.getClass());
				}
				System.out.println("___________");
			}
			
			for (List<String> obj : stokModel.getAllRows()) {
				Map<String, Object> m = new HashMap<String, Object>();

				m.put("Stok Kodu", obj.get(0));
				m.put("Stok Adi", obj.get(1));
				m.put("Stok Tipi", obj.get(2));
				m.put("Stoktipi Adi", obj.get(3));
				m.put("StokTipi Aciklama", obj.get(4));
				m.put("Birim", obj.get(5));
				m.put("Barkod", obj.get(6));
				m.put("KDV Tipi", obj.get(7));
				m.put("KDV Adi",obj.get(8));
				m.put("KDV Aciklama", obj.get(9));
				m.put("Aciklama", obj.get(10));
				m.put("Olusturma Tarihi", new SimpleDateFormat("yyyy/MM/dd").format(obj.get(11)));

				listProducts.add(m);
			}

			JRDataSource dataSource = new JRMapCollectionDataSource(listProducts);
			String sourceName = "src/src/util/JasperReport.jrxml";

			JasperReport report = JasperCompileManager.compileReport(sourceName);
			JasperPrint filledReport = JasperFillManager.fillReport(report, null, dataSource);
			JasperViewer.viewReport(filledReport);
			// frame = new JRViewer(filledReport);

		} catch (Exception e) {
			JOptionPane.showConfirmDialog(null, e.getMessage());
		}
	}

	@SuppressWarnings("deprecation")
	public static ByteArrayOutputStream getPDF() {
		try {

			List<List<String>> deneme = stokModel.getAllRows();
			List<Map<String, ?>> listProducts = new ArrayList<Map<String, ?>>();

			
			for(List<String> obj : stokModel.getAllRows()) {
				for(Object obje : obj) {
					System.out.println(obje.getClass());
				}
				System.out.println("___________");
			}
			
			for (List<String> obj : stokModel.getAllRows()) {
				Map<String, Object> m = new HashMap<String, Object>();

				m.put("Stok Kodu", obj.get(0));
				m.put("Stok Adi", obj.get(1));
				m.put("Stok Tipi", obj.get(2));
				m.put("Stoktipi Adi", obj.get(3));
				m.put("StokTipi Aciklama", obj.get(4));
				m.put("Birim", obj.get(5));
				m.put("Barkod", obj.get(6));
				m.put("KDV Tipi", obj.get(7));
				m.put("KDV Adi",obj.get(8));
				m.put("KDV Aciklama", obj.get(9));
				m.put("Aciklama", obj.get(10));
				m.put("Olusturma Tarihi", new SimpleDateFormat("yyyy/MM/dd").format(obj.get(11)));

				listProducts.add(m);
			}
			JRDataSource dataSource = new JRMapCollectionDataSource(listProducts);
			String sourceName = "src/src/util/JasperReport.jrxml";

			JasperReport report = JasperCompileManager.compileReport(sourceName);
			JasperPrint filledReport = JasperFillManager.fillReport(report, null, dataSource);

			JasperPrintManager.printReportToPdfFile(filledReport, "src/src/util/StokList.pdf");

			return null;

		} catch (Exception e) {
			JOptionPane.showConfirmDialog(null, e.getMessage());
			return null;
		}
	}
}
