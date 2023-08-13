package src.command.StokKartMenu;

import src.command.Command;
import src.view.menus.StokKartMenuView;

public class StokKartMenuDeleteButtonCommand implements Command{
	
	StokKartMenuView frame;
	
	public StokKartMenuDeleteButtonCommand(StokKartMenuView frame) {
		this.frame = frame;
	}

	@Override
	public void execute() {
		frame.model.delete(frame.kod.getText());
	}

}
