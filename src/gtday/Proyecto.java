/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gtday;

import java.util.ArrayList;

/**
 * Esta clase se encarga de guardar todas las tareas y subtareas de cada proyecto creado.
 * Cada proyecto se compone de un nombre de proyecto y de diferentes listas
 * de tareas (una por cada estado).
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
    /**
     * Crea una copia a partir de otro proyecto
     * @param p proyecto original
     */
    public Proyecto(Proyecto p){
        this.nombre=p.nombre;
        this.espera=p.espera;
        this.haciendo=p.haciendo;
        this.proximo=p.proximo;
        this.hecho=p.hecho;
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
    /**
     * Añade una tarea al estado de Espera
     * @param e Tarea a añadir
     */
    public void addEspera(Tarea e){
        this.espera.add(e);
    }
    /**
     * Añade una tarea al estado Proximo
     * @param p Tarea a añadir
     */
    public void addProximo(Tarea p){
        this.proximo.add(p);
    }
    /**
     * Añade una tarea al estado Haciendo
     * @param h tarea a añadir
     */
    public void addHaciendo(Tarea h){
        this.haciendo.add(h);
    }
    /**
     * Añade una tarea al estado Hecho
     * @param h tarea a añadir
     */
    public void addHecho(Tarea h){
        this.hecho.add(h);
    }
    
    
}
