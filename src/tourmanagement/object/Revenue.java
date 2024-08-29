/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tourmanagement.object;

import java.io.Serializable;
import tourmanagement.constants.Colors;

/**
 *
 * @author admin
 */
public class Revenue implements Serializable {
    private double revenue;

    public Revenue() {
        this.revenue=0;
    }

    public double getRevenue() {
        return revenue;
    }

    public void setRevenue(double revenue) {
        this.revenue += revenue;
    }

    @Override
    public String toString() {
        return "Tổng doanh thu(USD): "+getRevenue()+"$";
    }
    
    
}
