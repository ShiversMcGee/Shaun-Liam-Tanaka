/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

/**
 *
 * @author smhowells
 */
public class AnObserver implements IObserver{

    @Override
    public void update() {
        System.out.println("State Change was detected!!!");
    }
    
}
