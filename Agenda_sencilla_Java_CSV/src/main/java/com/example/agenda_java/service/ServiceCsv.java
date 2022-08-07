package com.example.agenda_java.service;

import com.example.agenda_java.uml.Agenda;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.*;


public class ServiceCsv {
    public boolean save(Path path, HashMap<LocalDate, String> entity) {

        //obtenemos todas las claves del HasMap
        Set<LocalDate> lista = entity.keySet();

        System.out.println("coje las fechas");

        String csv = "";
        csv = csv + "fecha, anotacion";

        //creamos las lineas
        for (LocalDate key : lista) {
            csv = csv + ("\n");
            csv = csv + (key);
            csv = csv + (";");
            csv = csv + (entity.get(key));
        }


        //creamos archivo y escribimos
        try (FileWriter fw = new FileWriter(path.toFile())) {
            fw.write(csv);
            return true;
        } catch (Exception e) {
            System.out.println("Error");
            e.printStackTrace();
        }
        return false;
    }


    public Agenda load(Path path) {
        List<String[]> result = new ArrayList<String[]>() {
        };
        try {
             result = Files.lines(path)
                    .skip(1)
                    .map(this::cargarObjeto)
                    .toList();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Agenda a = new Agenda();
        for (int i = 0; i < result.size(); i++) {
            String[] item = result.get(i);
            LocalDate fecha = LocalDate.parse(item[0]);
            String descripcion = item[1];
            a.addItem(fecha,descripcion);
        }
       return a;
    }

    private String[] cargarObjeto(String linea) {
         return linea.split(";");
    }
}
