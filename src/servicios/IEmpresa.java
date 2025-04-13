package servicios;

import entidades.Empleado;

import java.util.List;

public interface IEmpresa {
    void imprimirDetallesDeEmpleados();
    void calcularTotalDeSueldos();
    void agregarEmpleado(Empleado empleado);
}
