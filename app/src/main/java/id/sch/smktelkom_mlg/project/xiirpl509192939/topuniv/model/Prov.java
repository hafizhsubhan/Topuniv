package id.sch.smktelkom_mlg.project.xiirpl509192939.topuniv.model;

import java.io.Serializable;

/**
 * Created by Hafizh Subhan Mahdiy on 20/11/2016.
 */

public class Prov implements Serializable {
    public String judul;
    public String deskripsi;
    public String foto;

    public Prov(String judul, String deskripsi, String foto) {
        this.judul = judul;
        this.deskripsi = deskripsi;
        this.foto = foto;
    }
}
