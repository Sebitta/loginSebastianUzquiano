package uzquiano.wagner.loginsebastianuzquiano.application;

import android.app.Application;

import java.util.concurrent.atomic.AtomicInteger;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmObject;
import io.realm.RealmResults;
import uzquiano.wagner.loginsebastianuzquiano.models.Alumno;
import uzquiano.wagner.loginsebastianuzquiano.models.Usuario;

public class MyApplication extends Application {
    public static AtomicInteger AlumnoId = new AtomicInteger();
    public static AtomicInteger UsuarioId = new AtomicInteger();

    @Override
    public void onCreate() {
        super.onCreate();
        // initialize Realm
        Realm.init(getApplicationContext());

        RealmConfiguration config = new RealmConfiguration
                .Builder()
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(config);
        Realm realm = Realm.getInstance(config);
        AlumnoId = setAtomicId(realm, Alumno.class);
        UsuarioId = setAtomicId(realm, Usuario.class);

        realm.close();
    }

    private <T extends RealmObject> AtomicInteger setAtomicId(Realm realm, Class<T> anyClass) {
        RealmResults<T> results = realm.where(anyClass).findAll();
        return (results.size() > 0) ? new AtomicInteger(results.max("Id").intValue()) : new AtomicInteger();
    }

}
