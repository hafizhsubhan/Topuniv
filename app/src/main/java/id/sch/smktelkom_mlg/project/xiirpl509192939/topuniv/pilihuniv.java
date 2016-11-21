package id.sch.smktelkom_mlg.project.xiirpl509192939.topuniv;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.project.xiirpl509192939.topuniv.adapter.UnivAdapter;
import id.sch.smktelkom_mlg.project.xiirpl509192939.topuniv.model.Prov;
import id.sch.smktelkom_mlg.project.xiirpl509192939.topuniv.model.Univ;

public class pilihuniv extends AppCompatActivity {

    ArrayList<Univ> mList = new ArrayList<>();
    UnivAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pilihuniv);

        Prov prov = (Prov) getIntent().getSerializableExtra(home.PROV);
        setTitle(prov.judul);

        ImageView ivFoto = (ImageView) findViewById(R.id.univ_pict);
        ivFoto.setImageURI(Uri.parse(prov.foto));
        TextView tvDeskripsi = (TextView) findViewById(R.id.univ_desc);
        tvDeskripsi.setText(prov.deskripsi);

        /*RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new UnivAdapter(mList);
        recyclerView.setAdapter(mAdapter);

        fillData();*/
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
}

