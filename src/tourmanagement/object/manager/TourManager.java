/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tourmanagement.object.manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import tourmanagement.constants.Constants;
import tourmanagement.enums.Duration;
import tourmanagement.enums.Location;
import tourmanagement.interfaces.IObjectManager;
import tourmanagement.view.Views;
import tourmanagement.object.Tour;
/**
 *
 * @author admin
 */
public class TourManager implements IObjectManager{
    private HashMap<String, Tour> tourList;

    public TourManager() {
        this.tourList= new HashMap<>();
    }

    public HashMap<String, Tour> getTourList() {
        return tourList;
    }


    @Override
    public List<Tour> showall() {
        List<Tour> list = new ArrayList<>(tourList.values());
        list.sort((Tour h1, Tour h2) -> h1.getName().compareToIgnoreCase(h2.getName()));
        int n=1;
        if(!list.isEmpty()){
        Views.display("===================Danh sách tour====================\n");
        }
        for(Tour x : list){
            Views.display(n+". "+x.toString()+"\n");
            Views.display(Constants.LINE);
            n++;
        }
        return list;
    }
    @Override
    public <T> void add(String id, T object) {
        this.tourList.put(id, (Tour) object);
    }

    @Override
    public void delete(String id) {
        this.tourList.remove(id);
    }

    @Override
    public <T> void update(String id, T object) {
        this.tourList.replace(id, (Tour) object);
    }
    
    public List<Tour> getListTrendingTours(){
        List<Tour> list = new ArrayList<>();
        for(Tour tour : tourList.values()){
            if(tour.getBookedTime()>Constants.TRENDING_CONDITION){
               list.add(tour);
            }
        }
        return list;
    }
    
    public List<Location> getListDestinationOfTrendingTours(){
        List<Location> destinations = new ArrayList<>();
        for(Tour tour: getListTrendingTours()){
            destinations.add(tour.getDestination());
        }
        return destinations;
        
    }
    
    public void showTrendingTours(){
        List<Tour> list = getListTrendingTours();
        if(list.isEmpty()){
            Views.displayRed("Chưa có tour hot");
            return;
        }
        Views.display("=====================Trending tour====================");
        for(Tour tour:list){
            Views.display(tour.toString());
            Views.display(Constants.LINE);
        }
    }
    
    public void searchByDestination(Location location){
        boolean check=true;
        Views.display(Constants.RESULT_TITLE);
        for(String key : tourList.keySet()){
            if(tourList.get(key).getDestination()==location){
                Views.display(tourList.get(key).toString());
                Views.display(Constants.LINE);
                check=false;
            }
        }
        if(check){

            Views.displayRed("Không có tour có thông tin bạn muốn tìm");
        }
    }
    
    public void searchByDuration(Duration duration){
        boolean check=true;
        Views.display(Constants.RESULT_TITLE);
        for(String key : tourList.keySet()){
            if(tourList.get(key).getDuration()==duration){
                Views.display(tourList.get(key).toString());
                Views.display(Constants.LINE);
                check=false;
            }
        }
        if(check){

            Views.displayRed("Không có tour có thông tin bạn muốn tìm");
        }
    }
    
    public void searchByPrice(String price){
        boolean check=true;
        try{
            double n = Double.parseDouble(price);
                Views.display(Constants.RESULT_TITLE);
        for(String key: tourList.keySet()){
            if(tourList.get(key).getPrice()<=n+Constants.PRICE_SEGMENT&&tourList.get(key).getPrice()>=n-Constants.PRICE_SEGMENT){
                Views.display(tourList.get(key).toString());
                Views.display(Constants.LINE);
                check=false;
            }
        }
        }catch(NumberFormatException e){
            Views.displayRed("Giá tiền không hợp lệ");
            return;
        }
        if(check){
            Views.displayRed("Không có tour có thông tin bạn muốn tìm");
        }
    }
    
}
