/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho_eduardozils;

import java.sql.SQLException;
import trabalho_eduardozils.screens.TelaInicial;

/**
 *
 * @author eduar
 */
public class Trabalho_EduardoZils {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        TelaInicial dialog = new TelaInicial(new javax.swing.JFrame(), true);
        dialog.setVisible(true);
    }

}
