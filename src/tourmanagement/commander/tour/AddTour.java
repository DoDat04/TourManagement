/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tourmanagement.commander.tour;

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
public class AddTour implements ICommand {

    @Override
    public void excute() {
        int n;
       do{
           String code = Tools.createCode(manageTour.getTourList(), "T");
           String name = Tools.inputString("Nhập tên: "); 
           Location destination = manageLocation.getLocation("điểm đến");
           Duration duration =manageDuration.getDuration();
           String description = Tools.inputMultiLines("Nhập mô tả(nhấn đúp enter để dừng nhập):\n");
           String price = Tools.inputPrice("Nhập giá(min: 10$): ");
           List<TourService> inclusions = manageTourService.getInclusions();
           if(name.isEmpty()||destination==Location.NULL||duration == Duration.NULL||description.isEmpty()||price.isEmpty()||inclusions.isEmpty()){
           Views.displayRed("Không thể thêm tour, bạn có thông tin không hợp lệ");
           }else{
               Tour tour= new Tour(code, name, destination, duration, description, Double.parseDouble(price), inclusions);
               manageTour.add(code, tour);
               Views.displayBlue("Thêm tour thành công");
           }
           
         n= Tools.inputInt("Bạn có muốn thêm tour nữa không?\nBấm phím 1 để tiếp tục, bấm phím khác để tiếp tục: ");
       }while(n==1);
    }
    
}
