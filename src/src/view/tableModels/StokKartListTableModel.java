package src.view.tableModels;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.event.TableModelEvent;
import javax.swing.table.AbstractTableModel;

import src.model.StokKart;

public class StokKartListTableModel extends AbstractTableModel {

	private Vector<String> columnNames = new Vector<String>() {
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
			add("KDV Tipi Açıklama");
			add("Açıklama");
			add("Oluşturma Tarihi");
		}
	};

	private Vector<Vector> data;

	private static <E> Vector<E> newVector(int size) {
		Vector<E> v = new Vector<>(size);
		v.setSize(size);
		return v;
	}

	private static <E> Vector<E> nonNullVector(Vector<E> v) {
		return (v != null) ? v : new Vector<>();
	}

	public StokKartListTableModel() {
		this(0, 0);
	}

	public StokKartListTableModel(int rowCount, int columnCount) {
		this(newVector(columnCount), rowCount);
	}

	public StokKartListTableModel(Vector<?> columnNames, int rowCount) {
		setDataVector(newVector(rowCount), columnNames);
	}

	public void setDataVector(Vector<? extends Vector> dataVector, Vector<?> columnIdentifiers) {
		this.data = nonNullVector((Vector<Vector>) dataVector);
		this.columnNames = (Vector<String>) nonNullVector(columnIdentifiers);
		justifyRows(0, getRowCount());
		fireTableStructureChanged();
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return this.data.size();
	}

	@Override
	public int getColumnCount() {
		return columnNames.size();
	}

	public boolean isCellEditable(int row, int column) {
		return false;
	}

	private void justifyRows(int from, int to) {
		data.setSize(getRowCount());
		for (int i = from; i < to; i++) {
			if (data.elementAt(i) == null) {
				data.setElementAt(new Vector<>(), i);
			}
			data.elementAt(i).setSize(getColumnCount());
		}
	}

	public void newRowsAdded(TableModelEvent e) {
		justifyRows(e.getFirstRow(), e.getLastRow() + 1);
		fireTableChanged(e);
	}

	public void insertRow(int row, Vector<?> rowData) {
		data.insertElementAt((Vector<StokKart>) rowData, row);
		justifyRows(row, row + 1);
		fireTableRowsInserted(row, row);
	}

	@Override
	public Object getValueAt(int row, int column) {
		@SuppressWarnings("unchecked")
		Vector<StokKart> rowVector = data.elementAt(row);
		return rowVector.elementAt(column);
	}

	public void addRow(Vector<Object> rowData) {
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

	public void addRow(Object[] rowData) {
		addRow(convertToVector(rowData));
	}

	public Vector getRowValue(int row) {
		Vector<StokKart> rowVector = data.elementAt(row);
		return rowVector;
	}

}
