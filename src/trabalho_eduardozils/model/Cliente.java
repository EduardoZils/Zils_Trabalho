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
public class Cliente {
    private int codigo;
    private String nome;
    private String CPF;
    private String RG;
    private Date dt_nasc;

    public Cliente() {
    }

    public Cliente(int codigo, String nome, String CPF, String RG, Date dt_nasc) {
        this.codigo = codigo;
        this.nome = nome;
        this.CPF = CPF;
        this.RG = RG;
        this.dt_nasc = dt_nasc;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getRG() {
        return RG;
    }

    public void setRG(String RG) {
        this.RG = RG;
    }
    

    public Date getDt_nasc() {
        return dt_nasc;
    }

    public void setDt_nasc(Date dt_nasc) {
        this.dt_nasc = dt_nasc;
    }

    @Override
    public String toString() {
        return nome ;
    }

    
}
