package src.command.Navbar;

import src.command.Command;
import src.controller.NavbarController;
import src.view.BaseMenuFrame;
import src.view.layouts.NavbarView;

public class NavbarCreateCommand implements Command {

	BaseMenuFrame frame;

	public NavbarCreateCommand(BaseMenuFrame frame) {
		this.frame = frame;
	}

	@Override
	public void execute() {
		navbar();
	}

	private void navbar() {
		NavbarController command = new NavbarController(frame);
		command.execute();
	}
}
