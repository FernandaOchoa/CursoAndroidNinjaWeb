package com.monsh.octocats.Model;

public class Series {
    private int imagen;
    private String nombre;
    private int visitas;

    public Series(int imagen, String nombre, int visitas){
        this.imagen = imagen;
        this.nombre = nombre;
        this.visitas = visitas;
    }
    public int getImagen() {  return imagen;  }
    public String getNombre(){  return nombre;  }
    public int getVisitas() {  return visitas;  }

}
