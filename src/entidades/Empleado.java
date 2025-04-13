package entidades;

import servicios.IPagable;

public abstract class Empleado implements IPagable {
    protected String nombreCompleto;
    protected String dni;
    protected Contrato contrato;

    public Empleado(String nombreCompleto, String dni, Contrato contrato){
        this.nombreCompleto = nombreCompleto;
        this.dni = dni;
        this.contrato = contrato;
    }

    public void mostrarDetalles(){
        System.out.printf("""
                Empleado: {
                \tNombre: %s,
                \tDni: %s,
                \tTipo de contrato: %s
                },
                """,this.nombreCompleto, this.dni, this.contrato.getTipo());
    }

    public abstract float calcularSueldo();
}