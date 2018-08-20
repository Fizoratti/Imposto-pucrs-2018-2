package br.pucrs.ep.es;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class IrpfTest {

    private Irpf i1;

    @Before
    public void setUp(){
        i1 = new Irpf("Felipe", "123.456.789-00");
        i1.setTotRendimentos(2850.0);
        i1.setContrPrev(0.0);
        i1.setNroDep(0);
        i1.setIdade(23);
    }

    public double calcularBaseDeCalculo() {
        return i1.getTotRendimentos() - i1.getContrPrev();
    }

    public double calcularDesconto(double desconto) {
        return calcularBaseDeCalculo() * desconto;
    }

    public double calcularDescontoNaBaseDeCalculo(int idade, int dependentes) {
        if ( idade < 65 ) {
            if ( dependentes <= 2 ) {
                return calcularDesconto( 0.025 );
            } else if ( dependentes <= 5 ) {
                return calcularDesconto( 0.05 );
            } else if ( dependentes > 5 ) {
                return calcularDesconto( 0.01);
            }
        } else {
            if ( dependentes <= 2 ) {
                return calcularDesconto( 0.03 );
            } else if ( dependentes <= 5 ) {
                return calcularDesconto( 0.045 );
            } else if ( dependentes > 5 ) {
                return calcularDesconto( 0.06);
            }
        }
    }

    @Test
    public void testarDescontoNaBaseDeCalculo() {
        calcularDescontoNaBaseDeCalculo(40, 3);
    }

    @Test
    public void plainTest() {
        i1.impostoDevido();
    }

}
