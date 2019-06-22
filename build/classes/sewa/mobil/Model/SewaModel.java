/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sewa.mobil.Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import sewa.mobil.Interfaces.CRUD;
import sewa.mobil.Model.Object.Sewa;
import sewa.mobil.Model.Object.Supir;

/**
 *
 * @author omandotkom
 */
public class SewaModel extends BasicQuery implements CRUD {

    private Sewa sewa;

    public SewaModel(Sewa sewa) {
        this.sewa = sewa;
    }

    public SewaModel() {
    }

    @Override
    public int save() {
        if (sewa != null) {
            String nik;
            if (sewa.getSupir().getNik().equals(Supir.UNAVAILABLE_TIDAKDITENTUKAN)) {
                nik = "0";
            } else {
                nik = sewa.getSupir().getNik();
            }
            String query = "INSERT INTO penyewaan(id_pelanggan,id_mobil,nik,sewa,kembali,harga,status) "
                    + "values(" + sewa.getPelanggan().getId() + "," + sewa.getMobil().getId() + ",'" + nik + "',"
                    + "'" + sewa.getTglSewa() + "','" + sewa.getTglKembali() + "'," + sewa.getTotalBiaya() + ",'" + Sewa.DISEWA + "')";

            return super.runQuery(query);
        } else {//disini berarti mobil null
            System.err.println("sewa null");
            return -1;
        }

    }

    public int updateStatus() {
        int res = 0;
        String query = "UPDATE mobil SET status='tidak tersedia' WHERE mobil.id=" + sewa.getMobil().getId();
        res = super.runQuery(query);
        if (!sewa.getSupir().getNik().equals(Supir.UNAVAILABLE_TIDAKDITENTUKAN)) {
            //berarti pakai supir
            query = "UPDATE supir SET status='TIDAK TERSEDIA' WHERE supir.nik='" + sewa.getSupir().getNik() + "'";
            res = res + super.runQuery(query);
        }
        System.out.println("ANGKA RES" + res);
        return res;
    }

    @Override
    public int update() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void error(String message) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList view() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Sewa getLastRecord() {
        sewa = new Sewa();
        String query = "SELECT penyewaan.id, pelanggan.nama, mobil.merk, mobil.nama as namamobil, "
                + "penyewaan.sewa, penyewaan.kembali, datediff(penyewaan.kembali, penyewaan.sewa) as hari, "
                + "supir.nama as supir, harga FROM penyewaan INNER JOIN pelanggan ON pelanggan.id = penyewaan.id_pelanggan "
                + "INNER JOIN mobil ON mobil.id = penyewaan.id_mobil left JOIN supir on supir.nik = penyewaan.nik"
                + " ORDER BY penyewaan.id DESC LIMIT 1";
        System.out.println(query);
        try {
            try (ResultSet rs = super.runView(query)) {
                while (rs.next()) {
                    sewa.setId(rs.getInt("id"));
                    sewa.getPelanggan().setNama(rs.getString("nama"));
                    sewa.getMobil().setMerkMobil(rs.getString("merk"));
                    sewa.getMobil().setNamaMobil(rs.getString("namamobil"));
                    sewa.setSewaString(rs.getString("sewa"));
                    sewa.setKembaliString(rs.getString("kembali"));
                    sewa.setHari(Integer.valueOf(rs.getString("hari")));
                    if (rs.getString("supir") != "0") {
                        sewa.getSupir().setNama(rs.getString("supir"));
                    } else {
                        sewa.getSupir().setNama("Tidak ditentukan");

                    }
                    sewa.setTotalBiaya(Double.valueOf(rs.getString("harga")));
                }
            }
            return sewa;

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return null;

    }

    public Sewa dataSewa() {
        String query = "SELECT penyewaan.id, penyewaan.id_mobil, pelanggan.nama, mobil.merk, mobil.nama as namamobil, "
                + "penyewaan.sewa, penyewaan.nik, penyewaan.kembali, datediff(penyewaan.kembali, penyewaan.sewa) as hari, "
                + "supir.nama as supir, harga FROM penyewaan INNER JOIN pelanggan ON pelanggan.id = penyewaan.id_pelanggan "
                + "INNER JOIN mobil ON mobil.id = penyewaan.id_mobil left JOIN supir on supir.nik = penyewaan.nik"
                + " WHERE penyewaan.id=" + sewa.getId();
        try {
            try (ResultSet rs = super.runView(query)) {
                while (rs.next()) {
                    sewa.setId(rs.getInt("id"));
                    sewa.getMobil().setId(rs.getInt("id_mobil"));
                    sewa.getSupir().setNik(rs.getString("nik"));
                    sewa.getPelanggan().setNama(rs.getString("nama"));
                    sewa.getMobil().setMerkMobil(rs.getString("merk"));
                    sewa.getMobil().setNamaMobil(rs.getString("namamobil"));
                    sewa.setSewaString(rs.getString("sewa"));
                    sewa.setKembaliString(rs.getString("kembali"));
                    sewa.setHari(Integer.valueOf(rs.getString("hari")));
                    if (rs.getString("supir") != "0") {
                        sewa.getSupir().setNama(rs.getString("nik"));
                    } else {
                        sewa.getSupir().setNama("Tidak ditentukan");

                    }
                    sewa.setTotalBiaya(Double.valueOf(rs.getString("harga")));
                }
            }
            return sewa;

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return null;

    }

    public int ubahStatusSewa() {
        String query = "UPDATE penyewaan SET penyewaan.status='" + Sewa.DIKEMBALIKAN + "' WHERE penyewaan.id=" + sewa.getId();
        return super.runQuery(query);
    }

    public int addDenda() {
        String query = "INSERT INTO denda (id_sewa,totalhari,biayadenda) values(" + sewa.getId() + "," + sewa.getHari() + ","
                + sewa.getDenda() + ")";

        return super.runQuery(query);
    }

    public ArrayList<Sewa> dataReport() {
        ArrayList<Sewa>Sewas = new ArrayList<Sewa>();
       
        String query = " SELECT pelanggan.nama, mobil.nama as namamobil, penyewaan.nik, sewa, kembali, harga, "
                + "COALESCE(denda.biayadenda,0) as  denda "
                + "FROM penyewaan LEFT JOIN pelanggan ON pelanggan.id = penyewaan.id_pelanggan "
                + "LEFT JOIN mobil ON mobil.id= penyewaan.id_mobil LEFT JOIN supir "
                + "ON supir.nik = penyewaan.nik LEFT JOIN denda ON denda.id_sewa = penyewaan.id "
                + "WHERE penyewaan.status='DIKEMBALIKAN'";
        try {
            try (ResultSet rs = super.runView(query)) {
                while (rs.next()) {
                     sewa = new Sewa();
                    sewa.getPelanggan().setNama(rs.getString("nama"));
                    sewa.getMobil().setNamaMobil(rs.getString("namamobil"));
                    sewa.getSupir().setNik(rs.getString("nik"));
                    sewa.setSewaString(rs.getString("sewa"));
                    sewa.setKembaliString(rs.getString("kembali"));
                    sewa.setTotalBiaya(Double.valueOf(rs.getString("harga")));
                    sewa.setDenda(Double.valueOf(rs.getString("denda")));
                   Sewas.add(sewa);
                     }
            }
            return Sewas;

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return null;

    }
}
