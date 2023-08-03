package src.command.KdvList;

import src.command.Command;
import src.util.ExcelExporter;
import src.view.KdvListView;

public class KdvListExcelCommand implements Command {

	KdvListView frame;
	
	public KdvListExcelCommand(KdvListView frame) {
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
