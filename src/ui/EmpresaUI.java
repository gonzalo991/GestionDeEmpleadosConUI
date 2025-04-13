package ui;

import entidades.*;

import javax.swing.*;
import java.awt.*;
import java.io.OutputStream;
import java.io.PrintStream;

public class EmpresaUI extends JFrame {
    private Empresa empresa;
    private JTextArea outputArea;
    Contrato contratoIt = new Contrato("Contrato IT", "Swiss Medical", "Descuentos en universidades");
    Contrato contratoRegular = new Contrato("Contrato Regular", "OSDE", "Sin beneficios extra");

    public EmpresaUI() {
        empresa = new Empresa("Tech Solutions");

        setTitle("Gestión de Empleados");
        setSize(600, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel de botones
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2, 2, 10, 10));

        JButton btnAgregar = new JButton("Agregar Empleado");
        JButton btnListar = new JButton("Listar Empleados");
        JButton btnSueldos = new JButton("Calcular Sueldos");
        JButton btnPorTipo = new JButton("Listar por Tipo");

        buttonPanel.add(btnAgregar);
        buttonPanel.add(btnListar);
        buttonPanel.add(btnSueldos);
        buttonPanel.add(btnPorTipo);

        // Área de salida
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);

        add(buttonPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        // Acciones
        btnAgregar.addActionListener(e -> mostrarFormularioAgregar());
        btnListar.addActionListener(e -> listarEmpleados());
        btnSueldos.addActionListener(e -> calcularSueldos());
        btnPorTipo.addActionListener(e -> listarPorTipo());

        setVisible(true);
    }

    private void mostrarFormularioAgregar() {
        String[] opciones = {"Desarrollador", "Diseñador", "Tester"};
        String [] opcionesContrato = {"Contrato IT", "Contrato Regular"};

        String tipo = (String) JOptionPane.showInputDialog(this, "Tipo de empleado:", "Agregar",
                JOptionPane.PLAIN_MESSAGE, null, opciones, "Desarrollador");

        if (tipo == null) return;

        String nombre = JOptionPane.showInputDialog("Nombre completo:");
        String dni = JOptionPane.showInputDialog("DNI:");

        switch (tipo) {
            case "Desarrollador" -> {
                var desarrollador = new Desarrollador(nombre, dni,contratoIt);
                float pagoPorHora = Float.parseFloat(JOptionPane.showInputDialog("Pago por hora:"));
                String especialidad = JOptionPane.showInputDialog("Especialidad:");
                String jerarquia = JOptionPane.showInputDialog("Jerarquía:");

                desarrollador.setPagoPorHora(pagoPorHora);
                desarrollador.setEspecialidad(especialidad);
                desarrollador.setJerarquia(jerarquia);
                empresa.agregarEmpleado(desarrollador);
            }
            case "Diseñador" -> {
                var diseñador = new Diseñador(nombre, dni, contratoRegular);
                float pagoProyecto = Float.parseFloat(JOptionPane.showInputDialog("Pago por proyecto:"));

                diseñador.setPagoDelProyecto(pagoProyecto);
                empresa.agregarEmpleado(diseñador);
            }
            case "Tester" -> {
                var tester = new Tester(nombre, dni, contratoIt);
                float pagoMensual = Float.parseFloat(JOptionPane.showInputDialog("Pago mensual:"));
                int bugs = Integer.parseInt(JOptionPane.showInputDialog("Cantidad de bugs encontrados:"));

                tester.setPagoFijoMensual(pagoMensual);
                tester.setCantidadDeBugEncontrados(bugs);
                empresa.agregarEmpleado(tester);
            }
        }

        outputArea.setText("\nEmpleado agregado correctamente.");
    }

    private void listarEmpleados() {
        outputArea.setText("");
        empresa.imprimirDetallesDeEmpleados();
    }

    private void calcularSueldos() {
        outputArea.setText("");
        empresa.calcularTotalDeSueldos();
    }

    private void listarPorTipo() {
        String tipo = JOptionPane.showInputDialog("Ingrese tipo (Desarrollador, Diseñador, Tester):");
        outputArea.setText("");
        empresa.mostrarEmpleadosPorTipo(tipo);
    }

    // Este método lo podés usar para redireccionar la salida del sistema al TextArea
    public void redirigirConsola() {
        PrintStream printStream = new PrintStream(new OutputStream() {
            public void write(int b) {
                outputArea.append(String.valueOf((char) b));
            }
        });
        System.setOut(printStream);
        System.setErr(printStream);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            EmpresaUI ui = new EmpresaUI();
            ui.redirigirConsola(); // para que se vea la salida en el JTextArea
        });
    }
}