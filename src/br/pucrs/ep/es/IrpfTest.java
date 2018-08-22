package br.pucrs.ep.es;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class IrpfTest {

    private Irpf i1;
    private Irpf i2;
    private Irpf i3;

    @Before
    public void setUp(){
        i1 = new Irpf("Felipe", "123.456.789-00");
        i1.setTotRendimentos(2850.0);
        i1.setContrPrev(0.0);
        i1.setNroDep(0);
        i1.setIdade(23);

        i2 = new Irpf("josé", "321.654.789-00");
        i2.setTotRendimentos(123450.0);
        i2.setContrPrev(934.0);
        i2.setNroDep(3);
        i2.setIdade(49);

        i3 = new Irpf("maria", "321.654.789-00");
        i3.setTotRendimentos(21450.0);
        i3.setContrPrev(3251.0);
        i3.setNroDep(2);
        i3.setIdade(66);
    }

    public double calcularBaseDeCalculoCaso1() {
        return i1.getTotRendimentos() - i1.getContrPrev();
    }
    public double calcularBaseDeCalculoCaso2() {
        return i2.getTotRendimentos() - i2.getContrPrev();
    }
    public double calcularBaseDeCalculoCaso3() {
        return i3.getTotRendimentos() - i3.getContrPrev();
    }

    public double calcularDescontoCaso1(double desconto) {
        return calcularBaseDeCalculoCaso1() * desconto;
    }
    public double calcularDescontoCaso2(double desconto) {
        return calcularBaseDeCalculoCaso2() * desconto;
    }
    public double calcularDescontoCaso3(double desconto) {
        return calcularBaseDeCalculoCaso3() * desconto;
    }

    public double calcularDescontoNaBaseDeCalculoCaso1(int idade, int dependentes) {
        double valor = 0.0;
        if ( idade < 65 ) {
            if ( dependentes <= 2 ) {
                valor = calcularDescontoCaso1( 0.025 );
            } else if ( dependentes <= 5 ) {
                valor = calcularDescontoCaso1( 0.05 );
            } else if ( dependentes > 5 ) {
                valor = calcularDescontoCaso1( 0.01);
            }
        } else {
            if ( dependentes <= 2 ) {
                valor = calcularDescontoCaso1( 0.03 );
            } else if ( dependentes <= 5 ) {
                valor = calcularDescontoCaso1( 0.045 );
            } else if ( dependentes > 5 ) {
                valor = calcularDescontoCaso1( 0.06);
            }
        }
        return valor;
    }
    public double calcularDescontoNaBaseDeCalculoCaso2(int idade, int dependentes) {
        double valor = 0.0;
        if ( idade < 65 ) {
            if ( dependentes <= 2 ) {
                valor = calcularDescontoCaso2( 0.025 );
            } else if ( dependentes <= 5 ) {
                valor = calcularDescontoCaso2( 0.05 );
            } else if ( dependentes > 5 ) {
                valor = calcularDescontoCaso2( 0.01);
            }
        } else {
            if ( dependentes <= 2 ) {
                valor = calcularDescontoCaso2( 0.03 );
            } else if ( dependentes <= 5 ) {
                valor = calcularDescontoCaso2( 0.045 );
            } else if ( dependentes > 5 ) {
                valor = calcularDescontoCaso2( 0.06);
            }
        }
        return valor;
    }
    public double calcularDescontoNaBaseDeCalculoCaso3(int idade, int dependentes) {
        double valor = 0.0;
        if ( idade < 65 ) {
            if ( dependentes <= 2 ) {
                valor = calcularDescontoCaso3( 0.025 );
            } else if ( dependentes <= 5 ) {
                valor = calcularDescontoCaso3( 0.05 );
            } else if ( dependentes > 5 ) {
                valor = calcularDescontoCaso3( 0.01);
            }
        } else {
            if ( dependentes <= 2 ) {
                valor = calcularDescontoCaso3( 0.03 );
            } else if ( dependentes <= 5 ) {
                valor = calcularDescontoCaso3( 0.045 );
            } else if ( dependentes > 5 ) {
                valor = calcularDescontoCaso3( 0.06);
            }
        }
        return valor;
    }


    @Test
    public void testarDescontoNaBaseDeCalculo() {
        assertEquals(calcularDescontoNaBaseDeCalculoCaso1(40, -1),71.25,0.01);
        assertEquals(calcularDescontoNaBaseDeCalculoCaso1(0, -1),71.25,0.01);
        assertEquals(calcularDescontoNaBaseDeCalculoCaso1(65, -1),85.5,0.01);
        assertEquals(calcularDescontoNaBaseDeCalculoCaso1(-1, -1),71.25,0.01);

        assertEquals(calcularDescontoNaBaseDeCalculoCaso1(40, 0),71.25,0.01);
        assertEquals(calcularDescontoNaBaseDeCalculoCaso1(0, 0),71.25,0.01);
        assertEquals(calcularDescontoNaBaseDeCalculoCaso1(65, 0),85.5,0.01);
        assertEquals(calcularDescontoNaBaseDeCalculoCaso1(-1, 0),71.25,0.01);

        assertEquals(calcularDescontoNaBaseDeCalculoCaso1(40, 1),71.25,0.01);
        assertEquals(calcularDescontoNaBaseDeCalculoCaso1(0, 1),71.25,0.01);
        assertEquals(calcularDescontoNaBaseDeCalculoCaso1(65, 1),85.5,0.01);
        assertEquals(calcularDescontoNaBaseDeCalculoCaso1(-1, 1),71.25,0.01);

//        assertEquals(calcularDescontoNaBaseDeCalculo(40, 2);
//        assertEquals(calcularDescontoNaBaseDeCalculo(0, 2);
//        assertEquals(calcularDescontoNaBaseDeCalculo(65, 2);
//        assertEquals(calcularDescontoNaBaseDeCalculo(-1, 2);
//
//        assertEquals(calcularDescontoNaBaseDeCalculo(40, 3);
//        assertEquals(calcularDescontoNaBaseDeCalculo(0, 3);
//        assertEquals(calcularDescontoNaBaseDeCalculo(65, 3);
//        assertEquals(calcularDescontoNaBaseDeCalculo(-1, 3);
//
//        assertEquals(calcularDescontoNaBaseDeCalculo(40, 4);
//        assertEquals(calcularDescontoNaBaseDeCalculo(0, 4);
//        assertEquals(calcularDescontoNaBaseDeCalculo(65, 4);
//        assertEquals(calcularDescontoNaBaseDeCalculo(-1, 4);
//
//        assertEquals(calcularDescontoNaBaseDeCalculo(40, 5);
//        assertEquals(calcularDescontoNaBaseDeCalculo(0, 5);
//        assertEquals(calcularDescontoNaBaseDeCalculo(65, 5);
//        assertEquals(calcularDescontoNaBaseDeCalculo(-1, 5);
//
//        assertEquals(calcularDescontoNaBaseDeCalculo(40, 42);
//        assertEquals(calcularDescontoNaBaseDeCalculo(40, 42);
//        assertEquals(calcularDescontoNaBaseDeCalculo(40, 42);
//        assertEquals(calcularDescontoNaBaseDeCalculo(40, 42);
    }

    @Test
    public void plainTest() {
        assertEquals(i1.impostoDevido(),0.0,0.01);
        assertEquals(i2.impostoDevido(),28917.06,0.01);
        assertEquals(i3.impostoDevido(),1147.95,0.01);
    }

}
