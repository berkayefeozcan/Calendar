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
public class DailyGoalsManipulation extends JListManupilation {

    public DailyGoalsManipulation( String filePath, JList<String> jlist) {
        super(filePath, jlist);
        getjLabel1().setText("Goal:");
        getAddNewGoalsButton().setText("Add Goal");
        setTitle("Add New Goals");
        getAddNewEventButton().setVisible(false);
    }

}
