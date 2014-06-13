/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gtday;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Especificaciones de los objetos de tipo Tarea para cada proyecto.
 * Cada tarea consta de un nombre de tarea, una fecha límite de realización,
 * una lista de subtareas y un campo de descripción por si necesitamos realizar
 * cualquier anotación sobre ella.
 * @author Hector Valentin <hectorvda@gmail.com>
 */
public class Tarea implements Serializable{
    private String titulo;
    private Calendar fecha_Limite;
    private ArrayList<Tarea> subtareas;
    private String descripcion;

    public Tarea(String titulo, Calendar fecha_Limite, String descripcion) {
        this.titulo = titulo;
        this.fecha_Limite = fecha_Limite;
        this.descripcion = descripcion;
    }

    public Tarea(String titulo, Calendar fecha_Limite) {
        this.titulo = titulo;
        this.fecha_Limite = fecha_Limite;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setFecha_Limite(Calendar fecha_Limite) {
        this.fecha_Limite = fecha_Limite;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getFecha_Limite() {
        return ""+fecha_Limite.get(Calendar.YEAR)+" / "+getMes()+" / "+fecha_Limite.get(Calendar.DAY_OF_MONTH);
    }

    public String getMes(){
        String f;
        int mes=(fecha_Limite.get(Calendar.MONTH)+1);
        if(mes<10){
            f="0"+mes;
        }else{
            f=""+mes;
        }
        return f;
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
