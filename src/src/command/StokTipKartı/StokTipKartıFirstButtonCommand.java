package src.command.StokTipKartı;

import src.command.Command;
import src.view.menus.StokTipKartMenuView;

public class StokTipKartıFirstButtonCommand implements Command{

	StokTipKartMenuView frame;
	
	public StokTipKartıFirstButtonCommand(StokTipKartMenuView frame) {
		this.frame = frame;
	}
	
	@Override
	public void execute() {
		frame.model.travelseFirst(frame);
	}
	
}
