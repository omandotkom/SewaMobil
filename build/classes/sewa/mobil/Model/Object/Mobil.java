/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sewa.mobil.Model.Object;

/**
 *
 * @author omandotkom
 */
public class Mobil {
 
public static final String AVAILABLE = "tersedia";
public static final String UNAVAILABLE = "tidak tersedia";
int jumlah;

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

  private String merkMobil, typeMobil, namaMobil, isiSilinderMobil, noRangkaMobil, noMesinMobil, platMobil, warnaMobil, gambarMobil;
  private int tahunPembuatan,id;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
  double hargaSewa;
  public Mobil(){};
    public Mobil(String merkMobil, String typeMobil, String namaMobil, String isiSilinderMobil, String noRangkaMobil, String noMesinMobil, String platMobil, String warnaMobil, int tahunPembuatan, double hargaSewa) {
        this.merkMobil = merkMobil;
        this.typeMobil = typeMobil;
        this.namaMobil = namaMobil;
        this.isiSilinderMobil = isiSilinderMobil;
        this.noRangkaMobil = noRangkaMobil;
        this.noMesinMobil = noMesinMobil;
        this.platMobil = platMobil;
        this.warnaMobil = warnaMobil;
          this.tahunPembuatan = tahunPembuatan;
        this.hargaSewa = hargaSewa;
    }

    public String getMerkMobil() {
        return merkMobil;
    }

    public void setMerkMobil(String merkMobil) {
        this.merkMobil = merkMobil;
    }

    public String getTypeMobil() {
        return typeMobil;
    }

    public void setTypeMobil(String typeMobil) {
        this.typeMobil = typeMobil;
    }

    public String getNamaMobil() {
        return namaMobil;
    }

    public void setNamaMobil(String namaMobil) {
        this.namaMobil = namaMobil;
    }

    public String getIsiSilinderMobil() {
        return isiSilinderMobil;
    }

    public void setIsiSilinderMobil(String isiSilinderMobil) {
        this.isiSilinderMobil = isiSilinderMobil;
    }

    public String getNoRangkaMobil() {
        return noRangkaMobil;
    }

    public void setNoRangkaMobil(String noRangkaMobil) {
        this.noRangkaMobil = noRangkaMobil;
    }

    public String getNoMesinMobil() {
        return noMesinMobil;
    }

    public void setNoMesinMobil(String noMesinMobil) {
        this.noMesinMobil = noMesinMobil;
    }

    public String getPlatMobil() {
        return platMobil;
    }

    public void setPlatMobil(String platMobil) {
        this.platMobil = platMobil;
    }

    public String getWarnaMobil() {
        return warnaMobil;
    }

    public void setWarnaMobil(String warnaMobil) {
        this.warnaMobil = warnaMobil;
    }

    public String getGambarMobil() {
        return gambarMobil;
    }

    public void setGambarMobil(String gambarMobil) {
        this.gambarMobil = gambarMobil;
    }

    public int getTahunPembuatan() {
        return tahunPembuatan;
    }

    public void setTahunPembuatan(int tahunPembuatan) {
        this.tahunPembuatan = tahunPembuatan;
    }

    public double getHargaSewa() {
        return hargaSewa;
    }

    public void setHargaSewa(double hargaSewa) {
        this.hargaSewa = hargaSewa;
    }
  
}
