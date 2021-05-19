
package ru.iam.pojos_out;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class MyMoveInt {

    @SerializedName("Event-Category")
    private String mEventCategory;
    @SerializedName("Event-Name")
    private String mEventName;
    @SerializedName("message")
    private Message mMessage;

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

}
