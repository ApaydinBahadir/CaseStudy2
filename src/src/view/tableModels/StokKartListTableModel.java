package src.view.tableModels;

import java.util.List;
import java.util.Vector;

import javax.swing.event.TableModelEvent;

import src.model.StokKart;

public class StokKartListTableModel extends BaseTableModel {

	private Vector<String> tableColumnNames = new Vector<String>() {
		{
			add("Stok Kodu");
			add("Stok Adı");
			add("Stok Tipi");
			add("Stok Tipi Adı");
			add("Stok Tipi Açıklama");
			add("Birimi");
			add("Barkodu");
			add("KDV Tipi");
			add("KDV Tipi Adı");
			add("KDV Tipi Oranı");
			add("Açıklama");
			add("Oluşturma Tarihi");
		}
	};

	private Vector<StokKart> data;

	public List getColumnsNames() {
		return tableColumnNames;
	}
	
	private static <E> Vector<E> newVector(int size) {
		Vector<E> v = new Vector<>(size);
		v.setSize(size);
		return v;
	}

	private static <E> Vector nonNullVector(Vector<E> v) {
		return (v != null) ? v : new Vector<StokKart>();
	}

	public StokKartListTableModel() {
		setDataVector(newVector(0), tableColumnNames);
	}

	public StokKartListTableModel(int rowCount, int columnCount) {
		this(newVector(columnCount), rowCount);
	}

	public StokKartListTableModel(Vector<?> columnNames, int rowCount) {
		setDataVector(newVector(rowCount), tableColumnNames);
	}

	public void setDataVector(Vector<? extends Vector> dataVector, Vector<String> columnIdentifiers) {
		this.data = nonNullVector((Vector) dataVector);
		this.tableColumnNames = nonNullVector(columnIdentifiers);
		justifyRows(0, getRowCount());
		fireTableStructureChanged();
	}

	@Override
	public int getRowCount() {
		return this.data.size();
	}

	@Override
	public int getColumnCount() {
		return tableColumnNames.size();
	}

	public boolean isCellEditable(int row, int column) {
		return false;
	}

	private void justifyRows(int from, int to) {
		data.setSize(getRowCount());
		for (int i = from; i < to; i++) {
			if (data.elementAt(i) == null) {
				data.setElementAt(new StokKart(), i);
			}
		}
	}

	public void newRowsAdded(TableModelEvent e) {
		justifyRows(e.getFirstRow(), e.getLastRow() + 1);
		fireTableChanged(e);
	}

	public void insertRow(int row, StokKart rowData) {
		data.insertElementAt(rowData, row);
		justifyRows(row, row + 1);
		fireTableRowsInserted(row, row);
	}

	@Override
	public Object getValueAt(int row, int column) {
		switch (column) {
		case 0: {

			return data.get(row).getStokKodu();
		}
		case 1: {

			return data.get(row).getStokAdi();
		}
		case 2: {

			return data.get(row).getStokTipi().getKodu();
		}
		case 3: {
			return data.get(row).getStokTipi().getAdi();
		}
		case 4: {
			return data.get(row).getStokTipi().getAciklama();
		}
		case 5: {
			return data.get(row).getBirim();
		}
		case 6: {
			return data.get(row).getBarkod();
		}
		case 7: {
			return data.get(row).getKdvtipi().getKodu();
		}
		case 8: {
			return data.get(row).getKdvtipi().getAdi();
		}
		case 9: {
			return data.get(row).getKdvtipi().getOrani();
		}
		case 10: {
			return data.get(row).getAciklama();
		}
		case 11: {
			return data.get(row).getOlusturmaTarihi();
		}

		default:
			throw new IllegalArgumentException("Unexpected value: " + column);
		}
	}

	public void addRow(StokKart rowData) {
		insertRow(getRowCount(), rowData);
	}

	public void setNumRows(int rowCount) {
		int old = getRowCount();
		if (old == rowCount) {
			return;
		}
		data.setSize(rowCount);
		if (rowCount <= old) {
			fireTableRowsDeleted(rowCount, old - 1);
		} else {
			justifyRows(old, rowCount);
			fireTableRowsInserted(old, rowCount - 1);
		}
	}

	public void setRowCount(int rowCount) {
		setNumRows(rowCount);
	}

	protected static Vector<Object> convertToVector(Object[] anArray) {
		if (anArray == null) {
			return null;
		}
		Vector<Object> v = new Vector<>(anArray.length);
		for (Object o : anArray) {
			v.addElement(o);
		}
		return v;
	}

	public StokKart getRowValue(int row) {
		StokKart rowVector = data.elementAt(row);
		return rowVector;
	}

	public String getColumnName(int column) {
		Object id = null;
		// This test is to cover the case when
		// getColumnCount has been subclassed by mistake ...
		if (column < tableColumnNames.size() && (column >= 0)) {
			id = tableColumnNames.elementAt(column);
		}
		return (id == null) ? super.getColumnName(column) : id.toString();
	}

}
