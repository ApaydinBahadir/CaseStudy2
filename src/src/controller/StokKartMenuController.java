package src.controller;

import java.awt.Desktop.Action;
import java.awt.event.ActionEvent;
import java.util.Date;
import java.util.List;

import src.command.StokKartMenu.StokKartMenuDeleteCommand;
import src.command.StokKartMenu.StokKartMenuGetKDVCommand;
import src.command.StokKartMenu.StokKartMenuGetTipCommand;
import src.command.StokKartMenu.StokKartMenuSaveCommand;
import src.model.StokKart;
import src.view.MainFrame;
import src.view.StokKartMenu;

public class StokKartMenuController {

	private StokKartMenu kartMenu;
	private MainFrame mainFrame;

	public StokKartMenuController(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
	}
	
	public StokKartMenuController(MainFrame mainFrame,List datas) {
		this.mainFrame = mainFrame;
		execute();
		this.kartMenu.refreshButton.doClick();
		this.kartMenu.stokKoduField.setText((String) datas.get(0));
		this.kartMenu.stokAdiField.setText((String) datas.get(1));
		this.kartMenu.stokTipiField.setSelectedItem(((String) datas.get(2)));
		this.kartMenu.birimField.setSelectedItem(datas.get(3));
		this.kartMenu.barkodField.setText((String) datas.get(4));
		this.kartMenu.kdvTipiField.setSelectedItem(datas.get(5));
		this.kartMenu.aciklamaField.setText((String)datas.get(6));
		this.kartMenu.olusTarihField.setDate((Date) datas.get(7));
		
	}

	public void execute() {
		this.kartMenu = new StokKartMenu();
		kartMenu.setVisible(true);
		mainFrame.add(kartMenu);
		listeners();
	}

	private void listeners() {
		kartMenu.refreshButton.addActionListener(new GeneralAction(new StokKartMenuGetKDVCommand(kartMenu)));
		kartMenu.refreshButton.addActionListener(new GeneralAction(new StokKartMenuGetTipCommand(kartMenu)));
		kartMenu.saveButton.addActionListener(new GeneralAction(new StokKartMenuSaveCommand(kartMenu)));
		kartMenu.deleteButton.addActionListener(new GeneralAction(new StokKartMenuDeleteCommand(kartMenu)));
	}

}
