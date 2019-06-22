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
public class Pelanggan extends Person{
private int id;
public Pelanggan(){}
 public Pelanggan(int id, String nama, String jk, String ktp, String sim, String hp, String alamat, String foto) {
       this.id = id;
        this.nama = nama;
        this.jk = jk;
        this.ktp = ktp;
        this.sim = sim;
        this.hp = hp;
        this.alamat = alamat;
        this.foto = foto;
        
    }
 public Pelanggan(String nama, String jk, String ktp, String sim, String hp, String alamat, String foto) {
      
        this.nama = nama;
        this.jk = jk;
        this.ktp = ktp;
        this.sim = sim;
        this.hp = hp;
        this.alamat = alamat;
        this.foto = foto;
        
    }
 
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
