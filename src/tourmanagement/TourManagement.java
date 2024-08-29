/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tourmanagement;

import tourmanagement.commander.MainCommander;
import tourmanagement.constants.Constants;
import tourmanagement.tools.Tools;
import tourmanagement.view.Views;

/**
 *
 * @author admin
 */
public class TourManagement {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MainCommander mainCommander = new MainCommander();
        mainCommander.excuteCommand(mainCommander.getDataCommand(), "2");

        String choice;
        do {
            Views.showMainOptions();
            choice = Tools.inputString(Constants.ENTER_CHOICE);
            String subChoice;
            switch (choice) {
                case "1":
                    do{
                    Views.showSubOptions("1. Quản lý tour");
                    subChoice = Tools.inputString(Constants.ENTER_CHOICE);
                    mainCommander.excuteCommand(mainCommander.getTourCommand(), subChoice);
                    }while(!subChoice.equals(Integer.toString(mainCommander.getTourCommand().size())));
                    break;
                case "2":
                    do{
                    Views.showSubOptions("2. Quản lý khách sạn");
                    subChoice = Tools.inputString(Constants.ENTER_CHOICE);
                    mainCommander.excuteCommand(mainCommander.getHotelCommand(), subChoice);
                    }while(!subChoice.equals(Integer.toString(mainCommander.getHotelCommand().size())));
                    break;
                case "3":
                    do{
                    Views.showBookingOptions();
                    subChoice = Tools.inputString(Constants.ENTER_CHOICE);
                    mainCommander.excuteCommand(mainCommander.getBookingCommand(), subChoice);
                    }while(!subChoice.equals(Integer.toString(mainCommander.getBookingCommand().size())));
                    break;
                case "4":
                    do{
                    Views.showReportOptions();
                    subChoice = Tools.inputString(Constants.ENTER_CHOICE);
                    mainCommander.excuteCommand(mainCommander.getReportCommand(), subChoice);
                    }while(!subChoice.equals(Integer.toString(mainCommander.getReportCommand().size())));
                    break;
                case "5":
                    mainCommander.excuteCommand(mainCommander.getDataCommand(), "1");
                    break;
                case "6":
                    subChoice =Tools.inputString("Bạn có muốn lưu trước khi thoát?\nBấm phím 1 để lưu, bấm phím khác để không lưu: ");
                    if(subChoice.equals("1")){
                    mainCommander.excuteCommand(mainCommander.getDataCommand(), "1"); 
                    }
                    Views.displayGreen("Cám ơn quý khách đã sử dụng dịch vụ của chúng tôi");
                    break;
                default:
                    Views.displayRed(Constants.INVALID_CHOICE);
                    
            }

        } while (!choice.equals("6"));

    }
}
