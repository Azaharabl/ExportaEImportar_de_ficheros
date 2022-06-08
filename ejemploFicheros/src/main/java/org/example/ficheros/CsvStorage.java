package org.example.ficheros;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static java.util.Collections.emptyList;

public class CsvStorage implements ICsvStorage{

    //para crear documento

    /**
     *
     * @param path ruta del archivo a crear
     * @param entity lista de objetos a guardar
     * @return creado o no
     */
    @Override
    public boolean save(Path path, List<Object> entity) {
        //documento a crear
        String csv ="";

        csv = csv+ "lo que quieras poner en el inicio del  documento";

        //creamos las lineas
        List<String> objetosEnCsv = entity.stream().map(this::pasarCsv).toList();

        //escribimos cada linea
        for (String objeto : objetosEnCsv) {
            csv = csv+("\n");
            csv = csv+(objeto);
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

    /**
     * metodo que devuelve las propiedades del objeto en string
     * @param entity objeto a pasar a string
     * @return string creada
     */
    private String pasarCsv(Object entity) {

        /**ej. Persona p
         * p.getId() + ";" + p.getNombre() + ";" + p.getDni();
         */

        return entity.toString();

    }

    //para cargar documento

    /**
     * metodo que pasado un path de un fichero csv lo leer y carga datos
     * @param path de carga de fichero
     * @return lista de objetos
     */
    @Override
    public List<Object> load(Path path) {
        try {
            //nos saltamos la primera linea  //cargamos cada objeto //pasamos a lista
            return Files.lines(path)
                    .skip(1)
                    .map(this::cargarObjeto)
                    .toList();
        } catch (IOException e) {
            System.out.println("Error al leer el fichero");
            e.printStackTrace();
        }
        return emptyList();
    }

    /**
     * metodo que pasa de una string a un objeto con sus campos
     * @param linea la string con los campos
     * @return objeto
     */
    private Object cargarObjeto(String linea) {
        /**
         * cargamos el objeto y sus datos ej.
         * String nombre = campo[0];
         * LocalDate = LocalDate.parse(campo[1]);
         * int Edad = Interger.parseInt(campo[2]);
         * Boolean activo = Boolean.parseBolean(campo[3]);
         *
         */

        return new Object( /**campos obtenidos **/ );
    }


}
