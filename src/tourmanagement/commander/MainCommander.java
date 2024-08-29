/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tourmanagement.commander;

import tourmanagement.commander.booking.CompleteOnGoingBookingTour;
import java.util.HashMap;
import tourmanagement.interfaces.ICommand;
import tourmanagement.commander.booking.*;
import tourmanagement.commander.tour.*;
import tourmanagement.commander.hotel.*;
import tourmanagement.commander.report.*;
import tourmanagement.commander.data.*;
import tourmanagement.constants.Constants;
import tourmanagement.view.Views;
/**
 *
 * @author admin
 */
public class MainCommander {
    private HashMap<String, ICommand> tourCommand = new HashMap<>();
    private HashMap<String, ICommand> hotelCommand = new HashMap<>();
    private HashMap<String, ICommand> bookingCommand = new HashMap<>();
    private HashMap<String, ICommand> reportCommand = new HashMap<>();
    private HashMap<String, ICommand> dataCommand = new HashMap<>();

    public MainCommander() {
        tourCommand.put("1", new AddTour());
        tourCommand.put("2", new UpdateTour());
        tourCommand.put("3", new SearchTour());
        tourCommand.put("4", new DeleteTour());
        tourCommand.put("5", new ShowAllTour());
        tourCommand.put(Integer.toString(tourCommand.size()+1), new ExitToMainMenu());
        hotelCommand.put("1", new AddHotel());
        hotelCommand.put("2", new UpdateHotel());
        hotelCommand.put("3", new SearchHotel());
        hotelCommand.put("4", new DeleteHotel());
        hotelCommand.put("5", new ShowAllHotel());
        hotelCommand.put(Integer.toString(hotelCommand.size()+1), new ExitToMainMenu());
        bookingCommand.put("1", new BookTour());
        bookingCommand.put("2", new CancelTour());
        bookingCommand.put("3", new ShowAllOnGoingBookingTour());
        bookingCommand.put("4", new CompleteOnGoingBookingTour());
        bookingCommand.put("4", new CompleteOnGoingBookingTour());
        bookingCommand.put(Integer.toString(bookingCommand.size()+1), new ExitToMainMenu());
        reportCommand.put("1", new ShowTrendingTour());
        reportCommand.put("2", new ShowOccupancyOfAllHotel());
        reportCommand.put("3", new CustomerPreference());
        reportCommand.put("4", new ShowRevenue());
        reportCommand.put(Integer.toString(reportCommand.size()+1), new ExitToMainMenu());
        dataCommand.put("1", new SaveData());
        dataCommand.put("2", new LoadData());
    }

    public HashMap<String, ICommand> getTourCommand() {
        return tourCommand;
    }

    public HashMap<String, ICommand> getHotelCommand() {
        return hotelCommand;
    }

    public HashMap<String, ICommand> getBookingCommand() {
        return bookingCommand;
    }

    public HashMap<String, ICommand> getReportCommand() {
        return reportCommand;
    }

    public HashMap<String, ICommand> getDataCommand() {
        return dataCommand;
    }
    
    public void excuteCommand(HashMap<String, ICommand> command, String choice){
        if(command.containsKey(choice)){
        command.get(choice).excute();
        }else{
            Views.displayRed(Constants.INVALID_CHOICE);
        }
        
    }
    
    
    
}
