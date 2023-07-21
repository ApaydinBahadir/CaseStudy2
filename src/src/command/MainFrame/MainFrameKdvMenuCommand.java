package src.command.MainFrame;

import src.command.Command;
import src.controller.KdvTipController;
import src.view.MainFrame;

public class MainFrameKdvMenuCommand implements Command {

	private MainFrame frame;

	public MainFrameKdvMenuCommand(MainFrame frame) {
		this.frame = frame;
	}

	@Override
	public void execute() {
		showStokKartMenu();
	}

	private void showStokKartMenu() {
		KdvTipController command = new KdvTipController(frame);
		command.execute();
	}
}
