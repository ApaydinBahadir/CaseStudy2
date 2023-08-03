package src.command.StokKartList;

import src.command.Command;
import src.util.ExcelExporter;
import src.view.StokKartListView;

public class StokKartListExcelCommand implements Command {
	StokKartListView frame;

	public StokKartListExcelCommand(StokKartListView frame) {
		this.frame = frame;
	}

	@Override
	public void execute() {
		try {
			ExcelExporter.toXML(frame);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
