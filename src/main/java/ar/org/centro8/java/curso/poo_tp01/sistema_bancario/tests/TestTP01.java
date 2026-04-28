package ar.org.centro8.java.curso.poo_tp01.sistema_bancario.tests;

import ar.org.centro8.java.curso.poo_tp01.sistema_bancario.cheques.Cheque;
import ar.org.centro8.java.curso.poo_tp01.sistema_bancario.clientes.ClienteEmpresa;
import ar.org.centro8.java.curso.poo_tp01.sistema_bancario.clientes.ClienteIndividual;
import ar.org.centro8.java.curso.poo_tp01.sistema_bancario.cuentas.CajaAhorro;
import ar.org.centro8.java.curso.poo_tp01.sistema_bancario.cuentas.CuentaConvertibilidad;
import ar.org.centro8.java.curso.poo_tp01.sistema_bancario.cuentas.CuentaCorriente;

public class TestTP01 {

    public static void main(String[] args) {
        
        ClienteIndividual cliente1 = new ClienteIndividual(1, "Leon S.", "Kennedy", "12345678");
        ClienteEmpresa empresa1 = new ClienteEmpresa(2, "Umbrella-corp", "30-12345678-9");
        
        CajaAhorro caja1 = new CajaAhorro(100, cliente1, 0.05);
        System.out.println("\n#####Caja de Ahorro#####");
        System.out.println(caja1);
        caja1.depositar(100000);
        System.out.println("Depósito realizado. Saldo actual: "+caja1.getSaldo());
        caja1.extraer(30000);
        System.out.println("Extracción realizada con éxito. Saldo actualizado: "+caja1.getSaldo());
        caja1.cobrarIntereses();
        System.out.println("Cantidad de dinero disponible: dinero en cuenta + intereses del 5%: "+caja1.getSaldo());

        System.out.println("\n#####Cuenta Corriente#####");
        CuentaCorriente cc1 = new CuentaCorriente(200, empresa1, 50000);
        System.out.println(cc1);
        cc1.depositar(30000);
        System.out.println("Se depositó: "+cc1.getSaldo()+" en Cuenta Corriente");
        cc1.extraer(10000);
        System.out.println("Se realizó la extracción, el saldo actual en cuenta es: "+cc1.getSaldo());

        Cheque cheque1 = new Cheque(500000, "Banco Nación", "26-04-2026");
        System.out.println(cheque1);
        cc1.depositarCheque(cheque1);
        System.out.println("El cheque se depositó con éxito. Su saldo actual es: "+cc1.getSaldo());

        System.out.println("\n#####Cuenta Convertibilidad#####");
        CuentaConvertibilidad conver1 = new CuentaConvertibilidad(300, empresa1, 35000);
        System.out.println(conver1);
        conver1.depositar(20000);
        System.out.println("Se realizó el depósito en pesos. Saldo actual: "+conver1.getSaldo()+" Pesos");
        conver1.depositarDolares(500);
        System.out.println("Se realizó el depósito en dólares. Saldo actual: "+conver1.getSaldoDolares()+" dólares");
        conver1.extraerDolares(200);
        System.out.println("Extracción realizada con éxito. su saldo en dólares es: "+conver1.getSaldoDolares());
        System.out.println("Saldo en descubierto: "+conver1.getDescubierto());
        conver1.convertirPaA(30000, 13.4);
        System.out.println("Se procedió a la compra de dólares, su saldo actual en pesos es: "+(conver1.getSaldo()));
        System.out.println("Monto total en dólares disponible: "+conver1.getSaldoDolares());
        
    }
}
