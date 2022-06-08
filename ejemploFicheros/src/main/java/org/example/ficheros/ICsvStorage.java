package org.example.ficheros;


import org.example.ficheros.InterfazStorage.StorageServiceLoad;
import org.example.ficheros.InterfazStorage.StorageServiceSave;

import java.util.List;

public interface ICsvStorage extends StorageServiceLoad<List<Object>>, StorageServiceSave<List<Object>> {
}
