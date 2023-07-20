package src.command.StokTipKartı;

import src.command.Command;
import src.view.KdvTipiKartMenu;
import src.view.StokTipKartMenu;

public class StokTipKartSaveButtonCommand implements Command {
	StokTipKartMenu frame;

	public StokTipKartSaveButtonCommand(StokTipKartMenu frame) {
		this.frame = frame;
	}

	public void execute() {
		save();
	}

	private void save() {
		frame.kart.saveOrUpdate(Integer.parseInt(frame.tipKodField.getText()), frame.tipAdiField.getText(),
				frame.tipAciklamaField.getText());
	}
}
