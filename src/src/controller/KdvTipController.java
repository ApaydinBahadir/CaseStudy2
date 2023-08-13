package src.controller;

import src.command.BaseMenuView.BaseMenuViewCodeChangeCommand;
import src.command.KdvKartMenu.KdvKartMenuBackwardButtonCommand;
import src.command.KdvKartMenu.KdvKartMenuDeleteButtonCommand;
import src.command.KdvKartMenu.KdvKartMenuFirstButtonCommand;
import src.command.KdvKartMenu.KdvKartMenuForwardButtonCommand;
import src.command.KdvKartMenu.KdvKartMenuLastButtonCommand;
import src.command.KdvKartMenu.KdvKartMenuSaveButtonCommand;
import src.view.MainFrameView;
import src.view.menus.KdvTipiKartMenuView;

public class KdvTipController extends BaseMenuController {
	private MainFrameView mainFrame;

	KdvTipiKartMenuView frame;

	public KdvTipController(MainFrameView mainFrame) {
		this.mainFrame = mainFrame;

	}

	public void execute() {
		this.frame = new KdvTipiKartMenuView();
		frame.setVisible(true);
		mainFrame.desktopPane.add(frame);
		listeners();
		this.navbarCreate(frame);

	}

	private void listeners() {
		frame.navbarView.forwardButton.addActionListener(new GeneralAction(new KdvKartMenuForwardButtonCommand(frame)));
		frame.navbarView.backwardButton.addActionListener(new GeneralAction(new KdvKartMenuBackwardButtonCommand(frame)));
		frame.navbarView.firstButton.addActionListener(new GeneralAction(new KdvKartMenuFirstButtonCommand(frame)));
		frame.navbarView.lastButton.addActionListener(new GeneralAction(new KdvKartMenuLastButtonCommand(frame)));
		frame.navbarView.deleteButton.addActionListener(new GeneralAction(new KdvKartMenuDeleteButtonCommand(frame)));
		frame.navbarView.saveButton.addActionListener(new GeneralAction(new KdvKartMenuSaveButtonCommand(frame)));
		
		if(frame.changeKodButton != null) {
			frame.changeKodButton.addActionListener(new GeneralAction(new BaseMenuViewCodeChangeCommand(frame)));
		}
		
		

	}
}
