package lib;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import entidades.Desarrollador;
import entidades.Diseñador;
import entidades.Empleado;
import entidades.Tester;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoSerializer {
    private static final String FILE_PATH = "empleados.json";
    
    public static Gson buildGson() {
        RuntimeTypeAdapterFactory<Empleado> adapterFactory =
                RuntimeTypeAdapterFactory.of(Empleado.class, "tipo")
                        .registerSubtype(Desarrollador.class,"desarrollador")
                        .registerSubtype(Diseñador.class,"diseñador")
                        .registerSubtype(Tester.class,"Tester");
        return new GsonBuilder()
                .registerTypeAdapterFactory(adapterFactory)
                .setPrettyPrinting().create();
    }

    public static void guardarEmpleado(Empleado e){
        List<Empleado> empleados = cargarEmpleados();
        empleados.add(e);
        guardarListaCompleta(empleados);
    }

    public static void guardarListaCompleta(List<Empleado> empleados){
        Gson gson = buildGson();
        try(FileWriter writer = new FileWriter(FILE_PATH)){
            gson.toJson(empleados, writer);
            System.out.println("✅ Lista actualizada y guardada.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Empleado> cargarEmpleados(){
        File archivo = new File(FILE_PATH);
        if(!archivo.exists()) return new ArrayList<>();

        Gson gson = buildGson();
        try(FileReader reader = new FileReader(FILE_PATH)){
            Type tipoLista = new TypeToken<List<Empleado>>(){}.getType();
            return gson.fromJson(reader, tipoLista);
        }catch(IOException exception){
            exception.printStackTrace();
            return new ArrayList<>();
        }
    }
}
