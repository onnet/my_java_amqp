
package ru.iam.pojos_out;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class MsgBody {

    @SerializedName("move_int")
    private MoveInt mMoveInt;

    @JsonProperty("move_int")
    public MoveInt getMoveInt() {
        return mMoveInt;
    }

    public void setMoveInt(MoveInt moveInt) {
        mMoveInt = moveInt;
    }

}
