package polinema.uts_retrofit.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by aldid on 11/22/2017.
 */

public class PostPutDelPeminjaman {
    @SerializedName("status")
    String status;
    @SerializedName("result")
    Peminjaman mPeminjaman;
    @SerializedName("message")
    String message;
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getMessage() {return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public Peminjaman getPeminjaman() {
        return mPeminjaman;
    }
    public void setPeminjaman(Peminjaman peminjaman) {
        mPeminjaman = peminjaman;
    }
}
