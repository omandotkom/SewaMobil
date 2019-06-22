/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sewa.mobil.Controller;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import sewa.mobil.Interfaces.ControllerErrHandler;
import sewa.mobil.Model.Object.Pelanggan;
import sewa.mobil.Model.PelangganModel;

/**
 *
 * @author omandotkom
 */
public class PelangganController implements ControllerErrHandler {

    private Pelanggan pelanggan;

    public PelangganController(int id, String nama, String jk, String ktp, String sim, String hp, String alamat, String foto) {
        pelanggan = new Pelanggan(id, nama, jk, ktp, sim, hp, alamat, foto);
    }

    public PelangganController(String nama, String jk, String ktp, String sim, String hp, String alamat, String foto) {
        pelanggan = new Pelanggan(nama, jk, ktp, sim, hp, alamat, foto);
    }

    public PelangganController() {
    }

    public void saveData() {
        if (this.pelanggan != null) {
            PelangganModel model = new PelangganModel(pelanggan);
            if (model.save() == 1) {
                success("berhasil menambahkan data baru");
            } else {
                error("gagal menambah data baru");
            }
        } else {
            error("supir is null");
        }

    }

    public Pelanggan getDetil(int id) {
    pelanggan = new PelangganModel().getDetil(id);
        if (pelanggan != null) {
            //   new DetilMobilView(supir);
            return pelanggan;
        } else {
            System.out.println("its null");
            return null;
        }
      }

    @Override
    public void error(String message) {
        System.err.println(message + " => " + getClass());
    }

    @Override
    public void success(String message) {
        System.out.println(message + " => " + getClass().getName());
    }

    public DefaultTableModel listPelanggan() {
        final String[] tableColumnsName = {"id", "nama", "jeniskelamin", "ktp"};

        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(tableColumnsName);

        ArrayList<Pelanggan> pelanggan = new ArrayList<Pelanggan>();
        pelanggan = new PelangganModel().view();
        for (int i = 0; i < pelanggan.size(); i++) {
            Pelanggan currentPelanggan = pelanggan.get(i);
            Object[] pelanggans = {
                currentPelanggan.getId(),
                currentPelanggan.getNama(),
                currentPelanggan.getJk(),
                currentPelanggan.getKtp(),};
            model.addRow(pelanggans);

        }
        return model;
    }
}
