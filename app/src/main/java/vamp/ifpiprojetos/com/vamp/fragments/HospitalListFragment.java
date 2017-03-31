package vamp.ifpiprojetos.com.vamp.fragments;


import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import vamp.ifpiprojetos.com.vamp.R;
import vamp.ifpiprojetos.com.vamp.adapter.HospitalAdapter;
import vamp.ifpiprojetos.com.vamp.database.HospitalDb;
import vamp.ifpiprojetos.com.vamp.models.Hospital;

/**
 * A simple {@link Fragment} subclass.
 */
public class HospitalListFragment extends Fragment {

    private ListView hospitalList;


    public HospitalListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_hospital_list, container, false);
        hospitalList = (ListView) view.findViewById(R.id.fragment_hospital_list_view);
        registerForContextMenu(hospitalList);
        return view;
    }

    public void loadHospitals(){
        HospitalDb db = new HospitalDb(getContext());
        List<Hospital> hospitals = db.listHospital();
        db.close();
        HospitalAdapter adapter = new HospitalAdapter(getContext(), hospitals);
        hospitalList.setAdapter(adapter);
    }

    @Override
    public void onResume() {
        super.onResume();
        loadHospitals();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, final ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
        final Hospital hospital = (Hospital) hospitalList.getItemAtPosition(info.position);

        MenuItem itemMapa = menu.add("Ver Endereço no Mapa");
        Intent intentMapa = new Intent(Intent.ACTION_VIEW);
        intentMapa.setData(Uri.parse("geo:0,0?q=" + hospital.getAddress()));
        itemMapa.setIntent(intentMapa);

        MenuItem deletar = menu.add("Excluir Hospital");
        deletar.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                HospitalDb db = new HospitalDb(getContext());
                db.deleteHospital(hospital);
                db.close();
                loadHospitals();
                Toast.makeText(getContext(), "Hospital "+ hospital.getName() + " excluido com sucesso", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }
}
