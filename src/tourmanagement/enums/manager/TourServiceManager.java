/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tourmanagement.enums.manager;

import java.util.ArrayList;
import java.util.List;
import tourmanagement.enums.TourService;
import tourmanagement.tools.Tools;
import tourmanagement.view.Views;

/**
 *
 * @author admin
 */
public class TourServiceManager {
    private final TourService[] allTourServices = TourService.values();
    

    public void showAll(){
        Views.display("===============All avalaible service===============");
        for(TourService t : allTourServices){
            if(t!=TourService.NULL){
                Views.display(t.ordinal()+1+". "+t.getMess());
            }
        }
    }

    
    public TourService get(int n){
        for(TourService t : allTourServices){
            if(n==t.ordinal()+1){
                return t;
            }
        }
        return TourService.NULL;
    }
    
    public List<TourService> getInclusions(){
       List<TourService> inclusions= new ArrayList<>();
       showAll();
       int n;
       do{
           n= Tools.inputInt("Chọn dịch vụ(1->"+(allTourServices.length-1)+"): ");
           if(get(n)!=TourService.NULL&&!checkIsExistService(inclusions, get(n))){
           inclusions.add(get(n));
           }
           n=Tools.inputInt("Bạn có muốn thêm dịch vụ?\n"
                   + "Bấm 1 để tiếp tục, bấm phím khác để thoát: ");
       }while(n==1);
            
        return inclusions;
    }
    public List<TourService> getExclusions(List<TourService> inclusions){
        List<TourService> exclusions=new ArrayList<>();
        for(TourService x: allTourServices){
            if(!checkIsExistService(inclusions, x)&& x!=TourService.NULL){
                exclusions.add(x);
            }
        }        
        return exclusions;
    }
    
    
    public boolean checkIsExistService(List<TourService> list, TourService tourService){
        boolean check=false;
        for(TourService x : list){
            if(x==tourService){
                check = true;
            }
        }
        
        return check;
    }
}
