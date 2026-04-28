package ar.org.centro8.java.curso.poo_tp01.sistema_bancario.cheques;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class Cheque {

    private double monto;
    private String banco;
    private String fecha;
}
