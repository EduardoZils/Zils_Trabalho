/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho_eduardozils.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author eduar
 */
public class ConnectionFactory {

    private static ConnectionFactory instancia;

    public ConnectionFactory() {

    }

    public static synchronized ConnectionFactory getInstancia() {
        if (instancia == null) {
            instancia = new ConnectionFactory();
        }
        return instancia;
    }

    public Connection getConnection() {
        try {
            //jdbc do postgres/endereço/ porta/ database
            return DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5433/concesionaria",
                    "postgres", "root");
        } catch (SQLException ex) {
            System.out.println("Erro ao criar uma "
                    + "conexão com o banco de dados "
                    + ex.getMessage());
        }
        return null;
    }

}
