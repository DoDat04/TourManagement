/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tourmanagement.commander.booking;

import java.util.List;
import tourmanagement.constants.Constants;
import tourmanagement.interfaces.ICommand;
import static tourmanagement.interfaces.ICommand.manageBooking;
import tourmanagement.object.Booking;
import tourmanagement.tools.Tools;
import tourmanagement.view.Views;

/**
 *
 * @author admin
 */
public class CancelTour implements ICommand{

    @Override
    public void excute() {
        List<Booking> bookingList = manageBooking.showall();
        if(bookingList.isEmpty()){
            Views.displayRed("Chưa có gói tour nào đang trong quá trình xử lý");
            return;
        }
        int n = Tools.inputInt("Chọn gói tour bạn muốn hủy(1->"+bookingList.size()+"): ");
        Booking booking = manageBooking.get(bookingList, n);
        if(booking==null){
            Views.displayRed(Constants.INVALID_CHOICE);
            return;
        }
        n = Tools.inputInt("Bạn có chắc chắn là muốn hủy gói tour?\nBấm phím 1 để hủy gói tour, bấm phím khác để dừng hủy: ");
        if(n==1){
            manageBooking.delete(booking.getId());
            manageHotel.getHotelList().get(booking.getHotel().getId()).addOneRoomAvailable();
            manageTour.getTourList().get(booking.getTour().getId()).minusBookedTime();
            Views.displayBlue("Hủy tour thành công, chúc quý khách có những chuyến đi vui vẻ trong tương lai");
        }else{
            Views.displaySkyBlue("Đã dừng hủy tour, cám ơn quý khách đã tin tưởng và chọn ở lại với chúng tôi");
        }
        
    }
    
}
