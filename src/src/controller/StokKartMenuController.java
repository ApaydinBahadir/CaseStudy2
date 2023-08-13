package src.controller;

import java.util.List;

import src.command.BaseMenuView.BaseMenuViewCodeChangeCommand;
import src.command.StokKartMenu.StokKartMenuBackwardButtonCommand;
import src.command.StokKartMenu.StokKartMenuDeleteButtonCommand;
import src.command.StokKartMenu.StokKartMenuFirstButtonCommand;
import src.command.StokKartMenu.StokKartMenuForwardButtonCommand;
import src.command.StokKartMenu.StokKartMenuGetKDVCommand;
import src.command.StokKartMenu.StokKartMenuGetTipCommand;
import src.command.StokKartMenu.StokKartMenuLastButtonCommand;
import src.command.StokKartMenu.StokKartMenuSaveButtonCommand;
import src.model.StokKart;
import src.view.MainFrameView;
import src.view.menus.StokKartMenuView;

public class StokKartMenuController extends BaseMenuController {

	private StokKartMenuView frame;
	private MainFrameView mainFrame;

	public StokKartMenuController(MainFrameView mainFrame) {
		this.mainFrame = mainFrame;
	}

	public StokKartMenuController(MainFrameView mainFrame, StokKart stokKart) {
		this.mainFrame = mainFrame;
		Boolean check = null;

		for (int i = 0; i <= mainFrame.desktopPane.getComponentCount() - 1; i++) {
			if (mainFrame.desktopPane.getComponent(i) instanceof StokKartMenuView) {
				this.frame = (StokKartMenuView) mainFrame.desktopPane.getComponent(i);
				check = false;
				break;
			}
			check = true;
		}

		if (check) {
			execute();
		} else {
			new StokKartMenuGetKDVCommand(frame).execute();
			new StokKartMenuGetTipCommand(frame).execute();
		}

		this.frame.stokKart.setData(stokKart, frame);

	}

	public void execute() {
		this.frame = new StokKartMenuView();
		frame.setVisible(true);
		mainFrame.desktopPane.add(frame);
		this.navbarCreate(frame);

		listeners();
		new StokKartMenuGetKDVCommand(frame).execute();
		new StokKartMenuGetTipCommand(frame).execute();

	}

	private void listeners() {
		this.frame.navbarView.forwardButton
				.addActionListener(new GeneralAction(new StokKartMenuForwardButtonCommand(frame)));
		this.frame.navbarView.backwardButton
				.addActionListener(new GeneralAction(new StokKartMenuBackwardButtonCommand(frame)));
		this.frame.navbarView.firstButton
				.addActionListener(new GeneralAction(new StokKartMenuFirstButtonCommand(frame)));
		this.frame.navbarView.lastButton.addActionListener(new GeneralAction(new StokKartMenuLastButtonCommand(frame)));
		this.frame.navbarView.saveButton.addActionListener(new GeneralAction(new StokKartMenuSaveButtonCommand(frame)));
		this.frame.navbarView.deleteButton
				.addActionListener(new GeneralAction(new StokKartMenuDeleteButtonCommand(frame)));
		
		if(this.frame.changeKodButton != null) {
			this.frame.changeKodButton.addActionListener(new GeneralAction(new BaseMenuViewCodeChangeCommand(frame)));
		}
	}

}
