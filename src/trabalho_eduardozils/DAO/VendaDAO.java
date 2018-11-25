/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho_eduardozils.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import trabalho_eduardozils.jdbc.ConnectionFactory;
import trabalho_eduardozils.model.Venda;

/**
 *
 * @author eduar
 */
public class VendaDAO implements GenericDAO<Venda> {

    private Connection connection = null; 

    @Override
    public void save(Venda entity) throws SQLException {
        try {
            this.connection = ConnectionFactory.getInstancia().getConnection(); 
            this.connection.setAutoCommit(false);
            StringBuilder sql = new StringBuilder();
            sql.append("INSERT INTO VENDA(CODIGO_VENDA, FORMA_PAGAMENTEO")
                    .append(", CODIGO_CARRO, CODIGO_VENDEDOR, CODIGO_CLIENTE")
                    .append(", DT_VENDA, VALOR_VENDA) VALUES (?,?,?,?,?,current_date,?)");

            PreparedStatement pstm = connection.prepareStatement(sql.toString());
            pstm.setInt(1, entity.getCodigo());
            pstm.setString(2, entity.getForma_pagamento());
            pstm.setInt(3, entity.getCodigo_carro());
            pstm.setInt(4, entity.getCodigo_vendedor());
            pstm.setInt(5, entity.getCodigo_cliente());
            pstm.setDouble(6, entity.getValorTotal());
            pstm.execute();
            pstm.close();

        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Falha ao efetuar Venda!");
            sqle.printStackTrace();
            this.connection.rollback();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Falha inesperada ao efetuar Venda!");
            ex.printStackTrace();
            this.connection.rollback();
        } finally {
            this.connection.commit();
            this.connection.close();
        }
    }

    @Override
    public void update(Venda entity) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Venda getById(int id) throws SQLException {
        Venda venda = null;
        try {
            this.connection = ConnectionFactory.getInstancia().getConnection();
            this.connection.setAutoCommit(false);
            String sql = "SELECT * FROM FORNECEDOR WHERE CD_FORNECEDOR = " + id;
            PreparedStatement pstm = connection.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            venda = new Venda();
            while (rs.next()) {
                venda.setCodigo(rs.getInt("CODIGO_VENDA"));
                venda.setForma_pagamento(rs.getString("FORMA_PAGAMENTEO"));
                venda.setData_venda(rs.getDate("DT_VENDA"));
                venda.setCodigo_carro(rs.getInt("CODIGO_CARRO"));
                venda.setCodigo_cliente(rs.getInt("CODIGO_CLIENTE"));
                venda.setCodigo_vendedor(rs.getInt("CODIGO_VENDEDOR"));
                venda.setValorTotal(rs.getDouble("VALOR_VENDA"));
            }
            pstm.close();
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Falha ao buscar Venda pelo ID!");
            sqle.printStackTrace();
            this.connection.rollback();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Falha ao buscar Venda pelo ID!");
            ex.printStackTrace();
            this.connection.rollback();
        } finally {
            this.connection.commit();
            this.connection.close();
        }
        return venda;
    }

    @Override
    public List<Venda> getByName(String name) throws SQLException {
        List<Venda> listaVenda = null;
        Venda venda = null;
        try {
            this.connection = ConnectionFactory.getInstancia().getConnection();
            this.connection.setAutoCommit(false);
            String sql = "SELECT * FROM VENDA WHERE UPPER(VALOR_VENDA) LIKE UPPER('%" + name + "%') ";
            PreparedStatement pstm = connection.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            listaVenda = new ArrayList<>();
            while (rs.next()) {
                venda = new Venda();
                venda.setCodigo(rs.getInt("CODIGO_VENDA"));
                venda.setForma_pagamento(rs.getString("FORMA_PAGAMENTEO"));
                venda.setData_venda(rs.getDate("DT_VENDA"));
                venda.setCodigo_carro(rs.getInt("CODIGO_CARRO"));
                venda.setCodigo_cliente(rs.getInt("CODIGO_CLIENTE"));
                venda.setCodigo_vendedor(rs.getInt("CODIGO_VENDEDOR"));
                venda.setValorTotal(rs.getDouble("VALOR_VENDA"));
                listaVenda.add(venda);
            }
            pstm.close();
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Falha ao buscar Venda(s)!");
            sqle.printStackTrace();
            this.connection.rollback();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Falha inesperada ao buscar Venda(s)!");
            ex.printStackTrace();
            this.connection.rollback();
        } finally {
            this.connection.commit();
            this.connection.close();
        }
        return listaVenda;
    }

    @Override
    public List<Venda> getAll() throws SQLException {
        List<Venda> listaVenda = null;
        Venda venda = null;
        try {
            this.connection = ConnectionFactory.getInstancia().getConnection();
            this.connection.setAutoCommit(false);
            String sql = "SELECT * FROM VENDA ORDER BY CODIGO_VENDA ";
            PreparedStatement pstm = connection.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            listaVenda = new ArrayList<>();
            while (rs.next()) {
                venda = new Venda();
                venda.setCodigo(rs.getInt("CODIGO_VENDA"));
                venda.setForma_pagamento(rs.getString("FORMA_PAGAMENTEO"));
                venda.setData_venda(rs.getDate("DT_VENDA"));
                venda.setCodigo_carro(rs.getInt("CODIGO_CARRO"));
                venda.setCodigo_cliente(rs.getInt("CODIGO_CLIENTE"));
                venda.setCodigo_vendedor(rs.getInt("CODIGO_VENDEDOR"));
                venda.setValorTotal(rs.getDouble("VALOR_VENDA"));
                listaVenda.add(venda);
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
        return listaVenda;
    }

    @Override
    public int getLastId() throws SQLException {
        PreparedStatement pstm = null;
        try {
            this.connection = ConnectionFactory.getInstancia().getConnection();
            this.connection.setAutoCommit(false);
            String sql = "SELECT COALESCE(MAX(CODIGO_VENDA),0)+1 AS MAIOR FROM VENDA ";
            pstm = connection.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                return rs.getInt("MAIOR");
            }
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Falha ao buscar ID da ultima Venda!");
            sqle.printStackTrace();
            this.connection.rollback();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Falha inesperada ao buscar ID da ultima Venda!");
            ex.printStackTrace();
            this.connection.rollback();
        } finally {
            this.connection.commit();
            this.connection.close();
        }
        return 1;
    }
}
