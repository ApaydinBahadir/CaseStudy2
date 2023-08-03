package src.command.KdvKartMenu;

import src.command.Command;
import src.view.KdvTipiKartMenuView;

public class KdvKartMenuBackwardButtonCommand implements Command{
	
	KdvTipiKartMenuView frame;

	public KdvKartMenuBackwardButtonCommand(KdvTipiKartMenuView frame) {
		this.frame = frame;
	}
	
	@Override
	public void execute() {
		frame.model.travelseBackward(frame.kod.getText(), frame);
	}

}
