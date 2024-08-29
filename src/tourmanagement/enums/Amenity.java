/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tourmanagement.enums;



/**
 *
 * @author admin
 */
public enum Amenity {
    GYM("Phòng tập thể dục"),
    PARK("Gần công viên"),
    POOL("Hồ bơi"),
    CENTRAL("Gần trung tâm"),
    WIFI("Dịch vụ Internet miễn phí"),
    RESTAUNRANT("Nhà hàng"),
    MALL("Gần trung tâm mua sắm"),
    BEACHVIEW("View biển"),
    NULL("Không tồn tại");
    
    private String mess;

    private Amenity(String mess) {
        this.mess = mess;
    }


    public String getMess() {
        return mess;
    }
    
}
