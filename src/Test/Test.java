package Test;

import entidades.*;
import lib.EmpleadoSerializer;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Empleado> listaDeEmpleados = new ArrayList<>();

        // Instanciación de muestras para prueba
        var contratoIT = new Contrato("Por tiempo indefinido","Swiss Medical","Descuento en universidades");

        var contratoDiseño = new Contrato("Por proyecto","No aplica","Bono extra");

        var desarrollador = new Desarrollador(
                "Oscar Gonzalo Araya", "35912768", contratoIT,
                7000, "Programador Backend","Junior"
        );

        var diseñador = new Diseñador(
                "Pancho Villa", "2345678",contratoDiseño, 90000
        );

        var desarrollador2 = new Desarrollador(
                "Juán Pérez", "35912348", contratoIT,
                4000, "Programador Frontend","Trainee"
        );

        var diseñador2 = new Diseñador(
                "María Juana Rama", "34552378",contratoDiseño, 60000
        );

        var tester = new Tester(
                "Roman Duarte","43568790",contratoIT,
                800000,10);

        var desarrollador3 = new Desarrollador(
                "Alvaringuis Rojas","23547689", contratoIT,
                6000,"DevOps","Senior"
        );

        var tester2 = new Tester(
          "Hector Rubiano", "87658903", contratoIT,
          750000,50
        );


        // Prueba del funcionamiento de los métodos
        System.out.println("------------------------ Prueba de métodos ------------------------");
        System.out.println("\n******** Imprimir Pago ********\n");
        desarrollador.imprimirPago();
        System.out.println("\n");
        diseñador.imprimirPago();
        System.out.println("\n");
        desarrollador2.imprimirPago();
        System.out.println("\n");
        diseñador2.imprimirPago();
        System.out.println("\n");
        desarrollador3.imprimirPago();
        System.out.println("\n");
        tester.imprimirPago();
        System.out.println("\n");
        tester2.imprimirPago();
        System.out.println("\n");

        // Agregar empleados a la lista y guardarlos en un archivo json
        listaDeEmpleados.add(desarrollador);
        listaDeEmpleados.add(desarrollador2);
        listaDeEmpleados.add(desarrollador3);
        listaDeEmpleados.add(diseñador);
        listaDeEmpleados.add(diseñador2);
        listaDeEmpleados.add(tester);
        listaDeEmpleados.add(tester2);

        EmpleadoSerializer.guardarListaCompleta(listaDeEmpleados);

        // Instanciacion de la clase empresa para guardar los objetos
        var empresa = new Empresa("chanclaIT");

        System.out.println("------------- Métodos de la empresa ---------------");
        System.out.println("\n");
        System.out.println("*********** Sueldos **********");
        System.out.println("\n");
        empresa.calcularTotalDeSueldos();
        System.out.println("\n");
        System.out.println("************ Detalles **********");
        System.out.println("\n");
        empresa.imprimirDetallesDeEmpleados();
        System.out.println("\n");
        System.out.println("*********** Detalles por tipo ***********");
        empresa.mostrarEmpleadosPorTipo("desarrollador");
        System.out.println("\n");
        empresa.mostrarEmpleadosPorTipo("tester");
        System.out.println("\n");
        empresa.mostrarEmpleadosPorTipo("diseñador");
        System.out.println("\n");
        System.out.println("************ Fin de las pruebas ***********");
    }
}
