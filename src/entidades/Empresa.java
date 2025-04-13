package entidades;

import lib.EmpleadoSerializer;
import servicios.IEmpresa;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Empresa implements IEmpresa {
    private String nombre;
    private List<Empleado> empleados;

    public Empresa(String nombre){
        this.nombre = nombre;
        this.empleados = EmpleadoSerializer.cargarEmpleados();
    }

    public void mostrarEmpleadosPorTipo(String tipo){
        List<Empleado> empleadosDelTipo = empleados.stream().
                filter(e -> e.getClass().getSimpleName()
                .equalsIgnoreCase(tipo)).toList();
        System.out.printf("""
                Emplaeados de la empresa en la posición de %s:
                """, tipo);
       empleadosDelTipo.forEach(Empleado::mostrarDetalles);
    }

    @Override
    public void imprimirDetallesDeEmpleados() {
        this.empleados = EmpleadoSerializer.cargarEmpleados();
        Map<String,Long> conteo = empleados.stream()
                        .collect(Collectors.groupingBy(
                                e->{
                                  if(e instanceof Desarrollador) return "Desarrollador";
                                  else if (e instanceof Diseñador) return "Diseñador";
                                  else return "Tester";
                                }, Collectors.counting()
                                ));
        long cantidadDeDesarrolladores = conteo.getOrDefault("Desarrollador",0L);
        long cantidadDeDiseñadores = conteo.getOrDefault("Diseñador",0L);
        long cantidadDeTesters = conteo.getOrDefault("Tester", 0L);
        long totalDeEmpleados = cantidadDeDesarrolladores+cantidadDeTesters+cantidadDeDiseñadores;

        System.out.printf("""
                Empleados de la empresa %s
                """, this.nombre);
       empleados.forEach(Empleado::mostrarDetalles);
        System.out.printf("""
                Cantidad total de empleados: %d
                Desarrolladores: %d,
                Diseñadores: %d
                Testers: %d
                """, totalDeEmpleados, cantidadDeDesarrolladores,
                cantidadDeDiseñadores, cantidadDeTesters);
    }

    @Override
    public void calcularTotalDeSueldos() {
        float gastoEnSueldos = 0;
        for(Empleado e: empleados){
            gastoEnSueldos += e.calcularSueldo();
        }
        System.out.printf("""
                Gasto total en sueldos: $ %.4f
                """, gastoEnSueldos);
    }

    @Override
    public void agregarEmpleado(Empleado empleado) {
        EmpleadoSerializer.guardarEmpleado(empleado);
    }
}
