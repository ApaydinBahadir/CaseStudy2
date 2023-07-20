package src.util;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.activation.DataSource;
import javax.mail.util.ByteArrayDataSource;
import javax.swing.JOptionPane;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.data.JRMapCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;
import src.model.StokKart;

public class JasperUtil {
	
	static StokKart stokModel = new StokKart();
	
	public static void showPDF() {
		try {
			List<Map<String, ?>> listProducts = new ArrayList<Map<String, ?>>();
			for (StokKart stokKart : stokModel.listStoks()) {
				Map<String, Object> m = new HashMap<String, Object>();
				m.put("Stok Kodu", stokKart.getStokKodu());
				m.put("Stok Adi", stokKart.getStokAdi());
				m.put("Stok Tipi", stokKart.getStokTipi());
				m.put("Birim", stokKart.getBirim());
				m.put("Barkod", stokKart.getBarkod());
				m.put("KDV Tipi", stokKart.getKdvtipi());
				m.put("Acıklama", stokKart.getAciklama());
				m.put("Olusturma Tarihi", stokKart.getOlusturmaTarihi().toString());

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
			List<Map<String, ?>> listProducts = new ArrayList<Map<String, ?>>();
			for (StokKart stokKart : stokModel.listStoks()) {
				Map<String, Object> m = new HashMap<String, Object>();
				m.put("Stok Kodu", stokKart.getStokKodu());
				m.put("Stok Adi", stokKart.getStokAdi());
				m.put("Stok Tipi", stokKart.getStokTipi());
				m.put("Birim", stokKart.getBirim());
				m.put("Barkod", stokKart.getBarkod());
				m.put("KDV Tipi", stokKart.getKdvtipi());
				m.put("Acıklama", stokKart.getAciklama());
				m.put("Olusturma Tarihi", stokKart.getOlusturmaTarihi().toString());

				listProducts.add(m);
			}

			JRDataSource dataSource = new JRMapCollectionDataSource(listProducts);
			String sourceName = "src/src/util/JasperReport.jrxml";

			JasperReport report = JasperCompileManager.compileReport(sourceName);
			JasperPrint filledReport = JasperFillManager.fillReport(report, null, dataSource);
			
			JasperPrintManager.printReportToPdfFile(filledReport,"src/src/util/saveFile.pdf");
			
			
		    return null;
		    
		} catch (Exception e) {
			JOptionPane.showConfirmDialog(null, e.getMessage());
			return null;
		}
	}
}
