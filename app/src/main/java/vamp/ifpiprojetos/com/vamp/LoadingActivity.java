package vamp.ifpiprojetos.com.vamp;

import android.content.Intent;
import android.os.Handler;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import static vamp.ifpiprojetos.com.vamp.R.id.sangue_loading;

public class LoadingActivity extends AppCompatActivity {

    private int SPLASH_TIME_OUT = 5000;
    private ImageView imageView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_loading);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);

        imageView = (ImageView) findViewById(R.id.sangue_loading);

        Glide.with(this)
                .load("http://www.animatedimages.org/data/media/421/animated-blood-image-0063.gif") // aqui é teu gif
                .asGif()
                .into(imageView);

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                Intent i = new Intent(getApplicationContext(), MainMenuActivity.class);
                startActivity(i);
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}
