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
import trabalho_eduardozils.model.Funcionario;

/**
 *
 * @author eduar
 */
public class VendedorDAO implements GenericDAO<Funcionario> {

    private Connection connection = null;

    @Override
    public void save(Funcionario entity) throws SQLException {
        try {
            this.connection = ConnectionFactory.getInstancia().getConnection();
            this.connection.setAutoCommit(false);
            StringBuilder sql = new StringBuilder();
            sql.append("INSERT INTO VENDEDOR(CODIGO_VENDEDOR, NOME_VENDEDOR")
                    .append(", CPF, RG, DT_ADMISSAO")
                    .append(", SALARIO) VALUES (?,?,?,?,current_date,?)");

            PreparedStatement pstm = connection.prepareStatement(sql.toString());
            pstm.setInt(1, entity.getCodigo());
            pstm.setString(2, entity.getNome());
            pstm.setString(3, entity.getCPF());
            pstm.setString(4, entity.getRG());
            pstm.setDouble(5, entity.getSalario());

            pstm.execute();
            pstm.close();

        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Falha ao salvar Vendedor!");
            sqle.printStackTrace();
            this.connection.rollback();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Falha inesperada ao salvar Vendedor!");
            ex.printStackTrace();
            this.connection.rollback();
        } finally {
            this.connection.commit();
            this.connection.close();
        }
    }

    @Override
    public void update(Funcionario entity) throws SQLException {
        try {
            this.connection = ConnectionFactory.getInstancia().getConnection();
            this.connection.setAutoCommit(false);
            StringBuilder sql = new StringBuilder();
            sql.append("UPDATE VENDEDOR SET NOME_VENDEDOR = ?")
                    .append(", CPF = ?, RG = ?")
                    .append(", SALARIO = ?")
                    .append("WHERE CODIGO_VENDEDOR = ?");

            PreparedStatement pstm = connection.prepareStatement(sql.toString());
            pstm.setString(1, entity.getNome());
            pstm.setString(2, entity.getCPF());
            pstm.setString(3, entity.getRG());
            pstm.setDouble(4, entity.getSalario());
            pstm.execute();
            pstm.close();

        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Falha ao atualizar Vendedor!");
            sqle.printStackTrace();
            this.connection.rollback();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Falha inesperada ao atualizar Vendedor!");
            ex.printStackTrace();
            this.connection.rollback();
        } finally {
            this.connection.commit();
            this.connection.close();
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        try {
            this.connection = ConnectionFactory.getInstancia().getConnection();
            this.connection.setAutoCommit(false);
            String sql = "DELETE FROM VENDEDOR WHERE CODIGO_VENDEDOR =" + id;
            PreparedStatement pstm = connection.prepareStatement(sql.toString());
            pstm.execute();
            pstm.close();
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Falha ao deletar Vendedor!");
            sqle.printStackTrace();
            this.connection.rollback();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Falha inesperada ao deletar Vendedor!");
            ex.printStackTrace();
            this.connection.rollback();
        } finally {
            this.connection.commit();
            this.connection.close();
        }
    }

    @Override
    public Funcionario getById(int id) throws SQLException {
        Funcionario funcionario = null;
        try {
            this.connection = ConnectionFactory.getInstancia().getConnection();
            this.connection.setAutoCommit(false);
            String sql = "SELECT * FROM VENDEDOR WHERE CODIGO_VENDEDOR = " + id;
            PreparedStatement pstm = connection.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            funcionario = new Funcionario();
            while (rs.next()) {
                funcionario.setCodigo(rs.getInt("CODIGO_VENDEDOR"));
                funcionario.setNome(rs.getString("NOME_VENDEDOR"));
                funcionario.setCPF(rs.getString("CPF"));
                funcionario.setRG(rs.getString("RG"));
                funcionario.setDt_admissao(rs.getDate("DT_ADMISSAO"));
                funcionario.setSalario(rs.getDouble("SALARIO"));
            }
            pstm.close();
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Falha ao buscar Vendedor pelo ID!");
            sqle.printStackTrace();
            this.connection.rollback();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Falha ao buscar Vendedor pelo ID!");
            ex.printStackTrace();
            this.connection.rollback();
        } finally {
            this.connection.commit();
            this.connection.close();
        }
        return funcionario;
    }

    @Override
    public List<Funcionario> getByName(String name) throws SQLException {
        List<Funcionario> listaFuncionarios = null;
        Funcionario funcionario = null;
        try {
            this.connection = ConnectionFactory.getInstancia().getConnection();
            String sql = "SELECT * FROM FORNECEDOR WHERE UPPER(DS_FORNECEDOR) LIKE UPPER('%" + name + "%') ";
            PreparedStatement pstm = connection.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            listaFuncionarios = new ArrayList<>();
            while (rs.next()) {
                funcionario = new Funcionario();
                funcionario.setCodigo(rs.getInt("CODIGO_VENDEDOR"));
                funcionario.setNome(rs.getString("NOME_VENDEDOR"));
                funcionario.setCPF(rs.getString("CPF"));
                funcionario.setRG(rs.getString("RG"));
                funcionario.setDt_admissao(rs.getDate("DT_ADMISSAO"));
                funcionario.setSalario(rs.getDouble("SALARIO"));
                listaFuncionarios.add(funcionario);
            }
            pstm.close();
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Falha ao buscar Fornecedor(es)!");
            sqle.printStackTrace();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Falha inesperada ao buscar Fornecedor(es)!");
            ex.printStackTrace();
        } finally {
            this.connection.close();
        }
        return listaFuncionarios;
    }

    @Override
    public List<Funcionario> getAll() throws SQLException {
        List<Funcionario> listaFuncionario = null;
        Funcionario funcionario = null;
        try {
            this.connection = ConnectionFactory.getInstancia().getConnection();
            String sql = "SELECT * FROM VENDEDOR ORDER BY CODIGO_VENDEDOR ";
            PreparedStatement pstm = connection.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            listaFuncionario = new ArrayList<Funcionario>();
            while (rs.next()) {
                funcionario = new Funcionario();
                funcionario.setCodigo(rs.getInt("CODIGO_VENDEDOR"));
                funcionario.setNome(rs.getString("NOME_VENDEDOR"));
                funcionario.setCPF(rs.getString("CPF"));
                funcionario.setRG(rs.getString("RG"));
                funcionario.setDt_admissao(rs.getDate("DT_ADMISSAO"));
                funcionario.setSalario(rs.getDouble("SALARIO"));

                listaFuncionario.add(funcionario);
            }
            pstm.close();
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Falha ao buscar Vendedor(es)!");
            sqle.printStackTrace();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Falha inesperada ao buscar Vendedor(es)!");
            ex.printStackTrace();
        } finally {
            this.connection.close();
        }
        return listaFuncionario;
    }

    @Override
    public int getLastId() throws SQLException {
        PreparedStatement pstm = null;
        try {
            this.connection = ConnectionFactory.getInstancia().getConnection();
            this.connection.setAutoCommit(false);
            String sql = "SELECT COALESCE(MAX(CODIGO_VENDEDOR),0)+1 AS MAIOR FROM VENDEDOR ";
            pstm = connection.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                return rs.getInt("MAIOR");
            }
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Falha ao buscar Vendedor(es)!");
            sqle.printStackTrace();
            this.connection.rollback();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Falha inesperada ao buscar Vendedor(es)!");
            ex.printStackTrace();
            this.connection.rollback();
        } finally {
            this.connection.commit();
            this.connection.close();
        }
        return 1;
    }

}
