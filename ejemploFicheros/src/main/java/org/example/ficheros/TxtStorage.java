package org.example.ficheros;



import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class TxtStorage implements ITxtStorage {

    /**
     * metodo que guarda en un txt una lista de objetos
     * @param path donde se guardará el archivo
     * @param lista que vamos a guardar
     * @return booleano que nos indica si se ha podido hacer correctamente
     */
    @Override
    public boolean save(Path path, List<Object> lista) {
        //pasamos a texto la lista
        String toWrite = getString(lista);
        try(FileWriter fw = new FileWriter(path.toFile())){
            fw.write(toWrite);
            return true;
        } catch (IOException e){
            e.printStackTrace();
        }
        return false;
    }


    /**
     * metodo que dado una lista devuelva una string
     * @param lista que combertiremos a string
     * @return
     */
    private String getString(List<Object> lista){
        StringBuilder texto = new StringBuilder();
        /**
         * -> el string builder usa .apend(para añadir contenido)
         * texto.append("todos los objetos: ");
         * lista.stream().foreach(x->texto.append(x.toString).append(\n));
         *
         * texto.append("edad mas alta: ");
         * lista.stream().max(Comparator.comparing(Persona::getEdad)).append(\n)));

         */
        return texto.toString();

    }
}
