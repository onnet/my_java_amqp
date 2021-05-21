package ru.iam.pojos;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.google.gson.annotations.SerializedName;

public class SkudEvent {

    @SerializedName("action")
    private String mAction;
    @SerializedName("App-Name")
    private String mAppName;
    @SerializedName("App-Version")
    private String mAppVersion;
    @SerializedName("ClassId")
    private Long mClassId;
    @SerializedName("Data")
    private Data mData;
    @SerializedName("Event-Category")
    private String mEventCategory;
    @SerializedName("Event-Name")
    private String mEventName;
    @SerializedName("Msg-ID")
    private String mMsgID;
    @SerializedName("Node")
    private String mNode;

    public String getAction() {
        return mAction;
    }

    public void setAction(String action) {
        mAction = action;
    }

    @JsonProperty("App-Name")
    @JacksonXmlProperty(localName = "App-Name")
    public String getAppName() {
        return mAppName;
    }

    public void setAppName(String appName) {
        mAppName = appName;
    }

    @JsonProperty("App-Version")
    @JacksonXmlProperty(localName = "App-Version")
    public String getAppVersion() {
        return mAppVersion;
    }

    public void setAppVersion(String appVersion) {
        mAppVersion = appVersion;
    }

    @JacksonXmlProperty(localName = "ClassId")
    public Long getClassId() {
        return mClassId;
    }

    public void setClassId(Long classId) {
        mClassId = classId;
    }

    @JacksonXmlProperty(localName = "Data")
    public Data getData() {
        return mData;
    }

    public void setData(Data data) {
        mData = data;
    }

    @JsonProperty("Event-Category")
    @JacksonXmlProperty(localName = "Event-Category")
    public String getEventCategory() {
        return mEventCategory;
    }

    public void setEventCategory(String eventCategory) {
        mEventCategory = eventCategory;
    }

    @JsonProperty("Event-Name")
    @JacksonXmlProperty(localName = "Event-Name")
    public String getEventName() {
        return mEventName;
    }

    public void setEventName(String eventName) {
        mEventName = eventName;
    }

    @JsonProperty("Msg-ID")
    @JacksonXmlProperty(localName = "Msg-ID")
    public String getMsgID() {
        return mMsgID;
    }

    public void setMsgID(String msgID) {
        mMsgID = msgID;
    }

    @JacksonXmlProperty(localName = "Node")
    public String getNode() {
        return mNode;
    }

    public void setNode(String node) {
        mNode = node;
    }

}
