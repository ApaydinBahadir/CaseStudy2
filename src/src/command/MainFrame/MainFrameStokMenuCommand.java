package src.command.MainFrame;


import src.command.Command;
import src.controller.StokKartMenuController;
import src.view.MainFrameView;

public class MainFrameStokMenuCommand implements Command {

	private MainFrameView frame;

	public MainFrameStokMenuCommand(MainFrameView frame) {
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
