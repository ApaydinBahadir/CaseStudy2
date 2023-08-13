package src.command.StokKartList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import src.command.Command;
import src.controller.StokKartMenuController;
import src.view.MainFrameView;
import src.view.lists.StokKartListView;

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


		StokKartMenuController menuCommand = new StokKartMenuController(mainFrame, frame.model.getRowValue(row));
	}
}
