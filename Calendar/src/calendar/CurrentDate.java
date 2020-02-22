/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calendar;

import java.util.Calendar;

/**
 *
 * @author berkay
 */
public  class CurrentDate {
    
    private  String currentDate ;
    private  String currentDay;
    private  String currentDayNum;
    private  String currentMonth;
    private  String currentYear;
    private  String date ;
    private  String day;
    private  String dayNum;
    private  String month;
    private  String year;
    private int actualMaximum;
    
    private String tempMonth;
    private String tempYear;
    private Calendar calendar;
    private int currentActualMaximum;

    public CurrentDate() {
        
        calendar = Calendar.getInstance();
        setDate();
        this.currentDate = this.date;
        this.currentDay = this.day;
        this.currentMonth = this.month;
        this.currentDayNum= this.dayNum;
        this.currentYear = this.year;
        this.currentActualMaximum = this.actualMaximum;
        
        
    }
    private void setDate() {
        this.date=calendar.getTime().toString();
        String[] tempDate = this.date.split(" ");
        this.day = tempDate[0];
        this.month = tempDate[1];
        this.dayNum= tempDate[2];
        this.year = tempDate[5];
        this.actualMaximum = calendar.getActualMaximum(Calendar.DATE);
        
    }
    
    
    public void changeCurrentDay(int dayAmount){
      
        calendar.add(Calendar.DATE, dayAmount);
        setDate();
    }
    
     public void changeCurrentMonth(int monthAmount){
      
        calendar.add(Calendar.MONTH, monthAmount);
        setDate();
    }
    public void changeCurrentYear(int yearAmount){
        calendar.add(Calendar.YEAR, yearAmount);
        setDate();
    } 
    public String getBeginningOfMonth ()
    {
        calendar.add(Calendar.DATE, 1-Integer.parseInt(this.currentDayNum)); // back to beginning of the month
        String tempDay = calendar.getTime().toString();
        String[] tempArr = tempDay.split(" ");        
        calendar.add( Calendar.DATE , Integer.parseInt(this.currentDayNum) -1 );// back to current day.
        return tempArr[0];
    }

    public String getCurrentDate() {
        return currentDate;
    }

    public String getCurrentDay() {
        return currentDay;
    }

    public String getCurrentDayNum() {
        return currentDayNum;
    }

    public String getCurrentMonth() {
        return currentMonth;
    }

    public String getCurrentYear() {
        return currentYear;
    }

    public String getTempMonth() {
        return tempMonth;
    }

    public String getTempYear() {
        return tempYear;
    }

    public int getActualMaximum() {
        return actualMaximum;
    }

    public String getDate() {
        return date;
    }

    public String getDay() {
        return day;
    }

    public String getDayNum() {
        return dayNum;
    }

    public String getMonth() {
        return month;
    }

    public String getYear() {
        return year;
    }

    public int getCurrentActualMaximum() {
        return currentActualMaximum;
    }

    public Calendar getCalendar() {
        return calendar;
    }

   
    
    
    
    
    
}
