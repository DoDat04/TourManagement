/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tourmanagement.commander;

import tourmanagement.interfaces.ICommand;
import tourmanagement.view.Views;

/**
 *
 * @author admin
 */
public class ExitToMainMenu implements ICommand{

    @Override
    public void excute() {
        Views.display("\nThoát ra menu chính.........\n");
    }
    
}
