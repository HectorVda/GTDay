/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gtday;

import com.toedter.calendar.JCalendar;
import java.util.ArrayList;
import java.util.Date;

/**
 * Especificaciones de los objetos de tipo Tarea para cada proyecto.
 * Cada tarea consta de un nombre de tarea, una fecha límite de realización,
 * una lista de subtareas y un campo de descripción por si necesitamos realizar
 * cualquier anotación sobre ella.
 * @author Hector Valentin <hectorvda@gmail.com>
 */
public class Tarea {
    private String titulo;
    private JCalendar fecha_Limite;
    private ArrayList<Tarea> subtareas;
    private String descripcion;

    public Tarea(String titulo, JCalendar fecha_Limite, String descripcion) {
        this.titulo = titulo;
        this.fecha_Limite = fecha_Limite;
        this.descripcion = descripcion;
    }

    public Tarea(String titulo, JCalendar fecha_Limite) {
        this.titulo = titulo;
        this.fecha_Limite = fecha_Limite;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setFecha_Limite(JCalendar fecha_Limite) {
        this.fecha_Limite = fecha_Limite;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTitulo() {
        return titulo;
    }

    public JCalendar getFecha_Limite() {
        return fecha_Limite;
    }

    public ArrayList<Tarea> getSubtareas() {
        return subtareas;
    }

    public String getDescripcion() {
        return descripcion;
    }
    /**
     * Añade una tarea a la lista de subtareas.
     * @param subtarea Objeto de tipo Tarea a añadir en la lista.
     */
    public void addSubtarea(Tarea subtarea){
        //En caso de que no haya ninguna subtarea, se creará el Array que las contendrá
        if(this.subtareas == null){
            this.subtareas=new ArrayList<>();
        }
        this.subtareas.add(subtarea);
    }
}
