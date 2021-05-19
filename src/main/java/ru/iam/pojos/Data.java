
package ru.iam.pojos;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("Event")
    private Event mEvent;

    public Event getEvent() {
        return mEvent;
    }

    public void setEvent(Event event) {
        mEvent = event;
    }

}
