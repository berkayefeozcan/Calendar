/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calendar;

import static calendar.DayGUI.eventsArrayList;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;

/**
 *
 * @author berkay
 */
public class JListManupilation extends javax.swing.JFrame {

    /**
     * Creates new form JListNewElementAdder
     */
    private ArrayList<String> arrayList;
    private String filePath;
    private JList<String> jlist;

    public JListManupilation( String filePath, JList<String> jlist) {

        this.filePath = filePath;
        this.jlist = jlist;

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2
                - this.getSize().height / 2); //appear centered.
        

        initComponents();

    }

    public void setElementsToJList() {

        // this function set elements from string array to Jlist
        arrayList = FileWriterAndReader.readStringArray(filePath);
        String[] arr =  new String[arrayList.size()];;
        
        for (int i = 0; i < arrayList.size(); i++) {

            arr[i] = arrayList.get(i);

        }

        jlist.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = arr;

            @Override
            public int getSize() {
                return strings.length;
            }

            @Override
            public String getElementAt(int i) {
                return strings[i];
            }
        });
    }

    public ArrayList<String> getArrayList() {
        return arrayList;
    }

    public String getFilePath() {
        return filePath;
    }

    public JList<String> getJlist() {
        return jlist;
    }

    public JButton getAddNewGoalsButton() {
        return addNewGoalsButton;
    }

    public JTextField getInformationTextField() {
        return informationTextField;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public JButton getAddNewEventButton() {
        return addNewEventButton;
    }

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        informationTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        addNewGoalsButton = new javax.swing.JButton();
        addNewEventButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(210, 241, 240));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Serif", 0, 24)); // NOI18N
        jLabel1.setText("Element Infarmation :");

        addNewGoalsButton.setText("Add  new goals ");
        addNewGoalsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNewGoalsButtonActionPerformed(evt);
            }
        });

        addNewEventButton.setText("Add new events");
        addNewEventButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNewEventButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(informationTextField)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(227, 227, 227)
                .addComponent(addNewEventButton)
                .addGap(53, 53, 53)
                .addComponent(addNewGoalsButton)
                .addContainerGap(135, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(informationTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addNewGoalsButton)
                    .addComponent(addNewEventButton))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addNewGoalsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNewGoalsButtonActionPerformed

        String element = informationTextField.getText();
        if (!element.equals("")) {

            DayGUI.dailyGoalsArrayList.add(element);

        }
        if(DayGUI.dailyGoalsArrayList.get(0).equals("No information")){
            DayGUI.dailyGoalsArrayList.remove(0);
        }
        FileWriterAndReader.writeStringArray(DayGUI.dailyGoalsArrayList, filePath);
        setElementsToJList();
        setVisible(false);


    }//GEN-LAST:event_addNewGoalsButtonActionPerformed

    private void addNewEventButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNewEventButtonActionPerformed
        String element = informationTextField.getText();
        if (!element.equals("")) {

            DayGUI.eventsArrayList.add(element);

        }
        if(DayGUI.eventsArrayList.get(0).equals("No information")){
            DayGUI.eventsArrayList.remove(0);
        }
        FileWriterAndReader.writeStringArray(DayGUI.eventsArrayList, filePath);
        setElementsToJList();
        setVisible(false);
    }//GEN-LAST:event_addNewEventButtonActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addNewEventButton;
    private javax.swing.JButton addNewGoalsButton;
    private javax.swing.JTextField informationTextField;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
