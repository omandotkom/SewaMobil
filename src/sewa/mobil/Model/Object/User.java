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
public class User {

    private int id;
    private String nik, password, nama;

    public User(String nik, String password) {
        this.nik = nik;
        this.password = password;
    }

    public User() {
    }

    ;
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public int getId() {
        return id;
    }

    public String getNik() {
        return nik;
    }

    public String getPassword() {
        return password;
    }

}
