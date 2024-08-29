/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tourmanagement.tools;

import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import tourmanagement.constants.Constants;
import tourmanagement.view.Views;

/**
 *
 * @author admin
 */
public class Tools {
    private static final Scanner sc = new Scanner(System.in);
    
    public static String inputString(String mess){
        Views.displayOneLine(mess);        
        return sc.nextLine();
    }
    public static String inputMultiLines(String mess){
        Views.displayOneLine(mess);
        String string=" ",s="";
        while(!string.isEmpty()){
            string = inputString("");
            s=s+string+"\n";
        }
        return s.trim();
    }
    
    public static int inputInt(String mess){
        Views.displayOneLine(mess);
        int n=-1;
        try{
            n = Integer.parseInt(sc.nextLine());
        }catch(NumberFormatException e){
            //Views.displayRed("Số không hợp lệ\n");
        }
        return n;
    }
    
    public static String inputPrice(String mess){
        String s = inputString(mess);
        if(s.matches("^[0-9]+$")){
            double n = Double.parseDouble(s);
            if(n<Constants.MIN_PRICE){
                Views.display("Số tiền vừa nhập quá nhỏ, hệ thống sẽ tự đặt thành giá trị nhỏ nhất là "+Constants.MIN_PRICE+"$");
                s=Double.toString(Constants.MIN_PRICE);
            }
        }else{
            s="";
        }
        return s;
    }
    public static <T> String createCode(Map<String, T> map, String n) {
        Random rd = new Random();
        String s;
        do {
            s = n + String.format("%03d", rd.nextInt(1000));
        } while (map.containsKey(s));

        return s;
    }

}
