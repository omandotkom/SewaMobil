/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sewa.mobil.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author omandotkom
 */
public class DBConnector {

    private final String connectionString = "jdbc:mariadb://localhost:3306/sewamobil?user=root&password=";

    public Connection getConnection (){
        try {
            Connection connection = DriverManager.getConnection(connectionString);
            
            if (!connection.isClosed()){
                return connection;
            }
        } catch (SQLException sqle) {
            System.err.println(sqle.getMessage());
        }
        return null;
    }
   
    
}
