/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tourmanagement.commander.hotel;

import java.util.List;
import tourmanagement.constants.Constants;
import tourmanagement.interfaces.ICommand;
import tourmanagement.object.Hotel;
import tourmanagement.tools.Tools;
import tourmanagement.view.Views;

/**
 *
 * @author admin
 */
public class DeleteHotel implements ICommand {

    @Override
    public void excute() {
        List<Hotel> listHotel = manageHotel.showall();
        if (listHotel.isEmpty()) {
            Views.displayRed("Danh sách khách sạn trống, không thể xóa");
            return;
        }
        int n = Tools.inputInt("Chọn khách sạn bạn muốn xóa(1->" + listHotel.size() + "): ");
        Hotel hotel = manageHotel.get(listHotel, n);
        if (hotel == null) {
            Views.displayRed(Constants.INVALID_CHOICE);
            return;
        }
        if (manageBooking.checkOnGoingBookingHotel(hotel)) {
            Views.displayRed("Không thể xóa, khách sạn này đã có khách hàng đặt và đang trong quá trình xử lý");
            return;
        }
        n = Tools.inputInt("Bạn có chắc chắn muốn xóa khách sạn này?\nBấm phím 1 để xác nhận xóa, bấm phím khác để thoát: ");
        if (n == 1) {
            manageHotel.delete(hotel.getId());
            Views.displayBlue("Xóa khách sạn thành công");
        } else {
            Views.displayYellow("Đã hủy, xóa khách sạn thất bại");
        }
    }

}
