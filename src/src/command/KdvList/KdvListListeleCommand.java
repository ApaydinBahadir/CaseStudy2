package src.command.KdvList;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import src.command.Command;
import src.view.KdvListView;

public class KdvListListeleCommand implements Command {
	KdvListView frame;
	List<Object> listAll = new ArrayList<Object>();

	public KdvListListeleCommand(KdvListView frame) {
		this.frame = frame;
	}

	@Override
	public void execute() {
		listele();
	}

	private void listele() {
		if (!listAll.isEmpty()) {
			listAll.removeAll(listAll);
		}

		listAll.addAll(frame.baseModel.getAllRows());
		frame.model = (DefaultTableModel) frame.table.getModel();
		frame.model.setRowCount(0);

		for (List<String> obj : frame.baseModel.getAllRows()) {

			Object[] rows = { obj.get(0), obj.get(1), obj.get(2) };
			frame.model.addRow(rows);
		}
	}

}
