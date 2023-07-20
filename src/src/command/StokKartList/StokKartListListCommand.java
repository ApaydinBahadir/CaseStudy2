package src.command.StokKartList;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import java.util.stream.Stream;

import javax.swing.table.DefaultTableModel;

import src.command.Command;
import src.model.StokKart;
import src.view.StokKartList;
import src.view.StokKartMenu;

public class StokKartListListCommand implements Command {

	StokKartList frame;
	List<Object> listAll = new ArrayList<Object>();
	Vector<Object> deneme;

	public StokKartListListCommand(StokKartList frame) {
		this.frame = frame;
	}

	@Override
	public void execute() {
		listele();
	}

	void listele() {
		if (!listAll.isEmpty()) {
			listAll.removeAll(listAll);
		}

		listAll.addAll(frame.stokModel.listStoks());
		frame.model = (DefaultTableModel) frame.stokKartTable.getModel();
		frame.model.setRowCount(0);

		
		for (List<String> obj : frame.stokModel.getAllRows()) {			
			
			Object[] rows = { obj.get(0), obj.get(1),
					obj.get(2), obj.get(3),
					obj.get(4), obj.get(5), obj.get(6),
					obj.get(7), obj.get(8), obj.get(9),
					obj.get(10), obj.get(11) };
			frame.model.addRow(rows);
		}
	}

}
