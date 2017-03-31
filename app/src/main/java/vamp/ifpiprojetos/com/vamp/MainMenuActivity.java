package vamp.ifpiprojetos.com.vamp;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import vamp.ifpiprojetos.com.vamp.adapter.TabAdapter;
import vamp.ifpiprojetos.com.vamp.forms.DonorRegisterActivity;
import vamp.ifpiprojetos.com.vamp.forms.HospitalRegisterActivity;
import vamp.ifpiprojetos.com.vamp.sliding.SlidingTabLayout;

public class MainMenuActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private SlidingTabLayout slidingTabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        slidingTabLayout = (SlidingTabLayout) findViewById(R.id.stl_tab);
        viewPager = (ViewPager) findViewById(R.id.vp_content);

        //Configurar sliding tabs
        slidingTabLayout.setSelectedIndicatorColors(ContextCompat.getColor(this, R.color.colorAccent));
        slidingTabLayout.setDistributeEvenly(true);

        //Configurar o adapter
        TabAdapter tabAdapter = new TabAdapter(getSupportFragmentManager());
        viewPager.setAdapter(tabAdapter);
        slidingTabLayout.setViewPager(viewPager);


        toolbar = (Toolbar) findViewById(R.id.toolbar_main_menu);
        toolbar.setTitle("Blood Hero");
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_new_donor:
                startActivity(new Intent(getApplicationContext(), DonorRegisterActivity.class));
                break;
            case R.id.action_new_hospital:
                startActivity(new Intent(getApplicationContext(), HospitalRegisterActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }
}
