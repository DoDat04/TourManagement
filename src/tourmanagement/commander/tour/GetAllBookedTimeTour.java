/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tourmanagement.commander.tour;

import tourmanagement.interfaces.ICommand;
import tourmanagement.object.Tour;
import tourmanagement.view.Views;

/**
 *
 * @author admin
 */
public class GetAllBookedTimeTour implements ICommand{

    @Override
    public void excute() {
        for(Tour tour :manageTour.getTourList().values()){
            Views.display(tour.toString());
            Views.display("Booked time: "+ tour.getBookedTime()+"\n");
        }
    }
    
}
