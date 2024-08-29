/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tourmanagement.view;

import tourmanagement.constants.Colors;

/**
 *
 * @author admin
 */
public class Views {
    
    public static void displayOneLine(String mess) {
        System.out.print(mess);
    }
    
    public static void display(String mess) {
        System.out.println(mess);
    }

    /**
     * display red string
     *
     * @param mess string want to display
     */
    public static void displayRed(String mess) {
        display("");
        display(Colors.ANSI_RED + mess + Colors.ANSI_RESET);
        display("");
    }

    /**
     * display blue string
     *
     * @param mess string want to display
     */
    public static void displayBlue(String mess) {
        display(Colors.ANSI_BLUE + mess + Colors.ANSI_RESET);
    }

    /**
     * display sky blue string
     *
     * @param mess string want to display
     */
    public static void displaySkyBlue(String mess) {
        display(Colors.ANSI_SKY_BLUE + mess + Colors.ANSI_RESET);
    }

    /**
     * display green string
     *
     * @param mess string want to display
     */
    public static void displayGreen(String mess) {
        display(Colors.ANSI_GREEN + mess + Colors.ANSI_RESET);
    }

    /**
     * display yellow string
     *
     * @param mess string want to display
     */
    public static void displayYellow(String mess) {
        display(Colors.ANSI_YELLOW + mess + Colors.ANSI_RESET);
    }

    public static void showMainOptions() {
        Views.display("=======================Các dịch vụ=======================");
        Views.display("1. Quản lý tour."
                + "\n2. Quản lý khách sạn"
                + "\n3. Quản lý đặt tour"
                + "\n4. Báo cáo chung"
                + "\n5. Lưu trữ dữ liệu"
                + "\n6. Thoát\n");
    }

    public static void showSubOptions(String mess) {
        Views.display(mess
                + "\n   1. Thêm"
                + "\n   2. Cập nhật"
                + "\n   3. Tìm kiếm"
                + "\n   4. Xóa"
                + "\n   5. Hiện tất cả"
                + "\n   6. Thoát\n");
    }
    
    public static void showSearchTourOptions(){
        Views.display("1. Tìm theo điểm đến của tour"
                + "\n2. Tìm theo thời gian của tour"
                + "\n3. Tìm theo giá\n");
    }
    
    public static void showSearchHotelOptions(){
        Views.display("1. Tìm theo địa chỉ khách sạn"
                + "\n2. Tìm theo các tiện ích của khách sạn"
                + "\n3. Tìm theo số phòng còn trống của khách sạn");
    }
    
    public static void showBookingOptions(){
        Views.display("3. Quản lý đặt tour"
                + "\n   1. Đặt gói tour"
                + "\n   2. Hủy gói tour"
                + "\n   3. Xem các gói tour đang trong quá trình"
                + "\n   4. Hoàn tất gói tour"
                + "\n   5. Thoát");
    }
    
    public static void showReportOptions(){
        Views.display("4. Báo cáo chung"
                + "\n   1. Các tour hot"
                + "\n   2. Công suất của tất cả khách sạn"
                + "\n   3. Sở thích của khách hàng"
                + "\n   4. Doanh số"
                + "\n   5. Thoát");
    }
    
    
}
