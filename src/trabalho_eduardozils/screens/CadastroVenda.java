/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho_eduardozils.screens;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import trabalho_eduardozils.DAO.CarroDAO;
import trabalho_eduardozils.DAO.ClienteDAO;
import trabalho_eduardozils.DAO.VendaDAO;
import trabalho_eduardozils.DAO.VendedorDAO;
import trabalho_eduardozils.model.Carro;
import trabalho_eduardozils.model.Cliente;
import trabalho_eduardozils.model.Funcionario;
import trabalho_eduardozils.model.Venda;

/**
 *
 * @author eduar
 */
public class CadastroVenda extends javax.swing.JDialog {

    private VendaDAO vendaDAO = new VendaDAO();
    private CarroDAO carroDAO = new CarroDAO();
    private VendedorDAO vendedorDAO = new VendedorDAO();
    private ClienteDAO clienteDAO = new ClienteDAO();

    /**
     * Creates new form CadastroVenda
     */
    public CadastroVenda(java.awt.Frame parent, boolean modal) throws SQLException {
        super(parent, modal);
        initComponents();
        carregaComboBox();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jrDinheiro = new javax.swing.JRadioButton();
        jrCartao = new javax.swing.JRadioButton();
        cbVendedor = new javax.swing.JComboBox<>();
        cbCliente = new javax.swing.JComboBox<>();
        cbCarro = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        btVoltar = new javax.swing.JButton();
        btVerificarDados = new javax.swing.JButton();
        btEfetuaVenda = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        tfValorVenda = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Concesionaria Katchow - Vendas");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        jLabel1.setText("Concesionaria Katchow");

        jLabel2.setText("Vendas");

        jLabel3.setText("NOVA VENDA");

        jLabel4.setText("Venda #");

        jLabel5.setText("Vendedor");

        jLabel6.setText("Cliente");

        jLabel7.setText("Carro");

        jLabel8.setText("Valor da Venda");

        jLabel9.setText("Forma de Pagamento");

        buttonGroup1.add(jrDinheiro);
        jrDinheiro.setSelected(true);
        jrDinheiro.setText("Dinheiro");

        buttonGroup1.add(jrCartao);
        jrCartao.setText("Cartão");

        cbVendedor.setMaximumRowCount(100);
        cbVendedor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbCliente.setMaximumRowCount(100);
        cbCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbCliente.setToolTipText("");

        cbCarro.setMaximumRowCount(100);
        cbCarro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel11.setText("Codigo do cliente selecionado:");

        jLabel12.setText("Codigo do Vendedor selecionado:");

        jLabel13.setText("Codigo do Carro selecionado:");

        jLabel14.setText("Data da venda atual:");

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel10.setText("<>");

        jLabel15.setText("<>");

        jLabel16.setText("<>");

        jLabel17.setText("<>");

        btVoltar.setText("↩");
        btVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVoltarActionPerformed(evt);
            }
        });

        btVerificarDados.setText("Verificar Dados");
        btVerificarDados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVerificarDadosActionPerformed(evt);
            }
        });

        btEfetuaVenda.setText("Efetuar Venda");
        btEfetuaVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEfetuaVendaActionPerformed(evt);
            }
        });

        jLabel18.setText("Forma de Pagamento Selecionada:");

        jLabel19.setText("<>");

        jLabel20.setText("Nome do cliente:");

        jLabel21.setText("<>");

        tfValorVenda.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfValorVendaFocusGained(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator3)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btVoltar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btEfetuaVenda)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btVerificarDados))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel3)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel4))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel8)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(tfValorVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel9)
                                            .addComponent(jLabel5))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(cbVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel6)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(cbCliente, 0, 217, Short.MAX_VALUE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jrCartao)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jrDinheiro)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel7)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(cbCarro, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(13, 13, 13)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel14)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel17))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel13)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel16))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel10))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel15))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel18)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
                                        .addComponent(jLabel19))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel20)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel21)))))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(cbVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6)
                                    .addComponent(cbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jrDinheiro)
                                        .addComponent(jLabel7)
                                        .addComponent(cbCarro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jrCartao))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel10))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel15))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel16))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel17))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel18)
                                    .addComponent(jLabel19))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel20)
                                    .addComponent(jLabel21))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(tfValorVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btVoltar)
                            .addComponent(btVerificarDados)
                            .addComponent(btEfetuaVenda))
                        .addContainerGap())))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVoltarActionPerformed
        this.dispose();
        TelaInicial dialog = null;
        try {
            dialog = new TelaInicial(new javax.swing.JFrame(), true);
        } catch (SQLException ex) {
            Logger.getLogger(TelaInicial.class.getName()).log(Level.SEVERE, null, ex);
        }
        dialog.setVisible(true);
    }//GEN-LAST:event_btVoltarActionPerformed

    private void btVerificarDadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVerificarDadosActionPerformed
        try {
            verificaDados();        // TODO add your handling code here:
        } catch (SQLException ex) {
            Logger.getLogger(CadastroVenda.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btVerificarDadosActionPerformed

    private void btEfetuaVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEfetuaVendaActionPerformed
        try {
            Vender();        // TODO add your handling code here:
        } catch (SQLException ex) {
            Logger.getLogger(CadastroVenda.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btEfetuaVendaActionPerformed

    private void tfValorVendaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfValorVendaFocusGained
        puxaValor();        // TODO add your handling code here:
    }//GEN-LAST:event_tfValorVendaFocusGained

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CadastroVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CadastroVenda dialog = null;
                try {
                    dialog = new CadastroVenda(new javax.swing.JFrame(), true);
                } catch (SQLException ex) {
                    Logger.getLogger(CadastroVenda.class.getName()).log(Level.SEVERE, null, ex);
                }
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btEfetuaVenda;
    private javax.swing.JButton btVerificarDados;
    private javax.swing.JButton btVoltar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbCarro;
    private javax.swing.JComboBox<String> cbCliente;
    private javax.swing.JComboBox<String> cbVendedor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JRadioButton jrCartao;
    private javax.swing.JRadioButton jrDinheiro;
    private javax.swing.JTextField tfValorVenda;
    // End of variables declaration//GEN-END:variables

    private void Vender() throws SQLException {
        Venda v = new Venda();
        Carro carro = new Carro();
        Cliente cliente = new Cliente();
        Funcionario vendedor = new Funcionario();

        carro = (Carro) cbCarro.getSelectedItem();
        cliente = (Cliente) cbCliente.getSelectedItem();
        vendedor = (Funcionario) cbVendedor.getSelectedItem();

        java.util.Date data = new java.util.Date();

        v.setCodigo(vendaDAO.getLastId());
        v.setCarro(carro);
        v.setCliente(cliente);
        v.setVendedor(vendedor);
        v.setValorTotal(Double.parseDouble(tfValorVenda.getText()));
        v.setCodigo_carro(carro.getCodigo());
        v.setCodigo_cliente(cliente.getCodigo());
        v.setCodigo_vendedor(vendedor.getCodigo());
        v.setData_venda(data);
        if (verificaFormaPagamento() == 1) {
            v.setForma_pagamento("D");
        } else if (verificaFormaPagamento() == 2) {
            v.setForma_pagamento("C");
        } else if (verificaFormaPagamento() == 0) {
            v.setForma_pagamento("-");
        }

        vendaDAO.save(v);
        JOptionPane.showMessageDialog(null, "Venda Efetuada com Sucesso!");
        limpaCampos();
    }

    private void limpaCampos() {
        tfValorVenda.setText("");
    }

    private void carregaComboBox() throws SQLException {
        List<Carro> listaCarro = new ArrayList<Carro>();
        for (Carro c : carroDAO.getAll()) {
            listaCarro.add(c);
        }
        List<Funcionario> listaVendedor = new ArrayList<Funcionario>();
        for (Funcionario f : vendedorDAO.getAll()) {
            listaVendedor.add(f);
        }
        List<Cliente> listaCliente = new ArrayList<Cliente>();
        for (Cliente cl : clienteDAO.getAll()) {
            listaCliente.add(cl);
        }

        DefaultComboBoxModel modelo = new DefaultComboBoxModel(listaCarro.toArray());
        cbCarro.setModel(modelo);

        DefaultComboBoxModel modelo1 = new DefaultComboBoxModel(listaCliente.toArray());
        cbCliente.setModel(modelo1);

        DefaultComboBoxModel modelo2 = new DefaultComboBoxModel(listaVendedor.toArray());
        cbVendedor.setModel(modelo2);

    }

    private void verificaDados() throws SQLException {
        Carro carro = new Carro();
        Cliente cliente = new Cliente();
        Funcionario vendedor = new Funcionario();
        carro = (Carro) cbCarro.getSelectedItem();
        cliente = (Cliente) cbCliente.getSelectedItem();
        vendedor = (Funcionario) cbVendedor.getSelectedItem();

        java.util.Date data = new java.util.Date();

        jLabel10.setText(String.valueOf(cliente.getCodigo()));
        jLabel15.setText(String.valueOf(vendedor.getCodigo()));
        jLabel16.setText(String.valueOf(carro.getCodigo()));
        jLabel17.setText(String.valueOf(data));
        jLabel4.setText("Venda #" + vendaDAO.getLastId());

        jLabel21.setText(String.valueOf(cliente.getNome()));

        if (verificaFormaPagamento() == 1) {
            jLabel19.setText("Dinheiro");
        } else if (verificaFormaPagamento() == 2) {
            jLabel19.setText("Cartão");
        } else if (verificaFormaPagamento() == 0) {
            jLabel19.setText("<>");
        }
    }

    private int verificaFormaPagamento() {
        if (jrDinheiro.isSelected()) {
            return 1;
        } else if (jrCartao.isSelected()) {
            return 2;
        }
        return 0;
    }

    private void puxaValor() {
        Carro carro = new Carro();
        carro = (Carro) cbCarro.getSelectedItem();
        tfValorVenda.setText(String.valueOf(carro.getValor()));
    }
}