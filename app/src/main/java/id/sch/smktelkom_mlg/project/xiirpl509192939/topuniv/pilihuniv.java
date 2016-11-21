package id.sch.smktelkom_mlg.project.xiirpl509192939.topuniv;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.project.xiirpl509192939.topuniv.adapter.UnivAdapter;
import id.sch.smktelkom_mlg.project.xiirpl509192939.topuniv.model.Univ;

public class pilihuniv extends AppCompatActivity {

    ArrayList<Univ> mList = new ArrayList<>();
    UnivAdapter mAdapter;
    ArrayList<Univ> mListAll = new ArrayList<>();
    boolean isFiltered;
    ArrayList<Integer> mListMapFilter = new ArrayList<>();
    String mQuery;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pilihuniv);

        /*Prov prov = (Prov) getIntent().getSerializableExtra(home.PROV);

        ImageView ivFoto = (ImageView) findViewById(R.id.univ_pict);
        ivFoto.setImageURI(Uri.parse(prov.foto));
        TextView tvDeskripsi = (TextView) findViewById(R.id.univ_desc);
        tvDeskripsi.setText(prov.deskripsi);*/

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView2);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new UnivAdapter(mList);
        recyclerView.setAdapter(mAdapter);

        fillData();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void fillData() {
        Resources resource = getResources();
        String[] arJudul = resource.getStringArray(R.array.universitas);
        String[] arDeskripsi = resource.getStringArray(R.array.universitas_desc);
        TypedArray a = resource.obtainTypedArray(R.array.universitas_picture);
        Drawable[] arFoto = new Drawable[a.length
                ()];
        for (int i = 0; i < arFoto.length; i++) {
            BitmapDrawable bd = (BitmapDrawable) a.getDrawable(i);
            RoundedBitmapDrawable rbd =
                    RoundedBitmapDrawableFactory.create(getResources(), bd.getBitmap());
            rbd.setCircular(true);
            arFoto[i] = rbd;
        }
        a.recycle();

        for (int i = 0; i < arJudul.length; i++) {
            mList.add(new Univ(arJudul[i], arDeskripsi[i], arFoto[i]));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView)
                MenuItemCompat.getActionView(searchItem);

        searchView.setOnQueryTextListener(
                new SearchView.OnQueryTextListener() {
                    @Override
                    public boolean onQueryTextSubmit(String query) {
                        return false;
                    }

                    @Override
                    public boolean onQueryTextChange(String newText) {
                        mQuery = newText.toLowerCase();
                        doFilter(mQuery);
                        return true;
                    }
                });
        return true;
    }

    private void doFilter(String query) {
        if (!isFiltered) {
            mListAll.clear();
            mListAll.addAll(mList);
            isFiltered = true;
        }

        mList.clear();
        if (query == null || query.isEmpty()) {
            mList.addAll(mListAll);
            isFiltered = false;
        } else {
            mListMapFilter.clear();
            for (int i = 0; i < mListAll.size(); i++) {
                Univ univ = mListAll.get(i);
                if (univ.judul.toLowerCase().contains(query) ||
                        univ.deskripsi.toLowerCase().contains(query)) {
                    mList.add(univ);
                    mListMapFilter.add(i);
                }
            }
        }
        mAdapter.notifyDataSetChanged();
    }
}

