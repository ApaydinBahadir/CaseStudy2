package src.controller;

import java.util.Date;
import java.util.List;

import javax.swing.JInternalFrame;

import src.command.StokKartMenu.StokKartMenuDeleteCommand;
import src.command.StokKartMenu.StokKartMenuGetKDVCommand;
import src.command.StokKartMenu.StokKartMenuGetTipCommand;
import src.command.StokKartMenu.StokKartMenuSaveCommand;
import src.view.MainFrame;
import src.view.StokKartMenu;

public class StokKartMenuController {

	private StokKartMenu kartMenu;
	private MainFrame mainFrame;

	public StokKartMenuController(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
	}

	public StokKartMenuController(MainFrame mainFrame, List datas) {
		this.mainFrame = mainFrame;
		Boolean check = null;

		for (int i = 0; i <= mainFrame.desktopPane.getComponentCount() - 1; i++) {
			if (mainFrame.desktopPane.getComponent(i) instanceof StokKartMenu) {
				this.kartMenu = (StokKartMenu) mainFrame.desktopPane.getComponent(i);
				check = false;
				break;
			}
			check = true;
		}

		if (check) {
			execute();
		}

			this.kartMenu.refreshButton.doClick();

		this.kartMenu.stokKoduField.setText((String) datas.get(0));
		this.kartMenu.stokAdiField.setText((String) datas.get(1));
		this.kartMenu.stokTipiField.setSelectedItem(Integer.parseInt((String) datas.get(2)));
		this.kartMenu.birimField.setSelectedItem(datas.get(5));
		this.kartMenu.barkodField.setText((String) datas.get(6));
		this.kartMenu.kdvTipiField.setSelectedItem(datas.get(9));
		this.kartMenu.aciklamaField.setText((String) datas.get(10));
		this.kartMenu.olusTarihField.setDate((Date) datas.get(11));

	}

	public void execute() {
		this.kartMenu = new StokKartMenu();
		kartMenu.setVisible(true);
		mainFrame.desktopPane.add(kartMenu);
		listeners();
	}

	private void listeners() {
		kartMenu.refreshButton.addActionListener(new GeneralAction(new StokKartMenuGetKDVCommand(kartMenu)));
		kartMenu.refreshButton.addActionListener(new GeneralAction(new StokKartMenuGetTipCommand(kartMenu)));
		kartMenu.saveButton.addActionListener(new GeneralAction(new StokKartMenuSaveCommand(kartMenu)));
		kartMenu.deleteButton.addActionListener(new GeneralAction(new StokKartMenuDeleteCommand(kartMenu)));
	}

}
