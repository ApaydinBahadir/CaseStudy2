package src.command.StokKartList;

import java.util.ArrayList;
import java.util.List;


import src.command.Command;
import src.model.StokKart;
import src.view.lists.StokKartListView;
import src.view.tableModels.StokKartListTableModel;

public class StokKartListSearchButtonCommand implements Command {

	StokKartListView frame;

	public StokKartListSearchButtonCommand(StokKartListView frame) {
		this.frame = frame;
	}

	@Override
	public void execute() {
		
		
		((StokKart)frame.baseModel).searchString = frame.searchField.getText();
		List<Object> listAll = new ArrayList<Object>();
		listAll.addAll(frame.baseModel.getAllRows());
		frame.model = (StokKartListTableModel) frame.table.getModel();
		frame.model.setRowCount(0);

//		for (List<String> obj : frame.baseModel.getAllRows()) {
//
//			Object[] rows = { obj.get(0), obj.get(1), obj.get(2), obj.get(3), obj.get(4), obj.get(5), obj.get(6),
//					obj.get(7), obj.get(8), obj.get(9), obj.get(10), obj.get(11) };
//			frame.model.addRow(rows);
//		}

	}
}
