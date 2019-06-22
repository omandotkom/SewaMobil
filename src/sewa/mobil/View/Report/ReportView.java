/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sewa.mobil.View.Report;

import static net.sf.dynamicreports.examples.Templates.columnStyle;
import static net.sf.dynamicreports.report.builder.DynamicReports.*;
import net.sf.dynamicreports.report.builder.style.ReportStyleBuilder;

	
import net.sf.dynamicreports.report.datasource.DRDataSource;

import net.sf.dynamicreports.report.exception.DRException;
import net.sf.jasperreports.engine.JRDataSource;
import sewa.mobil.Model.Object.Sewa;

/**
 *
 * @author omandotkom
 */
public class ReportView {
private Sewa sewa;
public void setSewa(Sewa sewa){this.sewa = sewa;}
    public ReportView() {
        build();
    }
    public ReportView(Sewa sewa){
    this.sewa = sewa;
    }
   
     public static void main(String[] args) {
	      new ReportView();
	   }

    public void build() {

        try {
            report()// create new report design
                    
                    .columns(// add columns
                            // title, field name data type

                            col.column("Nama","nama", type.stringType()),
                            col.column("Mobil", "mobil", type.stringType()),
                            col.column("Tanggal Sewa", "tanggalsewa", type.stringType()),
                            col.column("Tanggal Kembali", "tanggalkembali", type.stringType()),
                            col.column("Supir","supir", type.stringType()),
                            col.column("Hari","jmlhari", type.integerType()),
                            col.column("Total Biaya","totalbiaya", type.doubleType())
                    )
                   
                    .title(cmp.text("Bukti Penyewaan Mobil " + "( ID : " + sewa.getId() + ")"))// shows report title

                     
                    .setDataSource(createDataSource())// set datasource

                    .show();// create and show report

        } catch (DRException e) {

            e.printStackTrace();

        }

    }

    private JRDataSource createDataSource() {

        DRDataSource dataSource = 
                new DRDataSource("nama", "mobil", "tanggalsewa","tanggalkembali","supir","jmlhari","totalbiaya");

        dataSource.add(sewa.getPelanggan().getNama(), sewa.getMobil().getMerkMobil() + " " + sewa.getMobil().getNamaMobil(),
                sewa.getSewaString(), sewa.getKembaliString(),sewa.getSupir().getNama(),sewa.getHari(), sewa.getTotalBiaya());
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
