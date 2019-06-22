/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sewa.mobil.View.Report;

import java.util.ArrayList;
import static net.sf.dynamicreports.report.builder.DynamicReports.*;
import static net.sf.dynamicreports.report.builder.expression.Expressions.dataSource;

import net.sf.dynamicreports.report.datasource.DRDataSource;

import net.sf.dynamicreports.report.exception.DRException;
import net.sf.jasperreports.engine.JRDataSource;
import sewa.mobil.Model.Object.Sewa;
import sewa.mobil.Model.SewaModel;

/**
 *
 * @author omandotkom
 */
public class GeneralReportView {

    private Sewa sewa;

    public void setSewa(Sewa sewa) {
        this.sewa = sewa;
    }

    public GeneralReportView() {
        build();
    }

    public GeneralReportView(Sewa sewa) {
        this.sewa = sewa;
    }

    public static void main(String[] args) {
        new GeneralReportView();
    }

    public void build() {

        try {
            report()// create new report design

                    .columns(// add columns
                            // title, field name data type

                            col.column("Nama", "nama", type.stringType()),
                            col.column("Mobil", "namamobil", type.stringType()),
                            col.column("Tanggal Sewa", "sewa", type.stringType()),
                            col.column("Tanggal Kembali", "kembali", type.stringType()),
                            col.column("Supir", "nik", type.stringType()),
                            col.column("Biaya", "biaya", type.doubleType()),
                            col.column("Denda", "denda", type.doubleType())
                    )
                    .title(cmp.text("LAPORAN TRANSAKSI"))// shows report title

                    .setDataSource(createDataSource())// set datasource

                    .show();// create and show report

        } catch (DRException e) {

            e.printStackTrace();

        }

    }

    private JRDataSource createDataSource() {
ArrayList<Sewa> reportList = new ArrayList<Sewa>();
reportList = new SewaModel().dataReport();
        DRDataSource dataSource
                = new DRDataSource("nama", "namamobil", "sewa", "kembali", "nik", "biaya", "denda");
for (int i =0;i<reportList.size()-1;i++){
Sewa sewa = new Sewa();
sewa = reportList.get(i);
dataSource.add(sewa.getPelanggan().getNama(), sewa.getMobil().getNamaMobil(),
                sewa.getSewaString(), sewa.getKembaliString(), sewa.getSupir().getNik(), sewa.getTotalBiaya(), sewa.getDenda());
       
}
         /*
        dataSource.add("DVD", 5, new BigDecimal(30));

        dataSource.add("DVD", 1, new BigDecimal(28));

        dataSource.add("DVD", 5, new BigDecimal(32));

        dataSource.add("Book", 3, new BigDecimal(11));

        dataSource.add("Book", 1, new BigDecimal(15));

        dataSource.add("Book", 5, new BigDecimal(10));

        dataSource.add("Book", 8, new BigDecimal(9));
         */
        return dataSource;

    }

}
