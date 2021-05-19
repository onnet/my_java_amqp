
package ru.iam.pojos_out;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class MoveInt {

    @SerializedName("action")
    private String mAction;
    @SerializedName("action_date")
    private String mActionDate;
    @SerializedName("begin_cell")
    private String mBeginCell;
    @SerializedName("begin_tier")
    private String mBeginTier;
    @SerializedName("container")
    private Container mContainer;
    @SerializedName("end_cell")
    private String mEndCell;
    @SerializedName("end_tier")
    private String mEndTier;
    @SerializedName("from_wh")
    private String mFromWh;
    @SerializedName("loader")
    private Loader mLoader;
    @SerializedName("move_syncid")
    private String mMoveSyncid;
    @SerializedName("move_time")
    private String mMoveTime;
    @SerializedName("move_type")
    private String mMoveType;
    @SerializedName("terminal_syncid")
    private String mTerminalSyncid;
    @SerializedName("to_wh")
    private String mToWh;
    @SerializedName("work_cnt_syncid")
    private Object mWorkCntSyncid;
    @SerializedName("work_type")
    private String mWorkType;
    @SerializedName("worker")
    private Worker mWorker;

    public String getAction() {
        return mAction;
    }

    public void setAction(String action) {
        mAction = action;
    }

    @JsonProperty("action_date")
    public String getActionDate() {
        return mActionDate;
    }

    public void setActionDate(String actionDate) {
        mActionDate = actionDate;
    }

    @JsonProperty("begin_cell")
    public String getBeginCell() {
        return mBeginCell;
    }

    public void setBeginCell(String beginCell) {
        mBeginCell = beginCell;
    }

    @JsonProperty("begin_tier")
    public String getBeginTier() {
        return mBeginTier;
    }

    public void setBeginTier(String beginTier) {
        mBeginTier = beginTier;
    }

    public Container getContainer() {
        return mContainer;
    }

    public void setContainer(Container container) {
        mContainer = container;
    }

    @JsonProperty("end_cell")
    public String getEndCell() {
        return mEndCell;
    }

    public void setEndCell(String endCell) {
        mEndCell = endCell;
    }

    @JsonProperty("end_tier")
    public String getEndTier() {
        return mEndTier;
    }

    public void setEndTier(String endTier) {
        mEndTier = endTier;
    }

    @JsonProperty("from_wh")
    public String getFromWh() {
        return mFromWh;
    }

    public void setFromWh(String fromWh) {
        mFromWh = fromWh;
    }

    public Loader getLoader() {
        return mLoader;
    }

    public void setLoader(Loader loader) {
        mLoader = loader;
    }

    @JsonProperty("move_syncid")
    public String getMoveSyncid() {
        return mMoveSyncid;
    }

    public void setMoveSyncid(String moveSyncid) {
        mMoveSyncid = moveSyncid;
    }

    @JsonProperty("move_time")
    public String getMoveTime() {
        return mMoveTime;
    }

    public void setMoveTime(String moveTime) {
        mMoveTime = moveTime;
    }

    @JsonProperty("move_type")
    public String getMoveType() {
        return mMoveType;
    }

    public void setMoveType(String moveType) {
        mMoveType = moveType;
    }

    @JsonProperty("terminal_syncid")
    public String getTerminalSyncid() {
        return mTerminalSyncid;
    }

    public void setTerminalSyncid(String terminalSyncid) {
        mTerminalSyncid = terminalSyncid;
    }

    @JsonProperty("to_wh")
    public String getToWh() {
        return mToWh;
    }

    public void setToWh(String toWh) {
        mToWh = toWh;
    }

    @JsonProperty("work_cnt_syncid")
    public Object getWorkCntSyncid() {
        return mWorkCntSyncid;
    }

    public void setWorkCntSyncid(Object workCntSyncid) {
        mWorkCntSyncid = workCntSyncid;
    }

    @JsonProperty("work_type")
    public String getWorkType() {
        return mWorkType;
    }

    public void setWorkType(String workType) {
        mWorkType = workType;
    }

    public Worker getWorker() {
        return mWorker;
    }

    public void setWorker(Worker worker) {
        mWorker = worker;
    }

}
