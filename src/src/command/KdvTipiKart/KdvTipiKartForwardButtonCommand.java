package src.command.KdvTipiKart;

import java.util.List;

import src.command.Command;
import src.view.KdvTipiKartMenu;

public class KdvTipiKartForwardButtonCommand implements Command {
	KdvTipiKartMenu frame;

	public KdvTipiKartForwardButtonCommand(KdvTipiKartMenu frame) {
		this.frame = frame;
	}

	public void execute() {
		frame.limitLooker = frame.limitLooker + 1;

		findByLimit();
	}

	private void findByLimit() {


		if (frame.limitLooker >= frame.maxLimit) {
			frame.limitLooker = frame.limitLooker % 3;
		}

		if (frame.limitLooker < 0) {
			frame.limitLooker = frame.limitLooker * -1;
		}
		List deneme = frame.tipKart.findByIndex(frame.limitLooker).get(0);
		frame.kdvKoduField.setText(deneme.get(1).toString());
		frame.kdvAdiField.setText(deneme.get(2).toString());
		frame.kdvOraniField.setText(deneme.get(3).toString());
	}
}
