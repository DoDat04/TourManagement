/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tourmanagement.commander.hotel;

import java.util.List;
import tourmanagement.constants.Constants;
import tourmanagement.enums.Amenity;
import tourmanagement.enums.Location;
import tourmanagement.interfaces.ICommand;
import tourmanagement.object.Hotel;
import tourmanagement.tools.Tools;
import tourmanagement.view.Views;

/**
 *
 * @author admin
 */
public class SearchHotel implements ICommand {

    @Override
    public void excute() {
        Views.showSearchHotelOptions();
        String s = "Không có khách sạn có thông tin bạn muốn.";
        boolean check = true;
        String choice = Tools.inputString(Constants.ENTER_CHOICE);
        switch (choice) {
            case "1":
                Location loc = manageLocation.getLocation("địa chỉ");
                Views.display(Constants.RESULT_TITLE);
                for (Hotel hotel : manageHotel.getHotelList().values()) {
                    if (manageHotel.checkHotelLocation(hotel, loc)) {
                        Views.display(hotel.toString());
                        Views.display(Constants.LINE);
                        check = false;
                    }
                }
                if (check) {
                    Views.displayRed(s);
                }
                break;
            case "2":
                List<Amenity> amenities = manageAmenity.getListAmenities();
                Views.display(Constants.RESULT_TITLE);
                for (Hotel hotel : manageHotel.getHotelList().values()) {
                    if (manageHotel.checkHotelAmenity(manageAmenity, hotel, amenities)) {
                        Views.display(hotel.toString());
                        Views.display(Constants.LINE);
                        check = false;
                    }
                }
                if (check) {
                    Views.displayRed(s);
                }
                break;
            case "3":
                int n = Tools.inputInt("Nhập số lượng phòng trống bạn muốn: ");
                if (n <= 0) {
                    Views.displayRed(Constants.INVALID_CHOICE);
                } else {
                    Views.display(Constants.RESULT_TITLE);
                    for (Hotel hotel : manageHotel.getHotelList().values()) {
                        if (manageHotel.checkHotelRoom(hotel, n)) {
                            Views.display(hotel.toString());
                            Views.display(Constants.LINE);
                            check = false;
                        }
                    }
                }
                if (check) {
                    Views.displayRed(s);
                }
                break;
            default:
                Views.displayRed(Constants.INVALID_CHOICE);
        }
    }

}
