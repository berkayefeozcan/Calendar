package calendar;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DataBase {

    private static Connection con = null;
    private static Statement statement = null;
    private static String[][] dataBaseString;
    private static PreparedStatement preparedStatement = null;

    public DataBase() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/calendar?useUnicode=true"
                    + "&characterEncoding=utf8",
                    "root", "root");
            System.out.println(" Database e baglanti saglandi.");
        } catch (Exception e) {
            System.out.println("Database e baglanilamadi.");
        }
        //Connecting database
    }

    public String[][] setBookTable(JTable table) {

        String sorgu = "select * from books ";
        try {
            statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sorgu);
            int counter = 0;

            while (rs.next()) {
                counter++; // this conter help to understand database size
            }
            dataBaseString = new String[counter][5];

            rs = statement.executeQuery(sorgu);

            int row = 0, col = 0;

            while (rs.next()) {
                dataBaseString[row][col++] = rs.getString("booksId");
                dataBaseString[row][col++] = rs.getString("name");
                dataBaseString[row][col++] = rs.getString("author");
                dataBaseString[row][col++] = rs.getString("pageAmount");
                dataBaseString[row][col++] = rs.getString("date");
                col = 0;
                row++;
            }

            table.setModel(new DefaultTableModel(dataBaseString, new String[]{
                "ID", "Name", "Author", "PageAmount", "Date"
            }));

        } catch (Exception ex) {
            System.out.println("veri tabanından verileri cekerken hata olustu.");
        }
        //******************** id resetting ******************************
        try {
            int rowAmout = dataBaseString.length;
            if (rowAmout == 0) {

                try {
                    statement.executeQuery("truncate books;");
                } catch (SQLException ex) {
                    System.out.println("idler sifirlanamadi.");
                }
            }
        } catch (Exception e) {
            System.out.println("!");
        }
        return dataBaseString;
    }

    public void deleteBook(int bookID) {
        try {
            statement = con.createStatement();
            String sorgu = "delete from books where booksId =" + Integer.toString(
                    bookID) + ";";
            statement.executeUpdate(sorgu); // exequting  query ...            

        } catch (SQLException ex) {
            System.out.println("kitap silinemedi");
        }
    }

    public boolean addNewBooktoDataBase(JFrame frame, String name, String author, String pageAmount,
            String date) {
        JFrame messageBox = new JFrame();
        try {
            Integer.parseInt(pageAmount);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(messageBox, "pageAmount must be integer",
                    "Alert", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        String[] splitedDate = date.split("-");
        if (splitedDate.length == 1) {
            JOptionPane.showMessageDialog(messageBox, "date formate must be Year-"
                    + "Mounth-Day", "Alert", JOptionPane.WARNING_MESSAGE);
            return false;

        }
        int year;
        int mounth;
        int day;
        try {
            year = Integer.parseInt(splitedDate[0]);
            mounth = Integer.parseInt(splitedDate[1]);
            day = Integer.parseInt(splitedDate[2]);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(messageBox, "date formate must be Year-"
                    + "Mounth-Day", "Alert", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        if (!(0 <= year) | !(1 <= mounth & mounth <= 12) | !(1 <= day & day <= 31)) {
            JOptionPane.showMessageDialog(messageBox, "date formate must be Year-"
                    + "Mounth-Day", "Alert", JOptionPane.WARNING_MESSAGE);
            return false;
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
        return true;
    }

    public boolean addEvent(String name, String location, String startingDate, String dueDate) {
        String sorgu = "insert into events (Name,Location,StartingDate,DueDate) values (?,?,?,?);";
        
        JFrame messageBox = new JFrame();
        try {
            preparedStatement = con.prepareStatement(sorgu);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, location);
            preparedStatement.setString(3, startingDate);
            preparedStatement.setString(4, dueDate);
            
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(messageBox, "starting date and due date"
                    + "must be 'yyyy-MM-dd HH:MM:SS' ", "Alert", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }
    public ArrayList<String >readEvents(){
        ArrayList<String> eventArrayList= new ArrayList();
        String sorgu = "select Name from events";
        JFrame messageBox = new JFrame();
        try {
            statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sorgu);
            while(rs.next()){
                eventArrayList.add(rs.getString("Name"));
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(messageBox, "Error : database read error"
                , "Alert", JOptionPane.WARNING_MESSAGE);
            
        }
        return eventArrayList;
    }
    public ArrayList<String >readEvents(String currentDate){
        ArrayList<String> eventArrayList= new ArrayList();
        String sorgu = "select Name from events where  StartingDate<=? and "+
                "?<=DueDate;";
        JFrame messageBox = new JFrame();
        try {
            preparedStatement = con.prepareStatement(sorgu);
            preparedStatement.setString(1, currentDate);
            preparedStatement.setString(2, currentDate);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                eventArrayList.add(rs.getString("Name"));
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(messageBox, "Error : database read error"
                , "Alert", JOptionPane.WARNING_MESSAGE);
            
        }
        return eventArrayList;
    }
    

}
