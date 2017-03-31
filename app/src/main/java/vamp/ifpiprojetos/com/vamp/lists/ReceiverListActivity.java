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
import vamp.ifpiprojetos.com.vamp.forms.ReceiverRegisterActivity;
import vamp.ifpiprojetos.com.vamp.database.ReceiverDb;
import vamp.ifpiprojetos.com.vamp.models.Receiver;

public class ReceiverListActivity extends AppCompatActivity {

    private ListView receiverList;
    private Button btnNewReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receiver_list);

        receiverList = (ListView) findViewById(R.id.receiver_list_list);
        btnNewReceiver = (Button) findViewById(R.id.receiver_list_new_receiver);
        btnNewReceiver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ReceiverRegisterActivity.class));
            }
        });
    }

    public void loadReceiver(){
        ReceiverDb db = new ReceiverDb(this);
        List<Receiver> receivers = db.listReceiver();
        db.close();
        ArrayAdapter<Receiver> receiverListAdapter = new ArrayAdapter<Receiver>(getApplicationContext(),
                android.R.layout.simple_list_item_1, receivers){
            @NonNull
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                ((TextView) view).setTextColor(Color.parseColor("#000000"));
                return view;
            }
        };
        receiverList.setAdapter(receiverListAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadReceiver();
    }
}
