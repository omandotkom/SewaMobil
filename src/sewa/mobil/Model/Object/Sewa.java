/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sewa.mobil.Model.Object;


import java.util.Date;

/**
 *
 * @author omandotkom
 */
public class Sewa {
    private Mobil mobil = new Mobil();
    private Pelanggan pelanggan = new Pelanggan();
    private Supir supir = new Supir();
    private double denda;
    public static final String DISEWA = "DISEWA";
    public static final String DIKEMBALIKAN = "DIKEMBALIKAN";
    public Mobil getMobil() {
        return mobil;
    }

    public void setMobil(Mobil mobil) {
        this.mobil = mobil;
    }

    public Pelanggan getPelanggan() {
        return pelanggan;
    }

    public void setPelanggan(Pelanggan pelanggan) {
        this.pelanggan = pelanggan;
    }

    public Supir getSupir() {
        return supir;
    }

    public void setSupir(Supir supir) {
        this.supir = supir;
    }
    
    public Sewa(){}
   /* 
    public Sewa(int id, int id_pelanggan, int id_mobil, String nik, Date tglSewa, Date tglKembali, double hargaMobil, String status) {
        this.id = id;
        this.pelanggan.setId(id_pelanggan);
        this.mobil.setId(id_mobil); 
        this.supir.setNik(nik);
        this.tglSewa = tglSewa;
        this.tglKembali = tglKembali;
        this.mobil.setHa = hargaMobil;
        this.status = status;
    }
    
      public Sewa(int id, int id_pelanggan, int id_mobil, Date tglSewa, Date tglKembali, double hargaMobil, String status) {
        this.id = id;
        this.pelanggan.setId(id_pelanggan);
        this.id_mobil = id_mobil;
        this.tglSewa = tglSewa;
        this.tglKembali = tglKembali;
        this.hargaMobil = hargaMobil;
        this.status = status;
    }*/
   private int id;
  
   private String tglSewa, tglKembali;
   
   private String status;
   private int hari;
private  double totalBiaya;

    public double getTotalBiaya() {
        return totalBiaya;
    }

    public void setTotalBiaya(double totalBiaya) {
        this.totalBiaya = totalBiaya;
    }

    public int getHari() {
        return hari;
    }

    public void setHari(int hari) {
        this.hari = hari;
    }
   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_pelanggan() {
        return this.pelanggan.getId();
    }

    public void setId_pelanggan(int id_pelanggan) {
        this.pelanggan.setId(id_pelanggan);
        
    }

   
    public String getTglSewa() {
        return tglSewa;
    }

    public void setTglSewa(String tglSewa) {
        this.tglSewa = tglSewa;
    }

    public String getTglKembali() {
        return tglKembali;
    }

    public void setTglKembali(String tglKembali) {
        this.tglKembali = tglKembali;
    }

 

    public String getStatus() {
        return status;
    }
    public String sewaString, kembaliString;

    public String getSewaString() {
        return sewaString;
    }

    public void setSewaString(String sewaString) {
        this.sewaString = sewaString;
    }

    public String getKembaliString() {
        return kembaliString;
    }

    public void setKembaliString(String kembaliString) {
        this.kembaliString = kembaliString;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }

    public double getDenda() {
      return denda;
    }

    public void setDenda(double denda) {
        this.denda = denda;
    }
    

}
