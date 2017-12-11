package polinema.uts_retrofit;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import polinema.uts_retrofit.Model.Peminjaman;

/**
 * Created by aldid on 12/11/2017.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    List<Peminjaman> mPeminjamanList;
    public MyAdapter(List<Peminjaman> peminjamanList) {
        mPeminjamanList = peminjamanList;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
        MyViewHolder mViewHolder = new MyViewHolder(mView);
        return mViewHolder;
    }
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.mTextViewIdPeminjaman.setText("ID Peminjaman : "+mPeminjamanList.get(position).getId_peminjaman());
        holder.mTextViewIdAnggota.setText("ID Anggota : "+mPeminjamanList.get(position).getId_anggota());
        holder.mTextViewIdBuku.setText("ID Buku : "+mPeminjamanList.get(position).getId_buku());
        holder.mTextViewTglPinjam.setText("Tanggal Pinjam : "+mPeminjamanList.get(position).getTgl_pinjam());
        holder.mTextViewTglKembali.setText("Tanggal Kembali : "+mPeminjamanList.get(position).getTgl_kembali());
    }
    @Override
    public int getItemCount() {
        return mPeminjamanList.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextViewIdPeminjaman, mTextViewIdAnggota,
                mTextViewIdBuku,mTextViewTglPinjam,mTextViewTglKembali;
        public MyViewHolder(View itemView) {
            super(itemView);
            mTextViewIdPeminjaman = (TextView) itemView.findViewById(R.id.tvIdPeminjaman);
            mTextViewIdAnggota = (TextView) itemView.findViewById(R.id.tvIdAnggota);
            mTextViewIdBuku = (TextView) itemView.findViewById(R.id.tvIdBuku);
            mTextViewTglPinjam = (TextView) itemView.findViewById(R.id.tvTanggalPinjam);
            mTextViewTglKembali = (TextView) itemView.findViewById(R.id.tvTanggalKembali);
        }
    }
}
