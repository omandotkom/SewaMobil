/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sewa.mobil;

import javax.swing.JDialog;
import sewa.mobil.Model.DBConnector;
import sewa.mobil.View.Pelanggan.PelangganView;

/**
 *
 * @author omandotkom
 */
public class SewaMobil extends DBConnector {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //MUNCULIN FORM LOGIN
    /*    PelangganView aWindow = new PelangganView();
        Point center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
        aWindow.setBounds(center.x - aWindow.getWidth() / 2, center.y - aWindow.getHeight() / 2, aWindow.getWidth(),
                aWindow.getHeight());
        aWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  aWindow.toFront();
 aWindow.setState(aWindow.NORMAL); 
 aWindow.setVisible(true);
 System.out.println("ini dijalankan");*/
        //CEK INSERT DATA MOBIL
       /* Mobil mobil = new Mobil("TOYOTA",Mobil.TYPE.SEDAN,"AVANZA","1200cc", "1234","988912","08129831","PUTIH","null",2007,1200000);
        new MobilModel(mobil).addMobil();*/
       
       
       //getListMobil;
      // System.out.println(new MobilModel().getListMobil().get(0).getMerkMobil());
   
    }

}
