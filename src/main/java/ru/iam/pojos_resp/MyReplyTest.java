
package ru.iam.pojos_resp;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class MyReplyTest {

    @SerializedName("App-Name")
    private String mAppName = "bp1c";
    @SerializedName("App-Version")
    private String mAppVersion = "4.0.0";
    @SerializedName("Event-Category")
    private String mEventCategory = "sync_resp_category";
    @SerializedName("Event-Name")
    private String mEventName = "sync_resp_envent_name";
    @SerializedName("message")
    private Message mMessage;
    @SerializedName("Msg-ID")
    private String mMsgID;

    @JsonProperty("App-Name")
    public String getAppName() {
        return mAppName;
    }

    public void setAppName(String appName) {
        mAppName = appName;
    }

    @JsonProperty("App-Version")
    public String getAppVersion() {
        return mAppVersion;
    }

    public void setAppVersion(String appVersion) {
        mAppVersion = appVersion;
    }

    @JsonProperty("Event-Category")
    public String getEventCategory() {
        return mEventCategory;
    }

    public void setEventCategory(String eventCategory) {
        mEventCategory = eventCategory;
    }

    @JsonProperty("Event-Name")
    public String getEventName() {
        return mEventName;
    }

    public void setEventName(String eventName) {
        mEventName = eventName;
    }

    public Message getMessage() {
        return mMessage;
    }

    public void setMessage(Message message) {
        mMessage = message;
    }

    @JsonProperty("Msg-ID")
    public String getMsgID() {
        return mMsgID;
    }

    public void setMsgID(String msgID) {
        mMsgID = msgID;
    }

}
