package org.example.ficheros;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import static java.util.Collections.emptyList;

public class JsonStorage implements IJsonStorage{

    /**
     * metodo que pasada una lista de objetos y un path te crea un fiichero en el path
     * @param path donde quieres el fichero creado
     * @param lista que quieres introducir en el json
     * @return boolena para saber si se ha hecho correctamente
     */
    @Override
    public boolean save(Path path, List<Object> lista) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(lista);

        //creamos archivo y escribimos
        try (FileWriter fw = new FileWriter(path.toFile())) {
            fw.write(json);
            return true;
        } catch (Exception e) {
            System.out.println("Error al escribir json");
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Object> load(Path path) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json;
        try {
            //leer fichero de golpe
            json = Files.readString(path);
            //combertir la lista en objetos
            return gson.fromJson(json, List.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return emptyList();
    }
}
