package src.command.StokTipKartı;

import src.command.Command;
import src.view.menus.StokTipKartMenuView;

public class StokTipiKartıLastButtonCommand implements Command {

	StokTipKartMenuView frame;

	public StokTipiKartıLastButtonCommand(StokTipKartMenuView frame) {
		this.frame = frame;
	}

	@Override
	public void execute() {
		frame.model.travelseLast(frame);
	}
}
