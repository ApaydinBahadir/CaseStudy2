package src.command.CodeChange;

import src.command.Command;
import src.view.baseViews.BaseMenuFrame;
import src.view.layouts.KodChangeView;

public class CodeChangeCancelButtonCommand implements Command {
	BaseMenuFrame frame;
	KodChangeView changeFrame;

	public CodeChangeCancelButtonCommand(BaseMenuFrame frame, KodChangeView changeFrame) {
		this.frame = frame;
		this.changeFrame = changeFrame;
	}

	@Override
	public void execute() {
		changeFrame.setVisible(false);
		changeFrame.dispose();
	}

}
