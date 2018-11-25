/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho_eduardozils.model;

import java.util.Date;

/**
 *
 * @author eduar
 */
public class Venda {

    private int codigo;
    private String forma_pagamento;
    private int codigo_carro;
    private int codigo_vendedor;
    private int codigo_cliente;
    private Carro carro;
    private Funcionario vendedor;
    private Cliente cliente;
    private double valorTotal;
    private Date data_venda;

    public Venda() {
    }

    public Venda(int codigo, String forma_pagamento, int codigo_carro, int codigo_vendedor, int codigo_cliente, Carro carro, Funcionario vendedor, Cliente cliente, double valorTotal, Date data_venda) {
        this.codigo = codigo;
        this.forma_pagamento = forma_pagamento;
        this.codigo_carro = codigo_carro;
        this.codigo_vendedor = codigo_vendedor;
        this.codigo_cliente = codigo_cliente;
        this.carro = carro;
        this.vendedor = vendedor;
        this.cliente = cliente;
        this.valorTotal = valorTotal;
        this.data_venda = data_venda;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getForma_pagamento() {
        return forma_pagamento;
    }

    public void setForma_pagamento(String forma_pagamento) {
        this.forma_pagamento = forma_pagamento;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    public Funcionario getVendedor() {
        return vendedor;
    }

    public void setVendedor(Funcionario vendedor) {
        this.vendedor = vendedor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Date getData_venda() {
        return data_venda;
    }

    public void setData_venda(Date data_venda) {
        this.data_venda = data_venda;
    }

    public int getCodigo_carro() {
        return codigo_carro;
    }

    public void setCodigo_carro(int codigo_carro) {
        this.codigo_carro = codigo_carro;
    }

    public int getCodigo_vendedor() {
        return codigo_vendedor;
    }

    public void setCodigo_vendedor(int codigo_vendedor) {
        this.codigo_vendedor = codigo_vendedor;
    }

    public int getCodigo_cliente() {
        return codigo_cliente;
    }

    public void setCodigo_cliente(int codigo_cliente) {
        this.codigo_cliente = codigo_cliente;
    }

    @Override
    public String toString() {
        return "Venda{" + "codigo=" + codigo + ", forma_pagamento=" + forma_pagamento + ", carro=" + carro + ", vendedor=" + vendedor + ", cliente=" + cliente + ", valorTotal=" + valorTotal + ", data_venda=" + data_venda + '}';
    }

}
