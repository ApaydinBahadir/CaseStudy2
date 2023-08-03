package src.command.KdvKartMenu;

import src.command.Command;
import src.view.KdvTipiKartMenuView;

public class KdvKartMenuForwardButtonCommand implements Command {

	KdvTipiKartMenuView frame;

	public KdvKartMenuForwardButtonCommand(KdvTipiKartMenuView frame) {
		this.frame = frame;
	}

	@Override
	public void execute() {
		frame.model.travelseForward(frame.kod.getText(), frame);
	}



}
