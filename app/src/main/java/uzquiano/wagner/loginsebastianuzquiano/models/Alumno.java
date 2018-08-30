package uzquiano.wagner.loginsebastianuzquiano.models;


import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import uzquiano.wagner.loginsebastianuzquiano.application.MyApplication;

public class Alumno extends RealmObject {

    @PrimaryKey
    private int Id;
    private String Rut;
    private String Nombre;
    private int Edad;
    private String Direccion;
    private int Sueldo;
    private String Cargo;

    public Alumno(){}

    public Alumno(String rut,String nombre, int edad, String direccion, int sueldo, String cargo)
    {
     Id = MyApplication.AlumnoId.incrementAndGet();
     Rut = rut;
     Nombre = nombre;
     Edad = edad;
     Direccion = direccion;
     Sueldo = sueldo;
     Cargo = cargo;

    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getRut() {
        return Rut;
    }

    public void setRut(String rut) {
        Rut = rut;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int edad) {
        Edad = edad;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public int getSueldo() {
        return Sueldo;
    }

    public void setSueldo(int sueldo) {
        Sueldo = sueldo;
    }

    public String getCargo() {
        return Cargo;
    }

    public void setCargo(String cargo) {
        Cargo = cargo;
    }
}
