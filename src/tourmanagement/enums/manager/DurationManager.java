/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tourmanagement.enums.manager;

import tourmanagement.enums.Duration;
import tourmanagement.tools.Tools;
import tourmanagement.view.Views;

/**
 *
 * @author admin
 */
public class DurationManager {
    private final Duration[] allDuration = Duration.values();
    

    public void showAll(){
        Views.display("=========All available duration=========");
        for(Duration d : allDuration){
            if(d!=Duration.NULL){
                Views.display(d.ordinal()+1+". "+d.getMess());
            }
        }
    }
    

    public Duration get(int n){
        for(Duration d : allDuration){
            if(n==d.ordinal()+1){
                return d;
            }
        }
        return Duration.NULL;
    }
    
    public Duration getDuration(){
        showAll();
        int n =Tools.inputInt("Chọn thời gian(1-->"+(allDuration.length-1)+"): ");
        return get(n);
        
    }
}
