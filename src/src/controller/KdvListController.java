package src.controller;

import src.command.KdvList.KdvListExcelCommand;
import src.command.KdvList.KdvListListeleCommand;
import src.command.StokKartList.StokKartListListCommand;
import src.view.KdvListView;
import src.view.MainFrameView;

public class KdvListController {
	private MainFrameView mainFrame;

	KdvListView frame;

	public KdvListController(MainFrameView mainFrame) {
		this.mainFrame = mainFrame;

	}

	public void execute() {
		this.frame = new KdvListView();
		frame.setVisible(true);
		mainFrame.desktopPane.add(frame);
		listeners();
	}

	private void listeners() {
		frame.listele.addActionListener(new GeneralAction(new KdvListListeleCommand(frame)));
		frame.excelButton.addActionListener(new GeneralAction(new KdvListExcelCommand(frame)));

	}
}
