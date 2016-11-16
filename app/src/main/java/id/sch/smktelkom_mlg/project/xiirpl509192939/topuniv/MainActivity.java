package id.sch.smktelkom_mlg.project.xiirpl509192939.topuniv;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.project.xiirpl509192939.topuniv.adapter.UnivAdapter;
import id.sch.smktelkom_mlg.project.xiirpl509192939.topuniv.model.Univ;

public class MainActivity extends AppCompatActivity {
    ArrayList<Univ> mList = new ArrayList<>();
    UnivAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("TopUniv!");

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new UnivAdapter(mList);
        recyclerView.setAdapter(mAdapter);

        fillData();
    }

    private void fillData() {
        Resources resource = getResources();
        String[] arJudul = resource.getStringArray(R.array.prov);
        String[] arDeskripsi = resource.getStringArray(R.array.prov_desc);
        TypedArray a = resource.obtainTypedArray(R.array.prov_picture);
        Drawable[] arFoto = new Drawable[a.length
                ()];
        for (int i = 0; i < arFoto.length; i++) {
            arFoto[i] = a.getDrawable(i);
        }
        a.recycle();

        for (int i = 0; i < arJudul.length; i++) {
            mList.add(new Univ(arJudul[i], arDeskripsi[i], arFoto[i]));
        }
        mAdapter.notifyDataSetChanged();
    }

}
