package vamp.ifpiprojetos.com.vamp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;

public class RankingActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ListView rankingList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);

        toolbar = (Toolbar) findViewById(R.id.toolbar_ranking);
        toolbar.setTitle("Ranking de Doadores");
        setSupportActionBar(toolbar);

        rankingList = (ListView) findViewById(R.id.ranking_list);

    }
}
