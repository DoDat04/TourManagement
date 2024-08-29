/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tourmanagement.commander.booking;

import java.util.List;
import tourmanagement.constants.Constants;
import tourmanagement.interfaces.ICommand;
import tourmanagement.object.Booking;
import tourmanagement.tools.Tools;
import tourmanagement.view.Views;

/**
 *
 * @author admin
 */
public class CompleteOnGoingBookingTour implements ICommand{

    @Override
    public void excute() {
        List<Booking> bookingList = manageBooking.showall();
        if(bookingList.isEmpty()){
            
            Views.displayRed("Chưa có gói tour nào đang trong quá trình xử lý");
            return;
        }
        int n = Tools.inputInt("Chọn gói tour(1->"+bookingList.size()+"): ");
        Booking booking = manageBooking.get(bookingList, n);
        if(booking==null){
            Views.displayRed(Constants.INVALID_CHOICE);
            return;
        }
        revenue.setRevenue(booking.getPrice());
        manageBookedTour.add(booking.getId(), booking);
        manageHotel.getHotelList().get(booking.getHotel().getId()).addOneRoomAvailable();
        manageBooking.delete(booking.getId());
        Views.displayBlue("Hoàn thành gói tour");
    }
    
}
