package src.command.StokKartMenu;

import src.command.Command;
import src.view.menus.StokKartMenuView;

public class StokKartMenuSaveButtonCommand implements Command{

	StokKartMenuView frame;
	
	public StokKartMenuSaveButtonCommand(StokKartMenuView frame) {
		this.frame = frame;
	}
	
	
	@Override
	public void execute() {
		frame.model.save(frame);
	}

	
	
}
