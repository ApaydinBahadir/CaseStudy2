package src.command.BaseMenuView;

import src.command.Command;
import src.controller.KodChangeViewController;
import src.view.baseViews.BaseMenuFrame;

public class BaseMenuViewCodeChangeCommand implements Command{
	
	BaseMenuFrame frame;

	public BaseMenuViewCodeChangeCommand(BaseMenuFrame frame) {
		this.frame = frame;
	}
	
	@Override
	public void execute() {
		KodChangeViewController changeViewController = new KodChangeViewController(frame,frame.kod.getText());
		changeViewController.execute();
	}
	
	
}
