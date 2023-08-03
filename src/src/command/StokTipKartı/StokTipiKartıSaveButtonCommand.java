package src.command.StokTipKartı;

import src.command.Command;
import src.view.StokTipKartMenuView;

public class StokTipiKartıSaveButtonCommand implements Command{
	
	StokTipKartMenuView frame;
	
	public StokTipiKartıSaveButtonCommand(StokTipKartMenuView frame) {
		this.frame = frame;
	}

	@Override
	public void execute() {
		frame.model.save();
	}
	
}
