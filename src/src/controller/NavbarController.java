package src.controller;

import src.view.baseViews.BaseMenuFrame;
import src.view.layouts.NavbarView;

public class NavbarController {

	NavbarView frame2;
	BaseMenuFrame frame = new BaseMenuFrame();

	public NavbarController(BaseMenuFrame frame) {
		this.frame = frame;
	}

	public void execute() {
		listeners();
	}

	public void listeners() {

	}
}
