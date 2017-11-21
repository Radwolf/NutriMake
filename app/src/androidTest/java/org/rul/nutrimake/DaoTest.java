package org.rul.nutrimake;

import org.rul.nutrimake.configuration.db.AppDatabase;
import org.rul.nutrimake.model.Alimentacion;
import org.rul.nutrimake.model.Analitica;
import org.rul.nutrimake.model.Biotipo;
import org.rul.nutrimake.model.Cliente;

import java.util.Date;

/**
 * Created by Rul on 18/11/2017.
 */

class DaoTest {

    protected void addAnalitica(final AppDatabase db,
                                final Cliente cliente, final Date fecha, final String descripcion) {
        Analitica analitica = new Analitica();
        analitica.descripcion = descripcion;
        analitica.fecha = fecha;
        analitica.clienteId = cliente.id;
        db.getAnaliticaDao().insert(analitica);
    }

    protected void addAlimentacion(final AppDatabase db,
                                final Cliente cliente, final String descripcion, final boolean activa,
                                   final Date fechaInicio, final Date fechaFin) {
        Alimentacion alimentacion = new Alimentacion();
        alimentacion.activa = activa;
        alimentacion.clienteId = cliente.id;
        alimentacion.descripcion = descripcion;
        alimentacion.fechaInicio = fechaInicio;
        alimentacion.fechaFin = fechaFin;
        db.getAlimentacionDao().insert(alimentacion);
    }


    protected Cliente addCliente(final AppDatabase db, final String nombre,
                                 final String apellidos, final String telefono,
                                 final String email, final String documentoIdentidad,
                                 final String sexo, final Long edad, final Long peso,
                                 final Long altura, final Long imc, final Long benedite,
                                 final boolean ejercicio, final String tipoEjercicio,
                                 final Long frecuenciaEjercicio, final Biotipo biotipo) {
        Cliente cliente = new Cliente();
        cliente.nombre = nombre;
        cliente.apellidos = apellidos;
        cliente.telefono = telefono;
        cliente.email = email;
        cliente.documentoIdentidad = documentoIdentidad;
        cliente.sexo = sexo;
        cliente.edad = edad;
        cliente.peso = peso;
        cliente.altura = altura;
        cliente.imc = imc;
        cliente.benedite = benedite;
        cliente.ejercicio = ejercicio;
        cliente.tipoEjercicio = tipoEjercicio;
        cliente.frecuenciaEjercicio = frecuenciaEjercicio;
        cliente.biotipo = biotipo;
        cliente.fechaAlta = new Date();
        db.getClienteDao().insert(cliente);
        return db.getClienteDao().findByNameAndLastName(nombre, apellidos).get(0);
    }

    protected Biotipo createBiotipo(final int biotioId, final String descripcion,
                                 final Long pesoCorporal, final Long indiceEnergia, final Long energiaTotal,
                                 final Long proteinas, final Long lipidos, final Long grasasSaturadas,
                                 final Long grasasMonoin, final Long grasasPoliin, final Long colesterol,
                                 final Long glucidos, final Long fibra, final Long potasio,
                                 final Long sodio, final Long calcio, final Long fosforo,
                                 final Long magnesio, final Long hierro, final Long yodo,
                                 final Long vitaminaA, final Long vitaminaD, final Long vitaminaE,
                                 final Long vitaminaB1, final Long vitaminaB2, final Long niacina,
                                 final Long acidoFolico, final Long vitaminaB12, final Long vitaminaC) {
        Biotipo biotipo = new Biotipo();
        biotipo.biotioId = biotioId;
        biotipo.descripcion = descripcion;
        biotipo.pesoCorporal = pesoCorporal;
        biotipo.indiceEnergia = indiceEnergia;
        biotipo.energiaTotal = energiaTotal;
        biotipo.proteinas = proteinas;
        biotipo.lipidos = lipidos;
        biotipo.grasasSaturadas = grasasSaturadas;
        biotipo.grasasMonoin = grasasMonoin;
        biotipo.grasasPoliin = grasasPoliin;
        biotipo.colesterol = colesterol;
        biotipo.glucidos = glucidos;
        biotipo.fibra = fibra;
        biotipo.potasio = potasio;
        biotipo.sodio = sodio;
        biotipo.calcio = calcio;
        biotipo.fosforo = fosforo;
        biotipo.magnesio = magnesio;
        biotipo.hierro = hierro;
        biotipo.yodo = yodo;
        biotipo.vitaminaA = vitaminaA;
        biotipo.vitaminaD = vitaminaD;
        biotipo.vitaminaE = vitaminaE;
        biotipo.vitaminaB1 = vitaminaB1;
        biotipo.vitaminaB2 = vitaminaB2;
        biotipo.niacina = niacina;
        biotipo.acidoFolico = acidoFolico;
        biotipo.vitaminaB12 = vitaminaB12;
        biotipo.vitaminaC = vitaminaC;
        return biotipo;
    }


}

