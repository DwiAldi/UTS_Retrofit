package polinema.uts_retrofit.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by aldid on 11/28/2017.
 */

public class PostPutDelAnggota {
    @SerializedName("status")
    String status;
    @SerializedName("result")
    Anggota mAnggota;
    @SerializedName("message")
    String message;
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public Anggota getAnggota() {
        return mAnggota;
    }
    public void setAnggota(Anggota anggota) {
        mAnggota = anggota;
    }
}
