package src.command.StokTipKartı;

import java.util.List;

import src.command.Command;
import src.view.StokTipKartMenu;

public class StokTipKartLastButtonCommand implements Command {

	StokTipKartMenu frame;

	public StokTipKartLastButtonCommand(StokTipKartMenu frame) {
		this.frame = frame;
	}

	public void execute() {
		frame.limitLooker = frame.maxLimit-1;

		findByLimit(frame.limitLooker);
	}

	private void findByLimit(int limit) {

		List deneme = frame.kart.findByIndex(frame.limitLooker).get(0);
		frame.tipKodField.setText(deneme.get(1).toString());
		frame.tipAdiField.setText(deneme.get(2).toString());
		frame.tipAciklamaField.setText(deneme.get(3).toString());
	}
}
