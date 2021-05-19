
package ru.iam.pojos_out;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Container {

    @SerializedName("cnt_number")
    private String mCntNumber;
    @SerializedName("cnt_syncid")
    private String mCntSyncid;

    @JsonProperty("cnt_number")
    public String getCntNumber() {
        return mCntNumber;
    }

    public void setCntNumber(String cntNumber) {
        mCntNumber = cntNumber;
    }

    @JsonProperty("cnt_syncid")
    public String getCntSyncid() {
        return mCntSyncid;
    }

    public void setCntSyncid(String cntSyncid) {
        mCntSyncid = cntSyncid;
    }

}
