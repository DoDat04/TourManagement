/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tourmanagement.commander.tour;

import java.util.ArrayList;
import java.util.List;
import tourmanagement.enums.Duration;
import tourmanagement.enums.Location;
import tourmanagement.enums.TourService;
import tourmanagement.interfaces.ICommand;
import tourmanagement.object.Tour;
import tourmanagement.tools.Tools;
import tourmanagement.view.Views;

/**
 *
 * @author admin
 */
public class UpdateTour implements ICommand{

    @Override
    public void excute() {
       List<Tour> listTour = manageTour.showall();
       if(listTour.isEmpty()){
           Views.displayRed("Danh sách khách sạn trống, không thể cập nhật");
           return;
       }
       int n = Tools.inputInt("Chọn tour bạn muốn cập nhật(1->"+listTour.size()+"): ");       
        Tour tour =manageTour.get(listTour, n);
        if(tour==null){
            Views.displayRed("Lựa chọn không hợp lệ");
            return;
        }
        if(manageBooking.checkOnGoingBookingTour(tour)){
            Views.displayRed("Không thể cập nhật, tour này đã được khách hàng đặt và đang trong quá trình xử lý");
            return;
        }
        Views.display("\nThông tin gốc:\n"+tour.toString());
        Views.displayRed("LƯU Ý: nếu không nhập thông tin hoặc nhập thông tin sai thì hệ thống sẽ không cập nhật");
        Views.displaySkyBlue("*Mẹo: nếu bạn không muốn cập nhật thông tin nào, hãy bỏ trống nó");
        String name = Tools.inputString("Nhập tên: ");
        tour.updateName(name);
        Location location = manageLocation.getLocation("điểm đến");
        tour.updateDestination(location);
        Duration duration = manageDuration.getDuration();
        tour.updateDuration(duration);
        String descripton = Tools.inputMultiLines("Nhập mô tả(nhấn đúp enter để dừng nhập):\n");
        tour.updateDescription(descripton);
        String price = Tools.inputString("Nhập giá(USD): ");
        tour.updatePrice(price);
        List<TourService> inclusions = manageTourService.getInclusions();
        tour.updateInclusions(inclusions);
        tour.updateExclusions();
        manageTour.update(tour.getId(), tour);
        
    }
    
}
