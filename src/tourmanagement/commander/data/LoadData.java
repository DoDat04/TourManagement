/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tourmanagement.commander.data;

import tourmanagement.interfaces.ICommand;


/**
 *
 * @author admin
 */
public class LoadData implements ICommand{

    @Override
    public void excute() {
        manageFile.loadListDataFromFile(manageTour.getTourList(), manageFile.TOUR_FILE_NAME);
        manageFile.loadListDataFromFile(manageHotel.getHotelList(), manageFile.HOTEL_FILE_NAME);
        manageFile.loadListDataFromFile(manageBooking.getBookingList(), manageFile.BOOKING_FILE_NAME);
        manageFile.loadObjectFromFile(revenue, manageFile.REVENUE_FILE_NAME);
    }
    
}
