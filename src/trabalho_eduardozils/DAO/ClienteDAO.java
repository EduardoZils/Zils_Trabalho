/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho_eduardozils.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import trabalho_eduardozils.jdbc.ConnectionFactory;
import trabalho_eduardozils.model.Cliente;

/**
 *
 * @author eduar
 */
public class ClienteDAO implements GenericDAO<Cliente>{

    private Connection connection = null;
    @Override
    public void save(Cliente entity) throws SQLException {
    try {
            this.connection = ConnectionFactory.getInstancia().getConnection();
            this.connection.setAutoCommit(false);
            StringBuilder sql = new StringBuilder();
            sql.append("INSERT INTO CLIENTE(CODIGO_CLIENTE, NOME")
                    .append(", DT_NASC, CPF, RG")
                    .append(") VALUES (?,?,?,?,?)");

            PreparedStatement pstm = connection.prepareStatement(sql.toString());
            pstm.setInt(1, entity.getCodigo());
            pstm.setString(2, entity.getNome());
            pstm.setDate(3,new Date(entity.getDt_nasc().getYear(), entity.getDt_nasc().getMonth(), entity.getDt_nasc().getDay()));
            pstm.setString(4, entity.getCPF());
            pstm.setString(5, entity.getRG());
            pstm.execute();
            pstm.close();

        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Falha ao salvar Cliente!");
            sqle.printStackTrace();
            this.connection.rollback();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Falha inesperada ao salvar Cliente!");
            ex.printStackTrace();
            this.connection.rollback();
        } finally {
            this.connection.commit();
            this.connection.close();
        }}

    @Override
    public void update(Cliente entity) throws SQLException {
    try {
            this.connection = ConnectionFactory.getInstancia().getConnection();
            this.connection.setAutoCommit(false);
            StringBuilder sql = new StringBuilder();
            sql.append("UPDATE CLIENTE SET NOME = ?")
                    .append(", DT_NASC = ?, CPF = ?, RG = ?");

            PreparedStatement pstm = connection.prepareStatement(sql.toString());
            pstm.setString(1, entity.getNome());
            pstm.setDate(2, new Date(entity.getDt_nasc().getYear(), entity.getDt_nasc().getMonth(), entity.getDt_nasc().getDay()));
            pstm.setString(3, entity.getCPF());
            pstm.setString(4, entity.getRG());
            pstm.execute();
            pstm.close();

        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Falha ao atualizar Cliente!");
            sqle.printStackTrace();
            this.connection.rollback();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Falha inesperada ao atualizar Cliente!");
            ex.printStackTrace();
            this.connection.rollback();
        } finally {
            this.connection.commit();
            this.connection.close();
        }}

    @Override
    public void delete(int id) throws SQLException {
    try {
            this.connection = ConnectionFactory.getInstancia().getConnection();
            this.connection.setAutoCommit(false);
            String sql = "DELETE FROM CLIENTE WHERE CODIGO_CLIENTE =" + id;
            PreparedStatement pstm = connection.prepareStatement(sql.toString());
            pstm.execute();
            pstm.close();
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Falha ao deletar Cliente!");
            sqle.printStackTrace();
            this.connection.rollback();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Falha inesperada ao deletar Cliente!");
            ex.printStackTrace();
            this.connection.rollback();
        } finally {
            this.connection.commit();
            this.connection.close();
        }}

    @Override
    public Cliente getById(int id) throws SQLException {
    Cliente cliente = null;
        try {
            this.connection = ConnectionFactory.getInstancia().getConnection();
            this.connection.setAutoCommit(false);
            String sql = "SELECT * FROM CLIENTE WHERE CODIGO_CLIENTE = " + id;
            PreparedStatement pstm = connection.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            cliente = new Cliente();
            while (rs.next()) {
                cliente.setCodigo(rs.getInt("CODIGO_CLIENTE"));
                cliente.setNome(rs.getString("NOME"));
                cliente.setDt_nasc(rs.getDate("DT_NASC"));
                cliente.setCPF(rs.getString("CPF"));
                cliente.setRG(rs.getString("RG"));
            }
            pstm.close();
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Falha ao buscar Cliente pelo ID!");
            sqle.printStackTrace();
            this.connection.rollback();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Falha inesperada ao buscar Cliente pelo ID!");
            ex.printStackTrace();
            this.connection.rollback();
        } finally {
            this.connection.commit();
            this.connection.close();
        }
        return cliente;}

    @Override
    public List<Cliente> getByName(String name) throws SQLException {
    List<Cliente> listaCliente = null;
        Cliente cliente = null;
        try {
            this.connection = ConnectionFactory.getInstancia().getConnection();
            this.connection.setAutoCommit(false);
            String sql = "SELECT * FROM FORNECEDOR WHERE UPPER(DS_FORNECEDOR) LIKE UPPER('%" + name + "%') ";
            PreparedStatement pstm = connection.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            listaCliente = new ArrayList<>();
            while (rs.next()) {
                cliente = new Cliente();
                cliente.setCodigo(rs.getInt("CODIGO_CLIENTE"));
                cliente.setNome(rs.getString("NOME"));
                cliente.setDt_nasc(rs.getDate("DT_NASC"));
                cliente.setCPF(rs.getString("CPF"));
                cliente.setRG(rs.getString("RG"));
                listaCliente.add(cliente);
            }
            pstm.close();
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Falha ao buscar Fornecedor(es)!");
            sqle.printStackTrace();
            this.connection.rollback();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Falha inesperada ao buscar Fornecedor(es)!");
            ex.printStackTrace();
            this.connection.rollback();
        } finally {
            this.connection.commit();
            this.connection.close();
        }
        return listaCliente;}

    @Override
    public List<Cliente> getAll() throws SQLException {
     List<Cliente> listaCliente = null;
        Cliente cliente = null;
        try {
            this.connection = ConnectionFactory.getInstancia().getConnection();
            this.connection.setAutoCommit(false);
            String sql = "SELECT * FROM CLIENTE ORDER BY CODIGO_CLIENTE ";
            PreparedStatement pstm = connection.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            listaCliente = new ArrayList<>();
            while (rs.next()) {
                cliente = new Cliente();
                cliente.setCodigo(rs.getInt("CODIGO_CLIENTE"));
                cliente.setNome(rs.getString("NOME"));
                cliente.setDt_nasc(rs.getDate("DT_NASC"));
                cliente.setCPF(rs.getString("CPF"));
                cliente.setRG(rs.getString("RG"));
                listaCliente.add(cliente);
            }
            pstm.close();
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Falha ao buscar Cliente(s)!");
            sqle.printStackTrace();
            this.connection.rollback();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Falha inesperada ao buscar Cliente(s)!");
            ex.printStackTrace();
            this.connection.rollback();
        } finally {
            this.connection.commit();
            this.connection.close();
        }
        return listaCliente;
    }

    @Override
    public int getLastId() throws SQLException {
    PreparedStatement pstm = null;
        try {
            this.connection = ConnectionFactory.getInstancia().getConnection();
            this.connection.setAutoCommit(false);
            String sql = "SELECT COALESCE(MAX(CODIGO_CLIENTE),0)+1 AS MAIOR FROM CLIENTE ";
            pstm = connection.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                return rs.getInt("MAIOR");
            }
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Falha ao buscar Cliente(s)!");
            sqle.printStackTrace();
            this.connection.rollback();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Falha inesperada ao buscar Cliente(s)!");
            ex.printStackTrace();
            this.connection.rollback();
        } finally {
            this.connection.commit();
            this.connection.close();
        }
        return 1;
    }
    
}
