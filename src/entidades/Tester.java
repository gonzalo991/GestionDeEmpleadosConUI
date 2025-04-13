package entidades;

import servicios.IEmpleado;

public class Tester extends Empleado implements IEmpleado {
    private float pagoFijoMensual;
    private int cantidadDeBugEncontrados;

    public Tester(String nombreCompleto, String dni, Contrato contrato,
                  float pagoFijoMensual, int cantidadDeBugEncontrados) {
        super(nombreCompleto, dni, contrato);
        this.pagoFijoMensual = pagoFijoMensual;
        this.cantidadDeBugEncontrados = cantidadDeBugEncontrados;
    }

    public Tester(String nombreCompleto, String dni, Contrato contrato) {
        super(nombreCompleto, dni, contrato);
    }

    @Override
    public float calcularSueldo() {
        return (this.cantidadDeBugEncontrados*1000)+this.pagoFijoMensual;
    }

    @Override
    public void imprimirPago() {
        float bono = this.cantidadDeBugEncontrados * 1000;
        float sueldoTotal = calcularSueldo();
        System.out.printf("""
                Se pago al empleado: %s
                la cantidad de: $ %.2f
                bono extra: $ %.2f
                cantidad de bugs encontrados: %d
                descuento: no aplica
                """, this.nombreCompleto,sueldoTotal,bono, this.cantidadDeBugEncontrados);
    }

    @Override
    public void mostrarDetalles(){
        System.out.printf("""
                Tester: {
                \tNombre: %s
                \tDni: %s
                \tTipo de contrado: %s
                \tObra Social: %s
                \tBeneficio: %s
                \tBugs encontrados: %d
                },
                """, this.nombreCompleto, this.dni,
                this.contrato.getTipo(), this.contrato.getObraSocial(),
                this.contrato.getBeneficioExtra(), this.cantidadDeBugEncontrados);
    }

    public float getPagoFijoMensual() {
        return pagoFijoMensual;
    }

    public void setPagoFijoMensual(float pagoFijoMensual) {
        this.pagoFijoMensual = pagoFijoMensual;
    }

    public int getCantidadDeBugEncontrados() {
        return cantidadDeBugEncontrados;
    }

    public void setCantidadDeBugEncontrados(int cantidadDeBugEncontrados) {
        this.cantidadDeBugEncontrados = cantidadDeBugEncontrados;
    }
}
