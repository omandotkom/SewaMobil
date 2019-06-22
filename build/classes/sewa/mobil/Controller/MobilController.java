/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sewa.mobil.Controller;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

import sewa.mobil.Model.MobilModel;
import sewa.mobil.Model.Object.Mobil;
import sewa.mobil.View.DialogView;

/**
 *
 * @author omandotkom
 */
public class MobilController {

    public MobilController() {
    }
    private Mobil mobil;

    public MobilController(String merk, String type, String nama, String silinder, String noRangka, String noMesi, String plat, String warna, int tahun, double hargaSewa) {
        mobil = new Mobil(merk, type, nama, silinder, noRangka, noMesi, plat, warna, tahun, hargaSewa);
    }

    public int saveMobil() {
        MobilModel model = new MobilModel(mobil);
        int returnValue = model.saveMobil();
        if (returnValue == 1) {

            DialogView.showMessage(null, "Berhasil menambahkan data baru.", DialogView.SUCCESS_MESSAGE);
        } else {
            DialogView.showMessage(null, "Gagal menambahkan data baru.", DialogView.ERROR_MESSAGE);
        }
        return returnValue;
    }
//public DefaultTableModel viewAvailableMobil() {
        //final String[] tableColumnsName = {"id", "merk", "type", "nama", "silinder", "noRangka", "noMesi", "plat", "warna", "tahun", "hargaSewa"};
    /*    final String[] tableColumnsName = {"id", "merk", "nama", "warna", "hargaSewa"};

        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(tableColumnsName);

        ArrayList<Mobil> mobil = new ArrayList<Mobil>();
        mobil = new MobilModel().getListAvailableMobil();
        for (int i = 0; i < mobil.size(); i++) {
            Mobil currentMobil = mobil.get(i);
            System.out.println(currentMobil.getPlatMobil());
            Object[] mobils = {
                currentMobil.getId(),
                currentMobil.getMerkMobil(),
                //currentMobil.getTypeMobil(), 
                currentMobil.getNamaMobil(),
                //currentMobil.getIsiSilinderMobil(),
                //currentMobil.getNoRangkaMobil(),
                //currentMobil.getNoMesinMobil(),
                //currentMobil.getPlatMobil(),
                currentMobil.getWarnaMobil(),
                //currentMobil.getTahunPembuatan(),
                currentMobil.getHargaSewa()};
            model.addRow(mobils);

        }
        return model;
*/    
//}
    
    public DefaultTableModel viewMobil(boolean isAvailable) {
        //final String[] tableColumnsName = {"id", "merk", "type", "nama", "silinder", "noRangka", "noMesi", "plat", "warna", "tahun", "hargaSewa"};
        final String[] tableColumnsName = {"id", "merk", "nama", "warna", "hargaSewa"};

        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(tableColumnsName);

        ArrayList<Mobil> mobil = new ArrayList<Mobil>();
        mobil = new MobilModel().getListMobil(isAvailable);
        for (int i = 0; i < mobil.size(); i++) {
            Mobil currentMobil = mobil.get(i);
            System.out.println(currentMobil.getPlatMobil());
            Object[] mobils = {
                currentMobil.getId(),
                currentMobil.getMerkMobil(),
                //currentMobil.getTypeMobil(), 
                currentMobil.getNamaMobil(),
                //currentMobil.getIsiSilinderMobil(),
                //currentMobil.getNoRangkaMobil(),
                //currentMobil.getNoMesinMobil(),
                //currentMobil.getPlatMobil(),
                currentMobil.getWarnaMobil(),
                //currentMobil.getTahunPembuatan(),
                currentMobil.getHargaSewa()};
            model.addRow(mobils);

        }
        return model;
    }

    public Mobil getDetil(int id) {
        Mobil mobil = new MobilModel().showDetilMobil(id);
        if (mobil != null) {
           //   new DetilMobilView(mobil);
           return mobil;
           } else {
            System.out.println("its null");
       return null;
        }
       
    }
    
     
    public DefaultTableModel viewMobilDisewa() {
        //final String[] tableColumnsName = {"id", "merk", "type", "nama", "silinder", "noRangka", "noMesi", "plat", "warna", "tahun", "hargaSewa"};
        final String[] tableColumnsName = {"id", "merk", "nama", "warna", "hargaSewa"};

        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(tableColumnsName);

        ArrayList<Mobil> mobil = new ArrayList<Mobil>();
        
        mobil = new MobilModel().getListMobilDisewa();
        for (int i = 0; i < mobil.size(); i++) {
            Mobil currentMobil = mobil.get(i);
            Object[] mobils = {
                currentMobil.getId(),
                currentMobil.getMerkMobil(),
                //currentMobil.getTypeMobil(), 
                currentMobil.getNamaMobil(),
                //currentMobil.getIsiSilinderMobil(),
                //currentMobil.getNoRangkaMobil(),
                //currentMobil.getNoMesinMobil(),
                //currentMobil.getPlatMobil(),
                currentMobil.getWarnaMobil(),
                //currentMobil.getTahunPembuatan(),
                currentMobil.getHargaSewa()};
        
            model.addRow(mobils);

        }
        return model;
    }
    
    
    public DefaultTableModel viewMobilTerlaris() {
        //final String[] tableColumnsName = {"id", "merk", "type", "nama", "silinder", "noRangka", "noMesi", "plat", "warna", "tahun", "hargaSewa"};
        final String[] tableColumnsName = {"Jumlah", "Merk", "Nama"};

        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(tableColumnsName);

        ArrayList<Mobil> mobil = new ArrayList<Mobil>();
        
        mobil = new MobilModel().getListMobilTerlaris();
        for (int i = 0; i < mobil.size(); i++) {
            Mobil currentMobil = mobil.get(i);
            Object[] mobils = {
                currentMobil.getJumlah(),
                currentMobil.getMerkMobil(),
                //currentMobil.getTypeMobil(), 
                currentMobil.getNamaMobil()};
        
            model.addRow(mobils);

        }
        return model;
    }
}
