/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sewa.mobil.Controller;

import sewa.mobil.Model.LoginModel;
import sewa.mobil.Model.Object.User;
import sewa.mobil.View.DialogView;
import sewa.mobil.View.LoginView;

/**
 *
 * @author omandotkom
 */
public class LoginController {

    private String nik, password;
    private User user;

    public LoginController(String nik, String password) {
        this.nik = nik;
        this.password = password;
        user = new User(this.nik, this.password);
    }

    public void validateUser() {
        User validatedUser = new LoginModel(user).authUser();
        if (validatedUser != null) {
            System.out.println("USER BERHASIL LOGIN " + validatedUser.getNama());
        } else {
            System.out.println("Useer gagal login");    
            DialogView.showMessage(null, "Andsa Gagal Login", DialogView.ERROR_MESSAGE);
        }
    }

}
