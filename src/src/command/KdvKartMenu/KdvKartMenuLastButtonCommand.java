package src.command.KdvKartMenu;

import src.command.Command;
import src.view.menus.KdvTipiKartMenuView;

public class KdvKartMenuLastButtonCommand implements Command{

	KdvTipiKartMenuView frame;
	
	public KdvKartMenuLastButtonCommand(KdvTipiKartMenuView frame) {
		this.frame = frame;
	}
	
	@Override
	public void execute() {
		frame.model.travelseLast(frame);
	}
}
