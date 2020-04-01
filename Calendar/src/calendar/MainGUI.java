/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calendar;

import java.awt.*;
import java.util.*;
import javax.swing.*;

/**
 *
 * @author berkay
 */
public class MainGUI extends javax.swing.JFrame {

    public CurrentDate currentDate;
    public JButton[] listofDays;
    private static  String[][] dataBaseString;
    private static DataBase dataBase = new DataBase();
    public MainGUI() {
        initComponents();
        setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
        currentDate = new CurrentDate();
        JButton[] listOfDays = {monday1, tuesday1, wednesday1, thursday1, friday1,
            saturday1, sunday1, monday2, tuesday2, wednesday2, thursday2, friday2,
            saturday2, sunday2, monday3, tuesday3, wednesday3, thursday3, friday3,
            saturday3, sunday3, monday4, tuesday4, wednesday4, thursday4, friday4,
            saturday4, sunday4, monday5, tuesday5, wednesday5, thursday5, friday5,
            saturday5, sunday5, monday6, tuesday6, wednesday6, thursday6, friday6,
            saturday6, sunday6};

        for (JButton b : listOfDays) {
            b.setBackground(new java.awt.Color(250, 128, 0));
        }
        this.listofDays = listOfDays.clone();
        prepareDaysInterface(listOfDays);
        todayDateLabel.setText(currentDate.getDayNum() + "/" + currentDate.getCurrentMonth() + "/" + currentDate.getCurrentYear());

        setTodayGoalsAndEvents();
        setBookTable(booksTable);
        booksTable.setVisible(false);
        booksPanel.setVisible(false);

    }

    private void setTodayGoalsAndEvents() {
        int i;
        ArrayList<String> goalsArrayList = FileWriterAndReader.readStringArray(
                currentDate.getDayNum() + currentDate.getMonth() + currentDate.getYear()
                + "goals.txt");

        ArrayList<String> eventsArrayList = FileWriterAndReader.readStringArray(
                currentDate.getDayNum() + currentDate.getMonth() + currentDate.getYear()
                + "events.txt");

        String goals = "";
        String events = "";

        for (i = 0; i < goalsArrayList.size(); i++) {
            goals += "---->  ";
            goals += goalsArrayList.get(i);
            goals += "\n\n";
        }
        goalsTextArea.setText(goals);

        for (i = 0; i < eventsArrayList.size(); i++) {
            events += "---->  ";
            events += eventsArrayList.get(i);
            events += "\n\n";
        }
        eventsTextArea.setText(events);
    }

    public void prepareDaysInterface(JButton[] listOfDays) {

        ArrayList<JButton> buttons = new ArrayList<>(Arrays.asList(listOfDays));

        String day = currentDate.getBeginningOfMonth();

        switch (day) {
            case "Tue": {
                buttons.remove(monday1);

                break;
            }
            case "Wed": {
                buttons.remove(monday1);
                buttons.remove(tuesday1);

                break;
            }
            case "Thu": {
                buttons.remove(monday1);
                buttons.remove(tuesday1);
                buttons.remove(wednesday1);

                break;
            }
            case "Fri": {
                buttons.remove(monday1);
                buttons.remove(tuesday1);
                buttons.remove(wednesday1);
                buttons.remove(thursday1);

                break;
            }
            case "Sat": {
                buttons.remove(monday1);
                buttons.remove(tuesday1);
                buttons.remove(wednesday1);
                buttons.remove(thursday1);
                buttons.remove(friday1);

                break;
            }
            case "Sun": {
                buttons.remove(monday1);
                buttons.remove(tuesday1);
                buttons.remove(wednesday1);
                buttons.remove(thursday1);
                buttons.remove(friday1);
                buttons.remove(saturday1);

                break;
            }
        }
        clearButtonsName(listOfDays); // clearing button's text
        setButtonsName(buttons, currentDate); // Setting buttons name 
        monthLabel.setText(currentDate.getMonth() + "/" + currentDate.getYear());

        if (currentDate.getCurrentDate().equals(currentDate.getDate())) {

            monthLabel.setForeground(Color.red); // if current date equals date funtcion set month label red color.
        } else {
            monthLabel.setForeground(Color.black);
        }

    }

    private void clearButtonsName(JButton[] buttons) {

        for (JButton b : buttons) {
            b.setText("");
            b.setForeground(Color.white);
        }
    }

    

  

    private void setButtonsName(ArrayList<JButton> button, CurrentDate currentDate) {

        int dayNum = Integer.parseInt(currentDate.getDayNum());

        for (int i = 0; i < currentDate.getActualMaximum(); i++) {

            button.get(i).setText(Integer.toString(i + 1));
            button.get(i).setFont(new Font("Arial", Font.PLAIN, 40)); // set font

        }
        if (currentDate.getCurrentMonth().equals(currentDate.getMonth())
                && currentDate.getCurrentYear().equals(currentDate.getYear())) {
            button.get(dayNum - 1).setForeground(Color.red);
        }

    }

    private void createNewDayGui(JButton button) {

        String day = button.getText();

        if (!day.equals("")) {
          //  DayGUI gui = new DayGUI(day, currentDate.getMonth(), currentDate.getYear());
          String [] temp = currentDate.getFormatedDate().split("-");
          DayGUI gui = new DayGUI(day, temp[1],temp[0]);
          gui.buildGoals();
        }

    }
    public static void setBookTable(JTable booksTable){
       dataBaseString = dataBase.setBookTable(booksTable);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        CalendarPanel = new javax.swing.JPanel();
        daysOfMonth = new javax.swing.JPanel();
        sunday3 = new javax.swing.JButton();
        monday2 = new javax.swing.JButton();
        wednesday2 = new javax.swing.JButton();
        monday1 = new javax.swing.JButton();
        tuesday2 = new javax.swing.JButton();
        saturday2 = new javax.swing.JButton();
        friday2 = new javax.swing.JButton();
        thursday2 = new javax.swing.JButton();
        wednesday1 = new javax.swing.JButton();
        sunday2 = new javax.swing.JButton();
        tuesday1 = new javax.swing.JButton();
        monday4 = new javax.swing.JButton();
        wednesday4 = new javax.swing.JButton();
        tuesday4 = new javax.swing.JButton();
        saturday4 = new javax.swing.JButton();
        saturday1 = new javax.swing.JButton();
        friday4 = new javax.swing.JButton();
        friday1 = new javax.swing.JButton();
        thursday4 = new javax.swing.JButton();
        thursday1 = new javax.swing.JButton();
        sunday1 = new javax.swing.JButton();
        sunday4 = new javax.swing.JButton();
        monday3 = new javax.swing.JButton();
        wednesday3 = new javax.swing.JButton();
        tuesday3 = new javax.swing.JButton();
        saturday3 = new javax.swing.JButton();
        friday3 = new javax.swing.JButton();
        thursday3 = new javax.swing.JButton();
        firstDay = new javax.swing.JLabel();
        secondDay = new javax.swing.JLabel();
        thirdDay = new javax.swing.JLabel();
        forthDay = new javax.swing.JLabel();
        fifthDay = new javax.swing.JLabel();
        sixthDay = new javax.swing.JLabel();
        ninethday = new javax.swing.JLabel();
        monday5 = new javax.swing.JButton();
        wednesday5 = new javax.swing.JButton();
        tuesday5 = new javax.swing.JButton();
        saturday5 = new javax.swing.JButton();
        friday5 = new javax.swing.JButton();
        thursday5 = new javax.swing.JButton();
        sunday5 = new javax.swing.JButton();
        friday6 = new javax.swing.JButton();
        thursday6 = new javax.swing.JButton();
        sunday6 = new javax.swing.JButton();
        monday6 = new javax.swing.JButton();
        wednesday6 = new javax.swing.JButton();
        tuesday6 = new javax.swing.JButton();
        saturday6 = new javax.swing.JButton();
        todayPanel = new javax.swing.JPanel();
        todayDateLabel = new javax.swing.JLabel();
        eventsLabel = new javax.swing.JLabel();
        goalsLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        eventsTextArea = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        goalsTextArea = new javax.swing.JTextArea();
        todayTitlePanel = new javax.swing.JPanel();
        todayLabel = new javax.swing.JLabel();
        nextPrevTitle = new javax.swing.JPanel();
        monthLabel = new javax.swing.JLabel();
        monthPrevButton = new javax.swing.JButton();
        monthNextButton = new javax.swing.JButton();
        addNewHabitButton = new javax.swing.JButton();
        MENU_PANEL = new javax.swing.JPanel();
        calendarButton = new javax.swing.JButton();
        booksButton = new javax.swing.JButton();
        habitButton = new javax.swing.JButton();
        booksPanel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        booksTable = new javax.swing.JTable();
        addNewBookButton = new javax.swing.JButton();
        refleshButton = new javax.swing.JButton();
        deleteBookButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        habitPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Calendar");
        setBackground(new java.awt.Color(204, 255, 255));
        setForeground(java.awt.Color.white);
        setMinimumSize(new java.awt.Dimension(500, 500));

        CalendarPanel.setBackground(new java.awt.Color(250, 250, 250));
        CalendarPanel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                CalendarPanelKeyPressed(evt);
            }
        });

        daysOfMonth.setBackground(new java.awt.Color(64, 64, 64));

        sunday3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sunday3ActionPerformed(evt);
            }
        });

        monday2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monday2ActionPerformed(evt);
            }
        });

        wednesday2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wednesday2ActionPerformed(evt);
            }
        });

        monday1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monday1ActionPerformed(evt);
            }
        });

        tuesday2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tuesday2ActionPerformed(evt);
            }
        });

        saturday2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saturday2ActionPerformed(evt);
            }
        });

        friday2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                friday2ActionPerformed(evt);
            }
        });

        thursday2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                thursday2ActionPerformed(evt);
            }
        });

        wednesday1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wednesday1ActionPerformed(evt);
            }
        });

        sunday2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sunday2ActionPerformed(evt);
            }
        });

        tuesday1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tuesday1ActionPerformed(evt);
            }
        });

        monday4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monday4ActionPerformed(evt);
            }
        });

        wednesday4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wednesday4ActionPerformed(evt);
            }
        });

        tuesday4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tuesday4ActionPerformed(evt);
            }
        });

        saturday4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saturday4ActionPerformed(evt);
            }
        });

        saturday1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saturday1ActionPerformed(evt);
            }
        });

        friday4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                friday4ActionPerformed(evt);
            }
        });

        friday1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                friday1ActionPerformed(evt);
            }
        });

        thursday4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                thursday4ActionPerformed(evt);
            }
        });

        thursday1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                thursday1ActionPerformed(evt);
            }
        });

        sunday1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sunday1ActionPerformed(evt);
            }
        });

        sunday4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sunday4ActionPerformed(evt);
            }
        });

        monday3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monday3ActionPerformed(evt);
            }
        });

        wednesday3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wednesday3ActionPerformed(evt);
            }
        });

        tuesday3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tuesday3ActionPerformed(evt);
            }
        });

        saturday3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saturday3ActionPerformed(evt);
            }
        });

        friday3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                friday3ActionPerformed(evt);
            }
        });

        thursday3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                thursday3ActionPerformed(evt);
            }
        });

        firstDay.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        firstDay.setForeground(new java.awt.Color(255, 255, 255));
        firstDay.setText("Monday");

        secondDay.setBackground(new java.awt.Color(255, 255, 255));
        secondDay.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        secondDay.setForeground(new java.awt.Color(255, 255, 255));
        secondDay.setText("Tuesday");

        thirdDay.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        thirdDay.setForeground(new java.awt.Color(255, 255, 255));
        thirdDay.setText("Wednesday");

        forthDay.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        forthDay.setForeground(new java.awt.Color(255, 255, 255));
        forthDay.setText("Thursday");

        fifthDay.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        fifthDay.setForeground(new java.awt.Color(255, 255, 255));
        fifthDay.setText("Friday");

        sixthDay.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        sixthDay.setForeground(new java.awt.Color(255, 255, 255));
        sixthDay.setText("Sunday");

        ninethday.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        ninethday.setForeground(new java.awt.Color(255, 255, 255));
        ninethday.setText("Saturday");

        monday5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monday5ActionPerformed(evt);
            }
        });

        wednesday5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wednesday5ActionPerformed(evt);
            }
        });

        tuesday5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tuesday5ActionPerformed(evt);
            }
        });

        saturday5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saturday5ActionPerformed(evt);
            }
        });

        friday5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                friday5ActionPerformed(evt);
            }
        });

        thursday5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                thursday5ActionPerformed(evt);
            }
        });

        sunday5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sunday5ActionPerformed(evt);
            }
        });

        friday6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                friday6ActionPerformed(evt);
            }
        });

        thursday6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                thursday6ActionPerformed(evt);
            }
        });

        sunday6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sunday6ActionPerformed(evt);
            }
        });

        monday6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monday6ActionPerformed(evt);
            }
        });

        wednesday6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wednesday6ActionPerformed(evt);
            }
        });

        tuesday6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tuesday6ActionPerformed(evt);
            }
        });

        saturday6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saturday6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout daysOfMonthLayout = new javax.swing.GroupLayout(daysOfMonth);
        daysOfMonth.setLayout(daysOfMonthLayout);
        daysOfMonthLayout.setHorizontalGroup(
            daysOfMonthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, daysOfMonthLayout.createSequentialGroup()
                .addGap(0, 35, Short.MAX_VALUE)
                .addGroup(daysOfMonthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(daysOfMonthLayout.createSequentialGroup()
                        .addComponent(monday6, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tuesday6, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(wednesday6, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(thursday6, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(friday6, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(saturday6, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sunday6, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(daysOfMonthLayout.createSequentialGroup()
                        .addGroup(daysOfMonthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(monday1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(monday4, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(daysOfMonthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(monday3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(monday2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(monday5, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(daysOfMonthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(daysOfMonthLayout.createSequentialGroup()
                                .addComponent(tuesday4, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(wednesday4, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(thursday4, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(friday4, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(saturday4, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(sunday4, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(daysOfMonthLayout.createSequentialGroup()
                                .addComponent(tuesday3, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(wednesday3, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(thursday3, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(friday3, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(saturday3, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(sunday3, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, daysOfMonthLayout.createSequentialGroup()
                                .addComponent(tuesday2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(wednesday2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(thursday2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(friday2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(saturday2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(sunday2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(daysOfMonthLayout.createSequentialGroup()
                                .addComponent(tuesday5, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(wednesday5, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(thursday5, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(friday5, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(saturday5, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(sunday5, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(daysOfMonthLayout.createSequentialGroup()
                                .addComponent(tuesday1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(wednesday1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(thursday1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(friday1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(saturday1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(sunday1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(36, 36, 36))
            .addGroup(daysOfMonthLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(daysOfMonthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(daysOfMonthLayout.createSequentialGroup()
                        .addGap(225, 225, 225)
                        .addComponent(thirdDay)
                        .addGap(37, 37, 37)
                        .addComponent(forthDay)
                        .addGap(52, 52, 52)
                        .addComponent(fifthDay)
                        .addGap(50, 50, 50)
                        .addComponent(ninethday)
                        .addGap(56, 56, 56)
                        .addComponent(sixthDay))
                    .addGroup(daysOfMonthLayout.createSequentialGroup()
                        .addComponent(firstDay)
                        .addGap(45, 45, 45)
                        .addComponent(secondDay)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        daysOfMonthLayout.setVerticalGroup(
            daysOfMonthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, daysOfMonthLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(daysOfMonthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(firstDay)
                    .addComponent(secondDay)
                    .addComponent(thirdDay)
                    .addComponent(forthDay)
                    .addComponent(fifthDay)
                    .addComponent(ninethday)
                    .addComponent(sixthDay))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(daysOfMonthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(monday1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(saturday1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(friday1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(thursday1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tuesday1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(wednesday1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sunday1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(daysOfMonthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(saturday2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(friday2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(thursday2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tuesday2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(wednesday2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sunday2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(monday2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(daysOfMonthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(monday3, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(saturday3, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(friday3, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(thursday3, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tuesday3, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(wednesday3, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sunday3, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(daysOfMonthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(monday4, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(saturday4, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(friday4, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(thursday4, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tuesday4, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(wednesday4, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sunday4, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(daysOfMonthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(monday5, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(saturday5, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(friday5, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(thursday5, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tuesday5, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(wednesday5, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sunday5, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(daysOfMonthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(sunday6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(monday6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tuesday6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(wednesday6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(thursday6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(friday6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(saturday6, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        todayPanel.setBackground(new java.awt.Color(153, 255, 255));

        todayDateLabel.setFont(new java.awt.Font("Ubuntu", 2, 24)); // NOI18N
        todayDateLabel.setText("    Today Date");

        eventsLabel.setFont(new java.awt.Font("DejaVu Sans", 0, 18)); // NOI18N
        eventsLabel.setText("--EVENTS--");

        goalsLabel.setFont(new java.awt.Font("DejaVu Sans", 0, 18)); // NOI18N
        goalsLabel.setText("--GOALS--");

        eventsTextArea.setEditable(false);
        eventsTextArea.setColumns(25);
        eventsTextArea.setRows(5);
        jScrollPane1.setViewportView(eventsTextArea);

        goalsTextArea.setEditable(false);
        goalsTextArea.setColumns(25);
        goalsTextArea.setRows(5);
        jScrollPane2.setViewportView(goalsTextArea);

        todayLabel.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        todayLabel.setText("TODAY");

        javax.swing.GroupLayout todayTitlePanelLayout = new javax.swing.GroupLayout(todayTitlePanel);
        todayTitlePanel.setLayout(todayTitlePanelLayout);
        todayTitlePanelLayout.setHorizontalGroup(
            todayTitlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(todayTitlePanelLayout.createSequentialGroup()
                .addGap(153, 153, 153)
                .addComponent(todayLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        todayTitlePanelLayout.setVerticalGroup(
            todayTitlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, todayTitlePanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(todayLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout todayPanelLayout = new javax.swing.GroupLayout(todayPanel);
        todayPanel.setLayout(todayPanelLayout);
        todayPanelLayout.setHorizontalGroup(
            todayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(todayTitlePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(todayPanelLayout.createSequentialGroup()
                .addGroup(todayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(todayPanelLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(todayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, todayPanelLayout.createSequentialGroup()
                                .addGap(78, 78, 78)
                                .addComponent(eventsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(93, 93, 93))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(todayPanelLayout.createSequentialGroup()
                                .addGap(91, 91, 91)
                                .addComponent(goalsLabel))))
                    .addGroup(todayPanelLayout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(todayDateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        todayPanelLayout.setVerticalGroup(
            todayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(todayPanelLayout.createSequentialGroup()
                .addComponent(todayTitlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(todayDateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(eventsLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(goalsLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(88, Short.MAX_VALUE))
        );

        monthLabel.setFont(new java.awt.Font("Ubuntu", 3, 24)); // NOI18N
        monthLabel.setText("       Month");

        monthPrevButton.setText("Prev");
        monthPrevButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monthPrevButtonActionPerformed(evt);
            }
        });

        monthNextButton.setText("Next");
        monthNextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monthNextButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout nextPrevTitleLayout = new javax.swing.GroupLayout(nextPrevTitle);
        nextPrevTitle.setLayout(nextPrevTitleLayout);
        nextPrevTitleLayout.setHorizontalGroup(
            nextPrevTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nextPrevTitleLayout.createSequentialGroup()
                .addGap(107, 107, 107)
                .addComponent(monthPrevButton, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 184, Short.MAX_VALUE)
                .addComponent(monthLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(165, 165, 165)
                .addComponent(monthNextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(101, 101, 101))
        );
        nextPrevTitleLayout.setVerticalGroup(
            nextPrevTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nextPrevTitleLayout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(nextPrevTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(monthPrevButton)
                    .addComponent(monthNextButton)
                    .addComponent(monthLabel))
                .addContainerGap())
        );

        addNewHabitButton.setText("Add a new habbit ");

        javax.swing.GroupLayout CalendarPanelLayout = new javax.swing.GroupLayout(CalendarPanel);
        CalendarPanel.setLayout(CalendarPanelLayout);
        CalendarPanelLayout.setHorizontalGroup(
            CalendarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CalendarPanelLayout.createSequentialGroup()
                .addGap(157, 157, 157)
                .addGroup(CalendarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addNewHabitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(CalendarPanelLayout.createSequentialGroup()
                        .addGroup(CalendarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nextPrevTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(daysOfMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addComponent(todayPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(159, Short.MAX_VALUE))
        );
        CalendarPanelLayout.setVerticalGroup(
            CalendarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CalendarPanelLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(CalendarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(todayPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CalendarPanelLayout.createSequentialGroup()
                        .addComponent(nextPrevTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(daysOfMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(addNewHabitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        MENU_PANEL.setBackground(new java.awt.Color(214, 20, 223));

        calendarButton.setText("Calendar");
        calendarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calendarButtonActionPerformed(evt);
            }
        });

        booksButton.setText("BOOKS");
        booksButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                booksButtonActionPerformed(evt);
            }
        });

        habitButton.setText("Add a habit");
        habitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                habitButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout MENU_PANELLayout = new javax.swing.GroupLayout(MENU_PANEL);
        MENU_PANEL.setLayout(MENU_PANELLayout);
        MENU_PANELLayout.setHorizontalGroup(
            MENU_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(calendarButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(booksButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(habitButton, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
        );
        MENU_PANELLayout.setVerticalGroup(
            MENU_PANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MENU_PANELLayout.createSequentialGroup()
                .addGap(142, 142, 142)
                .addComponent(calendarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(booksButton, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(habitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(622, Short.MAX_VALUE))
        );

        booksPanel.setBackground(new java.awt.Color(214, 217, 0));

        booksTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Name", "author", "pageAmount", "date"
            }
        ));
        jScrollPane3.setViewportView(booksTable);

        addNewBookButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        addNewBookButton.setText("Add New Book");
        addNewBookButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNewBookButtonActionPerformed(evt);
            }
        });

        refleshButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        refleshButton.setText("Refresh Table ");
        refleshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refleshButtonActionPerformed(evt);
            }
        });

        deleteBookButton.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        deleteBookButton.setText("Delete this book");
        deleteBookButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBookButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel1.setText("----------------Books i have read-----------------");

        javax.swing.GroupLayout booksPanelLayout = new javax.swing.GroupLayout(booksPanel);
        booksPanel.setLayout(booksPanelLayout);
        booksPanelLayout.setHorizontalGroup(
            booksPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(booksPanelLayout.createSequentialGroup()
                .addGap(149, 149, 149)
                .addGroup(booksPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(booksPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(booksPanelLayout.createSequentialGroup()
                            .addComponent(refleshButton)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(deleteBookButton, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(252, 252, 252)
                            .addComponent(addNewBookButton, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1208, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(booksPanelLayout.createSequentialGroup()
                        .addGap(335, 335, 335)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(647, Short.MAX_VALUE))
        );
        booksPanelLayout.setVerticalGroup(
            booksPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, booksPanelLayout.createSequentialGroup()
                .addContainerGap(63, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 704, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(booksPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(refleshButton)
                    .addGroup(booksPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(addNewBookButton, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(deleteBookButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(137, 137, 137))
        );

        habitPanel.setBackground(new java.awt.Color(24, 10, 31));

        javax.swing.GroupLayout habitPanelLayout = new javax.swing.GroupLayout(habitPanel);
        habitPanel.setLayout(habitPanelLayout);
        habitPanelLayout.setHorizontalGroup(
            habitPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2620, Short.MAX_VALUE)
        );
        habitPanelLayout.setVerticalGroup(
            habitPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1075, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(MENU_PANEL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CalendarPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(booksPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(habitPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MENU_PANEL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(booksPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(CalendarPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(habitPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void monday1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monday1ActionPerformed
        createNewDayGui(monday1);
    }//GEN-LAST:event_monday1ActionPerformed

    private void wednesday1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wednesday1ActionPerformed
        createNewDayGui(wednesday1);
    }//GEN-LAST:event_wednesday1ActionPerformed

    private void tuesday1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tuesday1ActionPerformed
        createNewDayGui(tuesday1);
    }//GEN-LAST:event_tuesday1ActionPerformed

    private void saturday1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saturday1ActionPerformed
        createNewDayGui(saturday1);
    }//GEN-LAST:event_saturday1ActionPerformed

    private void friday1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_friday1ActionPerformed
        createNewDayGui(friday1);
    }//GEN-LAST:event_friday1ActionPerformed

    private void thursday1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_thursday1ActionPerformed
        createNewDayGui(thursday1);
    }//GEN-LAST:event_thursday1ActionPerformed

    private void sunday1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sunday1ActionPerformed
        createNewDayGui(sunday1);
    }//GEN-LAST:event_sunday1ActionPerformed

    private void monday3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monday3ActionPerformed
        createNewDayGui(monday3);
    }//GEN-LAST:event_monday3ActionPerformed

    private void wednesday3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wednesday3ActionPerformed
        createNewDayGui(wednesday3);
    }//GEN-LAST:event_wednesday3ActionPerformed

    private void tuesday3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tuesday3ActionPerformed
        createNewDayGui(tuesday3);
    }//GEN-LAST:event_tuesday3ActionPerformed

    private void saturday3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saturday3ActionPerformed

        createNewDayGui(saturday3);
    }//GEN-LAST:event_saturday3ActionPerformed

    private void friday3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_friday3ActionPerformed
        // TODO add your handling code here:
        createNewDayGui(friday3);
    }//GEN-LAST:event_friday3ActionPerformed

    private void thursday3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_thursday3ActionPerformed
        // TODO add your handling code here:
        createNewDayGui(thursday3);
    }//GEN-LAST:event_thursday3ActionPerformed

    private void sunday3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sunday3ActionPerformed
        // TODO add your handling code here:
        createNewDayGui(sunday3);
    }//GEN-LAST:event_sunday3ActionPerformed

    private void monday2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monday2ActionPerformed
        // TODO add your handling code here:
        createNewDayGui(monday2);
    }//GEN-LAST:event_monday2ActionPerformed

    private void wednesday2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wednesday2ActionPerformed
        // TODO add your handling code here:
        createNewDayGui(wednesday2);
    }//GEN-LAST:event_wednesday2ActionPerformed

    private void tuesday2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tuesday2ActionPerformed
        // TODO add your handling code here:
        createNewDayGui(tuesday2);
    }//GEN-LAST:event_tuesday2ActionPerformed

    private void saturday2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saturday2ActionPerformed
        // TODO add your handling code here:
        createNewDayGui(saturday2);
    }//GEN-LAST:event_saturday2ActionPerformed

    private void friday2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_friday2ActionPerformed
        // TODO add your handling code here:
        createNewDayGui(friday2);
    }//GEN-LAST:event_friday2ActionPerformed

    private void thursday2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_thursday2ActionPerformed
        // TODO add your handling code here:
        createNewDayGui(thursday2);
    }//GEN-LAST:event_thursday2ActionPerformed

    private void sunday2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sunday2ActionPerformed
        // TODO add your handling code here:
        createNewDayGui(sunday2);
    }//GEN-LAST:event_sunday2ActionPerformed

    private void monday4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monday4ActionPerformed
        // TODO add your handling code here:
        createNewDayGui(monday4);
    }//GEN-LAST:event_monday4ActionPerformed

    private void wednesday4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wednesday4ActionPerformed
        // TODO add your handling code here:
        createNewDayGui(wednesday4);
    }//GEN-LAST:event_wednesday4ActionPerformed

    private void tuesday4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tuesday4ActionPerformed
        // TODO add your handling code here:
        createNewDayGui(tuesday4);
    }//GEN-LAST:event_tuesday4ActionPerformed

    private void saturday4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saturday4ActionPerformed
        // TODO add your handling code here:
        createNewDayGui(saturday4);
    }//GEN-LAST:event_saturday4ActionPerformed

    private void friday4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_friday4ActionPerformed
        // TODO add your handling code here:
        createNewDayGui(friday4);
    }//GEN-LAST:event_friday4ActionPerformed

    private void thursday4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_thursday4ActionPerformed
        // TODO add your handling code here:
        createNewDayGui(thursday4);
    }//GEN-LAST:event_thursday4ActionPerformed

    private void sunday4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sunday4ActionPerformed
        // TODO add your handling code here:
        createNewDayGui(sunday4);
    }//GEN-LAST:event_sunday4ActionPerformed

    private void monday5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monday5ActionPerformed
        // TODO add your handling code here:
        createNewDayGui(monday5);
    }//GEN-LAST:event_monday5ActionPerformed

    private void wednesday5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wednesday5ActionPerformed
        // TODO add your handling code here:
        createNewDayGui(wednesday5);
    }//GEN-LAST:event_wednesday5ActionPerformed

    private void tuesday5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tuesday5ActionPerformed
        // TODO add your handling code here:
        createNewDayGui(tuesday5);
    }//GEN-LAST:event_tuesday5ActionPerformed

    private void saturday5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saturday5ActionPerformed
        // TODO add your handling code here:
        createNewDayGui(saturday5);
    }//GEN-LAST:event_saturday5ActionPerformed

    private void friday5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_friday5ActionPerformed
        // TODO add your handling code here:
        createNewDayGui(friday5);
    }//GEN-LAST:event_friday5ActionPerformed

    private void thursday5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_thursday5ActionPerformed
        // TODO add your handling code here:
        createNewDayGui(thursday5);
    }//GEN-LAST:event_thursday5ActionPerformed

    private void sunday5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sunday5ActionPerformed
        // TODO add your handling code here:
        createNewDayGui(sunday5);
    }//GEN-LAST:event_sunday5ActionPerformed

    private void monthNextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monthNextButtonActionPerformed
        currentDate.changeCurrentMonth(1);
        prepareDaysInterface(this.listofDays);

    }//GEN-LAST:event_monthNextButtonActionPerformed

    private void monthPrevButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monthPrevButtonActionPerformed
        currentDate.changeCurrentMonth(-1);
        prepareDaysInterface(this.listofDays);

    }//GEN-LAST:event_monthPrevButtonActionPerformed

    private void friday6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_friday6ActionPerformed
        // TODO add your handling code here:
        createNewDayGui(friday6);
    }//GEN-LAST:event_friday6ActionPerformed

    private void thursday6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_thursday6ActionPerformed
        // TODO add your handling code here:
        createNewDayGui(thursday6);
    }//GEN-LAST:event_thursday6ActionPerformed

    private void sunday6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sunday6ActionPerformed
        // TODO add your handling code here:
        createNewDayGui(sunday6);
    }//GEN-LAST:event_sunday6ActionPerformed

    private void monday6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monday6ActionPerformed
        // TODO add your handling code here:
        createNewDayGui(monday6);
    }//GEN-LAST:event_monday6ActionPerformed

    private void wednesday6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wednesday6ActionPerformed
        // TODO add your handling code here:
        createNewDayGui(wednesday6);
    }//GEN-LAST:event_wednesday6ActionPerformed
  
    private void tuesday6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tuesday6ActionPerformed
        // TODO add your handling code here:
        createNewDayGui(tuesday6);
    }//GEN-LAST:event_tuesday6ActionPerformed

    private void saturday6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saturday6ActionPerformed
        // TODO add your handling code here:
        createNewDayGui(saturday6);
    }//GEN-LAST:event_saturday6ActionPerformed

    private void calendarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calendarButtonActionPerformed
        CalendarPanel.setVisible(true);
        booksTable.setVisible(false);
        booksPanel.setVisible(false);
        habitPanel.setVisible(false);

    }//GEN-LAST:event_calendarButtonActionPerformed

    private void booksButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_booksButtonActionPerformed
        CalendarPanel.setVisible(false);
        booksTable.setVisible(true);
        booksPanel.setVisible(true);
        habitPanel.setVisible(false);
    }//GEN-LAST:event_booksButtonActionPerformed

    private void CalendarPanelKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CalendarPanelKeyPressed
    }//GEN-LAST:event_CalendarPanelKeyPressed

    private void addNewBookButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNewBookButtonActionPerformed
        AddBook addBook = new AddBook(booksTable);
    }//GEN-LAST:event_addNewBookButtonActionPerformed

    private void refleshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refleshButtonActionPerformed
        setBookTable(booksTable); // refreshing book table ...
        
    }//GEN-LAST:event_refleshButtonActionPerformed

    private void habitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_habitButtonActionPerformed
        CalendarPanel.setVisible(false);
        booksTable.setVisible(false);
        booksPanel.setVisible(false);
        habitPanel.setVisible(true);
    }//GEN-LAST:event_habitButtonActionPerformed

    private void deleteBookButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBookButtonActionPerformed
        int tableIndex=-1;
        int index=-1;
        try {
            index = booksTable.getSelectedRow();
            tableIndex = Integer.parseInt(dataBaseString[index][0]);
        }
        catch(Exception ex){
            System.out.println("tabloda seçilen bir şey bulunamadı");
        }

        if (tableIndex != -1 & index != -1) {
            dataBase.deleteBook(tableIndex);
        }
        setBookTable(booksTable);
    }//GEN-LAST:event_deleteBookButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CalendarPanel;
    private javax.swing.JPanel MENU_PANEL;
    private javax.swing.JButton addNewBookButton;
    private javax.swing.JButton addNewHabitButton;
    private javax.swing.JButton booksButton;
    private javax.swing.JPanel booksPanel;
    private javax.swing.JTable booksTable;
    private javax.swing.JButton calendarButton;
    private javax.swing.JPanel daysOfMonth;
    private javax.swing.JButton deleteBookButton;
    private javax.swing.JLabel eventsLabel;
    private javax.swing.JTextArea eventsTextArea;
    private javax.swing.JLabel fifthDay;
    private javax.swing.JLabel firstDay;
    private javax.swing.JLabel forthDay;
    private javax.swing.JButton friday1;
    private javax.swing.JButton friday2;
    private javax.swing.JButton friday3;
    private javax.swing.JButton friday4;
    private javax.swing.JButton friday5;
    private javax.swing.JButton friday6;
    private javax.swing.JLabel goalsLabel;
    private javax.swing.JTextArea goalsTextArea;
    private javax.swing.JButton habitButton;
    private javax.swing.JPanel habitPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton monday1;
    private javax.swing.JButton monday2;
    private javax.swing.JButton monday3;
    private javax.swing.JButton monday4;
    private javax.swing.JButton monday5;
    private javax.swing.JButton monday6;
    private javax.swing.JLabel monthLabel;
    private javax.swing.JButton monthNextButton;
    private javax.swing.JButton monthPrevButton;
    private javax.swing.JPanel nextPrevTitle;
    private javax.swing.JLabel ninethday;
    private javax.swing.JButton refleshButton;
    private javax.swing.JButton saturday1;
    private javax.swing.JButton saturday2;
    private javax.swing.JButton saturday3;
    private javax.swing.JButton saturday4;
    private javax.swing.JButton saturday5;
    private javax.swing.JButton saturday6;
    private javax.swing.JLabel secondDay;
    private javax.swing.JLabel sixthDay;
    private javax.swing.JButton sunday1;
    private javax.swing.JButton sunday2;
    private javax.swing.JButton sunday3;
    private javax.swing.JButton sunday4;
    private javax.swing.JButton sunday5;
    private javax.swing.JButton sunday6;
    private javax.swing.JLabel thirdDay;
    private javax.swing.JButton thursday1;
    private javax.swing.JButton thursday2;
    private javax.swing.JButton thursday3;
    private javax.swing.JButton thursday4;
    private javax.swing.JButton thursday5;
    private javax.swing.JButton thursday6;
    private javax.swing.JLabel todayDateLabel;
    private javax.swing.JLabel todayLabel;
    private javax.swing.JPanel todayPanel;
    private javax.swing.JPanel todayTitlePanel;
    private javax.swing.JButton tuesday1;
    private javax.swing.JButton tuesday2;
    private javax.swing.JButton tuesday3;
    private javax.swing.JButton tuesday4;
    private javax.swing.JButton tuesday5;
    private javax.swing.JButton tuesday6;
    private javax.swing.JButton wednesday1;
    private javax.swing.JButton wednesday2;
    private javax.swing.JButton wednesday3;
    private javax.swing.JButton wednesday4;
    private javax.swing.JButton wednesday5;
    private javax.swing.JButton wednesday6;
    // End of variables declaration//GEN-END:variables
}
