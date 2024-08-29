/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tourmanagement.commander.hotel;


import java.util.List;
import tourmanagement.constants.Constants;
import tourmanagement.enums.Amenity;
import tourmanagement.interfaces.ICommand;
import tourmanagement.object.Hotel;
import tourmanagement.tools.Tools;
import tourmanagement.view.Views;

/**
 *
 * @author admin
 */
public class UpdateHotel implements ICommand{

    @Override
    public void excute() {
        List<Hotel> listHotel = manageHotel.showall();
        if(listHotel.isEmpty()){
            Views.displayRed("Danh sách khách sạn trống, không thể cập nhật");
            return;
        }
        int n = Tools.inputInt("Chọn khách sạn bạn muốn cập nhật(1->"+listHotel.size()+"): ");
        Hotel hotel = manageHotel.get(listHotel, n);
        if(hotel==null){           
            Views.displayRed(Constants.INVALID_CHOICE);
            return;
        }
        if(manageBooking.checkOnGoingBookingHotel(hotel)){
            Views.displayRed("Không thể cập nhật, khách sạn này đã được khách hàng đặt và đang trong quá trình xử lý");
            return;
        }
        Views.display("\nThông tin gốc:\n"+hotel.toString());
        Views.displayRed("LƯU Ý: nếu không nhập thông tin hoặc nhập thông tin sai thì hệ thống sẽ không cập nhật");
        Views.displaySkyBlue("*Mẹo: nếu bạn không muốn cập nhật thông tin nào, hãy bỏ trống nó");
        String name = Tools.inputString("Nhập tên: ");
        hotel.updateName(name);
        List<Amenity> amenities = manageAmenity.getListAmenities();
        String roomavailable = Tools.inputString("Nhập số phòng trống: ");
        hotel.updateAvailableRoom(roomavailable);
        hotel.updateAmenities(amenities);
        String price = Tools.inputString("Nhập giá(USD): ");
        hotel.updatePrice(price);
        manageHotel.update(hotel.getId(), hotel);
    }
    
}
