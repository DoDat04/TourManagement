/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tourmanagement.commander.report;

import tourmanagement.interfaces.ICommand;

/**
 *
 * @author admin
 */
public class ShowTrendingTour implements ICommand{

    @Override
    public void excute() {
        manageTour.showTrendingTours();
    }
    
}
