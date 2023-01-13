
package ru.iam.pojos_resp;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Message {

    @SerializedName("msgBody")
    private MsgBody mMsgBody;

    public MsgBody getMsgBody() {
        return mMsgBody;
    }

    public void setMsgBody(MsgBody msgBody) {
        mMsgBody = msgBody;
    }

}
