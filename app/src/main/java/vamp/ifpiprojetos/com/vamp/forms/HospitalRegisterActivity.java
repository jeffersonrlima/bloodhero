package vamp.ifpiprojetos.com.vamp.forms;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import vamp.ifpiprojetos.com.vamp.R;
import vamp.ifpiprojetos.com.vamp.database.HospitalDb;
import vamp.ifpiprojetos.com.vamp.helpers.RegisterHelper;
import vamp.ifpiprojetos.com.vamp.models.Hospital;

public class HospitalRegisterActivity extends AppCompatActivity {

    private RegisterHelper registerHelper;

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_register);

        registerHelper = new RegisterHelper(this);
        toolbar = (Toolbar) findViewById(R.id.toolbar_hospital_register);
        toolbar.setTitle("Novo Hospital");
        setSupportActionBar(toolbar);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_save, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.icon_save:
                Hospital hospital = registerHelper.getHospital();
                HospitalDb db = new HospitalDb(getApplicationContext());
                db.insertHospital(hospital);
                Toast.makeText(getApplicationContext(), "Hospital cadastrado com sucesso", Toast.LENGTH_SHORT).show();
                finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
