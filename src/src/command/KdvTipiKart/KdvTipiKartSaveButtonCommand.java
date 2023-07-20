package src.command.KdvTipiKart;

import java.util.List;

import src.command.Command;
import src.view.KdvTipiKartMenu;
import src.view.StokKartList;
import src.view.StokTipKartMenu;

public class KdvTipiKartSaveButtonCommand implements Command {

	KdvTipiKartMenu frame;

	public KdvTipiKartSaveButtonCommand(KdvTipiKartMenu frame) {
		this.frame = frame;
	}

	public void execute() {
		save();
	}

	private void save() {
//		frame.tipKart.saveOrUpdate(frame.kdvKoduField.getText(), frame.kdvAdiField.getText(),
//				Double.parseDouble(frame.kdvOraniField.getText()));
		System.out.println(frame.tipKart.findByIndex(1));
		System.out.println(frame.tipKart.findByIndex(1).get(0));
		List deneme = frame.tipKart.findByIndex(1).get(0);
		System.out.println(deneme.get(0));
		System.out.println(frame.tipKart.findByIndex(1));
	}
}
