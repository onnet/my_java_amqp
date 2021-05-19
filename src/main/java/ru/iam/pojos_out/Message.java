
package ru.iam.pojos_out;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Message {

    @SerializedName("classId")
    private String mClassId;
    @SerializedName("messageHeader")
    private MessageHeader mMessageHeader;
    @SerializedName("msgBody")
    private MsgBody mMsgBody;

    public String getClassId() {
        return mClassId;
    }

    public void setClassId(String classId) {
        mClassId = classId;
    }

    public MessageHeader getMessageHeader() {
        return mMessageHeader;
    }

    public void setMessageHeader(MessageHeader messageHeader) {
        mMessageHeader = messageHeader;
    }

    public MsgBody getMsgBody() {
        return mMsgBody;
    }

    public void setMsgBody(MsgBody msgBody) {
        mMsgBody = msgBody;
    }

}
