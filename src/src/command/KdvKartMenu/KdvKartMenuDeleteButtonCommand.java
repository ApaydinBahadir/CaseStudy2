package src.command.KdvKartMenu;

import src.command.Command;
import src.view.menus.KdvTipiKartMenuView;

public class KdvKartMenuDeleteButtonCommand implements Command{
	
	KdvTipiKartMenuView frame;
	
	public KdvKartMenuDeleteButtonCommand(KdvTipiKartMenuView frame) {
		this.frame = frame;
	}
	
	@Override
	public void execute() {
		frame.model.delete(frame.kod.getText());
	}

}
