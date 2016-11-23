package id.sch.smktelkom_mlg.project.xiirpl509192939.topuniv.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.project.xiirpl509192939.topuniv.R;
import id.sch.smktelkom_mlg.project.xiirpl509192939.topuniv.model.Univ;

/**
 * Created by Hafizh Subhan Mahdiy on 01/11/2016.
 */

public class UnivAdapter extends RecyclerView.Adapter<UnivAdapter.ViewHolder> {
    ArrayList<Univ> univList;
    IUnivAdapter mIUnivAdapter;

    public UnivAdapter(Context context, ArrayList<Univ> univList) {
        this.univList = univList;
        mIUnivAdapter = (IUnivAdapter) context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_univ, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Univ univ = univList.get(position);
        holder.tvJudul.setText(univ.judul);
        holder.tvDeskripsi.setText(univ.deskripsi);
        holder.ivFoto.setImageURI(Uri.parse(univ.foto));
    }

    @Override
    public int getItemCount() {
        if (univList != null)
            return univList.size();
        return 0;
    }


    public interface IUnivAdapter {
        void doClick(int pos);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView ivFoto;
        TextView tvJudul;
        TextView tvDeskripsi;

        public ViewHolder(View itemView) {
            super(itemView);
            ivFoto = (ImageView) itemView.findViewById(R.id.univ_pict);
            tvJudul = (TextView) itemView.findViewById(R.id.univ);
            tvDeskripsi = (TextView) itemView.findViewById(R.id.univ_desc);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mIUnivAdapter.doClick(getAdapterPosition());
                }
            });
            /*bEdit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mIHotelAdapter.doEdit(getAdapterPosition());
                }
            });
            bDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mIHotelAdapter.doDelete(getAdapterPosition());
                }
            });
            ibFav.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mIHotelAdapter.doFav(getAdapterPosition());
                }
            });
            ibShare.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mIHotelAdapter.doShare(getAdapterPosition());
                }
            });*/
        }
    }
}
