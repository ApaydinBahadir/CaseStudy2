package src.command.KdvTipiKart;

import java.util.List;

import src.command.Command;
import src.view.KdvTipiKartMenu;

public class KdvTipiKartBackwardButtonCommand implements Command {

	KdvTipiKartMenu frame;

	public KdvTipiKartBackwardButtonCommand(KdvTipiKartMenu frame) {
		this.frame = frame;
	}

	public void execute() {
		frame.limitLooker = frame.limitLooker - 1;

		findByLimit();
	}

	private void findByLimit() {

		if (frame.limitLooker > frame.maxLimit) {
			frame.limitLooker = frame.limitLooker % frame.maxLimit;
		}

		if (frame.limitLooker < 0) {
			frame.limitLooker = frame.maxLimit;
		}
		List deneme = frame.tipKart.findByIndex(frame.limitLooker).get(0);
		frame.kdvKoduField.setText(deneme.get(1).toString());
		frame.kdvAdiField.setText(deneme.get(2).toString());
		frame.kdvOraniField.setText(deneme.get(3).toString());

	}
}
