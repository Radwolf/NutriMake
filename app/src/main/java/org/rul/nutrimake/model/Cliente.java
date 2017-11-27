package org.rul.nutrimake.model;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverter;
import android.arch.persistence.room.TypeConverters;
import android.os.Parcel;
import android.os.Parcelable;

import org.rul.nutrimake.model.converter.DateConverter;

import java.util.Date;
import java.util.List;

/**
 * Created by Rul on 02/11/2017.
 */

@Entity(foreignKeys = {
        @ForeignKey(entity = Biotipo.class,
                parentColumns = "id",
                childColumns = "biotipoId")
})
@TypeConverters(DateConverter.class)
public class Cliente implements Parcelable {

    public @PrimaryKey(autoGenerate = true) Long id;
    public String nombre;
    public String apellidos;
    public String telefono;
    public String email;
    public String documentoIdentidad;
    //Enum o lista_valor
    public String sexo;
    public Long edad;
    public Long peso;
    public Long altura;
    public Long imc;
    public Long benedite;
    public boolean ejercicio;
    //Enum o lista_valor
    public String tipoEjercicio;
    public Long frecuenciaEjercicio;
    public Long biotipoId;

    public Date fechaAlta;
    public Date fecheBaja;

    public Cliente(Long id) {
        this.id = id;
    }

    protected Cliente(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readLong();
        }
        nombre = in.readString();
        apellidos = in.readString();
        telefono = in.readString();
        email = in.readString();
        documentoIdentidad = in.readString();
        sexo = in.readString();
        if (in.readByte() == 0) {
            edad = null;
        } else {
            edad = in.readLong();
        }
        if (in.readByte() == 0) {
            peso = null;
        } else {
            peso = in.readLong();
        }
        if (in.readByte() == 0) {
            altura = null;
        } else {
            altura = in.readLong();
        }
        if (in.readByte() == 0) {
            imc = null;
        } else {
            imc = in.readLong();
        }
        if (in.readByte() == 0) {
            benedite = null;
        } else {
            benedite = in.readLong();
        }
        ejercicio = in.readByte() != 0;
        tipoEjercicio = in.readString();
        if (in.readByte() == 0) {
            frecuenciaEjercicio = null;
        } else {
            frecuenciaEjercicio = in.readLong();
        }
        if (in.readByte() == 0) {
            biotipoId = null;
        } else {
            biotipoId = in.readLong();
        }
    }

    public static final Creator<Cliente> CREATOR = new Creator<Cliente>() {
        @Override
        public Cliente createFromParcel(Parcel in) {
            return new Cliente(in);
        }

        @Override
        public Cliente[] newArray(int size) {
            return new Cliente[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        if (id == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeLong(id);
        }
        parcel.writeString(nombre);
        parcel.writeString(apellidos);
        parcel.writeString(telefono);
        parcel.writeString(email);
        parcel.writeString(documentoIdentidad);
        parcel.writeString(sexo);
        if (edad == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeLong(edad);
        }
        if (peso == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeLong(peso);
        }
        if (altura == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeLong(altura);
        }
        if (imc == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeLong(imc);
        }
        if (benedite == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeLong(benedite);
        }
        parcel.writeByte((byte) (ejercicio ? 1 : 0));
        parcel.writeString(tipoEjercicio);
        if (frecuenciaEjercicio == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeLong(frecuenciaEjercicio);
        }
        if (biotipoId == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeLong(biotipoId);
        }
    }
}
