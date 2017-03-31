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
import vamp.ifpiprojetos.com.vamp.database.HospitalDb;
import vamp.ifpiprojetos.com.vamp.forms.HospitalRegisterActivity;
import vamp.ifpiprojetos.com.vamp.models.Hospital;

public class HospitalListActivity extends AppCompatActivity {

    private Button btnNewHospital;
    private ListView hospitalList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_list);

        btnNewHospital = (Button) findViewById(R.id.hospital_list_new_hospital);
        hospitalList = (ListView) findViewById(R.id.hospital_list_list);

        btnNewHospital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), HospitalRegisterActivity.class));
            }
        });

    }

    public void loadHospitals(){
        HospitalDb db = new HospitalDb(this);
        List<Hospital> hospitals = db.listHospital();
        db.close();
        ArrayAdapter<Hospital> hospitalListAdapter = new ArrayAdapter<Hospital>(getApplicationContext(),
                android.R.layout.simple_list_item_1, hospitals){
            @NonNull
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view =  super.getView(position, convertView, parent);
                ((TextView) view).setTextColor(Color.parseColor("#000000"));
                return view;
            }
        };
        hospitalList.setAdapter(hospitalListAdapter);

    }

    @Override
    protected void onResume() {
        super.onResume();
        loadHospitals();
    }
}
