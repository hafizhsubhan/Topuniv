package id.sch.smktelkom_mlg.project.xiirpl509192939.topuniv;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.project.xiirpl509192939.topuniv.model.Univ;

public class pilihuniv extends RecyclerView.Adapter<pilihuniv.ViewHolder> {


    ArrayList<Univ> univList;

    public pilihuniv(ArrayList<Univ> hotelList) {
        this.univList = hotelList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.pilihuniv, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Univ univ = univList.get(position);
        holder.tvJudul.setText(univ.judul);
        holder.tvDeskripsi.setText(univ.deskripsi);
        holder.ivFoto.setImageDrawable(univ.foto);
    }

    @Override
    public int getItemCount() {
        if (univList != null)
            return univList.size();
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivFoto;
        TextView tvJudul;
        TextView tvDeskripsi;

        public ViewHolder(View itemView) {
            super(itemView);

            ivFoto = (ImageView) itemView.findViewById(R.id.imageView);
            tvJudul = (TextView) itemView.findViewById(R.id.textViewJudul);
            tvDeskripsi = (TextView) itemView.findViewById(R.id.textViewDeskripsi);
        }
    }
}

