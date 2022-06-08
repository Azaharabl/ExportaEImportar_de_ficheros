package org.example.ficheros.InterfazStorage;

import java.nio.file.Path;

public interface StorageServiceSave<T> {


    boolean save(Path path, T entity);



}
