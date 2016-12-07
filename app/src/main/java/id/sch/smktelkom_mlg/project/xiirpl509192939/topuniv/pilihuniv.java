package id.sch.smktelkom_mlg.project.xiirpl509192939.topuniv;

import android.content.ContentResolver;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
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

public class pilihuniv extends AppCompatActivity implements UnivAdapter.IUnivAdapter {

    public static final String UNIV = "univ";
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

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView2);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new UnivAdapter(this, mList);
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
        String[] arJudul = resource.getStringArray(R.array.univ);
        String[] arDeskripsi = resource.getStringArray(R.array.prov_desc);
        String[] arDetail = resource.getStringArray(R.array.prov_desc);
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
            mList.add(new Univ(arJudul[i], arDeskripsi[i], arDetail[i], arFoto[i]));
        }
        mAdapter.notifyDataSetChanged();
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

    @Override
    public void doClick(int pos) {
        Intent intent = new Intent(this, detail_univ.class);
        intent.putExtra(UNIV, mList.get(pos));
        startActivity(intent);
    }
}

