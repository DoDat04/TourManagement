/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tourmanagement.tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import tourmanagement.object.Entity;
import tourmanagement.view.Views;

/**
 *
 * @author admin
 */
public class FileTools {
    public final String HOTEL_FILE_NAME = "Hotel.dat";
    public final String TOUR_FILE_NAME = "Tour.dat";
    public final String BOOKING_FILE_NAME = "Booking.dat";
    public final String REVENUE_FILE_NAME ="Revenue.dat";
    
    public <T extends Entity> void saveListDataToFile(HashMap<String, T> map, String fileName) {
        try (FileOutputStream fos = new FileOutputStream(fileName); ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(map);
            Views.displayBlue("Save data to " + fileName + " completed.");
        } catch (IOException e) {
            Views.displayRed("Save data to " + fileName + " failed.");
            System.out.println(e.getMessage());
        } catch (NullPointerException nul) {
            Views.displayRed("Null poitner");
        }
    }

    /**
     * load and get data from file
     *
     * @param <T>
     * @param map list object that will hold data from file
     * @param fileName file name want to load
     */
    public <T extends Entity> void loadListDataFromFile(HashMap<String, T> map, String fileName) {
        File file = new File(fileName);
        if (!file.exists()) {
            try {
                file.createNewFile();
                Views.display("New file " + fileName + " has been created.");
            } catch (IOException e) {
                Views.displayRed("Fail to create " + fileName + ".");
            }
        }
        if (file.length() == 0) {
            Views.displayRed("File " + fileName + " is empty.");
        } else {
            try (FileInputStream fis = new FileInputStream(file); ObjectInputStream ois = new ObjectInputStream(fis)) {
                HashMap<String, T> newMap = (HashMap) ois.readObject();
                map.clear();
                map.putAll(newMap);
                Views.displayBlue("Load data from " + fileName + " completed.");
            } catch (IOException e) {
                Views.displayRed("Fail to load data from " + fileName + ".");
            } catch (ClassNotFoundException ex) {
                Views.displayRed("Class not found for " + fileName + ".");
            } catch (NullPointerException nul) {
                Views.displayRed("Null poitner");
            }
        }
    }
    
    public <T> void saveObjectToFile(T object, String fileName) {
        try (FileOutputStream fos = new FileOutputStream(fileName); ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(object);
            Views.displayBlue("Save data to " + fileName + " completed.");
        } catch (IOException e) {
            Views.displayRed("Save data to " + fileName + " failed.");
            System.out.println(e.getMessage());
        } catch (NullPointerException nul) {
            Views.displayRed("Null poitner");
        }
    }
    
    public <T> void loadObjectFromFile(T object, String fileName) {
        File file = new File(fileName);
        if (!file.exists()) {
            try {
                file.createNewFile();
                Views.display("New file " + fileName + " has been created.");
            } catch (IOException e) {
                Views.displayRed("Fail to create " + fileName + ".");
            }
        }
        if (file.length() == 0) {
            Views.displayRed("File " + fileName + " is empty.");
        } else {
            try (FileInputStream fis = new FileInputStream(file); ObjectInputStream ois = new ObjectInputStream(fis)) {
                object =(T)ois.readObject();

                Views.displayBlue("Load data from " + fileName + " completed.");
            } catch (IOException e) {
                Views.displayRed("Fail to load data from " + fileName + ".");
            } catch (ClassNotFoundException ex) {
                Views.displayRed("Class not found for " + fileName + ".");
            } catch (NullPointerException nul) {
                Views.displayRed("Null poitner");
            }
        }
    }
}
