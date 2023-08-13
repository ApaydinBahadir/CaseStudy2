package src.command.StokTipKartı;

import src.command.Command;
import src.view.menus.StokTipKartMenuView;

public class StokTipkartıDeleteButtonCommand implements Command {

	StokTipKartMenuView frame;

	public StokTipkartıDeleteButtonCommand(StokTipKartMenuView frame) {
		this.frame = frame;
	}

	@Override
	public void execute() {
		frame.model.delete(frame.kod.getText());
	}

}
