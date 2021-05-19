
package ru.iam.pojos_out;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Worker {

    @SerializedName("worker_name")
    private String mWorkerName;
    @SerializedName("worker_syncid")
    private String mWorkerSyncid;

    @JsonProperty("worker_name")
    public String getWorkerName() {
        return mWorkerName;
    }

    public void setWorkerName(String workerName) {
        mWorkerName = workerName;
    }

    @JsonProperty("worker_syncid")
    public String getWorkerSyncid() {
        return mWorkerSyncid;
    }

    public void setWorkerSyncid(String workerSyncid) {
        mWorkerSyncid = workerSyncid;
    }

}
