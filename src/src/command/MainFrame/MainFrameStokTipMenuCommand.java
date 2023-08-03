package src.command.MainFrame;

import src.command.Command;
import src.controller.StokTipKartController;
import src.view.MainFrameView;

public class MainFrameStokTipMenuCommand implements Command {

	private MainFrameView frame;

	public MainFrameStokTipMenuCommand(MainFrameView frame) {
		this.frame = frame;
	}

	@Override
	public void execute() {
		showMenu();
	}

	void showMenu() {
		StokTipKartController command = new StokTipKartController(frame);
		command.execute();
	}

}
