package src.view.comboBox;

import java.util.List;
import java.util.Vector;
import javax.swing.JComboBox;
import src.model.KdvTipKart;

public class KdvTipComboBox extends JComboBox<KdvTipKart> {

	private Vector<KdvTipKart> itemList = new Vector<KdvTipKart>();

	public KdvTipComboBox() {
		super();

	}

	public void fillData(List<KdvTipKart> items) {
		for (KdvTipKart kart : items) {
			itemList.add(kart);
		}
		for (KdvTipKart i : itemList) {
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
