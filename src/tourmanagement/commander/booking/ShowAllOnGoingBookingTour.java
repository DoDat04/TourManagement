/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tourmanagement.commander.booking;

import tourmanagement.interfaces.ICommand;
import tourmanagement.view.Views;

/**
 *
 * @author admin
 */
public class ShowAllOnGoingBookingTour implements ICommand{

    @Override
    public void excute() {
        if(manageBooking.showall().isEmpty()){
            Views.displayRed("Không có gói tour nào đang trong quá trình xử lý");
        }
    }
    
}
