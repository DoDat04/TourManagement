/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tourmanagement.commander.tour;

import tourmanagement.interfaces.ICommand;
import tourmanagement.view.Views;

/**
 *
 * @author admin
 */
public class ShowAllTour implements ICommand{

    @Override
    public void excute() {
        if(manageTour.showall().isEmpty()){
            Views.displayRed("Danh sách tour trống");
        }
    }
    
}
