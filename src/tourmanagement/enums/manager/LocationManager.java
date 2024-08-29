/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tourmanagement.enums.manager;

import java.util.ArrayList;
import java.util.List;
import tourmanagement.enums.Location;
import tourmanagement.tools.Tools;
import tourmanagement.view.Views;

/**
 *
 * @author admin
 */
public class LocationManager {
    private final Location[] allLocations = Location.values();
    

    public void showAll(){
        Views.display("=====All available location=====");
        for(Location l : allLocations){
            if(l!=Location.NULL){
                Views.display(l.ordinal()+1+". "+l.getMess());
            }
        }
    }

    public Location get(int n){
        for(Location l : allLocations){
            if(n==l.ordinal()+1){
                return l;
            }
        }
        return Location.NULL;
    }
    
    public Location getLocation(String mess){
        showAll();
        int n =Tools.inputInt("Chọn "+mess+"(1-->"+(allLocations.length-1)+"): ");
        return get(n);
    }
    
    public boolean checkIsExistLocation(List<Location> locations, Location loc){
        boolean check = false;
        for(Location lc : locations){
            if(lc==loc){
                check=true;
            }
        }        
        return check;
    }
    
    public List<Location> getLocationPreference(List<Location> locationsOfTrendingTour){
        List<Location> locations = new ArrayList<>();
        for(Location loc : allLocations){
            for(Location loc2 : locationsOfTrendingTour){
                if(!checkIsExistLocation(locations, loc)&&loc==loc2){
                    locations.add(loc);
                }
            }
        }
        return locations;
    }
    
    
}
