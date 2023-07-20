package src.command.StokTipKartı;

import java.util.List;

import src.command.Command;
import src.view.StokTipKartMenu;

public class StokTipKartForwardButtonCommand implements Command {

	StokTipKartMenu frame;

	public StokTipKartForwardButtonCommand(StokTipKartMenu frame) {
		this.frame = frame;
	}

	public void execute() {
		frame.limitLooker = frame.limitLooker + 1;

		findByLimit(frame.limitLooker);
	}

	private void findByLimit(int limit) {

		if (frame.limitLooker >= frame.maxLimit) {
			frame.limitLooker = frame.limitLooker % frame.maxLimit;
		}

		if (frame.limitLooker < 0) {
			frame.limitLooker = frame.maxLimit;
		}

		List deneme = frame.kart.findByIndex(frame.limitLooker).get(0);
		frame.tipKodField.setText(deneme.get(1).toString());
		frame.tipAdiField.setText(deneme.get(2).toString());
		frame.tipAciklamaField.setText(deneme.get(3).toString());
	}
}
