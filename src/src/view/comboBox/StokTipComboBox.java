package src.view.comboBox;

import java.util.List;
import java.util.Vector;

import javax.swing.JComboBox;

import src.model.StokTipiKart;

public class StokTipComboBox extends JComboBox<StokTipiKart> {
	private static final long serialVersionUID = 1L;
	private Vector<StokTipiKart> itemList = new Vector<StokTipiKart>();

	public StokTipComboBox() {
		super();

	}

	public void fillData(List<StokTipiKart> items) {
		for (StokTipiKart kart : items) {
			itemList.add(kart);
		}
		for (StokTipiKart i : itemList) {
			this.addItem(i);
		}
	}

	public void setItem(Object anObject) {
		for (int i = 0; i < itemList.size(); i++) {
			if ((itemList.get(i).getId() == (int) anObject)) {
				this.dataModel.setSelectedItem(itemList.get(i));
			}
		}
	}

}