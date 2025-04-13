# 🧑‍💼 Gestión de Empleados - Java Swing

Aplicación de escritorio desarrollada en Java que permite gestionar empleados de una empresa a través de una interfaz gráfica usando **Swing**. Los empleados pueden ser **Desarrolladores**, **Diseñadores** o **Testers**, cada uno con su propio esquema de pago.

---

## 📌 Funcionalidades

✅ Agregar empleados con datos personalizados  
✅ Listar todos los empleados cargados  
✅ Calcular y mostrar el total de sueldos  
✅ Filtrar empleados por tipo (Desarrollador, Diseñador, Tester)  
✅ Interfaz gráfica amigable usando `Swing`

---

## 🧱 Estructura del Proyecto

src/
├── entidades/ 
│ ├── Empleado.java 
│ ├── Contrato.java 
│ ├── Desarrollador.java 
│ ├── Diseñador.java 
| ├── Tester.java 
│ └── Empresa.java 
├── servicios/ 
│ └── IEmpresa.java 
│ └── IEmpleado.java 
| └── IPagable.java │
├── ui/ 
│ └── EmpresaUI.java


---

## 🚀 Ejecución

### Requisitos

- Java 11 o superior
- IDE como IntelliJ, Eclipse o VSCode con soporte para Java

### Cómo correr el proyecto

1. Cloná el repositorio:
   ```bash
   git clone https://github.com/gonzalo991/GestionDeEmpleadosConUI.git
   ```
2. Abrí el proyecto con tu IDE favorito.

3. Ejecutá la clase EmpresaUI.java.

Al iniciar, verás una ventana con botones para interactuar con la aplicación.

🧪 Ejemplo de Uso
1. Agregar Empleado
 Completás un formulario con los datos del empleado según su tipo.

2. Listar Empleados
Muestra los detalles de todos los empleados agregados.

3. Calcular Sueldos
Calcula el sueldo de cada empleado y muestra el total.

4. Filtrar por Tipo
Ingresás un tipo (Desarrollador, Diseñador o Tester) y se muestran solo esos.

📷 Capturas de pantalla

![Vista inicial]("/images/inicio.png")
![Lista de empleados]("/images/listarempleados1.png")
![Segunda parte de la lista]("/images/listarempleados2.png")
![Filtrado por tipo]("/images/filtrarportipo.png")
![Resultados del filtro]("/images/resultadosDeFiltrado.png")

👨‍💻 Autor
Oscar Gonzalo Araya - ArgoDev
Técnico universitario en programación
