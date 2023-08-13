package src.command.StokKartMenu;

import src.command.Command;
import src.view.menus.StokKartMenuView;

public class StokKartMenuGetTipCommand implements Command {

	StokKartMenuView frame;

	public StokKartMenuGetTipCommand(StokKartMenuView frame) {
		this.frame = frame;
	}

	@Override
	public void execute() {
		addKDV();
	}

	public void addKDV() {
		frame.stokTipiField.fillData(frame.stokTipiKart.getTipList());
	}
}
