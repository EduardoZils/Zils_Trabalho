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
public class Funcionario {

    private int codigo;
    private String nome;
    private String CPF;
    private String RG;
    private Date dt_admissao;
    private double salario;
   

    public Funcionario() {
    }

    public Funcionario(int codigo, String nome, String CPF, String RG, Date dt_admissao, double salario) {
        this.codigo = codigo;
        this.nome = nome;
        this.CPF = CPF;
        this.RG = RG;
        this.dt_admissao = dt_admissao;
        this.salario = salario;

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

    public Date getDt_admissao() {
        return dt_admissao;
    }

    public void setDt_admissao(Date dt_admissao) {
        this.dt_admissao = dt_admissao;
    }


    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }



    @Override
    public String toString() {
        return nome;
    }
    
    
    
}
