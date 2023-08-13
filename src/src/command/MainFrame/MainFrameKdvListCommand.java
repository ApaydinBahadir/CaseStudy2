package src.command.MainFrame;

import src.command.Command;
import src.controller.KdvListController;
import src.view.MainFrameView;

public class MainFrameKdvListCommand implements Command {

	private MainFrameView frame;

	public MainFrameKdvListCommand(MainFrameView frame) {
		this.frame = frame;
	}

	@Override
	public void execute() {
		showStokKdvList();

	}

	private void showStokKdvList() {
		KdvListController command = new KdvListController(frame);
		command.execute();
	}
}
