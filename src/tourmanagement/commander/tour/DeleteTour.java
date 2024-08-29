/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tourmanagement.commander.tour;

import java.util.List;
import tourmanagement.constants.Constants;
import tourmanagement.interfaces.ICommand;
import tourmanagement.object.Tour;
import tourmanagement.tools.Tools;
import tourmanagement.view.Views;

/**
 *
 * @author admin
 */
public class DeleteTour implements ICommand{

    @Override
    public void excute() {
        List<Tour> listTour = manageTour.showall();
        if(listTour.isEmpty()){
            Views.displayRed("Danh sách tour trống, không thể xóa tour");
            return;
        }
        int n = Tools.inputInt("Chọn tour bạn muốn xóa(1->"+listTour.size()+"): ");
        Tour tour = manageTour.get(listTour, n);
        if(tour==null){
            Views.displayRed(Constants.INVALID_CHOICE);
            return;
        }
        if(manageBooking.checkOnGoingBookingTour(tour)){
            Views.displayRed("Không thể xóa, tour này đã có khách hàng đặt và đang trong quá trình xử lý");
            return;
        }
        n =Tools.inputInt("Bạn có chắc muốn xóa tour này không\nBấm phím 1 để xác nhận xóa, bấm phím khác để hủy: ");
        if(n==1){
            manageTour.delete(tour.getId());
            Views.displayBlue("Xóa thành công");
        }else{
            Views.displayYellow("Đã hủy, xóa tour thất bại");
        }
    }
    
}
