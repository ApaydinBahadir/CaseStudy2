package src.command.StokKartMenu;

import src.command.Command;
import src.view.StokKartMenuView;

public class StokKartMenuLastButtonCommand implements Command{

	StokKartMenuView frame;
	
	public StokKartMenuLastButtonCommand(StokKartMenuView frame) {
		this.frame = frame;
	}
	
	@Override
	public void execute() {
		frame.model.travelseLast(frame);
	}

}
