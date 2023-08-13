package src.command.StokKartMenu;

import src.command.Command;
import src.view.menus.StokKartMenuView;

public class StokKartMenuBackwardButtonCommand implements Command{

	StokKartMenuView frame;
	
	public StokKartMenuBackwardButtonCommand(StokKartMenuView frame) {
		this.frame = frame;
	}
	
	@Override
	public void execute() {
		frame.model.travelseBackward(frame.kod.getText(), frame);
	}
	
	

}
