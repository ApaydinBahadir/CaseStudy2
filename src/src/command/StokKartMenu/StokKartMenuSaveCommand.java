package src.command.StokKartMenu;

import src.command.Command;
import src.view.StokKartMenu;

public class StokKartMenuSaveCommand implements Command {
	StokKartMenu frame;

	public StokKartMenuSaveCommand(StokKartMenu frame) {
		this.frame = frame;
	}

	@Override
	public void execute() {
		save();
	}

	void save() {
		frame.stokKart.saveOrUpdate(frame.stokKoduField.getText(), frame.stokAdiField.getText(),
				(int) frame.stokTipiField.getSelectedItem(), frame.birimField.getSelectedItem().toString(),
				frame.barkodField.getText(),(double) frame.kdvTipiField.getSelectedItem(), frame.aciklamaField.getText(),
				frame.olusTarihField.getDate());
	}

}
