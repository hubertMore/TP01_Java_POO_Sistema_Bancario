package ar.org.centro8.java.curso.poo_tp01.sistema_bancario.cuentas;

import ar.org.centro8.java.curso.poo_tp01.sistema_bancario.clientes.ClienteEmpresa;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class CuentaConvertibilidad extends CuentaCorriente{

    private double saldoDolares;

    public CuentaConvertibilidad(int numeroCuenta, ClienteEmpresa cliente, double descubierto) {
        super(numeroCuenta, cliente, descubierto);
        this.saldoDolares = 0;
    }

    public void depositarDolares(double monto){
        if (monto > 0) {
            saldoDolares += monto;
        }
    }
    public void extraerDolares(double monto){
        if (saldoDolares >= monto) {
            saldoDolares -= monto;
        }
    }
    public void convertirPaA(double montoPesos, double tasa){
        if (tasa > 0) {
            saldoDolares += montoPesos / tasa;
            establecerSaldo(getSaldo() - montoPesos);
        }
    }
    public void convertirDaP(double montoDolares, double tasa){
        if (tasa > 0 && saldoDolares >= montoDolares) {
            establecerSaldo(getSaldo() + montoDolares * tasa);
            saldoDolares = saldoDolares - montoDolares;
        }
    }
}
