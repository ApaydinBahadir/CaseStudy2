package src.command.StokKartMenu;

import src.command.Command;
import src.view.StokKartMenuView;

public class StokKartMenuFirstButtonCommand implements Command{

	
	StokKartMenuView frame;
	
	public StokKartMenuFirstButtonCommand(StokKartMenuView frame){
		this.frame = frame;
	}
	
	@Override
	public void execute() {
		frame.model.travelseFirst(frame);
	}

	
	
}
