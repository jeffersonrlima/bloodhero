package vamp.ifpiprojetos.com.vamp.fragments;


import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
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

import java.io.Serializable;
import java.util.List;

import vamp.ifpiprojetos.com.vamp.R;
import vamp.ifpiprojetos.com.vamp.adapter.DonorAdapter;
import vamp.ifpiprojetos.com.vamp.database.DonorDb;
import vamp.ifpiprojetos.com.vamp.forms.DonorRegisterActivity;
import vamp.ifpiprojetos.com.vamp.models.Donor;

/**
 * A simple {@link Fragment} subclass.
 */
public class DonorListFragment extends Fragment {

    private ListView donorList;


    public DonorListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_donor_list, container, false);
        donorList = (ListView) view.findViewById(R.id.fragment_donor_list_view);
        registerForContextMenu(donorList);

        donorList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Donor donor = (Donor) donorList.getItemAtPosition(position);
                Intent donorRgisterEdit = new Intent(getContext(), DonorRegisterActivity.class);
                donorRgisterEdit.putExtra("donor", donor);
                startActivity(donorRgisterEdit);
            }
        });

        return view;
    }

    private void loadDonors() {
        DonorDb db = new DonorDb(getContext());
        List<Donor> donors = db.listDonor();
        db.close();
        DonorAdapter adapter = new DonorAdapter(getContext(), donors);
        donorList.setAdapter(adapter);
    }

    @Override
    public void onResume() {
        super.onResume();
        loadDonors();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, final ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
        final Donor donor = (Donor) donorList.getItemAtPosition(info.position);


        MenuItem itemMapa = menu.add("Ver Endereço no Mapa");
        Intent intentMapa = new Intent(Intent.ACTION_VIEW);
        intentMapa.setData(Uri.parse("geo:0,0?q=" + donor.getAddress()));
        itemMapa.setIntent(intentMapa);

        MenuItem donation = menu.add("Fazer Doação");
        donation.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                DonorDb db = new DonorDb(getContext());
                db.donation(donor);
                db.close();
                Toast.makeText(getContext(), "Doador "+ donor.getName() + " tem " + donor.getDonates() + " doações",
                        Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        MenuItem delete = menu.add("Excluir Doador");
        delete.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                DonorDb db = new DonorDb(getContext());
                db.deleteDonor(donor);
                db.close();
                loadDonors();
                Toast.makeText(getContext(), "Doador "+ donor.getName() + " excluido com sucesso", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }
}
