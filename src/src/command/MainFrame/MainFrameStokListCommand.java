package src.command.MainFrame;

import java.util.ArrayList;
import java.util.List;

import src.command.Command;
import src.controller.StokKartListController;
import src.model.StokKart;
import src.view.MainFrame;
import src.view.StokKartList;

public class MainFrameStokListCommand implements Command {

	private MainFrame frame;

	public MainFrameStokListCommand(MainFrame frame) {
		this.frame = frame;
	}

	@Override
	public void execute() {
		showStokKartList();
	}

	private void showStokKartList() {
		StokKartListController command = new StokKartListController(frame);
		command.execute();
	}

}
