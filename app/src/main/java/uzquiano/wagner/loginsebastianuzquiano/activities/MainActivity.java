package uzquiano.wagner.loginsebastianuzquiano.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmResults;
import uzquiano.wagner.loginsebastianuzquiano.R;
import uzquiano.wagner.loginsebastianuzquiano.adapters.MyAdapter;
import uzquiano.wagner.loginsebastianuzquiano.models.Alumno;

public class MainActivity extends AppCompatActivity implements RealmChangeListener<RealmResults<Alumno>> {

    private ListView listView;
    private MyAdapter adapter;

    private Realm realm;
    private RealmResults<Alumno> people;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Realm.init(getApplicationContext());
        realm = Realm.getDefaultInstance();
        listView = (ListView) findViewById(R.id.listView);

        people = getAllPeople();
        people.addChangeListener(this);

        adapter = new MyAdapter(people, R.layout.list_item_view, this);

        listView.setAdapter(adapter);
    }

    @Override
    public void onChange(RealmResults<Alumno> element) {
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onDestroy() {
        realm.removeAllChangeListeners();
        realm.close();
        super.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //getMenuInflater().inflate(R.menu.options, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.item_add:
                addPeople();
                return true;
            case R.id.item_delete:
                removeAll();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    private RealmResults<Alumno> getAllPeople() {
        return realm.where(Alumno.class).findAll();
    }

    private void removeAll() {
        realm.beginTransaction();
        realm.deleteAll();
        realm.commitTransaction();
    }


    private void addPeople() {
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {



                Alumno p1 = new Alumno("218700780","Sebastian",17,"lau",3000,"jefe");
                Alumno p2 = new Alumno("123456789","Sara",17,"lau",3000,"jefe");
                Alumno p3 = new Alumno("987655421","susana",17,"lau",3000,"jefe");

                realm.copyToRealmOrUpdate(p1);
                realm.copyToRealmOrUpdate(p2);
                realm.copyToRealmOrUpdate(p3);

                people = getAllPeople();
            }
        });
    }
}
