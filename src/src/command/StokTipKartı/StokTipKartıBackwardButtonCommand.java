package src.command.StokTipKartı;

import src.command.Command;
import src.view.StokTipKartMenuView;

public class StokTipKartıBackwardButtonCommand implements Command{
	
	StokTipKartMenuView frame;
	
	public StokTipKartıBackwardButtonCommand(StokTipKartMenuView frame) {
		this.frame = frame;
	}

	@Override
	public void execute() {
		frame.model.travelseBackward(frame.kod.getText(), frame);
	}
}