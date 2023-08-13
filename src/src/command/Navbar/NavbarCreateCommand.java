package src.command.Navbar;

import src.command.Command;
import src.controller.NavbarController;
import src.view.baseViews.BaseMenuFrame;

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
