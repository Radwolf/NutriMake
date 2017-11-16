package org.rul.nutrimake.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Rul on 16/11/2017.
 */

@Entity
public class Biotipo {

    public @PrimaryKey int id;
    public String Descripcion;
    public int pesoCorporal;
    public int indiceEnergia;
    public int energiaTotal;
    public int proteinas;
    public int lipidos;
    public int grasasSaturadas;
    public int grasasMonoin;
    public int grasasPoliin;
    public int colesterol;
    public int glucidos;
    public int fibra;
    public int potasio;
    public int sodio;
    public int calcio;
    public int fosforo;
    public int magnesio;
    public int hierro;
    public int yodo;
    public int vitaminaA;
    public int vitaminaD;
    public int vitaminaE;
    public int vitaminaB1;
    public int vitaminaB2;
    public int niacina;
    public int acidoFolico;
    public int vitaminaB12;
    public int vitaminaC;

}
