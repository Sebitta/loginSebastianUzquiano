package uzquiano.wagner.loginsebastianuzquiano.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import io.realm.RealmResults;
import uzquiano.wagner.loginsebastianuzquiano.R;
import uzquiano.wagner.loginsebastianuzquiano.models.Alumno;

public class MyAdapter extends BaseAdapter {

    private List<Alumno> list;
    private int layout;
    private Context context;

    public MyAdapter(RealmResults<Alumno> list, int layout, Context context) {
        this.list = list;
        this.layout = layout;
        this.context = context;
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Alumno getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int id) {
        return id;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        ViewHolder vh;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(layout, null);
            vh = new ViewHolder();
            vh.id = (TextView) convertView.findViewById(R.id.textViewId);
            vh.Alumno = (TextView) convertView.findViewById(R.id.textViewAlumno);
            //vh.Usuario = (TextView) convertView.findViewById(R.id.textViewUsuario);
            convertView.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }
        Alumno p = list.get(position);
        vh.id.setText(p.getId() + "");
        vh.Alumno.setText(p.getRut()+ "\n"+  p.getNombre()+"\n"+ p.getEdad()+"\n"+ p.getDireccion()+ "\n"+ p.getSueldo()+ "\n"+p.getCargo());

        return convertView;
    }
    public class ViewHolder {
        TextView id;
        TextView Alumno;
        TextView Usuario;
    }


}
