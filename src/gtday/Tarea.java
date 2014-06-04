/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gtday;

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
    private String nombre;
    private Date fecha_Limite;
    private ArrayList<Tarea> subtareas;
    private String descripcion;

    public Tarea(String nombre, Date fecha_Limite, ArrayList<Tarea> subtareas, String descripcion) {
        this.nombre = nombre;
        this.fecha_Limite = fecha_Limite;
        this.subtareas = subtareas;
        this.descripcion = descripcion;
    }

    public Tarea(String nombre, Date fecha_Limite) {
        this.nombre = nombre;
        this.fecha_Limite = fecha_Limite;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFecha_Limite(Date fecha_Limite) {
        this.fecha_Limite = fecha_Limite;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public Date getFecha_Limite() {
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
        if(this.subtareas == null){
            this.subtareas=new ArrayList<>();
        }
        this.subtareas.add(subtarea);
    }
}
