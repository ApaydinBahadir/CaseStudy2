package src.controller;

import src.command.KdvTipiKart.KdvTipiKartBackwardButtonCommand;
import src.command.KdvTipiKart.KdvTipiKartFirstButtonCommand;
import src.command.KdvTipiKart.KdvTipiKartForwardButtonCommand;
import src.command.KdvTipiKart.KdvTipiKartLastButtonCommand;
import src.command.KdvTipiKart.KdvTipiKartSaveButtonCommand;
import src.view.KdvTipiKartMenu;
import src.view.MainFrame;

public class KdvTipController {
	private KdvTipiKartMenu frame;
	private MainFrame mainFrame;

	public KdvTipController(MainFrame mainFrame) {
		this.mainFrame = mainFrame;

	}

	public void execute() {
		this.frame = new KdvTipiKartMenu();
		frame.setVisible(true);
		mainFrame.desktopPane.add(frame);
		listeners();
	}

	private void listeners() {
		frame.saveButton.addActionListener(new GeneralAction(new KdvTipiKartSaveButtonCommand(frame)));
		frame.forwardButton.addActionListener(new GeneralAction(new KdvTipiKartForwardButtonCommand(frame)));
		frame.lastButton.addActionListener(new GeneralAction(new KdvTipiKartLastButtonCommand(frame)));
		frame.backwardButton.addActionListener(new GeneralAction(new KdvTipiKartBackwardButtonCommand(frame)));
		frame.firstButton.addActionListener(new GeneralAction(new KdvTipiKartFirstButtonCommand(frame)));
	}
}
