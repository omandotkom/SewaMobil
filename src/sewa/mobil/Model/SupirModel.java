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
import sewa.mobil.Model.Object.Supir;
import sewa.mobil.Interfaces.CRUD;
import sewa.mobil.View.DialogView;

/**
 *
 * @author omandotkom
 */
public class SupirModel extends BasicQuery implements CRUD {

    private Connection connection = new DBConnector().getConnection();
    private Supir supir;

    public SupirModel() {
    }

    public SupirModel(Supir supir) {
        this.supir = supir;
    }

    public Supir isExist(String nik) {
        String query = "SELECT * FROM supir where nik = '" + nik + "'";
        if (connection != null) {
            try {
                Statement statement = connection.createStatement();
                try (ResultSet rs = statement.executeQuery(query)) {
                    while (rs.next()) {
                        supir = new Supir();
                        supir.setNik(rs.getString("nik"));
                        supir.setNama(rs.getString("nama"));
                        supir.setJk(rs.getString("jeniskelamin"));
                        supir.setKtp(rs.getString("ktp"));
                        supir.setSim(rs.getString("sim"));
                        supir.setHp(rs.getString("hp"));
                        supir.setAlamat(rs.getString("alamat"));
                        supir.setUsia(Integer.valueOf(rs.getString("usia")));
                        supir.setFoto(rs.getString("foto"));
                        rs.close();
                        connection.close();
                        statement.close();
                        return supir;
                    }
                    connection.close();
                }
            } catch (SQLException sqle) {
                System.err.println(sqle.getMessage());
                return null;
            } finally {

            }
        } else {
            System.err.println("connection object is null");
        }

        return null;
    }

    @Override
    public int save() {
        if (supir != null) {
            String query = "INSERT INTO supir (nik,nama,jeniskelamin,ktp,sim,hp,alamat,usia,foto,status) "
                    + "VALUES ('" + supir.getNik() + "','" + supir.getNama()
                    + "','" + supir.getJk() + "', '" + supir.getKtp() + "','" + supir.getSim() + "','" + supir.getHp()
                    + "','" + supir.getAlamat() + "','" + supir.getUsia() + "','" + supir.getFoto() + "','" + Supir.SUPIR_AVAILABLE + "')";

            return super.runQuery(query);
        } else {//disini berarti mobil null
            System.err.println("mobilnya null");
            return -1;
        }

    }

    @Override
    public int update() {
        String query = "UPDATE supir SET nama='" + supir.getNama() + "',"
                + "jeniskelamin='" + supir.getJk() + "',"
                + "ktp='" + supir.getKtp() + "',"
                + "sim='" + supir.getSim() + "',"
                + "hp='" + supir.getHp() + "',"
                + "alamat='" + supir.getAlamat() + "',"
                + "usia=" + supir.getUsia()
                + ",foto='" + supir.getFoto() + "' WHERE supir.nik='" + supir.getNik() + "'";
        return super.runQuery(query);

    }

    @Override
    public void error(String message) {
        DialogView.showMessage(null, message + "\n" + getClass().getName() + " => " + ERRORTYPE, DialogView.ERROR_MESSAGE);

    }

    public ArrayList view(boolean isAvailableView) {
        String query;
        if (isAvailableView) {
            query = "SELECT * FROM supir WHERE status ='" + Supir.SUPIR_AVAILABLE + "' LIMIT 10";

        } else {
            query = "SELECT * FROM supir LIMIT 10";

        }
        ArrayList<Supir> listSupir = new ArrayList<Supir>();
        try {
            ResultSet rs = super.runView(query);
            while (rs.next()) {
                supir = new Supir();
                supir.setNik(rs.getString("nik"));
                supir.setNama(rs.getString("nama"));
                supir.setHp(rs.getString("hp"));
                supir.setUsia(Integer.valueOf(rs.getString("usia")));
                listSupir.add(supir);
            }
            rs.close();
            return listSupir;

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return null;

    }

    public Supir getDetilSopir(String nik) {
        String query = "SELECT * FROM supir where nik='" + nik + "'";

        ResultSet rs = super.runView(query);
        try {
            while (rs.next()) {
                return new Supir(rs.getString("nik"), rs.getString("nama"), rs.getString("jeniskelamin"),
                        rs.getString("ktp"), rs.getString("sim"), rs.getString("hp"), rs.getString("alamat"), rs.getString("foto"),
                        Integer.valueOf(rs.getString("usia")));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());

        }
        return null;
    }

    public int remove(String nik) {
        String query = "DELETE FROM supir WHERE nik='" + nik + "'";
        return super.runQuery(query);
    }

    @Override
    public ArrayList view() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int updateStatusSupir() {
        String query = "UPDATE supir set status='" + Supir.SUPIR_AVAILABLE + "' WHERE supir.nik='" + supir.getNik() + "'";
        return super.runQuery(query);
    }
}
