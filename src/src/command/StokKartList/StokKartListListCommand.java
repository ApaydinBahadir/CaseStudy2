package src.command.StokKartList;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import src.command.Command;
import src.model.StokKart;
import src.view.lists.StokKartListView;
import src.view.tableModels.StokKartListTableModel;

public class StokKartListListCommand implements Command {

	StokKartListView frame;
	List<StokKart> listAll = new ArrayList<StokKart>();
	Vector<Object> deneme;

	public StokKartListListCommand(StokKartListView frame) {
		this.frame = frame;
	}

	@Override
	public void execute() {
		listele();
	}

	void listele() {
		if (!listAll.isEmpty()) {
			listAll.removeAll(listAll);
		}

		listAll.addAll(frame.baseModel.getAllRows());
		frame.model = (StokKartListTableModel) frame.table.getModel();
		frame.model.setRowCount(0);

		for (Object obj : frame.baseModel.getAllRows()) {
			frame.model.addRow((StokKart) obj);
		}
	}

}
