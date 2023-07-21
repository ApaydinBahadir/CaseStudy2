package src.controller;

import java.awt.Desktop.Action;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;
import java.util.List;

import javax.swing.JTable;
import javax.swing.event.EventListenerList;

import src.command.StokKartList.StokKartListExcelCommand;
import src.command.StokKartList.StokKartListListCommand;
import src.command.StokKartList.StokKartListMailCommand;
import src.command.StokKartList.StokKartListPDFCommand;
import src.command.StokKartList.StokKartListStokKartButtonCommand;
import src.view.MainFrame;
import src.view.StokKartList;

public class StokKartListController {

	private StokKartList frame;
	private MainFrame mainFrame;

	public StokKartListController(MainFrame mainFrame) {
		this.mainFrame = mainFrame;

	}

	public void execute() {
		this.frame = new StokKartList();
		frame.setVisible(true);
		mainFrame.desktopPane.add(frame);
		listeners();
	}

	private void listeners() {

		frame.excelButton.addActionListener(new GeneralAction(new StokKartListExcelCommand(frame)));
		frame.listele.addActionListener(new GeneralAction(new StokKartListListCommand(frame)));
		frame.pdfButton.addActionListener(new GeneralAction(new StokKartListPDFCommand(frame)));
		frame.mailButton.addActionListener(new GeneralAction(new StokKartListMailCommand(frame)));
		frame.stokKartTable.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					JTable source = (JTable) e.getSource();
					int row = source.rowAtPoint(e.getPoint());
					frame.popupMenu.show(e.getComponent(), e.getX(), e.getY());
					List actions = Arrays.asList(frame.StokKartButton.getActionListeners());
					if (actions.isEmpty()) {
						frame.StokKartButton.addActionListener(
								new GeneralAction(new StokKartListStokKartButtonCommand(mainFrame, frame, row)));
					} else {
						    for( ActionListener al :frame.StokKartButton.getActionListeners() ) {
						    	frame.StokKartButton.removeActionListener( al );
						    }
						
						
						frame.StokKartButton.addActionListener(
								new GeneralAction(new StokKartListStokKartButtonCommand(mainFrame, frame, row)));

					}

				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
	}

}
