/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gtday;

import java.util.ArrayList;

/**
 * Esta clase se encarga de guardar todas las tareas y subtareas de cada proyecto creado
 * @author Hector Valentin <hectorvda@gmail.com>
 */
public class Proyecto {
    private String nombre;
    private ArrayList<Tarea> espera;
    private ArrayList<Tarea> proximo;
    private ArrayList<Tarea> haciendo;
    private ArrayList<Tarea> hecho;

    public Proyecto(String nombre, ArrayList<Tarea> espera, ArrayList<Tarea> proximo, ArrayList<Tarea> haciendo, ArrayList<Tarea> hecho) {
        this.nombre = nombre;
        this.espera = espera;
        this.proximo = proximo;
        this.haciendo = haciendo;
        this.hecho = hecho;
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Tarea> getEspera() {
        return espera;
    }

    public ArrayList<Tarea> getProximo() {
        return proximo;
    }

    public ArrayList<Tarea> getHaciendo() {
        return haciendo;
    }

    public ArrayList<Tarea> getHecho() {
        return hecho;
    }
    
    
    
}
