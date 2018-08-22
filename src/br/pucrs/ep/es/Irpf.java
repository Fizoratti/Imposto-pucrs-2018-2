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

    public double calcularBaseDeCalculo() {
        return totRendimentos - contrPrev;
    }

    public double calcularDesconto(double desconto) {
        return calcularBaseDeCalculo() * desconto;
    }

    public double calcularDescontoNaBaseDeCalculo() {
        double valor = 0.0;
        if ( idade < 65 ) {
            if ( nroDep <= 2 ) {
                valor = calcularDesconto( 0.025 );
            } else if ( nroDep <= 5 ) {
                valor = calcularDesconto( 0.05 );
            } else if ( nroDep > 5 ) {
                valor = calcularDesconto( 0.01);
            }
        } else {
            if ( nroDep <= 2 ) {
                valor = calcularDesconto( 0.03 );
            } else if ( nroDep <= 5 ) {
                valor = calcularDesconto( 0.045 );
            } else if ( nroDep > 5 ) {
                valor = calcularDesconto( 0.06);
            }
        }
        return valor;
    }

    public double impostoDevido() {
        double impostoFinal = 0.0;
        double baseDeCalculoDescontada = calcularBaseDeCalculo() - calcularDescontoNaBaseDeCalculo();
        if ( baseDeCalculoDescontada < 10000.0 ) {
            impostoFinal = 0.0;
        } else if ( baseDeCalculoDescontada >= 10000.0 ) {
            if ( baseDeCalculoDescontada >= 20000.0 ) {
                if ( baseDeCalculoDescontada > 20000.0 ) {
                    impostoFinal = ( baseDeCalculoDescontada - 20000.0 ) * 0.30;
                }
            } else {
                impostoFinal = ( baseDeCalculoDescontada - 10000.0 ) * 0.15;
            }
        }
        return impostoFinal;
    }
}
