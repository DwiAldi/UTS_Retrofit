package polinema.uts_retrofit.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by aldid on 11/22/2017.
 */

public class Peminjaman {
    @SerializedName("id_peminjaman")
    private String id_peminjaman;
    @SerializedName("id_anggota")
    private String id_anggota;
    @SerializedName("id_buku")
    private String id_buku;
    @SerializedName("tgl_pinjam")
    private String tgl_pinjam;
    @SerializedName("tgl_kembali")
    private String tgl_kembali;

    public Peminjaman() {
    }

    public Peminjaman(String id_peminjaman, String id_anggota, String id_buku, String tgl_pinjam, String tgl_kembali) {
        this.id_peminjaman = id_peminjaman;
        this.id_anggota = id_anggota;
        this.id_buku = id_buku;
        this.tgl_pinjam = tgl_pinjam;
        this.tgl_kembali = tgl_kembali;
    }

    public String getId_peminjaman() {
        return id_peminjaman;
    }

    public void setId_peminjaman(String id_peminjaman) {
        this.id_peminjaman = id_peminjaman;
    }

    public String getId_anggota() {
        return id_anggota;
    }

    public void setId_anggota(String id_anggota) {
        this.id_anggota = id_anggota;
    }

    public String getId_buku() {
        return id_buku;
    }

    public void setId_buku(String id_buku) {
        this.id_buku = id_buku;
    }

    public String getTgl_pinjam() {
        return tgl_pinjam;
    }

    public void setTgl_pinjam(String tgl_pinjam) {
        this.tgl_pinjam = tgl_pinjam;
    }

    public String getTgl_kembali() {
        return tgl_kembali;
    }

    public void setTgl_kembali(String tgl_kembali) {
        this.tgl_kembali = tgl_kembali;
    }
}
