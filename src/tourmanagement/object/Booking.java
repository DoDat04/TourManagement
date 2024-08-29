/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tourmanagement.object;

import java.io.Serializable;
import tourmanagement.constants.Colors;
import tourmanagement.view.Views;



/**
 *
 * @author admin
 */
public class Booking extends Entity implements Serializable{

    private Tour tour;
    private Hotel hotel;


    public Booking(String id, Tour tour, Hotel hotel) {
        super(id);
        this.tour = tour;
        this.hotel = hotel;
        this.price=0;
        this.price= this.tour.getPrice()+(this.hotel.getPrice()*this.tour.getDuration().getRate());
    }

    public Tour getTour() {
        return tour;
    }

    public void setTour(Tour tour) {
        this.tour = tour;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
 
       this.hotel = hotel;
    }
    
    
    @Override
    public void updatePrice(String price){
        Views.displayRed("Tổng chi phí phải trả không thể sửa đổi");
    }
    
    @Override
    public String getName() {
        Views.displayRed("Tên không tồn tại trong thông tin đặt tour");
        return "";
    }
    
    @Override
    public void updateName(String name){
        Views.displayRed("Thông tin đặt tour không có tên.");
    }


    @Override
    public String toString() {
        return "Mã đặt tour: "+getId()+
                "\nThông tin tour:\n"+getTour().getIdentityInformation()+
                "\nThông tin khách sạn:\n"+getHotel().getIdentityInformation()+
                "\nTổng chi phí(USD): "+getPrice()+"$";
    }
    

}
