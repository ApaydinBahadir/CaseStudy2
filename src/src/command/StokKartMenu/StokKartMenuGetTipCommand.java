package src.command.StokKartMenu;

import src.command.Command;
import src.model.StokTipiKart;
import src.view.StokKartMenuView;

public class StokKartMenuGetTipCommand implements Command{
	

	StokKartMenuView frame;
	
	public StokKartMenuGetTipCommand(StokKartMenuView frame) {
		this.frame = frame;
	}
	
	
	@Override
	public void execute() {
		addKDV();
	}
	
	public void addKDV(){
		for(
				StokTipiKart kart:frame.stokTipiKart.getTipList()) {
			frame.stokTipiField.addItem(kart);
		}
	}
}
