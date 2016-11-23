package id.sch.smktelkom_mlg.project.xiirpl509192939.topuniv.model;

import java.io.Serializable;

/**
 * Created by Hafizh Subhan Mahdiy on 01/11/2016.
 */

public class Univ implements Serializable {
    public String judul;
    public String deskripsi;
    public String foto;
    public String detail;

    public Univ(String judul, String deskripsi, String detail, String foto) {
        this.judul = judul;
        this.detail = detail;
        this.deskripsi = deskripsi;
        this.foto = foto;
    }

}
