package com.inferno.projectx.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by saravana.subramanian on 8/22/17.
 */

public class WorkerModel  extends RealmObject {

    @PrimaryKey
    private int nid;
    private String workerName;
    private String workerPhone;
    private String workerAddress;
    private String workerImageURL;

    public WorkerModel(int nid, String workerName, String workerPhone, String workerAddress, String workerImageURL) {
        this.nid = nid;
        this.workerName = workerName;
        this.workerPhone = workerPhone;
        this.workerAddress = workerAddress;
        this.workerImageURL = workerImageURL;
    }

    public WorkerModel() {
    }

    public int getNid() {
        return nid;
    }

    public void setNid(int nid) {
        this.nid = nid;
    }

    public String getWorkerName() {
        return workerName;
    }

    public void setWorkerName(String workerName) {
        this.workerName = workerName;
    }

    public String getWorkerPhone() {
        return workerPhone;
    }

    public void setWorkerPhone(String workerPhone) {
        this.workerPhone = workerPhone;
    }

    public String getWorkerAddress() {
        return workerAddress;
    }

    public void setWorkerAddress(String workerAddress) {
        this.workerAddress = workerAddress;
    }

    public String getWorkerImageURL() {
        return workerImageURL;
    }

    public void setWorkerImageURL(String workerImageURL) {
        this.workerImageURL = workerImageURL;
    }
}
