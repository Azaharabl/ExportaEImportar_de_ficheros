package com.example.agenda_java;


import com.example.agenda_java.service.ServiceCsv;
import com.example.agenda_java.uml.Agenda;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.nio.file.Path;
import java.time.LocalDate;

public class HelloController {

    private Agenda a = new Agenda();

    @FXML
    private TextArea areaDeTexto;

    @FXML
    private Button cargarButon;

    @FXML
    private DatePicker fecha;

    @FXML
    private Button guardarButon;

    @FXML
    void onCargarAction(ActionEvent event) {

        LocalDate fechaS =fecha.getValue();
        if(a.getAnotacion(fechaS).isPresent()) {

           if(a.getAnotacion(fecha.getValue()).isPresent()){
               areaDeTexto.setText(a.getAnotacion(fecha.getValue()).get());
           }else{
               areaDeTexto.setText("vacio");
           }

        }else{
            System.out.println("entra en cargar opcion 2");
            areaDeTexto.setText("");
            Alert b = new Alert(Alert.AlertType.INFORMATION);
            b.setTitle("no hay datos guardados");
            b.showAndWait();
        }
    }

    @FXML
    void onGuardarAction(ActionEvent event) {

        LocalDate  fechaSelect = fecha.getValue();
        if(a.getAnotacion(fechaSelect).isPresent()) {
            System.out.println("entra en guardar opcion 1");
            a.update(fechaSelect, areaDeTexto.getText());
        }else{
            a.addItem(fecha.getValue(), areaDeTexto.getText());
            System.out.println("entra en guardar opcion 2");
        }
        ServiceCsv s = new ServiceCsv();
        s.save(Path.of("C:\\Users\\blanc\\Desktop\\Ajenda_Java\\csv")  , a.getTreemap());


    }

    @FXML
    void initialize(){
        ServiceCsv s = new ServiceCsv();
        Agenda b = s.load(Path.of("C:\\Users\\blanc\\Desktop\\Ajenda_Java\\csv"));
        a = b;
        System.out.println(" entra en cargar datos de csv");
    }


    @FXML
    public  void onFechaEscogida(){
        System.out.println("seleciona fecha");

        LocalDate fechaS =fecha.getValue();
        if(a.getAnotacion(fechaS).isPresent()) {

            if(a.getAnotacion(fecha.getValue()).isPresent()){
                areaDeTexto.setText(a.getAnotacion(fecha.getValue()).get());
            }else{
                areaDeTexto.setText("vacio");
            }

        }else {
            areaDeTexto.setText("Este día está vacio . Escrive aquí para guardar alguna nota");
        }
    }





}