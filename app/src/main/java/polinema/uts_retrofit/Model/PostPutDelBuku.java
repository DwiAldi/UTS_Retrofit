package polinema.uts_retrofit.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by aldid on 11/28/2017.
 */

public class PostPutDelBuku {
    @SerializedName("status")
    String status;
    @SerializedName("result")
    Buku mBuku;
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
    public Buku getBuku() {
        return mBuku;
    }
    public void setBuku(Buku buku) {
        mBuku = buku;
    }
}
