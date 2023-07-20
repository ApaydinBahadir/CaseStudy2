package src.command.StokKartMenu;

import src.command.Command;
import src.model.KdvTipKart;
import src.view.StokKartMenu;

public class StokKartMenuGetKDVCommand implements Command{

	StokKartMenu frame;
	
	public StokKartMenuGetKDVCommand(StokKartMenu frame) {
		this.frame = frame;
	}
	
	
	@Override
	public void execute() {
		addKDV();
	}
	
	public void addKDV(){
		for(
				KdvTipKart kart:frame.kdvTipiKart.getKDV()) {
			frame.kdvTipiField.addItem(kart.getOrani());
		}
	}

}
