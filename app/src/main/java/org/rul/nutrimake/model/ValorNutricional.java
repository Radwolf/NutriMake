package org.rul.nutrimake.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Rul on 16/11/2017.
 */

@Entity
public class ValorNutricional {

    public @PrimaryKey(autoGenerate = true) Long valorNutriId;
    public Long porcion;
    public Long indiceEnergia;
    public Long energiaTotal;
    public Long proteinas;
    public Long lipidos;
    public Long grasasSaturadas;
    public Long grasasMonoin;
    public Long grasasPoliin;
    public Long colesterol;
    public Long glucidos;
    public Long fibra;
    public Long potasio;
    public Long sodio;
    public Long calcio;
    public Long fosforo;
    public Long magnesio;
    public Long hierro;
    public Long yodo;
    public Long vitaminaA;
    public Long vitaminaD;
    public Long vitaminaE;
    public Long vitaminaB1;
    public Long vitaminaB2;
    public Long niacina;
    public Long acidoFolico;
    public Long vitaminaB12;
    public Long vitaminaC;

}
