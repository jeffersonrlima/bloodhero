package vamp.ifpiprojetos.com.vamp.forms;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import vamp.ifpiprojetos.com.vamp.R;
import vamp.ifpiprojetos.com.vamp.database.DonorDb;
import vamp.ifpiprojetos.com.vamp.database.ReceiverDb;
import vamp.ifpiprojetos.com.vamp.helpers.RegisterHelper;
import vamp.ifpiprojetos.com.vamp.models.Donor;
import vamp.ifpiprojetos.com.vamp.models.Receiver;

public class ReceiverRegisterActivity extends AppCompatActivity {

    private RegisterHelper registerHelper;
    private Button btnSaveReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receiver_register);
        registerHelper = new RegisterHelper(this);
        btnSaveReceiver = (Button) findViewById(R.id.receiver_register_button_save);
        btnSaveReceiver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Receiver receiver = registerHelper.getReceiver();
                ReceiverDb db = new ReceiverDb(getApplicationContext());
                db.insertReceiver(receiver);
                Toast.makeText(getApplicationContext(), "Paciente inserido com Sucesso", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

    }
}
