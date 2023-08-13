package src.command.StokKartMenu;

import src.command.Command;
import src.view.menus.StokKartMenuView;

public class StokKartMenuForwardButtonCommand implements Command {
	
	StokKartMenuView frame;

	public StokKartMenuForwardButtonCommand(StokKartMenuView frame) {
		this.frame = frame;
	}

	@Override
	public void execute() {
		frame.model.travelseForward(frame.kod.getText(), frame);
	}

}
