/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tourmanagement.commander.hotel;

import java.util.List;
import tourmanagement.enums.Amenity;
import tourmanagement.enums.Location;
import tourmanagement.interfaces.ICommand;
import tourmanagement.object.Hotel;
import tourmanagement.tools.Tools;
import tourmanagement.view.Views;

/**
 *
 * @author admin
 */
public class AddHotel implements ICommand{

    @Override
    public void excute() {
        int n;
        do{
            String code = Tools.createCode(manageHotel.getHotelList(), "H");
            String name = Tools.inputString("Nhập tên: ");
            Location location = manageLocation.getLocation("địa chỉ");
            int maxroom = Tools.inputInt("Nhập tổng số phòng của khách sạn: ");
            int roomAvailable = Tools.inputInt("Nhập số phòng trống: ");
            List<Amenity> amenities = manageAmenity.getListAmenities();
            String price = Tools.inputPrice("Nhập giá(min: 10$): ");
            if(name.isEmpty()||location==Location.NULL||maxroom<=0||roomAvailable<=0||amenities.isEmpty()||price.isEmpty()){
                Views.displayRed("Không thể thêm khách sạn, bạn có thông tin không hợp lệ");
            }else{
                Hotel hotel = new Hotel(code, name, location, maxroom, roomAvailable, amenities, Double.parseDouble(price));
                manageHotel.add(code, hotel);
                Views.displayBlue("Thêm khách sạn thành công");
            }
            
            n=Tools.inputInt("Bạn có muốn thêm khách sạn nữa không\nNhấn phím 1 để tiếp tục thêm khách sạn, nhấn phím khác để hủy: ");
        }while(n==1);
    }
    
}
