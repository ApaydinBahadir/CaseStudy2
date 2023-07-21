package src.command.StokKartList;

import src.command.Command;
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
