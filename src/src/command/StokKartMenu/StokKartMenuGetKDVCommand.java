package src.command.StokKartMenu;

import src.command.Command;
import src.model.KdvTipKart;
import src.view.StokKartMenuView;

public class StokKartMenuGetKDVCommand implements Command{

	StokKartMenuView frame;
	
	public StokKartMenuGetKDVCommand(StokKartMenuView frame) {
		this.frame = frame;
	}
	
	
	@Override
	public void execute() {
		addKDV();
	}
	
	public void addKDV(){
		for(
				KdvTipKart kart:frame.kdvTipiKart.getKDV()) {
			frame.kdvTipiField.addItem(kart);
		}
	}

}
