/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tourmanagement.enums;



/**
 *
 * @author admin
 */
public enum Location{
   HCM("TP.HCM"),
   HN("Hà Nội"),
   NT("Nha Trang"),
   VT("Vũng Tàu"),
   PQ("Phú Quốc"),
   SP("SaPa"),
   DN("Đà Nẵng"),
   DL("Đà Lạt"),
   HL("Hạ Lọng"),
   CD("Côn Đảo"),
   NULL("Không tồn tại");
   
   
    private String mess;

    private Location(String mess) {
        this.mess = mess;

    }
    

    public String getMess() {
        return mess;
    }
    

    
    
    
}
