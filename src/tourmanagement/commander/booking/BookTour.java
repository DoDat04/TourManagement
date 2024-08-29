/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tourmanagement.commander.booking;

import java.util.List;
import tourmanagement.constants.Constants;
import tourmanagement.interfaces.ICommand;
import tourmanagement.object.Booking;
import tourmanagement.object.Hotel;
import tourmanagement.object.Tour;
import tourmanagement.tools.Tools;
import tourmanagement.view.Views;

/**
 *
 * @author admin
 */
public class BookTour implements ICommand {

    @Override
    public void excute() {
        List<Tour> tourList = manageTour.showall();
        if(tourList.isEmpty()){
            Views.displayRed("Xin lỗi quý khách, hiện tại chúng tôi vẫn chưa có tour để đặt");
            return;
        }
        int n = Tools.inputInt("Chọn tour(1->"+tourList.size()+"): ");
        Tour tour = manageTour.get(tourList, n);
        if (tour == null) {
            Views.displayRed(Constants.INVALID_CHOICE);
            return;
        }
        List<Hotel> hotelList = manageHotel.getHotelListForBooking(tour.getDestination());
        if (hotelList.isEmpty()) {
            Views.displayYellow("Rất xin lỗi quý khách, hiện tại chúng tôi chưa có khách sạn phù hợp với tour."
                    + "\nMong quý khách thông cảm, chúng tôi sẽ sớm cập nhật thêm thông tin khách sạn\n");
            return;
        }
        n = Tools.inputInt("Chọn khách sạn(1->" + hotelList.size() + "): ");
        Hotel hotel = manageHotel.get(hotelList, n);
        if (hotel == null) {
            Views.displayRed(Constants.INVALID_CHOICE);
            return;
        }
        String code = Tools.createCode(manageBooking.getBookingList(), "B");
        Booking booked = new Booking(code, tour, hotel);
        manageBooking.add(code, booked);
        manageTour.getTourList().get(tour.getId()).addBookedTime();
        manageHotel.getHotelList().get(hotel.getId()).minusOneRoomAvailable();
        Views.displayGreen("Đặt tour thành công, chúc quý khách có một chuyến đi an toàn và vui vẻ");

    }

}
