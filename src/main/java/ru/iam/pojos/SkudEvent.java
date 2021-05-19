
package ru.iam.pojos;

import javax.annotation.Generated;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.google.gson.annotations.SerializedName;

public class SkudEvent {

    @SerializedName("action")
    private String mAction;
    @SerializedName("App-Name")
    @JacksonXmlProperty(localName = "App-Name")
    private String mAppName;
    @SerializedName("App-Version")
    @JacksonXmlProperty(localName = "App-Version")
    private String mAppVersion;
    @SerializedName("ClassId")
    @JacksonXmlProperty(localName = "ClassId")
    private Long mClassId;
    @SerializedName("Data")
    private Data mData;
    @SerializedName("Event-Category")
    @JacksonXmlProperty(localName = "Event-Category")
    private String mEventCategory;
    @SerializedName("Event-Name")
    private String mEventName;
    @SerializedName("Msg-ID")
    private String mMsgID;
    @SerializedName("Node")
    @JacksonXmlProperty(localName = "Node")
    private String mNode;

    public String getAction() {
        return mAction;
    }

    public void setAction(String action) {
        mAction = action;
    }

    public String getAppName() {
        return mAppName;
    }

    public void setAppName(String appName) {
        mAppName = appName;
    }

    public String getAppVersion() {
        return mAppVersion;
    }

    public void setAppVersion(String appVersion) {
        mAppVersion = appVersion;
    }

    public Long getClassId() {
        return mClassId;
    }

    public void setClassId(Long classId) {
        mClassId = classId;
    }

    public Data getData() {
        return mData;
    }

    public void setData(Data data) {
        mData = data;
    }

    public String getEventCategory() {
        return mEventCategory;
    }

    public void setEventCategory(String eventCategory) {
        mEventCategory = eventCategory;
    }

    public String getEventName() {
        return mEventName;
    }

    public void setEventName(String eventName) {
        mEventName = eventName;
    }

    public String getMsgID() {
        return mMsgID;
    }

    public void setMsgID(String msgID) {
        mMsgID = msgID;
    }

    public String getNode() {
        return mNode;
    }

    public void setNode(String node) {
        mNode = node;
    }

}
