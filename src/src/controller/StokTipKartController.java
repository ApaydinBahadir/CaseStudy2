package src.controller;

import src.command.BaseMenuView.BaseMenuViewCodeChangeCommand;
import src.command.StokTipKartı.StokTipKartıBackwardButtonCommand;
import src.command.StokTipKartı.StokTipKartıFirstButtonCommand;
import src.command.StokTipKartı.StokTipKartıForwardButtonCommand;
import src.command.StokTipKartı.StokTipiKartıLastButtonCommand;
import src.command.StokTipKartı.StokTipiKartıSaveButtonCommand;
import src.command.StokTipKartı.StokTipkartıDeleteButtonCommand;
import src.view.MainFrameView;
import src.view.menus.StokTipKartMenuView;

public class StokTipKartController extends BaseMenuController{
	private StokTipKartMenuView tipMenu;
	private MainFrameView mainFrame;

	public StokTipKartController(MainFrameView mainFrame) {
		this.mainFrame = mainFrame;

	}

	public void execute() {
		this.tipMenu = new StokTipKartMenuView();
		tipMenu.setVisible(true);
		mainFrame.desktopPane.add(tipMenu);
		listeners();
		this.navbarCreate(tipMenu);
	}

	private void listeners() {
		this.tipMenu.navbarView.forwardButton.addActionListener(new GeneralAction(new StokTipKartıForwardButtonCommand(tipMenu)));
		this.tipMenu.navbarView.backwardButton.addActionListener(new GeneralAction(new StokTipKartıBackwardButtonCommand(tipMenu)));
		this.tipMenu.navbarView.firstButton.addActionListener(new GeneralAction(new StokTipKartıFirstButtonCommand(tipMenu)));
		this.tipMenu.navbarView.lastButton.addActionListener(new GeneralAction(new StokTipiKartıLastButtonCommand(tipMenu)));
		this.tipMenu.navbarView.saveButton.addActionListener(new GeneralAction(new StokTipiKartıSaveButtonCommand(tipMenu)));
		this.tipMenu.navbarView.deleteButton.addActionListener(new GeneralAction(new StokTipkartıDeleteButtonCommand(tipMenu)));
		if(this.tipMenu.changeKodButton != null) {
			this.tipMenu.changeKodButton.addActionListener(new GeneralAction(new BaseMenuViewCodeChangeCommand(tipMenu)));
		}
	}
}
