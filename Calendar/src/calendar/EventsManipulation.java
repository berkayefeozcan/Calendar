/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calendar;

import java.util.ArrayList;
import javax.swing.JList;

/**
 *
 * @author berkay
 */
public class EventsManipulation extends JListManupilation{
    
    public EventsManipulation( String filePath, JList<String> jlist) {
        super( filePath, jlist);
        
       getjLabel1().setText("Events:");
       getAddNewGoalsButton().setText("Add Events");
        setTitle("Add New Events");
        getAddNewGoalsButton().setVisible(false);
    }
    
    
}
