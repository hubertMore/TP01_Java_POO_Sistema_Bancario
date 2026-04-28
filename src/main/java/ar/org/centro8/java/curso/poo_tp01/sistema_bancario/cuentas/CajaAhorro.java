package ar.org.centro8.java.curso.poo_tp01.sistema_bancario.cuentas;

import ar.org.centro8.java.curso.poo_tp01.sistema_bancario.clientes.Cliente;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class CajaAhorro extends Cuenta{

    private double tasaInteres;

    public CajaAhorro(int numeroCuenta, Cliente cliente, double tasaInteres) {
        super(numeroCuenta, cliente);
        this.tasaInteres = tasaInteres;
    }

    @Override
    public void extraer(double monto) {
        if (getSaldo() >= monto) {
            establecerSaldo(getSaldo() - monto);
        }  
    }
    public void cobrarIntereses(){
        establecerSaldo(getSaldo() + getSaldo() * tasaInteres);
    }
  
}
