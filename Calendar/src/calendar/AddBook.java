/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calendar;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author BerkayEfe
 */
public class AddBook extends javax.swing.JFrame {

    private Connection con = null;
    private Statement statement = null;
    private JTable booksTable;

    public AddBook(JTable booksTable) {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2
                - this.getSize().height / 2); //appear centered.
        initComponents();
        setVisible(true);
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/calendar?useUnicode=true"
                    + "&characterEncoding=utf8",
                    "root", "root");
            dataBaseStatus.setBackground(Color.GREEN);
        } catch (Exception e) {
            dataBaseStatus.setBackground(Color.red);
        }
        this.booksTable = booksTable;
    }

    public void addNewBooktoDataBase(String name, String author, String pageAmount,
            String date) {
        JFrame messageBox = new JFrame();
        try {
            Integer.parseInt(pageAmount);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(messageBox, "pageAmount must be integer",
                    "Alert", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String[] splitedDate = date.split("-");        
        if (splitedDate.length == 1) {
            JOptionPane.showMessageDialog(messageBox, "date formate must be Year-"
                    + "Mounth-Day", "Alert", JOptionPane.WARNING_MESSAGE);
            return;

        }
         int year;
         int mounth ;
         int day ;
        try {
            year= Integer.parseInt(splitedDate[0]);
            mounth = Integer.parseInt(splitedDate[1]);
            day = Integer.parseInt(splitedDate[2]);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(messageBox, "date formate must be Year-"
                    + "Mounth-Day", "Alert", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if ( !(0 <= year) |!(1 <= mounth & mounth <= 12) | !(1 <= day & day <= 31) ) {
            JOptionPane.showMessageDialog(messageBox, "date formate must be Year-"
                    + "Mounth-Day", "Alert", JOptionPane.WARNING_MESSAGE);
            return;
        }
        try {
            statement = con.createStatement();
            String sorgu = "INSERT INTO `books` (`booksId`, `name`, "
                    + "`author`, `pageAmount`, `date`) VALUES (NULL, '" + name + "','"
                    + author + "','" + pageAmount + "','" + date + "')";
            statement.executeUpdate(sorgu);
        } catch (SQLException ex) {
            Logger.getLogger(AddBook.class.getName()).log(Level.SEVERE, null, ex);
        }
        dispose(); // this window will death.
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nameLabel = new javax.swing.JLabel();
        authorLabel = new javax.swing.JLabel();
        pageAmountLabel = new javax.swing.JLabel();
        dateLabel = new javax.swing.JLabel();
        pageAmountTextField = new javax.swing.JTextField();
        nameTextField = new javax.swing.JTextField();
        dateTextField = new javax.swing.JTextField();
        authorTextField = new javax.swing.JTextField();
        addBookButton = new javax.swing.JButton();
        exiButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        dataBaseStatus = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);

        nameLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        nameLabel.setText("Name           :");

        authorLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        authorLabel.setText("Author          :");

        pageAmountLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        pageAmountLabel.setText("Page Amount :");

        dateLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        dateLabel.setText("Date             :");

        pageAmountTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pageAmountTextFieldActionPerformed(evt);
            }
        });

        nameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameTextFieldActionPerformed(evt);
            }
        });

        addBookButton.setText("Add the book now !");
        addBookButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBookButtonActionPerformed(evt);
            }
        });

        exiButton.setText("Exit");
        exiButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exiButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("DataBase:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nameLabel)
                        .addGap(43, 43, 43)
                        .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(authorLabel)
                        .addGap(41, 41, 41)
                        .addComponent(authorTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pageAmountLabel)
                        .addGap(37, 37, 37)
                        .addComponent(pageAmountTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(dateLabel)
                        .addGap(41, 41, 41)
                        .addComponent(dateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(exiButton)
                        .addGap(295, 295, 295)
                        .addComponent(addBookButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel1)
                        .addGap(12, 12, 12)
                        .addComponent(dataBaseStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 28, 28))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nameLabel)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(authorLabel)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(authorTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pageAmountLabel)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(pageAmountTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(dateLabel))
                    .addComponent(dateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(exiButton)
                    .addComponent(addBookButton))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(dataBaseStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameTextFieldActionPerformed

    private void pageAmountTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pageAmountTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pageAmountTextFieldActionPerformed

    private void addBookButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBookButtonActionPerformed
        addNewBooktoDataBase(nameTextField.getText(), authorTextField.getText(),
                pageAmountTextField.getText(), dateTextField.getText());
        MainGUI.setBookTable(booksTable); // refreshin book table 

    }//GEN-LAST:event_addBookButtonActionPerformed

    private void exiButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exiButtonActionPerformed
        dispose();
    }//GEN-LAST:event_exiButtonActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBookButton;
    private javax.swing.JLabel authorLabel;
    private javax.swing.JTextField authorTextField;
    private javax.swing.JButton dataBaseStatus;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JTextField dateTextField;
    private javax.swing.JButton exiButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JLabel pageAmountLabel;
    private javax.swing.JTextField pageAmountTextField;
    // End of variables declaration//GEN-END:variables
}
