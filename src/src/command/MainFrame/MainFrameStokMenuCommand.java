package src.command.MainFrame;


import src.command.Command;
import src.controller.StokKartMenuController;
import src.view.MainFrame;

public class MainFrameStokMenuCommand implements Command {

	private MainFrame frame;

	public MainFrameStokMenuCommand(MainFrame frame) {
		this.frame = frame;
	}

	@Override
	public void execute() {
		showStokKartMenu();
	}

	private void showStokKartMenu() {
		StokKartMenuController command = new StokKartMenuController(frame);
		command.execute();
	}
	
	
}
