/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tourmanagement.object;

import java.io.Serializable;
import tourmanagement.constants.Constants;
import tourmanagement.view.Views;

/**
 *
 * @author admin
 */
public class Entity implements Serializable {

    private String id;
    private String name;
    double price;

    public Entity() {
    }

    public Entity(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Entity(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public void updateName(String name) {
        if (!name.isEmpty()) {
            this.name = name;
            Views.displayBlue("Cập nhật tên thành công");
        } else {
            Views.displayYellow("Không cập nhật tên");
        }
    }

    public void updatePrice(String price) {
        try {
            double n = Double.parseDouble(price);
            if (n >= Constants.MIN_PRICE) {
                this.price = n;
                Views.displayBlue("Cập nhật giá thành công");
            } else {
                this.price = Constants.MIN_PRICE;
                Views.displaySkyBlue("Số tiền quá nhỏ, hệ thống sẽ tự động đặt thành giá tiền nhỏ nhất là "+Constants.MIN_PRICE+"$");
            }
        } catch (NumberFormatException e) {
            Views.displayYellow("Không cập nhật giá");
        }
    }

}
