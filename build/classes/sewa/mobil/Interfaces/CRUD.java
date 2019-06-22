/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sewa.mobil.Interfaces;

import static java.lang.Math.E;
import java.util.ArrayList;

/**
 *
 * @author omandotkom
 */
public interface CRUD <T> {

    /**
     *
     */
    public final String ERRORTYPE="crud";
    public int save();
    public int update();
    public void error(String message);
    
    public ArrayList<T> view();
}
