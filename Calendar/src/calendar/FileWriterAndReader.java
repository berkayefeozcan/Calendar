/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

 */
package calendar;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author berkay
 */
public class FileWriterAndReader {

        
    
    public static void write(String text,String fileName){
        
        try( BufferedWriter writer =  new BufferedWriter(new FileWriter(fileName)) ){
            
            writer.write(text);
            
        } 
        catch (IOException ex) {
            System.out.println("write fonksiyonunda dosya açılırken hata oldu.");
        }
            
        
    }
    public static String read(String fileName){
        
        String text = "" ;
        try( Scanner scanner =  new Scanner (new BufferedReader(new FileReader(fileName)) ) ){
            
            while (scanner.hasNext()){
                
                text +=scanner.nextLine();
            }
            
        } 
        catch (IOException ex) {
            System.out.println("read fonksiyonunda dosya açılırken hata oldu.");
        }
            
        return text;
    }
    
    public static ArrayList<String> getLineByLine(String fileName)
    {
        ArrayList<String> stringArray = new ArrayList<String>();
        
        try( Scanner scanner =  new Scanner (new BufferedReader(new FileReader(fileName)) ) ){
            
            while (scanner.hasNext()){
                
                stringArray.add(scanner.nextLine());
            }
            
        } 
        catch (IOException ex) {
            System.out.println("read fonksiyonunda dosya açılırken hata oldu.");
        }
        
        return stringArray;
    }
    
    public static  void   writeStringArray(ArrayList<String> arr ,String filePath){
        
        try(ObjectOutputStream out =new ObjectOutputStream(new FileOutputStream(filePath))){
            out.writeObject(arr);
             
            
        } catch (IOException ex) {
            System.out.println(filePath + "dosyasına array yazılamadı.");
        }
        
        
    }
    public static ArrayList<String>  readStringArray(String filePath){
        
        ArrayList<String> arr = new ArrayList<String>();
        try(ObjectInputStream in =new ObjectInputStream(new FileInputStream(filePath)) ){
           
             arr  = (ArrayList<String>)in.readObject();
            
        } catch (IOException ex) {
            System.out.println(filePath + " dosyasindan okunamadi.");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FileWriterAndReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return arr;
    }

  

}
