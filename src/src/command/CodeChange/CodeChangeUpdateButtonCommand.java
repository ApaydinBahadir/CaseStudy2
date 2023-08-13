package src.command.CodeChange;

import src.command.Command;
import src.view.baseViews.BaseMenuFrame;
import src.view.layouts.KodChangeView;

public class CodeChangeUpdateButtonCommand implements Command {

	BaseMenuFrame frame;
	KodChangeView changeFrame;

	public CodeChangeUpdateButtonCommand(BaseMenuFrame frame, KodChangeView changeFrame) {
		this.frame = frame;
		this.changeFrame = changeFrame;
	}

	@Override
	public void execute() {
		frame.model.updateKod(changeFrame.eskiKod.getText(),changeFrame.yeniKod.getText(),frame);
		frame.kod.setText(changeFrame.yeniKod.getText());
		changeFrame.setVisible(false);
		changeFrame.dispose();
	}
}
