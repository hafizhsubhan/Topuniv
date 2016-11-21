package id.sch.smktelkom_mlg.project.xiirpl509192939.topuniv;

import android.content.ContentResolver;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.project.xiirpl509192939.topuniv.adapter.ProvAdapter;
import id.sch.smktelkom_mlg.project.xiirpl509192939.topuniv.model.Prov;

public class home extends AppCompatActivity implements ProvAdapter.
        IProvAdapter {

    public static final int REQUEST_CODE_SEARCH = 88;
    public static final String PROV = "PROV";
    public static final String UNIV = "UNIV";
    int itemPos;
    ArrayList<Prov> mList = new ArrayList<>();
    ProvAdapter mAdapter;
    ArrayList<Prov> mListAll = new ArrayList<>();
    boolean isFiltered;
    ArrayList<Integer> mListMapFilter = new ArrayList<>();
    String mQuery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new ProvAdapter(this, mList);
        recyclerView.setAdapter(mAdapter);

        fillData();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private void fillData() {
        Resources resource = getResources();
        String[] arJudul = resource.getStringArray(R.array.prov);
        String[] arDeskripsi = resource.getStringArray(R.array.prov_desc);
        TypedArray a = resource.obtainTypedArray(R.array.universitas_picture);
        String[] arFoto = new String[a.length()];
        for (int i = 0; i < arFoto.length; i++) {
            int id = a.getResourceId(i, 0);
            arFoto[i] = ContentResolver.SCHEME_ANDROID_RESOURCE + "://"
                    + resource.getResourcePackageName(id) + '/'
                    + resource.getResourceTypeName(id) + '/'
                    + resource.getResourceEntryName(id);
        }
        a.recycle();

        for (int i = 0; i < arJudul.length; i++) {
            mList.add(new Prov(arJudul[i], arDeskripsi[i], arFoto[i]));
        }
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void doClick(int pos) {
        Intent intent = new Intent(this, pilihuniv.class);
        startActivity(intent);
    }


}
