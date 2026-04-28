package ar.org.centro8.java.curso.poo_tp01.sistema_bancario.cuentas;

import java.util.ArrayList;
import java.util.List;

import ar.org.centro8.java.curso.poo_tp01.sistema_bancario.cheques.Cheque;
import ar.org.centro8.java.curso.poo_tp01.sistema_bancario.clientes.Cliente;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)

public class CuentaCorriente extends Cuenta{

    private double descubierto;
    private List<Cheque> cheques;
    public CuentaCorriente(int numeroCuenta, Cliente cliente, double descubierto) {
        super(numeroCuenta, cliente);
        this.descubierto = descubierto;
        this.cheques = new ArrayList<>();
    }

    @Override
    public void extraer(double monto){
        if (getSaldo() + descubierto >= monto) {
            establecerSaldo(getSaldo() - monto);
        }
    }
    public void depositarCheque(Cheque cheque){
        cheques.add(cheque);
        establecerSaldo(getSaldo() + cheque.getMonto());
    }

    
}
