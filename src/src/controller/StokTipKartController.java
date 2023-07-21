package src.controller;

import src.command.StokTipKartı.StokTipKartBackwardButtonCommand;
import src.command.StokTipKartı.StokTipKartFirstButtonCommand;
import src.command.StokTipKartı.StokTipKartForwardButtonCommand;
import src.command.StokTipKartı.StokTipKartLastButtonCommand;
import src.command.StokTipKartı.StokTipKartSaveButtonCommand;
import src.view.MainFrame;
import src.view.StokTipKartMenu;

public class StokTipKartController {
	private StokTipKartMenu tipMenu;
	private MainFrame mainFrame;

	public StokTipKartController(MainFrame mainFrame) {
		this.mainFrame = mainFrame;

	}

	public void execute() {
		this.tipMenu = new StokTipKartMenu();
		tipMenu.setVisible(true);
		mainFrame.desktopPane.add(tipMenu);
		listeners();
	}

	private void listeners() {
		tipMenu.saveButton.addActionListener(new GeneralAction(new StokTipKartSaveButtonCommand(tipMenu)));
		tipMenu.forwardButton.addActionListener(new GeneralAction(new StokTipKartForwardButtonCommand(tipMenu)));
		tipMenu.lastButton.addActionListener(new GeneralAction(new StokTipKartLastButtonCommand(tipMenu)));
		tipMenu.backwardButton.addActionListener(new GeneralAction(new StokTipKartBackwardButtonCommand(tipMenu)));
		tipMenu.firstButton.addActionListener(new GeneralAction(new StokTipKartFirstButtonCommand(tipMenu)));
	}
}
