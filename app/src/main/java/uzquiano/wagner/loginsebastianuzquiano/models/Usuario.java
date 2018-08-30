package uzquiano.wagner.loginsebastianuzquiano.models;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import uzquiano.wagner.loginsebastianuzquiano.application.MyApplication;

public class Usuario extends RealmObject {

    @PrimaryKey
    private int Id;
    //private String Rut;
    private String Pass;
    private RealmList<Alumno> Rut;


    public Usuario(){}

    public Usuario(String pass ){
        Id = MyApplication.UsuarioId.incrementAndGet();
        //Rut = rut;
        Pass = pass;
        Rut = new RealmList<Alumno>();
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public RealmList<Alumno> getRut() {
        return Rut;
    }

    public void setRut(RealmList<Alumno> rut) {
        Rut = rut;
    }

    public String getPass() {
        return Pass;
    }

    public void setPass(String pass) {
        Pass = pass;
    }
}
