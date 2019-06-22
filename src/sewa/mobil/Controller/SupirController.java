/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sewa.mobil.Controller;

import java.io.File;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import sewa.mobil.Interfaces.ControllerErrHandler;
import sewa.mobil.Model.MobilModel;
import sewa.mobil.Model.Object.Supir;
import sewa.mobil.Model.SupirModel;

/**
 *
 * @author omandotkom
 */
public class SupirController implements ControllerErrHandler {

    private Supir supir;

    public SupirController(String nik, String nama, String jk, String ktp, String sim, String hp, String alamat, String foto, int usia) {
        supir = new Supir(nik, nama, jk, ktp, sim, hp, alamat, foto, usia);
    }

    public SupirController() {
    }

    public Supir isNikExist(String nik) {
        supir = new SupirModel().isExist(nik);
        if (supir != null) {
            return supir;
        } else {
            return null;
        }
    }

    public void saveData() {
        if (this.supir != null) {
            File file = new File(supir.getFoto());
            if (file.exists()) {
                SupirModel model = new SupirModel(supir);
                if (model.save() == 1) {
                    success("berhasil menambahkan data baru");
                } else {
                    error("gagal menambah data baru");
                }
            } else {
                error("file tidak ditemukan");
            }
        } else {
            error("supir is null");
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

    public DefaultTableModel listSupir(boolean isAvailableView) {

        //final String[] tableColumnsName = {"id", "merk", "type", "nama", "silinder", "noRangka", "noMesi", "plat", "warna", "tahun", "hargaSewa"};
        final String[] tableColumnsName = {"nik", "nama", "hp", "usia"};

        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(tableColumnsName);

        ArrayList<Supir> supir = new ArrayList<Supir>();
        supir = new SupirModel().view(isAvailableView);
        for (int i = 0; i < supir.size(); i++) {
            Supir currentSupir = supir.get(i);
            Object[] mobils = {
                currentSupir.getNik(),
                currentSupir.getNama(),
                currentSupir.getHp(),
                currentSupir.getUsia(),};
            model.addRow(mobils);

        }
        return model;
    }

    public Supir getDetil(String nik) {
        supir = new SupirModel().getDetilSopir(nik);
        if (supir != null) {
            //   new DetilMobilView(supir);
            return supir;
        } else {
            System.out.println("its null");
            return null;
        }

    }

    public int delete(String nik) {
        int hasil = new SupirModel().remove(nik);
        if (hasil == 1) {
            success("berhasil menghapus data");
            return hasil;
        } else {
            error("gagal menghapus data");
            return 0;
        }
    }

    public void updateDataSupir() {
        SupirModel model = new SupirModel(supir);

        if (model.update() == 1) {
            success("berhasil mengupdate ");

        } else {
            error("gagal mengupdate data ");
        }
    }

}
