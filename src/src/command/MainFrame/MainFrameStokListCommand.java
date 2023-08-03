package src.command.MainFrame;

import src.command.Command;
import src.controller.StokKartListController;
import src.view.MainFrameView;

public class MainFrameStokListCommand implements Command {

	private MainFrameView frame;

	public MainFrameStokListCommand(MainFrameView frame) {
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
