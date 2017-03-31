package vamp.ifpiprojetos.com.vamp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import vamp.ifpiprojetos.com.vamp.R;
import vamp.ifpiprojetos.com.vamp.models.Donor;

/**
 * Created by Jefferson Lima on 30/03/2017.
 */

public class DonorAdapter extends BaseAdapter {

    private final List<Donor> donors;
    private final Context context;
    private TextView nameField;
    private TextView addressField;
    private TextView genreField;
    private TextView bloodTypeField;

    public DonorAdapter(Context context, List<Donor> donors){
        this.context = context;
        this.donors = donors;
    }

    @Override
    public int getCount() {
        return donors.size();
    }

    @Override
    public Object getItem(int position) {
        return donors.get(position);
    }

    @Override
    public long getItemId(int position) {
        return donors.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Donor donor = donors.get(position);
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = convertView;
        if(convertView == null){
            view = inflater.inflate(R.layout.list_item_form_donor, parent, false);
        }

        nameField = (TextView) view.findViewById(R.id.list_item_form_donor_name);
        nameField.setText(donor.getName());

        genreField = (TextView) view.findViewById(R.id.list_item_form_donor_genre);
        genreField.setText(donor.getGenre());

        bloodTypeField = (TextView) view.findViewById(R.id.list_item_form_donor_bloodType);
        bloodTypeField.setText(donor.getBloodType());


        addressField = (TextView) view.findViewById(R.id.list_item_form_donor_address);
        if(addressField != null){
            addressField.setText(donor.getAddress());
        }

        return view;
    }
}
