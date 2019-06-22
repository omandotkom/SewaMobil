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
public class UbahOrder {
private Sewa sewa;
public void setSewa(Sewa sewa){this.sewa = sewa;}
    public UbahOrder() {
        build();
    }
    public UbahOrder(Sewa sewa){
    this.sewa = sewa;
    }
   
     public static void main(String[] args) {
	      new UbahOrder();
	   }

    public void build() {

        try {
            report()// create new report design
                    
                    .columns(// add columns
                            // title, field name data type

                            col.column("Nama","nama", type.stringType()),
                            col.column("Tanggal Sewa", "tanggalsewa", type.stringType()),
                            col.column("Tanggal Kembali", "tanggalkembali", type.stringType()),
                            col.column("Denda","denda", type.stringType())
                              )
                   
                    .title(cmp.text("Bukti Pengembalian Mobil"))// shows report title

                     
                    .setDataSource(createDataSource())// set datasource

                    .show();// create and show report

        } catch (DRException e) {

            e.printStackTrace();

        }

    }

    private JRDataSource createDataSource() {

        DRDataSource dataSource = 
                new DRDataSource("nama", "tanggalsewa","tanggalkembali","denda");

        dataSource.add(sewa.getPelanggan().getNama(), sewa.getSewaString(),
                 sewa.getKembaliString(),String.valueOf(sewa.getDenda()));
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
