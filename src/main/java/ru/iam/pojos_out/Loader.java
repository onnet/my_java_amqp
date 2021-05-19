
package ru.iam.pojos_out;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Loader {

    @SerializedName("loader_name")
    private String mLoaderName;
    @SerializedName("loader_syncid")
    private String mLoaderSyncid;

    @JsonProperty("loader_name")
    public String getLoaderName() {
        return mLoaderName;
    }

    public void setLoaderName(String loaderName) {
        mLoaderName = loaderName;
    }

    @JsonProperty("loader_syncid")
    public String getLoaderSyncid() {
        return mLoaderSyncid;
    }

    public void setLoaderSyncid(String loaderSyncid) {
        mLoaderSyncid = loaderSyncid;
    }

}
