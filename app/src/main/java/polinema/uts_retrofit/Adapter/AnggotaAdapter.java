package polinema.uts_retrofit.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import polinema.uts_retrofit.AnggotaDetailActivity;
import polinema.uts_retrofit.Model.Anggota;
import polinema.uts_retrofit.Model.Peminjaman;
import polinema.uts_retrofit.R;

/**
 * Created by aldid on 12/11/2017.
 */

public class AnggotaAdapter extends RecyclerView.Adapter<AnggotaAdapter.MyViewHolder> {
    List<Anggota> mAnggotaList;
    Context ctx;
//    Context mContext;
//    private OnItemClickListener mListener;

//    public interface OnItemClickListener{
//        void onItemClick(int position);
//    }
//
//    public AnggotaAdapter(List<Anggota> mAnggotaList, Context mContext) {
//        this.mAnggotaList = mAnggotaList;
//        this.mContext = mContext;
//    }

//    public void setOnClickListener(OnItemClickListener listener){
//        mListener = listener;
//    }

    public AnggotaAdapter(List<Anggota> mAnggotaList , Context ctx) {
        this.mAnggotaList = mAnggotaList;
        this.ctx = ctx;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_anggota,parent,false);
        AnggotaAdapter.MyViewHolder mViewHolder = new AnggotaAdapter.MyViewHolder(mView, ctx, mAnggotaList);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
//        Anggota currentItem = mAnggotaList.get(position);
//        String id = currentItem.getId_anggota();
//        String nama = currentItem.getNama();
//        String alamat = currentItem.getAlamat();
//        String nomor = currentItem.getNo_telp();


        holder.mTextViewIdAnggota.setText("ID Keanggotaan : "+mAnggotaList.get(position).getId_anggota());
        holder.mTextViewNamaAnggota.setText("Nama Anggota : "+mAnggotaList.get(position).getNama());
        holder.mTextViewAlamatAnggota.setText("Alamat Anggota : "+mAnggotaList.get(position).getAlamat());
        holder.mTextViewNomorTelepon.setText("Nomor Telepon : "+mAnggotaList.get(position).getNo_telp());
    }

    @Override
    public int getItemCount() {
        return mAnggotaList.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView mTextViewIdAnggota, mTextViewNamaAnggota, mTextViewAlamatAnggota, mTextViewNomorTelepon;
        List<Anggota> anggotas = new List<Anggota>() {
            @Override
            public int size() {
                return mAnggotaList.size();
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @NonNull
            @Override
            public Iterator<Anggota> iterator() {
                return null;
            }

            @NonNull
            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @NonNull
            @Override
            public <T> T[] toArray(@NonNull T[] ts) {
                return null;
            }

            @Override
            public boolean add(Anggota anggota) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(@NonNull Collection<?> collection) {
                return false;
            }

            @Override
            public boolean addAll(@NonNull Collection<? extends Anggota> collection) {
                return false;
            }

            @Override
            public boolean addAll(int i, @NonNull Collection<? extends Anggota> collection) {
                return false;
            }

            @Override
            public boolean removeAll(@NonNull Collection<?> collection) {
                return false;
            }

            @Override
            public boolean retainAll(@NonNull Collection<?> collection) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public boolean equals(Object o) {
                return false;
            }

            @Override
            public int hashCode() {
                return 0;
            }

            @Override
            public Anggota get(int i) {
                return null;
            }

            @Override
            public Anggota set(int i, Anggota anggota) {
                return null;
            }

            @Override
            public void add(int i, Anggota anggota) {

            }

            @Override
            public Anggota remove(int i) {
                return null;
            }

            @Override
            public int indexOf(Object o) {
                return 0;
            }

            @Override
            public int lastIndexOf(Object o) {
                return 0;
            }

            @Override
            public ListIterator<Anggota> listIterator() {
                return null;
            }

            @NonNull
            @Override
            public ListIterator<Anggota> listIterator(int i) {
                return null;
            }

            @NonNull
            @Override
            public List<Anggota> subList(int i, int i1) {
                return null;
            }
        };
        Context ctx;
        public MyViewHolder(View itemView , Context ctx , List<Anggota> anggotas) {
            super(itemView);
            itemView.setOnClickListener(this);
            this.anggotas = anggotas;
            this.ctx = ctx;
            mTextViewIdAnggota = (TextView) itemView.findViewById(R.id.tvIdAnggota);
            mTextViewNamaAnggota = itemView.findViewById(R.id.tvNamaAnggota);
            mTextViewAlamatAnggota = itemView.findViewById(R.id.tvAlamatAnggota);
            mTextViewNomorTelepon = itemView.findViewById(R.id.tvNomorTeleponAnggota);
//
//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    if (mListener != null){
//                        int position = getAdapterPosition();
//                        if (position != RecyclerView.NO_POSITION){
//                            mListener.onItemClick(position);
//                        }
//                    }
//                }
//            });
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            Anggota anggota = this.anggotas.get(position);
            Intent i = new Intent(ctx, AnggotaDetailActivity.class);
            i.putExtra("id", anggota.getId_anggota());
            i.putExtra("nama", anggota.getNama());
            i.putExtra("alamat", anggota.getAlamat());
            i.putExtra("notelp", anggota.getNo_telp());
            this.ctx.startActivity(i);
        }
    }
}
