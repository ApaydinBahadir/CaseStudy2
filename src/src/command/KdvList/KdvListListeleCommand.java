package src.command.KdvList;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import src.command.Command;
import src.model.KdvTipKart;
import src.view.lists.KdvListView;
import src.view.tableModels.KdvTipTableModel;

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
		frame.model = (KdvTipTableModel) frame.table.getModel();
		frame.model.setRowCount(0);
		for (Object obj : frame.baseModel.getAllRows()) {

			frame.model.addRow((KdvTipKart) obj);
		}
	}

}
