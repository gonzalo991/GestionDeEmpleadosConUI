package entidades;

import servicios.IEmpleado;

public class Diseñador extends Empleado implements IEmpleado {
    private float pagoDelProyecto;

    public Diseñador(String nombreCompleto, String dni, Contrato contrato, float pagoDelProyecto) {
        super(nombreCompleto, dni, contrato);
        this.pagoDelProyecto = pagoDelProyecto;
    }

    @Override
    public float calcularSueldo() {
        return (this.pagoDelProyecto * 0.2f) + pagoDelProyecto;
    }

    @Override
    public void imprimirPago() {
        float sueldoTotal = calcularSueldo();
        System.out.printf("""
                Se pago al empleado: %s
                la cantidad de: $ %.2f
                bono extra: 20%%
                descuento: no aplica
                """, this.nombreCompleto,sueldoTotal);
    }

    @Override
    public void mostrarDetalles(){
        System.out.printf("""
                Diseñador: {
                \tNombre: %s
                \tDni: %s
                \tTipo de contrado: %s
                \tObra Social: %s
                \tBeneficio: %s
                },
                """, this.nombreCompleto, this.dni,
                this.contrato.getTipo(), this.contrato.getObraSocial(),
                this.contrato.getBeneficioExtra());
    }
}
