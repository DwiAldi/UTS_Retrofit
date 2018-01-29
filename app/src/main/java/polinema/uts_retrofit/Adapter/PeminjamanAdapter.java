package polinema.uts_retrofit.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import polinema.uts_retrofit.Model.Buku;
import polinema.uts_retrofit.Model.Peminjaman;
import polinema.uts_retrofit.R;

/**
 * Created by aldid on 1/27/2018.
 */

public class PeminjamanAdapter extends RecyclerView.Adapter<PeminjamanAdapter.MyViewHolder> {

    List<Peminjaman> mPeminjamanList;

    public PeminjamanAdapter(List<Peminjaman> mPeminjamanList) {
        this.mPeminjamanList = mPeminjamanList;
    }

    @Override
    public PeminjamanAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_peminjaman, parent, false);
        PeminjamanAdapter.MyViewHolder mViewHolder = new PeminjamanAdapter.MyViewHolder(mView);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(PeminjamanAdapter.MyViewHolder holder, int position) {
        holder.mTexViewIdPeminjaman.setText("ID Peminjaman : "+ mPeminjamanList.get(position).getId_peminjaman());
        holder.mTextViewIdAngota.setText("ID Anggota : " + mPeminjamanList.get(position).getId_anggota());
        holder.mTextViewIdBuku.setText("ID Buku : " + mPeminjamanList.get(position).getId_buku());
        holder.mTextViewTanggalPinjam.setText("Tanggal Pinjam : " + mPeminjamanList.get(position).getTgl_pinjam());
        holder.getmTextViewTanggalKembali.setText("Tanggal Kembali : " + mPeminjamanList.get(position).getTgl_kembali());
    }

    @Override
    public int getItemCount() {
        return mPeminjamanList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView mTexViewIdPeminjaman , mTextViewIdAngota , mTextViewIdBuku , mTextViewTanggalPinjam , getmTextViewTanggalKembali;

        public MyViewHolder(View itemView) {
            super(itemView);
            mTexViewIdPeminjaman = itemView.findViewById(R.id.tvIdPeminjaman);
            mTextViewIdAngota = itemView.findViewById(R.id.tvIdAnggotaPeminjaman);
            mTextViewIdBuku = itemView.findViewById(R.id.tvIdBukuPeminjaman);
            mTextViewTanggalPinjam = itemView.findViewById(R.id.tvTanggalPinjam);
            getmTextViewTanggalKembali = itemView.findViewById(R.id.tvTanggalKembali);
        }
    }

}
