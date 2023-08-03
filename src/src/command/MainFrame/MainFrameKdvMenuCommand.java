package src.command.MainFrame;

import src.command.Command;
import src.controller.KdvTipController;
import src.view.MainFrameView;

public class MainFrameKdvMenuCommand implements Command {

	private MainFrameView frame;

	public MainFrameKdvMenuCommand(MainFrameView frame) {
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
