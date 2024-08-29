/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tourmanagement.enums;



/**
 *
 * @author admin
 */
public enum TourService{
    FLIGHT_TICKET("Vé máy bay khứ hồi"),
    SINGED_LUGGAGE("Hành lý ký gửi khi khách hàng muốn mang thêm hành lý cá nhân (tối đa 10kg)"),
    FOOD("Các bữa ăn chính theo trương trình của chuyến du lịch"),
    TRANSPOSTATION("Các phương tiện đưa khách hàng đi tham quan"),
    ENTRANCE_TICKET("Vé vào cổng của các địa điểm du lịch có trong trương trình"),
    PERSONAL_COST("Chi phí cá nhân khi khách hàng muốn trải nghiệm các dịch vụ không có trong trương trình"),
    NULL("Không tồn tại");
    
    private String mess;

    private TourService(String mess) {
        this.mess = mess;
       
    }


    public String getMess() {
        return mess;
    }
    
    
}
