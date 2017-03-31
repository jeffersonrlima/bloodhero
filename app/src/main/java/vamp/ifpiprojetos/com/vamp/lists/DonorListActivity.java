package vamp.ifpiprojetos.com.vamp.lists;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import vamp.ifpiprojetos.com.vamp.R;
import vamp.ifpiprojetos.com.vamp.database.DonorDb;
import vamp.ifpiprojetos.com.vamp.forms.DonorRegisterActivity;
import vamp.ifpiprojetos.com.vamp.models.Donor;

public class DonorListActivity extends AppCompatActivity {

    private ListView donorList;
    private Button btnNewDonor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donor_list);
        donorList = (ListView) findViewById(R.id.donorlist_list);
        btnNewDonor = (Button) findViewById(R.id.donorlist_button_new_donor);
        btnNewDonor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), DonorRegisterActivity.class));
            }
        });
    }


    private void loadDonors() {
        DonorDb db = new DonorDb(this);
        List<Donor> donors = db.listDonor();
        db.close();
        ArrayAdapter<Donor>  donorListAdapter = new ArrayAdapter<Donor>(getApplication(),
                android.R.layout.simple_list_item_1, donors){
            @NonNull
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view =  super.getView(position, convertView, parent);
                ((TextView) view).setTextColor(Color.parseColor("#000000"));
                return view;
            }
        };
        donorList.setAdapter(donorListAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadDonors();
    }
}
