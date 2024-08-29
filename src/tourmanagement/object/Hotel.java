/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tourmanagement.object;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import tourmanagement.constants.Colors;
import tourmanagement.enums.Amenity;
import tourmanagement.enums.Location;
import tourmanagement.view.Views;

/**
 *
 * @author admin
 */
public class Hotel extends Entity implements Serializable {
    
    private Location location;
    private int availableRoom;
    private int maxRoom;
    private List<Amenity> amenities;
    
    public Hotel() {
    }
    
    public Hotel(String id, String name, Location location, int maxRoom, int availableRoom, List<Amenity> amenities, double price) {
        super(id, name, price);
        this.location = location;
        this.maxRoom = maxRoom;
        if (availableRoom <= this.maxRoom&&availableRoom>0) {
            this.availableRoom = availableRoom;
        } else if(availableRoom<0){
            this.availableRoom = 0;
        } else{
            this.availableRoom=maxRoom;
        }
        this.amenities = amenities;
    }
    
    public Location getLocation() {
        return location;
    }
    
    public int getAvailableRoom() {
        return availableRoom;
    }
    
    public List<Amenity> getAmenities() {
        return amenities;
    }
    
    public void minusOneRoomAvailable() {
        if (this.availableRoom > 0) {
            this.availableRoom--;
        }
    }
    
    public void addOneRoomAvailable() {
        if (this.availableRoom < this.maxRoom) {
            this.availableRoom++;
        }
    }
    
    public void setLocation(Location location) {
        this.location = location;
    }
    
    public void updateAvailableRoom(String availableRoom) {
        if (!availableRoom.isEmpty()) {
            try {
                int n = Integer.parseInt(availableRoom);
                if (n <= this.maxRoom&&n>=0) {
                    this.availableRoom = n;
                } else if(n>this.maxRoom){
                    this.availableRoom = this.maxRoom;
                }else{
                    this.availableRoom=0;
                }
                Views.displayBlue("Cập nhật phòng trống thành công");
            } catch (NumberFormatException e) {
                Views.displayYellow("Không cập nhật phòng trống");
            }
        }
    }
    
    public void updateAmenities(List<Amenity> amenities) {
        if (!amenities.isEmpty()) {
            this.amenities = amenities;
            Views.displayBlue("Cập nhật các tiện nghi thành công");
        } else {
            Views.displayYellow("Không cập nhật các tiện nghi");
        }
    }
    
    public int getMaxRoom() {
        return maxRoom;
    }
    
    public void setMaxRoom(int maxRoom) {
        this.maxRoom = maxRoom;
    }

    /**
     *
     * @return trả về một chuỗi thông báo số lượng phòng đã được sử dụng của
     * khách sạn
     */
    public String getOccupancyInformation() {
        return "Đã sử dụng " + (getMaxRoom() - getAvailableRoom()) + " phòng trên tổng số " + getMaxRoom() + " phòng";
    }
    
    public String getIdentityInformation() {
        return "[ID: " + getId() + "|Tên: " + getName() + "]";
    }
    
    @Override
    public String toString() {
        List<String> lisAmenity = new ArrayList<>();
        getAmenities().forEach(item -> lisAmenity.add(item.getMess()));
        String string = String.join(Colors.ANSI_BLUE+"\n", lisAmenity);
        return "[" + getId() + "] " + getName()
                + "\nĐịa chỉ: " + getLocation().getMess()
                + "\nSố phòng trống: " + getAvailableRoom()
                + "\nCác tiện nghi:\n" +Colors.ANSI_BLUE +string+Colors.ANSI_RESET
                + "\nGiá(USD/ngày): "+ getPrice()+"$";
    }
    
}
