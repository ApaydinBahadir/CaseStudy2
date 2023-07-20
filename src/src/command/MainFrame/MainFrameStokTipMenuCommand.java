package src.command.MainFrame;

import src.command.Command;
import src.controller.StokTipKartController;
import src.view.MainFrame;

public class MainFrameStokTipMenuCommand implements Command{

	private MainFrame frame;

	public MainFrameStokTipMenuCommand(MainFrame frame) {
		this.frame = frame;
	}
	
	
	@Override
	public void execute() {
		showMenu();		
	}
	
	void showMenu(){
		StokTipKartController command = new StokTipKartController(frame);
		command.execute();
	}

}
