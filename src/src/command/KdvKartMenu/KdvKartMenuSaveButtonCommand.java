package src.command.KdvKartMenu;

import src.command.Command;
import src.view.menus.KdvTipiKartMenuView;

public class KdvKartMenuSaveButtonCommand implements Command{
	KdvTipiKartMenuView frame;
	
	public KdvKartMenuSaveButtonCommand(KdvTipiKartMenuView frame) {
		this.frame = frame;
	}
	
	@Override
	public void execute() {
		frame.model.save(frame);
	}
	
	
}
