package org.example.ficheros.InterfazStorage;

import java.nio.file.Path;

public interface StorageServiceLoad <T>{

    T load(Path Path);
}
