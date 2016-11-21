package id.sch.smktelkom_mlg.project.xiirpl509192939.topuniv;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class search_univ extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_univ);
        findViewById(R.id.buttonCari).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(pilihuniv.class, pilihuniv.this));
            }
        });
    }
}

