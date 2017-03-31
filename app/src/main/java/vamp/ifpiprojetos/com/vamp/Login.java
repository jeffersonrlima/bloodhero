package vamp.ifpiprojetos.com.vamp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import vamp.ifpiprojetos.com.vamp.lists.DonorListActivity;

public class Login extends AppCompatActivity {

    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = (Button) findViewById(R.id.loging_button);

        final MediaPlayer massa = MediaPlayer.create(getApplicationContext(), R.raw.massa);
        massa.start();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), LoadingActivity.class));
                massa.stop();
            }
        });
    }
}
