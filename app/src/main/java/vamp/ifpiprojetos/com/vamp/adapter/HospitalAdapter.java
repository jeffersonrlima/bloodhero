package vamp.ifpiprojetos.com.vamp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import vamp.ifpiprojetos.com.vamp.R;
import vamp.ifpiprojetos.com.vamp.models.Hospital;

/**
 * Created by Jefferson Lima on 31/03/2017.
 */

public class HospitalAdapter extends BaseAdapter {

    private final List<Hospital> hospitals;
    private final Context context;
    private TextView nameField;
    private TextView addressField;
    private TextView phoneField;


    public HospitalAdapter(Context context, List<Hospital> hospitals){
        this.context = context;
        this.hospitals = hospitals;
    }


    @Override
    public int getCount() {
        return hospitals.size();
    }

    @Override
    public Object getItem(int position) {
        return hospitals.get(position);
    }

    @Override
    public long getItemId(int position) {
        return hospitals.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Hospital hospital = hospitals.get(position);
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = convertView;
        if(convertView == null){
            view = inflater.inflate(R.layout.list_item_form_hospital, parent, false);
        }

        nameField = (TextView) view.findViewById(R.id.list_item_form_hospital_name);
        nameField.setText(hospital.getName());

        addressField = (TextView) view.findViewById(R.id.list_item_form_hospital_address);
        if(addressField != null){
            addressField.setText(hospital.getAddress());
        }

        phoneField = (TextView) view.findViewById(R.id.list_item_form_hospital_phone);
        phoneField.setText(hospital.getPhone());

        return view;
    }
}
