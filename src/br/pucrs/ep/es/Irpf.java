package br.pucrs.ep.es;

public class Irpf {
    private String nome;
    private String cpf;
    private int nroDep;
    private int idade;
    private double totRendimentos;
    private double contrPrev;

    public Irpf(String nome,String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }
    public String getNome() {
        return this.nome;
    }
    public String getCpf() {
        return this.cpf;
    }
    public int getNroDep() {
        return this.nroDep;
    }
    public void setNroDep(int nroDep) {
        this.nroDep = nroDep;
    }
    public int getIdade() {
        return this.idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
    public double getTotRendimentos() {
        return this.totRendimentos;
    }
    public void setTotRendimentos(double totRendimentos) {
        this.totRendimentos = totRendimentos;
    }
    public double getContrPrev() {
        return this.contrPrev = contrPrev;
    }
    public void setContrPrev(double contrPrev) {
        this.contrPrev = contrPrev;
    }

    public double impostoDevido() {
        return 0.0;
    }
}
