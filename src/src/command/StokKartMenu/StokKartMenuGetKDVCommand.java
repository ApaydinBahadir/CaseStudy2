package src.command.StokKartMenu;

import src.command.Command;
import src.view.menus.StokKartMenuView;

public class StokKartMenuGetKDVCommand implements Command {

	StokKartMenuView frame;

	public StokKartMenuGetKDVCommand(StokKartMenuView frame) {
		this.frame = frame;
	}

	@Override
	public void execute() {
		addKDV();
	}

	public void addKDV() {
		frame.kdvTipiField.fillData(frame.kdvTipiKart.getKDV());
	}

}
