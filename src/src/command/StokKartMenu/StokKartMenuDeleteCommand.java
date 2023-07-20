package src.command.StokKartMenu;

import src.command.Command;
import src.view.StokKartMenu;

public class StokKartMenuDeleteCommand implements Command {
	StokKartMenu frame;
	
	public StokKartMenuDeleteCommand(StokKartMenu frame) {
		this.frame = frame;
	}

	@Override
	public void execute() {
		delete();
	}
	
	void delete() {
		frame.stokKart.delete(frame.stokKoduField.getText());
	}
	

}
