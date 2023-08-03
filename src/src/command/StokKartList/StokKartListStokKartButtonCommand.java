package src.command.StokKartList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

import src.command.Command;
import src.controller.StokKartMenuController;
import src.view.MainFrameView;
import src.view.StokKartListView;

public class StokKartListStokKartButtonCommand implements Command {
	MainFrameView mainFrame;
	StokKartListView frame;
	int row;

	public StokKartListStokKartButtonCommand(MainFrameView mainFrame, StokKartListView frame, int row) {
		this.frame = frame;
		this.mainFrame = mainFrame;
		this.row = row;
	}

	public void execute() {
		showStokKart();
	}

	private void showStokKart() {

		List<Object> selectedRow = new ArrayList<>();

		for (int j = frame.model.getColumnCount() - 1; j >= 0; --j) {
			selectedRow.add((Object) frame.model.getValueAt(row, j));
		}
		Collections.reverse(selectedRow);

		StokKartMenuController menuCommand = new StokKartMenuController(mainFrame, selectedRow);
	}
}
