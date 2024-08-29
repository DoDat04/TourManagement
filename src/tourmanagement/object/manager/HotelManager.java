/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tourmanagement.object.manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import tourmanagement.constants.Constants;
import tourmanagement.enums.Amenity;
import tourmanagement.enums.Location;
import tourmanagement.enums.manager.AmenityManager;
import tourmanagement.interfaces.IObjectManager;
import tourmanagement.view.Views;
import tourmanagement.object.Hotel;

/**
 *
 * @author admin
 */
public class HotelManager implements IObjectManager {

    private HashMap<String, Hotel> hotelList;

    public HotelManager() {
        this.hotelList = new HashMap<>();
    }

    public HashMap<String, Hotel> getHotelList() {
        return hotelList;
    }

    @Override
    public List<Hotel> showall() {
        List<Hotel> list = new ArrayList<>(hotelList.values());
        list.sort((Hotel h1, Hotel h2) -> h1.getName().compareToIgnoreCase(h2.getName()));
        int n = 1;
        if(!list.isEmpty()){
            Views.display("===================Danh sách khách sạn====================\n");
        }
        for (Hotel x : list) {
            Views.display(n + ". " + x.toString());
            Views.display(Constants.LINE);
            n++;
        }
        return list;
    }

    @Override
    public <T> void add(String id, T object) {
        this.hotelList.put(id, (Hotel) object);
    }

    @Override
    public void delete(String id) {
        this.hotelList.remove(id);
    }

    @Override
    public <T> void update(String id, T object) {
        this.hotelList.replace(id, (Hotel) object);
    }

    public void occupancyOfAllHotel() {
        if (this.hotelList.isEmpty()) {
            Views.displayRed("Danh sách khách sạn trống");
            return;
        }
        for (String key : this.hotelList.keySet()) {
            Views.display(hotelList.get(key).getIdentityInformation());
            Views.display(hotelList.get(key).getOccupancyInformation() + "\n");
            Views.display(Constants.LINE);
        }
    }

    public boolean checkHotelLocation(Hotel hotel, Location loc) {
        return hotel.getLocation() == loc;
    }

    public boolean checkHotelRoom(Hotel hotel, int n) {
        return hotel.getAvailableRoom() >= n;
    }

    public boolean checkHotelAmenity(AmenityManager manageAmenity, Hotel hotel, List<Amenity> amenities) {
        boolean check = true;
        for (Amenity a : amenities) {
            if (!manageAmenity.checkIsExistAmenity(hotel.getAmenities(), a)) {
                check = false;
            }
        }
        return check;
    }

    public List<Hotel> getHotelListForBooking(Location loc) {
        List<Hotel> list = new ArrayList<>();
        int n = 1;
        for (Hotel hotel : hotelList.values()) {
            if (checkHotelLocation(hotel, loc) && checkHotelRoom(hotel, 1)) {
                list.add(hotel);
                Views.display(n + ". " + hotel.toString());
                Views.display(Constants.LINE);
                n++;
            }
        }
        return list;
    }

}
