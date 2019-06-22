/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sewa.mobil.Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import sewa.mobil.Model.Object.Mobil;

/**
 *
 * @author omandotkom
 */
public class MobilModel extends BasicQuery{

    private Mobil mobil;

    public MobilModel(Mobil mobil) {
        this.mobil = mobil;
    }

    public MobilModel() {
    }

    public int saveMobil() {
      //  Connection connection = new DBConnector().getConnection();
        if (mobil != null) {
            String query = "INSERT INTO mobil(merk,type,nama,silinder,noRangka,noMesin,plat,warna,tahun,hargaSewa,status) VALUES('" + mobil.getMerkMobil() + "','" + mobil.getTypeMobil() + "','"
                    + mobil.getNamaMobil() + "','" + mobil.getIsiSilinderMobil() + "','" + mobil.getNoRangkaMobil() + "','"
                    + mobil.getNoMesinMobil() + "','" + mobil.getPlatMobil() + "','" + mobil.getWarnaMobil() + "',"
                    + mobil.getTahunPembuatan() + "," + mobil.getHargaSewa() + ",'tersedia')";
        /*    try {
                Statement statement = connection.createStatement();
                int result = statement.executeUpdate(query);
                System.out.println(result);
                connection.close();
                statement.close();
                return result;
            } catch (SQLException sqle) {
                System.err.println(sqle.getMessage());
                return -1;
            }
*/
      return super.runQuery(query);
        } else {//disini berarti mobil null
            System.err.println("mobilnya null");
            return -1;
        }
    }

    public ArrayList<Mobil> getListAvailableMobil() {
        Connection connection = new DBConnector().getConnection();
        ArrayList<Mobil> listMobil = new ArrayList<Mobil>();
        String query = "SELECT * FROM mobil WHERE status='tersedia' LIMIT 10 ";
        try {
            Statement statement = connection.createStatement();
            try (ResultSet rs = statement.executeQuery(query)) {
                Mobil newMobil;
                while (rs.next()) {
                    newMobil = new Mobil();
                    newMobil.setId(rs.getInt("id"));
                    newMobil.setMerkMobil(rs.getString("merk"));
                    // newMobil.setTypeMobil(rs.getString("type"));
                    newMobil.setNamaMobil(rs.getString("nama"));
                    //newMobil.setIsiSilinderMobil(rs.getString("silinder"));
                    //newMobil.setNoRangkaMobil(rs.getString("noRangka"));
                    // newMobil.setNoMesinMobil(rs.getString("noMesin"));
                    //newMobil.setPlatMobil(rs.getString("plat"));
                    newMobil.setWarnaMobil(rs.getString("warna"));
                    //newMobil.setTahunPembuatan(Integer.valueOf(rs.getString("tahun")));
                    newMobil.setHargaSewa(Double.valueOf(rs.getString("hargaSewa")));
                    // newMobil.setHargaSewa(rs.getDouble("harga"));
                    listMobil.add(newMobil);
                    /* rs.close();
                        connection.close();
                        statement.close();
                     */

                }

                statement.close();
                rs.close();
                connection.close();
                return listMobil;

            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }
    
    
    
    
   
    public ArrayList<Mobil> getListMobil(boolean isAvailableView) {
        String query;
        if (!isAvailableView){
        query = "SELECT * FROM mobil LIMIT 10";
        }else{
        query = "SELECT * FROM mobil WHERE status='" + Mobil.AVAILABLE + "' LIMIT 10";
        
        }
        Connection connection = new DBConnector().getConnection();
        ArrayList<Mobil> listMobil = new ArrayList<Mobil>();
        
        try {
            Statement statement = connection.createStatement();
            try (ResultSet rs = statement.executeQuery(query)) {
                Mobil newMobil;
                while (rs.next()) {
                    newMobil = new Mobil();
                    newMobil.setId(rs.getInt("id"));
                    newMobil.setMerkMobil(rs.getString("merk"));
                    // newMobil.setTypeMobil(rs.getString("type"));
                    newMobil.setNamaMobil(rs.getString("nama"));
                    //newMobil.setIsiSilinderMobil(rs.getString("silinder"));
                    //newMobil.setNoRangkaMobil(rs.getString("noRangka"));
                    // newMobil.setNoMesinMobil(rs.getString("noMesin"));
                    //newMobil.setPlatMobil(rs.getString("plat"));
                    newMobil.setWarnaMobil(rs.getString("warna"));
                    //newMobil.setTahunPembuatan(Integer.valueOf(rs.getString("tahun")));
                    newMobil.setHargaSewa(Double.valueOf(rs.getString("hargaSewa")));
                    
                    // newMobil.setHargaSewa(rs.getDouble("harga"));
                    listMobil.add(newMobil);
                    /* rs.close();
                        connection.close();
                        statement.close();
                     */

                }

                statement.close();
                rs.close();
                connection.close();
                return listMobil;

            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }
   
     public ArrayList<Mobil> getListMobilDisewa() {
        String query;
       
        query = "SELECT * FROM mobil  WHERE mobil.status='" + Mobil.UNAVAILABLE + "' LIMIT 10";
       
        Connection connection = new DBConnector().getConnection();
        ArrayList<Mobil> listMobil = new ArrayList<Mobil>();
        
        try {
            Statement statement = connection.createStatement();
            try (ResultSet rs = statement.executeQuery(query)) {
                Mobil newMobil;
                while (rs.next()) {
                    newMobil = new Mobil();
                    newMobil.setId(rs.getInt("id"));
                    newMobil.setMerkMobil(rs.getString("merk"));
                    // newMobil.setTypeMobil(rs.getString("type"));
                    newMobil.setNamaMobil(rs.getString("nama"));
                    //newMobil.setIsiSilinderMobil(rs.getString("silinder"));
                    //newMobil.setNoRangkaMobil(rs.getString("noRangka"));
                    // newMobil.setNoMesinMobil(rs.getString("noMesin"));
                    //newMobil.setPlatMobil(rs.getString("plat"));
                    newMobil.setWarnaMobil(rs.getString("warna"));
                    //newMobil.setTahunPembuatan(Integer.valueOf(rs.getString("tahun")));
                    newMobil.setHargaSewa(Double.valueOf(rs.getString("hargaSewa")));
                    
                    // newMobil.setHargaSewa(rs.getDouble("harga"));
                    listMobil.add(newMobil);
                    /* rs.close();
                        connection.close();
                        statement.close();
                     */

                }

                statement.close();
                rs.close();
                connection.close();
                return listMobil;

            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }
   
      public ArrayList<Mobil> getListMobilTerlaris() {
        String query;
       
        query = "SELECT COUNT(id_mobil) as count , mobil.nama, mobil.merk FROM penyewaan INNER JOIN mobil on mobil.id = penyewaan.id_mobil group by (id_mobil) ORDER BY COUNT(id_mobil) DESC";
        Connection connection = new DBConnector().getConnection();
        ArrayList<Mobil> listMobil = new ArrayList<Mobil>();
        
        try {
            Statement statement = connection.createStatement();
            try (ResultSet rs = statement.executeQuery(query)) {
                Mobil newMobil;
                while (rs.next()) {
                    newMobil = new Mobil();
                    newMobil.setJumlah(rs.getInt("count"));
                    newMobil.setMerkMobil(rs.getString("merk"));
                     newMobil.setNamaMobil(rs.getString("nama"));
                    
                    listMobil.add(newMobil);
                    /* rs.close();
                        connection.close();
                        statement.close();
                     */

                }

                statement.close();
                rs.close();
                connection.close();
                return listMobil;

            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }
   
    
    public Mobil showDetilMobil(int id) {
        try {
            String query = "SELECT * FROM mobil where mobil.id=" + id;
            Connection connection = new DBConnector().getConnection();
            Statement statement = connection.createStatement();
            try (ResultSet rs = statement.executeQuery(query)) {
                Mobil newMobil;
                while (rs.next()) {
                    newMobil = new Mobil();
                    newMobil.setId(rs.getInt("id"));
                    newMobil.setMerkMobil(rs.getString("merk"));
                    newMobil.setTypeMobil(rs.getString("type"));
                    newMobil.setNamaMobil(rs.getString("nama"));
                    newMobil.setIsiSilinderMobil(rs.getString("silinder"));
                    newMobil.setNoRangkaMobil(rs.getString("noRangka"));
                    newMobil.setNoMesinMobil(rs.getString("noMesin"));
                    newMobil.setPlatMobil(rs.getString("plat"));
                    newMobil.setWarnaMobil(rs.getString("warna"));
                    newMobil.setTahunPembuatan(Integer.valueOf(rs.getString("tahun")));
                    newMobil.setHargaSewa(Double.valueOf(rs.getString("hargaSewa")));

                    //TODO : BELUM LENGKAP
                    /* rs.close();
                        connection.close();
                        statement.close();
                     */
                    return newMobil;

                }
                statement.close();
                rs.close();
                connection.close();
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }
public int updateStatusMobil(){
String query = "UPDATE mobil SET status='" + Mobil.AVAILABLE + "' WHERE mobil.id="+ mobil.getId();
   return super.runQuery(query);
}


   
}
