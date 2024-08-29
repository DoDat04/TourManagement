/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tourmanagement.interfaces;

import java.util.List;

/**
 *
 * @author admin
 */
public interface IObjectManager {
    <T> List<T> showall();
    <T> void add(String id, T object);
    void delete(String id);
    <T> void update(String id, T object);

    default <T> T get(List<T> list, int n) {
        int check = 1;
        for (T x : list) {
            if (n == check) {
                return x;
            }
            check++;
        }
        return null;
    }
}
