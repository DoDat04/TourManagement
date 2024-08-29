/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tourmanagement.enums;



/**
 *
 * @author admin
 */
public enum Duration{
    ONE_DAY("1 ngày", 1),
    ONE_DAY_ONE_NIGHT("1 ngày 1 đêm",1.5),
    ONE_DAY_TWO_NIGHT("1 ngày 2 đêm",2),
    TWO_DAY_ONE_NIGHT("2 ngày 1 đêm",2.5),
    TWO_DAY_TWO_NIGHT("2 ngày 2 đêm",3),
    TWO_DAY_THREE_NIGHT("2 ngày 3 đêm",3.5),
    THREE_DAY_TWO_NIGHT("3 ngày 2 đêm",4),
    THREE_DAY_THREE_NIGHT("3 ngày 3 đêm",4.5),
    THREE_DAY_FOUR_NIGHT("3 ngày 4 đêm",5),
    NULL("Không tồn tại",0);
    
    private String mess;
    private double rate;

    private Duration(String mess, double rate) {
        this.mess = mess;
        this.rate=rate;
    }

    public double getRate() {
        return rate;
    }


    public String getMess() {
        return mess;
    }
    
}
