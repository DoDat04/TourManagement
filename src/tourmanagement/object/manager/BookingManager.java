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
import tourmanagement.interfaces.IObjectManager;
import tourmanagement.view.Views;
import tourmanagement.object.Booking;
import tourmanagement.object.Hotel;
import tourmanagement.object.Tour;

/**
 *
 * @author admin
 */
public class BookingManager implements IObjectManager{
    private HashMap<String, Booking> bookingList;

    public BookingManager() {
        this.bookingList = new HashMap<>();
    }

    public HashMap<String, Booking> getBookingList() {
        return bookingList;
    }
    
    
    @Override
    public List<Booking> showall() {
        List<Booking> list = new ArrayList<>(bookingList.values());
        list.sort((Booking b1, Booking b2) -> b1.getId().compareToIgnoreCase(b2.getId()));
        int n =1;
        if(!list.isEmpty()){
            Views.display("===================Danh sách gói tour đang trong quá trình====================\n");
        }
        for(Booking x : list){
            Views.display(n+". "+x.toString());
            Views.display(Constants.LINE);
            n++;
        }
        return list;
    }

    @Override
    public <T> void add(String id, T object) {
        bookingList.put(id, (Booking) object);
    }

    @Override
    public void delete(String id) {
        bookingList.remove(id);
    }

    @Override
    public <T> void update(String id, T object) {
        try{
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }catch(UnsupportedOperationException e){
           Views.displayRed(e.getMessage());
        }
    }
    
    public boolean checkOnGoingBookingTour(Tour tour){
        boolean check = false;
        for(String key: bookingList.keySet()){
            if(bookingList.get(key).getTour().getId().equals(tour.getId())){
                check =true;
            }
        }        
        return check;
    }
    
    public boolean checkOnGoingBookingHotel(Hotel hotel){
        boolean check = false;
        for(String key: bookingList.keySet()){
            if(bookingList.get(key).getHotel().getId().equals(hotel.getId())){
                check=true;
            }
        }
        
        return check;
    }
    
    public List<Amenity> getAllHotelAmenityInBookedTour(){
        List<Amenity> amenities = new ArrayList<>();
        for(Booking b : bookingList.values()){
            amenities.addAll(b.getHotel().getAmenities());
        }
        return amenities;
    }

}
