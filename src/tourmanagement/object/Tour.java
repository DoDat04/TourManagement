/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tourmanagement.object;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import tourmanagement.constants.Colors;
import tourmanagement.enums.Duration;
import tourmanagement.enums.Location;
import tourmanagement.enums.TourService;
import tourmanagement.enums.manager.TourServiceManager;
import tourmanagement.view.Views;

/**
 *
 * @author admin
 */
public class Tour extends Entity implements Serializable{

    private Location destination;
    private Duration duration;
    private String description;
    private List<TourService> inclusions;
    private List<TourService> exclusions;
    private int bookedTime;

    public Tour() {
    }

    public Tour(String id, String name, Location destination, Duration duration, String description, double price, List<TourService> inclusions) {
        super(id, name,price);
        this.destination = destination;
        this.duration = duration;
        this.description = description;
        this.price = price;
        this.inclusions = inclusions;
        TourServiceManager tsm = new TourServiceManager();
        this.exclusions = tsm.getExclusions(inclusions);
        this.bookedTime = 0;
    }

    public Location getDestination() {
        return destination;
    }

    public Duration getDuration() {
        return duration;
    }

    public String getDescription() {
        return description;
    }

    public List<TourService> getInclusions() {
        return inclusions;
    }

    public List<TourService> getExclusions() {
        return exclusions;
    }

    public int getBookedTime() {
        return bookedTime;
    }

    public void minusBookedTime() {
        this.bookedTime--;
    }

    public void addBookedTime() {
        this.bookedTime++;
    }

    public void updateDestination(Location destination) {
        if (destination != Location.NULL) {
            this.destination = destination;
            Views.displayBlue("Cập điểm đến thành công");
        } else {
            Views.displayYellow("Không cập nhật điểm đến");
        }
    }

    public void updateDuration(Duration duration) {
        if (duration != Duration.NULL) {
            this.duration = duration;
            Views.displayBlue("Cập nhật thời gian thành công");
        } else {
            Views.displayYellow("Không cập nhật thời gian");
        }
    }


    public void updateDescription(String description) {
        if (!description.isEmpty()) {
            this.description = description;
            Views.displayBlue("Cập nhật mô tả thành công");
        } else {
            Views.displayYellow("Không cập nhật mô tả");
        }
    }

    public void updateInclusions(List<TourService> inclusions) {
        if (!inclusions.isEmpty()) {
            this.inclusions = inclusions;
            Views.displayBlue("Cập nhật các dịch vụ thành công");
        } else {
            Views.displayYellow("Không cập nhật các dịch vụ");
        }
    }

    public void updateExclusions() {
        TourServiceManager tsm = new TourServiceManager();
        this.exclusions = tsm.getExclusions(getInclusions());
    }

    public String getIdentityInformation() {
        return "[" + getId() + "|" + getName() + "]";
    }

    @Override
    public String toString() {
        List<String> listInclusions = new ArrayList<>();
        getInclusions().forEach(string -> listInclusions.add(string.getMess()));
        String string1 = String.join(Colors.ANSI_BLUE + "\n", listInclusions);
        List<String> listExclusions = new ArrayList<>();
        getExclusions().forEach(string -> listExclusions.add(string.getMess()));
        String string2 = String.join(Colors.ANSI_RED + "\n", listExclusions);
        return "[" + getId() + "] " + getName()
                + "\nĐiểm đến: " + getDestination().getMess()
                + "\nThời gian: " + getDuration().getMess()
                + "\nMô tả:\n" + getDescription()
                + "\nGiá(USD): " + getPrice()+"$"
                + "\nGiá tour bao gồm:\n" + Colors.ANSI_BLUE + string1 + Colors.ANSI_RESET
                + "\nGiá tour không bao gồm:\n" + Colors.ANSI_RED + string2 + Colors.ANSI_RESET;
    }

}
