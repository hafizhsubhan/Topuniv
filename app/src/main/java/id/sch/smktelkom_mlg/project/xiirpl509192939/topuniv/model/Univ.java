package id.sch.smktelkom_mlg.project.xiirpl509192939.topuniv.model;

import android.graphics.drawable.Drawable;

/**
 * Created by Hafizh Subhan Mahdiy on 01/11/2016.
 */

public class Univ {
    public String judul;
    public String deskripsi;
    public Drawable foto;

    public Univ(String judul, String deskripsi, Drawable foto) {
        this.judul = judul;
        this.deskripsi = deskripsi;
        this.foto = foto;
    }
}
