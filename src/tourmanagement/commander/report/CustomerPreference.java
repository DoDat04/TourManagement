/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tourmanagement.commander.report;

import java.util.List;
import tourmanagement.enums.Amenity;
import tourmanagement.enums.Location;
import tourmanagement.interfaces.ICommand;
import tourmanagement.view.Views;

/**
 *
 * @author admin
 */
public class CustomerPreference implements ICommand{

    @Override
    public void excute() {
        List<Amenity> amenityPreference = manageAmenity.getCustomerPreference(manageBooking.getAllHotelAmenityInBookedTour());
        List<Location> locationPreference = manageLocation.getLocationPreference(manageTour.getListDestinationOfTrendingTours());
        Views.display("Những địa điểm được khách hàng ưa chuộng:");
        if(locationPreference.isEmpty()){
            Views.displayRed("Chưa có đủ thông tin để phân tích địa điểm ưa thích");
        }else{
            locationPreference.forEach(loc->Views.displayBlue(loc.getMess()));
        }
        Views.display("Những tiện nghi của khách sạn mà khách hàng ưa thích: ");
        if(amenityPreference.isEmpty()){
            Views.displayRed("Chưa có đủ thông tin để phân tích tiện nghi ưa thích");
            
        }else{
            amenityPreference.forEach(amenity->Views.displayBlue(amenity.getMess()));
        }
    }
    
}
