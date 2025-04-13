package entidades;

import servicios.IEmpleado;

public class Desarrollador extends Empleado implements IEmpleado {
    private float pagoPorHora;
    private String especialidad;
    private String jerarquia;

    public Desarrollador(String nombreCompleto, String dni, Contrato contrato,
                         float pagoPorHora, String especialidad, String jerarquia) {
        super(nombreCompleto, dni, contrato);
        this.pagoPorHora = pagoPorHora;
        this.especialidad = especialidad;
        this.jerarquia = jerarquia;
    }

    public Desarrollador(String nombreCompleto, String dni, Contrato contrato) {
        super(nombreCompleto, dni, contrato);
    }

    @Override
    public void imprimirPago() {
        float sueldoTotal = calcularSueldo();
        System.out.printf("""
                Se pago al empleado: %s
                la cantidad de: $ %.2f
                bono extra: 20%%
                descuento: 16%%
                """, this.nombreCompleto,sueldoTotal);
    }

    @Override
    public void mostrarDetalles(){
        System.out.printf("""
                Desarrollador: {
                \tNombre: %s
                \tDni: %s
                \tEspecialidad: %s
                \tJerarquía: %s
                \tTipo de contrado: %s
                \tObra Social: %s
                \tBeneficio: %s
                },
                """, this.nombreCompleto, this.dni,
                this.especialidad, this.jerarquia,
                this.contrato.getTipo(), this.contrato.getObraSocial(),
                this.contrato.getBeneficioExtra());
    }

    @Override
    public float calcularSueldo() {
        float sueldoBase = 8 * 28 * this.pagoPorHora;
        float bono = sueldoBase * 0.2f;
        float descuentos = sueldoBase * 0.16f;
        return sueldoBase+bono-descuentos;
    }

    public float getPagoPorHora() {
        return pagoPorHora;
    }

    public void setPagoPorHora(float pagoPorHora) {
        this.pagoPorHora = pagoPorHora;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getJerarquia() {
        return jerarquia;
    }

    public void setJerarquia(String jerarquia) {
        this.jerarquia = jerarquia;
    }
}