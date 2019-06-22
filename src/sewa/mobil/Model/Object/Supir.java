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
public class Supir extends Person{
public static final String UNAVAILABLE_TIDAKDITENTUKAN = "Tidak Ditentukan";
public static final String SUPIR_AVAILABLE = "TERSEDIA";
public static final String SUPIR_UNAVAILABLE = "TIDAK TERSEDIA";
    private int usia;
private String nik;

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

public Supir(){}
    public Supir(String nik, String nama, String jk, String ktp, String sim, String hp, String alamat, String foto, int usia) {
       this.nik = nik;
        this.nama = nama;
        this.jk = jk;
        this.ktp = ktp;
        this.sim = sim;
        this.hp = hp;
        this.alamat = alamat;
        this.foto = foto;
        this.usia = usia;
    }


    public int getUsia() {
        return usia;
    }

    public void setUsia(int usia) {
        this.usia = usia;
    }
    

}
