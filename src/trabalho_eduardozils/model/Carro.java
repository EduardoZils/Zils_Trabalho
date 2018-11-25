/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho_eduardozils.model;

/**
 *
 * @author eduar
 */
public class Carro {
    private int codigo;
    private int codigo_marca;
    private String modelo;
    private String ano;
    private double valor;
    private String cor;

    public Carro() {
    }

    public Carro(int codigo, int codigo_marca, String modelo, String ano, double valor, String cor) {
        this.codigo = codigo;
        this.codigo_marca = codigo_marca;
        this.modelo = modelo;
        this.ano = ano;
        this.valor = valor;
        this.cor = cor;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo_marca() {
        return codigo_marca;
    }

    public void setCodigo_marca(int codigo_marca) {
        this.codigo_marca = codigo_marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    @Override
    public String toString() {
        return modelo + " - " + ano + " - " + valor + " - " + cor;
    }
    
    
    
    
    
    
    
}
