package ar.org.centro8.java.curso.poo_tp01.sistema_bancario.cuentas;

import ar.org.centro8.java.curso.poo_tp01.sistema_bancario.clientes.Cliente;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public abstract class Cuenta {

    private int numeroCuenta;
    private double saldo;
    private Cliente cliente;
    
    public Cuenta(int numeroCuenta, Cliente cliente) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = 0;
        this.cliente = cliente;
    }
    public void depositar(double monto){
        if (monto > 0) {
            saldo += monto;
        }
    }
    //Se usa abstrac en este método, ya que las clases hijas la implementarán de manera diferente.
    public abstract void extraer(double monto);

    //Se usa protected para permitir que las clases hijas modifiquen el saldo de forma controlada,
    //evitando acceso directo desde clases externas y manteniendo encapsulamiento
    protected void establecerSaldo(double saldo){
        this.saldo = saldo;
    }

    
}
