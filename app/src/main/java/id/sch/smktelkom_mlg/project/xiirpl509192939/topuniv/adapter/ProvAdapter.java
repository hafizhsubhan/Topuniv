package id.sch.smktelkom_mlg.project.xiirpl509192939.topuniv.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.project.xiirpl509192939.topuniv.R;
import id.sch.smktelkom_mlg.project.xiirpl509192939.topuniv.model.Prov;

/**
 * Created by Hafizh Subhan Mahdiy on 20/11/2016.
 */

public class ProvAdapter extends RecyclerView.Adapter<ProvAdapter.ViewHolder> {
    ArrayList<Prov> provList;
    IProvAdapter mIProvAdapter;

    public ProvAdapter(Context context, ArrayList<Prov> provList) {
        this.provList = provList;
        mIProvAdapter = (IProvAdapter) context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_prov, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Prov prov = provList.get(position);
        holder.tvJudul.setText(prov.judul);
        holder.tvDeskripsi.setText(prov.deskripsi);
        holder.ivFoto.setImageURI(Uri.parse(prov.foto));
    }

    @Override
    public int getItemCount() {
        if (provList != null)
            return provList.size();
        return 0;
    }

    public interface IProvAdapter {
        void doClick(int pos);

        /*void doEdit(int pos);

        void doDelete(int pos);

        void doFav(int pos);

        void doShare(int pos);*/
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView ivFoto;
        TextView tvJudul;
        TextView tvDeskripsi;
        Button bMore;

        public ViewHolder(View itemView) {
            super(itemView);
            ivFoto = (ImageView) itemView.findViewById(R.id.prov_pict);
            tvJudul = (TextView) itemView.findViewById(R.id.prov);
            tvDeskripsi = (TextView) itemView.findViewById(R.id.prov_desc);
            bMore = (Button) itemView.findViewById(R.id.readMore);

            bMore.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    mIProvAdapter.doClick(pos);
                }
            });
           /* bEdit.setOnClickListener(new View.OnClickListener() {
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
