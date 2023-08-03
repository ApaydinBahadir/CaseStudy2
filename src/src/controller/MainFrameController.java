package src.controller;

import src.command.MainFrame.MainFrameKdvListCommand;
import src.command.MainFrame.MainFrameKdvMenuCommand;
import src.command.MainFrame.MainFrameStokListCommand;
import src.command.MainFrame.MainFrameStokMenuCommand;
import src.command.MainFrame.MainFrameStokTipMenuCommand;
import src.view.MainFrameView;

public class MainFrameController {
	private MainFrameView mainFrame;

	public MainFrameController(MainFrameView mainFrame) {
		this.mainFrame = mainFrame;
		execute();
	}

	public void execute() {
		mainFrame.setVisible(true);
		listeners();
	}

	private void listeners() {

		mainFrame.getStokKartList().addActionListener(new GeneralAction(new MainFrameStokListCommand(mainFrame)));
		mainFrame.stokKartMenu.addActionListener(new GeneralAction(new MainFrameStokMenuCommand(mainFrame)));
		mainFrame.kdvTip.addActionListener(new GeneralAction(new MainFrameKdvMenuCommand(mainFrame)));
		mainFrame.StokKartTip.addActionListener(new GeneralAction(new MainFrameStokTipMenuCommand(mainFrame)));
		mainFrame.kdvList.addActionListener(new GeneralAction(new MainFrameKdvListCommand(mainFrame)));

	}

}
