package src.command.KdvTipiKart;

import java.util.List;

import src.command.Command;
import src.view.KdvTipiKartMenu;

public class KdvTipiKartSaveButtonCommand implements Command {

	KdvTipiKartMenu frame;

	public KdvTipiKartSaveButtonCommand(KdvTipiKartMenu frame) {
		this.frame = frame;
	}

	public void execute() {
		save();
	}

	private void save() {
		frame.tipKart.saveOrUpdate(frame.kdvKoduField.getText(), frame.kdvAdiField.getText(),
				Double.parseDouble(frame.kdvOraniField.getText()));

	}
}
