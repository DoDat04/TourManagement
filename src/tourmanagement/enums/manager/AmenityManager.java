/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tourmanagement.enums.manager;

import java.util.ArrayList;
import java.util.List;
import tourmanagement.constants.Constants;
import tourmanagement.enums.Amenity;
import tourmanagement.tools.Tools;
import tourmanagement.view.Views;

/**
 *
 * @author admin
 */
public class AmenityManager{

    private final Amenity[] allAmenities = Amenity.values();


    public void showAll() {
        Views.display("==========All available amenity=========");
        for (Amenity a : allAmenities) {
            if (a != Amenity.NULL) {
                Views.display(a.ordinal() + 1 + ". " + a.getMess());
            }
        }
    }


    public Amenity get(int n) {
        for (Amenity a : allAmenities) {
            if (n == a.ordinal() + 1) {
                return a;
            }
        }
        return Amenity.NULL;
    }
    
    public List<Amenity> getListAmenities(){
        List<Amenity> list = new ArrayList<>();

        showAll();
        int n;
        do{
            n= Tools.inputInt("Chọn tiện nghi(1-->"+(allAmenities.length-1)+"): ");
            if(get(n)!=Amenity.NULL&&!checkIsExistAmenity(list, get(n))){
                list.add(get(n));
            }
            
            n =Tools.inputInt("Bạn có muốn thêm tiện nghi nữa không?\n"
                    + "Bấm phím 1 để tiếp tục thêm tiện nghi,bấm phím khác để dừng: ");
        }while(n==1);
        
        
        return list;
    }
    
        public boolean checkIsExistAmenity(List<Amenity> list, Amenity amenity){
        boolean check=false;
        for(Amenity x : list){
            if(x==amenity){
                check = true;
            }
        }
        return check;
        }
        
        public List<Amenity> getCustomerPreference(List<Amenity> allBookedHotelAmenities){
            List<Amenity> preference = new ArrayList<>();
            for(Amenity a: allAmenities){
                int n=0;
                for(Amenity a2 : allBookedHotelAmenities){
                    if(a==a2){
                        n++;
                    }
                }
                if(n>Constants.TRENDING_CONDITION){
                    preference.add(a);
                }
            }
            return preference;
        }

}
