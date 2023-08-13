package src.command.KdvKartMenu;

import src.command.Command;
import src.view.menus.KdvTipiKartMenuView;

public class KdvKartMenuFirstButtonCommand implements Command{
	
	KdvTipiKartMenuView frame;
	
	public KdvKartMenuFirstButtonCommand(KdvTipiKartMenuView frame) {
		this.frame = frame;
	}
	
	@Override
	public void execute() {
		frame.model.travelseFirst(frame);
	}

}
