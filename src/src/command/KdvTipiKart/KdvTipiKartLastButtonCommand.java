package src.command.KdvTipiKart;

import java.util.List;

import src.command.Command;
import src.view.KdvTipiKartMenu;

public class KdvTipiKartLastButtonCommand implements Command{
	KdvTipiKartMenu frame;

	public KdvTipiKartLastButtonCommand(KdvTipiKartMenu frame) {
		this.frame = frame;
	}

	public void execute() {
		frame.limitLooker = frame.maxLimit-1;
		
		findByLimit();
	}

	private void findByLimit() {

		List deneme = frame.tipKart.findByIndex(frame.limitLooker).get(0);
		frame.kdvKoduField.setText(deneme.get(1).toString());
		frame.kdvAdiField.setText(deneme.get(2).toString());
		frame.kdvOraniField.setText(deneme.get(3).toString());
	}
}
