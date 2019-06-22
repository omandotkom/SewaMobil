/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sewa.mobil.Controller;

import static sewa.mobil.Interfaces.CRUD.ERRORTYPE;
import sewa.mobil.Interfaces.ControllerErrHandler;
import sewa.mobil.Model.MobilModel;
import sewa.mobil.Model.Object.Mobil;
import sewa.mobil.Model.Object.Sewa;
import sewa.mobil.Model.Object.Supir;
import sewa.mobil.Model.SewaModel;
import sewa.mobil.Model.SupirModel;
import sewa.mobil.View.DialogView;
import sewa.mobil.View.Report.ReportView;

/**
 *
 * @author omandotkom
 */
public class SewaController implements ControllerErrHandler {

    private Sewa sewa;

    public SewaController(int id, int id_pelanggan, int id_mobil, String nik, String tglSewa, String tglKembali, double harga, String status, int hari, double total) {
        sewa = new Sewa();
        sewa.getPelanggan().setId(id_pelanggan);
        sewa.getMobil().setId(id_mobil);
        sewa.getMobil().setHargaSewa(harga);
        sewa.getSupir().setNik(nik);
        sewa.setTglSewa(tglSewa);
        sewa.setTglKembali(tglKembali);
        sewa.setTotalBiaya(total);
        sewa.setStatus(status);
        sewa.setHari(hari);

    }

    public SewaController(int id, int id_pelanggan, int id_mobil, String nik, String tglSewa, String tglKembali, double harga, String status, int hari) {
        sewa = new Sewa();
        sewa.getPelanggan().setId(id_pelanggan);
        sewa.getMobil().setId(id_mobil);
        sewa.getMobil().setHargaSewa(harga);
        sewa.getSupir().setNik(nik);
        sewa.setTglSewa(tglSewa);
        sewa.setTglKembali(tglKembali);

        sewa.setStatus(status);
        sewa.setHari(hari);

    }

    public void saveData() {
        if (this.sewa != null) {
            SewaModel model = new SewaModel(sewa);
            if (model.save() == 1) {
                model.updateStatus();
                success("berhasil menambahkan data baru");
                Sewa sewa = new SewaModel().getLastRecord();

                ReportView report = new ReportView(sewa);
                report.build();

            } else {
                error("gagal menambah data baru");
            }
        } else {
            error("supir is null");
        }

    }

    public double totalBiaya() {

        double biayaMobil = (double) sewa.getMobil().getHargaSewa() * sewa.getHari();
        if (!sewa.getSupir().getNik().equals(Supir.UNAVAILABLE_TIDAKDITENTUKAN)) {
            double total = 130000 * sewa.getHari();
            biayaMobil = biayaMobil + total;
        } else {
            System.out.println("DIA GA PAKE SUPIR");
        }
        return biayaMobil;
    }

    public SewaController() {
    }

    @Override
    public void error(String message) {
        DialogView.showMessage(null, message + "\n" + getClass().getName() + " => " + ERRORTYPE, DialogView.ERROR_MESSAGE);

    }

    @Override
    public void success(String message) {
        System.out.println(message + " => " + getClass().getName());
    }

    public void setSewa(Sewa sewa) {
        this.sewa = sewa;
    }

    public void ubahOrder() {
        /*
        if (!sewa.getSupir().getNik().equals("0")) {
            SupirModel modelSupir = new SupirModel(sewa.getSupir());
            if (modelSupir.updateStatusSupir()!=0){
            System.out.println("ubah status supir");
            };
        }
*/
        new SupirModel(sewa.getSupir()).updateStatusSupir();
        
        MobilModel mobilModel = new MobilModel(sewa.getMobil());
       if ( mobilModel.updateStatusMobil()!=0){
       System.out.println("ubah status mobil");
       };

        SewaModel modelSewa = new SewaModel(sewa);
       if ( modelSewa.ubahStatusSewa()!=0){
       System.out.println("ubah status sewa");
       };
        System.out.println("DENDANYA ADALAH : " + sewa.getDenda());
        if (sewa.getDenda() > 0.0) {
            if (modelSewa.addDenda() != 0) {
                System.out.println("denda insered");
            };
        }

    }
}
