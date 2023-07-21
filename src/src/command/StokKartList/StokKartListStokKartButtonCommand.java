package src.command.StokKartList;

import java.awt.Component;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JInternalFrame;

import src.command.Command;
import src.controller.StokKartMenuController;
import src.view.MainFrame;
import src.view.StokKartList;

public class StokKartListStokKartButtonCommand implements Command {
	MainFrame mainFrame;
	StokKartList frame;
	int row;

	public StokKartListStokKartButtonCommand(MainFrame mainFrame, StokKartList frame, int row) {
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
