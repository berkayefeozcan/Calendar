/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calendar;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


import javax.swing.*;

/**
 *
 * @author berkay
 */
public class DayGUI extends javax.swing.JFrame {

    /**
     * Creates new form DayGUI
     */
    private String day;
    private String month;
    private String year;
    private String goalsFilePath;
    private String thoughtsFilePath;
    private String eventsFilePath;
    public static ArrayList<String> eventsArrayList;
    public static ArrayList<String> dailyGoalsArrayList;
    private JListManupilation eventJListManupilation;
    private JListManupilation dailyGoalsJListManupilation;

    public DayGUI(String day, String month, String year) {

        eventsArrayList = new ArrayList<String>();
        dailyGoalsArrayList = new ArrayList<String>();

        initComponents();

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2
                - this.getSize().height / 2); //appear centered.
        this.setTitle(day + "/" + month + "/" + year);
        this.day = day;
        this.month = month;
        this.year = year;
        String temp = this.day + this.month + this.year;
        this.goalsFilePath = temp + "goals.txt";
        this.thoughtsFilePath = temp + "thougths.txt";
        this.eventsFilePath = temp + "events.txt";
        buildGoals();

        eventJListManupilation = new EventsManipulation( eventsFilePath, eventsJList);
        eventJListManupilation.setVisible(false);
        dailyGoalsJListManupilation = new DailyGoalsManipulation(goalsFilePath, dailyGoalsJList);
        dailyGoalsJListManupilation.setVisible(false);

        this.setVisible(true);

        removeEvntButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (eventsJList.getSelectedIndex() != -1) {

                    eventsArrayList.remove(eventsJList.getSelectedIndex()); // remove elements from eventsArrayList
                    FileWriterAndReader.writeStringArray(eventsArrayList, eventsFilePath);
                    setGoalsElementsToJList(eventsJList, eventsFilePath);

                }

            }
        });

        removeGoalsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (dailyGoalsJList.getSelectedIndex() != -1) {

                    System.out.println(dailyGoalsJList.getSelectedIndex());
                    dailyGoalsArrayList.remove(dailyGoalsJList.getSelectedIndex());

                    FileWriterAndReader.writeStringArray(dailyGoalsArrayList, goalsFilePath);

                    setGoalsElementsToJList(dailyGoalsJList, goalsFilePath);
                }

            }
        });

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    public void buildGoals() {
        /*
        this function add Jlist , text area 
        this functions purpose is create new editable goals panel and gui
        
         */
        String read = FileWriterAndReader.read(this.thoughtsFilePath);

        if (read.equals("")) {
            thoughtsTextArea.setText("No thoughts");
        } else {
            thoughtsTextArea.setText(read);
        }
        setEventElementsToJList(eventsJList, eventsFilePath);
        setGoalsElementsToJList(dailyGoalsJList, goalsFilePath);

        thoughtsScrollPane.setVisible(true);
        thoughtsTextArea.setVisible(true);
        addEventButton.setVisible(false);
        addGoalsButton.setVisible(false);

        removeEvntButton.setVisible(false);
        removeGoalsButton.setVisible(false);
        thoughtsEditScrollPane.setVisible(false);
        thoughtsEditTextArea.setVisible(false);

        editButton.setVisible(true);
        saveButton.setVisible(false);

    }

    public void setEventElementsToJList(JList<String> list, String filePath) {

        // this function set elements from string array to Jlist
        eventsArrayList = FileWriterAndReader.readStringArray(filePath);

        String[] arr;
        if (eventsArrayList.isEmpty()) {
            eventsArrayList.add("No information");
            arr = new String[eventsArrayList.size() + 1]; // now string arr size is 1  
        } else {
            arr = new String[eventsArrayList.size()];
        }

        for (int i = 0; i < eventsArrayList.size(); i++) {

            arr[i] = eventsArrayList.get(i);

        }

        list.setModel(new javax.swing.AbstractListModel<String>() {
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


    public void setGoalsElementsToJList(JList<String> list, String filePath) {

        // this function set elements from string array to Jlist
        dailyGoalsArrayList = FileWriterAndReader.readStringArray(filePath);

        String[] arr;
        if (dailyGoalsArrayList.isEmpty()) {
            dailyGoalsArrayList.add("No information");
            arr = new String[dailyGoalsArrayList.size() + 1]; // now string arr size is 1  
        } else {
            arr = new String[dailyGoalsArrayList.size()];
        }

        for (int i = 0; i < dailyGoalsArrayList.size(); i++) {

            arr[i] = dailyGoalsArrayList.get(i);

        }

        list.setModel(new javax.swing.AbstractListModel<String>() {
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        removeEvntButton = new javax.swing.JButton();
        removeGoalsButton = new javax.swing.JButton();
        addEventButton = new javax.swing.JButton();
        eventsListScrollPane = new javax.swing.JScrollPane();
        eventsJList = new javax.swing.JList<>();
        addGoalsButton = new javax.swing.JButton();
        dailyGoalsListScrollPane = new javax.swing.JScrollPane();
        dailyGoalsJList = new javax.swing.JList<>();
        thoughtsScrollPane = new javax.swing.JScrollPane();
        thoughtsTextArea = new javax.swing.JTextArea();
        thoughtsEditScrollPane = new javax.swing.JScrollPane();
        thoughtsEditTextArea = new javax.swing.JTextArea();
        editButton = new javax.swing.JButton();
        thoughtsLabel = new javax.swing.JLabel();
        eventLabel = new javax.swing.JLabel();
        dailyGoalsLabel = new javax.swing.JLabel();
        saveButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(211, 134, 78));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(1100, 600));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(230, 159, 93));
        jPanel1.setMinimumSize(new java.awt.Dimension(1070, 450));
        jPanel1.setPreferredSize(new java.awt.Dimension(1070, 450));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        removeEvntButton.setText("Remove Events");
        jPanel1.add(removeEvntButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 450, -1, -1));

        removeGoalsButton.setText("Remove goals");
        jPanel1.add(removeGoalsButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 450, -1, -1));

        addEventButton.setText("Add Events");
        addEventButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addEventButtonActionPerformed(evt);
            }
        });
        jPanel1.add(addEventButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 450, -1, -1));

        eventsJList.setBackground(new java.awt.Color(242, 238, 203));
        eventsJList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        eventsListScrollPane.setViewportView(eventsJList);

        jPanel1.add(eventsListScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 40, 310, 400));

        addGoalsButton.setText("Add goals");
        addGoalsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addGoalsButtonActionPerformed(evt);
            }
        });
        jPanel1.add(addGoalsButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 450, -1, -1));

        dailyGoalsJList.setBackground(new java.awt.Color(242, 238, 203));
        dailyGoalsJList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        dailyGoalsListScrollPane.setViewportView(dailyGoalsJList);

        jPanel1.add(dailyGoalsListScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 290, 400));

        thoughtsScrollPane.setBackground(new java.awt.Color(242, 238, 203));

        thoughtsTextArea.setEditable(false);
        thoughtsTextArea.setColumns(20);
        thoughtsTextArea.setRows(5);
        thoughtsTextArea.setText("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        thoughtsScrollPane.setViewportView(thoughtsTextArea);

        jPanel1.add(thoughtsScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 40, 320, 400));

        thoughtsEditScrollPane.setBackground(new java.awt.Color(242, 238, 203));

        thoughtsEditTextArea.setBackground(new java.awt.Color(242, 238, 203));
        thoughtsEditTextArea.setColumns(20);
        thoughtsEditTextArea.setRows(5);
        thoughtsEditTextArea.setText("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        thoughtsEditScrollPane.setViewportView(thoughtsEditTextArea);

        jPanel1.add(thoughtsEditScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 40, 320, 400));

        editButton.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        editButton.setText("Edit");
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });
        jPanel1.add(editButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 460, -1, -1));

        thoughtsLabel.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        thoughtsLabel.setForeground(new java.awt.Color(255, 255, 255));
        thoughtsLabel.setText("Thoughts ");
        jPanel1.add(thoughtsLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 10, -1, -1));

        eventLabel.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        eventLabel.setForeground(new java.awt.Color(255, 255, 255));
        eventLabel.setText("Events");
        jPanel1.add(eventLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 10, -1, -1));

        dailyGoalsLabel.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        dailyGoalsLabel.setForeground(new java.awt.Color(255, 255, 255));
        dailyGoalsLabel.setText("Daily Goals");
        jPanel1.add(dailyGoalsLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, -1, -1));

        saveButton.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        saveButton.setText("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });
        jPanel1.add(saveButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 460, 100, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1120, 520));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed

        thoughtsScrollPane.setVisible(false);
        thoughtsTextArea.setVisible(false);

        editButton.setVisible(false);
        saveButton.setVisible(true);

        thoughtsEditTextArea.setText(
                FileWriterAndReader.read(this.thoughtsFilePath)
        );

        thoughtsEditScrollPane.setVisible(true);
        thoughtsEditTextArea.setVisible(true);

        removeEvntButton.setVisible(true);
        removeGoalsButton.setVisible(true);

        addEventButton.setVisible(true);
        addGoalsButton.setVisible(true);
       


    }//GEN-LAST:event_editButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed

        FileWriterAndReader.write(thoughtsEditTextArea.getText(), thoughtsFilePath);
        saveButton.setVisible(false);
        editButton.setVisible(true);
        buildGoals();

    }//GEN-LAST:event_saveButtonActionPerformed

    private void addGoalsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addGoalsButtonActionPerformed
        dailyGoalsJListManupilation.setVisible(true);
    }//GEN-LAST:event_addGoalsButtonActionPerformed

    private void addEventButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addEventButtonActionPerformed
        eventJListManupilation.setVisible(true);

    }//GEN-LAST:event_addEventButtonActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addEventButton;
    private javax.swing.JButton addGoalsButton;
    private javax.swing.JList<String> dailyGoalsJList;
    private javax.swing.JLabel dailyGoalsLabel;
    private javax.swing.JScrollPane dailyGoalsListScrollPane;
    private javax.swing.JButton editButton;
    private javax.swing.JLabel eventLabel;
    private javax.swing.JList<String> eventsJList;
    private javax.swing.JScrollPane eventsListScrollPane;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton removeEvntButton;
    private javax.swing.JButton removeGoalsButton;
    private javax.swing.JButton saveButton;
    private javax.swing.JScrollPane thoughtsEditScrollPane;
    private javax.swing.JTextArea thoughtsEditTextArea;
    private javax.swing.JLabel thoughtsLabel;
    private javax.swing.JScrollPane thoughtsScrollPane;
    private javax.swing.JTextArea thoughtsTextArea;
    // End of variables declaration//GEN-END:variables
}
