/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tourmanagement.commander.tour;

import tourmanagement.constants.Constants;
import tourmanagement.enums.Duration;
import tourmanagement.enums.Location;
import tourmanagement.interfaces.ICommand;
import tourmanagement.tools.Tools;
import tourmanagement.view.Views;

/**
 *
 * @author admin
 */
public class SearchTour implements ICommand {

    @Override
    public void excute() {
        Views.showSearchTourOptions();
        String choice = Tools.inputString(Constants.ENTER_CHOICE);
        switch (choice) {
            case "1":
                Location location = manageLocation.getLocation("điểm đến");
                manageTour.searchByDestination(location);
                break;
            case "2":
                Duration duration = manageDuration.getDuration();
                manageTour.searchByDuration(duration);
                break;
            case"3":
                String price = Tools.inputString("Nhập giá bạn muốn(USD): ");
                manageTour.searchByPrice(price);
                break;
            default:
                Views.displayRed(Constants.INVALID_CHOICE);
        }
    }

}
