package src.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import src.command.Command;

public class GeneralAction implements ActionListener{
    private Command command;
    public GeneralAction(Command command) {
        this.command = command;
    }

	@Override
	public void actionPerformed(ActionEvent e) {
        command.execute();		
	}
}
