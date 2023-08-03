package src.command.StokTipKartı;

import src.command.Command;
import src.view.StokTipKartMenuView;

public class StokTipKartıForwardButtonCommand implements Command{
	
	StokTipKartMenuView frame;
	
	public StokTipKartıForwardButtonCommand(StokTipKartMenuView frame) {
		this.frame = frame;
	}

	@Override
	public void execute() {
		frame.model.travelseForward(frame.kod.getText(), frame);
	}
}
