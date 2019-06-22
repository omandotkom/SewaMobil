/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sewa.mobil.Controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import sewa.mobil.Interfaces.ControllerErrHandler;
import sewa.mobil.Model.MobilModel;
import sewa.mobil.Model.Object.Sewa;
import sewa.mobil.Model.SewaModel;

/**
 *
 * @author omandotkom
 */
public class PengembalianController implements ControllerErrHandler {

    private Sewa sewa;
    private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

    public Sewa getDataSewa(int idSewa) {
        sewa = new Sewa();
        sewa.setId(idSewa);
        SewaModel model = new SewaModel(sewa);
        sewa = model.dataSewa();
        return sewa;
    }
    public double getBiayaDenda(int hari)
    {
    return hari * 140000;
    }
    public long getDenda(String tglKembali) {
        long diff = 0;
         try {
            Date kembali = formatter.parse(tglKembali);
            Date sekarang = formatter.parse(this.getTodayDate());
            if (sekarang.getTime() > kembali.getTime()) {
                System.out.println("telat");
                long diffInMillies = Math.abs(sekarang.getTime() - kembali.getTime());
                diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
                return diff;
            } else {
                System.out.println("tidak telat");
                return -1;
            }
        } catch (ParseException e) {
            error(e.getMessage());
        }
return -1;
    }

    public String getTodayDate() {
        Date date = new Date();
        return formatter.format(date);
    }

    @Override
    public void error(String message) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void success(String message) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
