package vamp.ifpiprojetos.com.vamp.forms;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;
import vamp.ifpiprojetos.com.vamp.R;
import vamp.ifpiprojetos.com.vamp.database.DonorDb;
import vamp.ifpiprojetos.com.vamp.helpers.RegisterHelper;
import vamp.ifpiprojetos.com.vamp.models.Donor;

public class DonorRegisterActivity extends AppCompatActivity {


    private RegisterHelper registerHelper;
    private Toolbar toolbar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donor_register);

        registerHelper = new RegisterHelper(this);
        toolbar = (Toolbar) findViewById(R.id.toolbar_donor_register);
        toolbar.setTitle("Novo Doador");
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        Donor donor = (Donor) intent.getSerializableExtra("donor");
        if(donor != null){
            registerHelper.donorEdit(donor);
        }

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
                Donor donor = registerHelper.getDonor();
                DonorDb db = new DonorDb(getApplicationContext());
                if(donor.getId() != null){
                    db.update(donor);
                    Toast.makeText(getApplicationContext(), "Doador "+donor.getName()+ " alterado com Sucesso", Toast.LENGTH_SHORT).show();
                    finish();
                }else{
                    db.insertDonor(donor);
                    Toast.makeText(getApplicationContext(), "Doador inserido com Sucesso", Toast.LENGTH_SHORT).show();
                    finish();
                }
                db.close();
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}
