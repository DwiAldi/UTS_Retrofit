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
import polinema.uts_retrofit.BukuDetailActivity;
import polinema.uts_retrofit.Model.Anggota;
import polinema.uts_retrofit.Model.Buku;
import polinema.uts_retrofit.R;

/**
 * Created by aldid on 1/27/2018.
 */

public class BukuAdapter extends RecyclerView.Adapter<BukuAdapter.MyViewHolder> {
    List<Buku> mBukuList;
    Context ctx;

//    public BukuAdapter(List<Buku> mBukuList) {
//        this.mBukuList = mBukuList;
//    }


    public BukuAdapter(List<Buku> mBukuList, Context ctx) {
        this.mBukuList = mBukuList;
        this.ctx = ctx;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_buku, parent, false);
        BukuAdapter.MyViewHolder mViewHolder = new BukuAdapter.MyViewHolder(mView, ctx, mBukuList);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.mTextViewIdBuku.setText("ID Buku : " + mBukuList.get(position).getId_buku());
        holder.mTextViewNamaBuku.setText("Nama Buku : " + mBukuList.get(position).getNama_buku());
        holder.mTextViewPenulis.setText("Nama Penulis : " + mBukuList.get(position).getPenulis());
        holder.mTextViewPenerbit.setText("Nama Penerbit : " + mBukuList.get(position).getPenerbit());
    }

    @Override
    public int getItemCount() {
        return mBukuList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView mTextViewIdBuku, mTextViewNamaBuku, mTextViewPenulis, mTextViewPenerbit;
        List<Buku> bukus = new List<Buku>() {
            @Override
            public int size() {
                return mBukuList.size();
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
            public Iterator<Buku> iterator() {
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
            public boolean add(Buku buku) {
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
            public boolean addAll(@NonNull Collection<? extends Buku> collection) {
                return false;
            }

            @Override
            public boolean addAll(int i, @NonNull Collection<? extends Buku> collection) {
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
            public Buku get(int i) {
                return null;
            }

            @Override
            public Buku set(int i, Buku buku) {
                return null;
            }

            @Override
            public void add(int i, Buku buku) {

            }

            @Override
            public Buku remove(int i) {
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
            public ListIterator<Buku> listIterator() {
                return null;
            }

            @NonNull
            @Override
            public ListIterator<Buku> listIterator(int i) {
                return null;
            }

            @NonNull
            @Override
            public List<Buku> subList(int i, int i1) {
                return null;
            }
        };
        Context ctx;

        public MyViewHolder(View itemView, Context ctx, List<Buku> bukus) {
            super(itemView);
            itemView.setOnClickListener(this);
            this.bukus = bukus;
            this.ctx = ctx;
            mTextViewIdBuku = (TextView) itemView.findViewById(R.id.tvIdBuku);
            mTextViewNamaBuku = itemView.findViewById(R.id.tvNamaBuku);
            mTextViewPenulis = itemView.findViewById(R.id.tvPenulisBuku);
            mTextViewPenerbit = itemView.findViewById(R.id.tvPenerbitBuku);
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
            Buku buku = this.bukus.get(position);
            Intent i = new Intent(ctx, BukuDetailActivity.class);
            i.putExtra("id", buku.getId_buku());
            i.putExtra("nama", buku.getNama_buku());
            i.putExtra("penulis", buku.getPenulis());
            i.putExtra("penerbit", buku.getPenerbit());
            this.ctx.startActivity(i);
        }
    }
}