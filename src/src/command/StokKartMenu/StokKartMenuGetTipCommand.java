package src.command.StokKartMenu;

import src.command.Command;
import src.model.KdvTipKart;
import src.model.StokTipiKart;
import src.view.StokKartMenu;

public class StokKartMenuGetTipCommand implements Command{
	

	StokKartMenu frame;
	
	public StokKartMenuGetTipCommand(StokKartMenu frame) {
		this.frame = frame;
	}
	
	
	@Override
	public void execute() {
		addKDV();
	}
	
	public void addKDV(){
		for(
				StokTipiKart kart:frame.stokTipiKart.getTipList()) {
			frame.stokTipiField.addItem(kart.getKodu());
		}
	}
}
