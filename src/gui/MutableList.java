package gui;

import javax.swing.DefaultListModel;
import javax.swing.JList;

public class MutableList extends JList {

    MutableList() {
    	super(new DefaultListModel());
    }
    
    DefaultListModel getContents() {
    	return (DefaultListModel)getModel();
    }
}
