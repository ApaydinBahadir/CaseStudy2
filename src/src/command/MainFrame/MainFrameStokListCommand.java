package src.command.MainFrame;

import src.command.Command;
import src.controller.StokKartListController;
import src.view.MainFrame;

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
