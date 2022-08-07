package com.example.agenda_java.uml;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class Agenda {
    private HashMap<LocalDate , String> agenda = new HashMap<LocalDate , String>();

    public void addItem(LocalDate  fecha , String anotacion){
        agenda.put(fecha, anotacion);
    }

    public Optional<String> getAnotacion (LocalDate  fecha) {
        if (agenda.containsKey(fecha)) {
            return Optional.of(agenda.get(fecha));
        } else {
            return Optional.empty();
        }
    }
        public void update(LocalDate fecha , String anotacion){
        agenda.replace(fecha, anotacion);
    }

    public List<String> toList() {
        System.out.println(agenda.values().stream().toList());
       return agenda.values().stream().toList();

    }

    public HashMap<LocalDate,String> getTreemap() {
       return  agenda;

    }
}
