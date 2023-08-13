package src.controller;

import src.command.CodeChange.CodeChangeCancelButtonCommand;
import src.command.CodeChange.CodeChangeUpdateButtonCommand;
import src.view.baseViews.BaseMenuFrame;
import src.view.layouts.KodChangeView;

public class KodChangeViewController {
	BaseMenuFrame frame;
	KodChangeView changeFrame;
	Object degisenDeger;

	public KodChangeViewController(BaseMenuFrame frame, Object degisenDeger) {
		this.frame = frame;
		this.degisenDeger = degisenDeger;
	}

	public void execute() {
		this.changeFrame = new KodChangeView();
		changeFrame.eskiKod.setText((String) degisenDeger);
		changeFrame.eskiKod.setEditable(false);
		changeFrame.setVisible(true);

		listeners();
	}

	private void listeners() {
		changeFrame.okButton
				.addActionListener(new GeneralAction(new CodeChangeUpdateButtonCommand(frame, changeFrame)));
		changeFrame.cancelButton.addActionListener(new GeneralAction(new CodeChangeCancelButtonCommand(frame, changeFrame)));
	}

}
