/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tourmanagement.interfaces;

import tourmanagement.commander.MainCommander;
import tourmanagement.object.manager.*;
import tourmanagement.enums.manager.*;
import tourmanagement.object.Revenue;
import tourmanagement.tools.FileTools;
/**
 *
 * @author admin
 */
public interface ICommand {
    TourManager manageTour = new TourManager();
    HotelManager manageHotel = new HotelManager();
    BookingManager manageBooking = new BookingManager();
    AmenityManager manageAmenity = new AmenityManager();
    DurationManager manageDuration = new DurationManager();
    LocationManager manageLocation = new  LocationManager();
    TourServiceManager manageTourService = new TourServiceManager();
    MainCommander mainCommander = new MainCommander();
    FileTools manageFile = new FileTools();
    BookingManager manageBookedTour = new BookingManager();
    Revenue revenue = new Revenue();
    void excute();
}
