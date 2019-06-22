/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sewa.mobil.View;

import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author omandotkom
 */
public class DialogView extends JOptionPane{
    public static final String SUCCESS_MESSAGE = "SUCCESS";
    public static final String ERROR_MESSAGE = "ERROR";
    
    public static void showMessage(Component component,String message, String MessageType){
        if (MessageType.equals(SUCCESS_MESSAGE)){
        showMessageDialog(component,message, SUCCESS_MESSAGE,JOptionPane.INFORMATION_MESSAGE);
        }else{
        showMessageDialog(component,message, ERROR_MESSAGE,JOptionPane.ERROR_MESSAGE);
        
        }
    }
}
