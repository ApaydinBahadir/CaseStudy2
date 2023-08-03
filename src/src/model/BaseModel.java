package src.model;

import java.util.Collection;
import java.util.List;
import javax.swing.JInternalFrame;

import src.view.BaseMenuFrame;

public interface BaseModel {
	void travelseForward(String str,JInternalFrame frame);
	void travelseBackward(String str, JInternalFrame frame);
	void travelseLast(JInternalFrame frame);
	void travelseFirst(JInternalFrame frame);
	void save();
	void getData(BaseMenuFrame menuClass);
	void delete(String str);
	List<List<String>> getAllRows();
	
}
