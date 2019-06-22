/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sewa.mobil.Model;

import sewa.mobil.Model.Object.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;
import sewa.mobil.View.DialogView;

/**
 *
 * @author omandotkom
 */
public class LoginModel {

    private Connection connection = new DBConnector().getConnection();
    private User user;

    public LoginModel(User user) {
        this.user = user;
        
    }

    @SuppressWarnings("empty-statement")
    public User authUser() {
        String query = "SELECT * FROM user where nik = '" + user.getNik() + "' AND password = '" + user.getPassword() + "'";

        if (connection != null) {
            try {
                Statement statement = connection.createStatement();
                try (ResultSet rs = statement.executeQuery(query)) {
                    while (rs.next()) {
                        User newUser = new User();
                        newUser.setNama(rs.getString("nama"));
                        newUser.setId(rs.getInt("id"));
                        newUser.setNik(rs.getString("nik"));
                        rs.close();
                        connection.close();
                        statement.close();

                        return newUser;
                    }
                    connection.close();
                }
            } catch (SQLException sqle) {
                System.err.println(sqle.getMessage());
                
            } finally {

            }
        } else {
            System.err.println("connection object is null");
        }

        return null;
    }

}
