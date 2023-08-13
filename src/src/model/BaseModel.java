package src.model;

import java.io.Serializable;
import java.util.List;
import javax.swing.JInternalFrame;

import src.view.baseViews.BaseMenuFrame;


public interface BaseModel extends Serializable{
	void travelseForward(String str,JInternalFrame frame);
	void travelseBackward(String str, JInternalFrame frame);
	void travelseLast(JInternalFrame frame);
	void travelseFirst(JInternalFrame frame);
	void save(JInternalFrame frame);
	void getData(BaseMenuFrame menuClass);
	void delete(String str);
	void updateKod(Object eskiDegisen,Object yeniDegisen,BaseMenuFrame frame);
	List getAllRows();
	
}
