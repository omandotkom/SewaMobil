/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sewa.mobil.Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import sewa.mobil.Interfaces.CRUD;
import sewa.mobil.Model.Object.Pelanggan;


/**
 *
 * @author omandotkom
 */
public class PelangganModel extends BasicQuery implements CRUD {

    private Pelanggan pelanggan;

    public PelangganModel(Pelanggan pelanggan) {
        this.pelanggan = pelanggan;
    }

    @Override
    public int save() {
        if (pelanggan != null) {
            String query = "INSERT INTO pelanggan (nama,jeniskelamin,ktp,sim,hp,alamat,foto) "
                    + "VALUES ('" + pelanggan.getNama()
                    + "','" + pelanggan.getJk() + "', '" + pelanggan.getKtp() + "','" + pelanggan.getSim() + "','" + pelanggan.getHp()
                    + "','" + pelanggan.getAlamat() + "','" + pelanggan.getFoto() + "')";
            return super.runQuery(query);
        } else {//disini berarti mobil null
            System.err.println("pelangganya null");
            return -1;
        }

    }

    @Override
    public int update() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void error(String message) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public PelangganModel(){}
    @Override
    public ArrayList view() {
           ArrayList<Pelanggan> listPelanggan = new ArrayList<Pelanggan>();
        String query = "SELECT * FROM pelanggan LIMIT 10";
        try {
            ResultSet rs = super.runView(query);
            while (rs.next()) {
                pelanggan = new Pelanggan();
                pelanggan.setId(Integer.valueOf(rs.getString("id")));
                pelanggan.setNama(rs.getString("nama"));
                pelanggan.setJk(rs.getString("jeniskelamin"));
                pelanggan.setKtp(rs.getString("ktp"));
                listPelanggan.add(pelanggan);
            }
            rs.close();
            return listPelanggan;

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return null;

    }
    
    public Pelanggan getDetil(int id){
    String query = "SELECT * FROM pelanggan where id=" + id;
    pelanggan = new Pelanggan();
        try {
            ResultSet rs = super.runView(query);
            while (rs.next()) {
           /*     pelanggan = new Pelanggan();
                pelanggan.setId(Integer.valueOf(rs.getString("id")));
                pelanggan.setNama(rs.getString("nama"));
                pelanggan.setJk(rs.getString("jeniskelamin"));
                pelanggan.setKtp(rs.getString("ktp"));
            */
             return new Pelanggan(Integer.valueOf(rs.getString("id")), rs.getString("nama"),
                     rs.getString("jeniskelamin"), rs.getString("ktp"), rs.getString("sim"), rs.getString("hp"),
                     rs.getString("alamat"), rs.getString("foto")
                    );
              }
            rs.close();
            return pelanggan;

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

}
