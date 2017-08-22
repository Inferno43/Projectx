package com.inferno.projectx.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by saravana.subramanian on 8/21/17.
 */

public class ContractorModel extends RealmObject {

    @PrimaryKey
    private int nid;
    private String contractorName;
    private String contractorPhone;
    private String contractorAddress;
    private String contractorImageURL;


    public ContractorModel(int nid, String contractorName, String contractorPhone, String contractorAddress, String contractorImageURL) {
        this.nid = nid;
        this.contractorName = contractorName;
        this.contractorPhone = contractorPhone;
        this.contractorAddress = contractorAddress;
        this.contractorImageURL = contractorImageURL;
    }

    public ContractorModel() {
    }

    public int getNid() {
        return nid;
    }

    public void setNid(int nid) {
        this.nid = nid;
    }

    public String getContractorName() {
        return contractorName;
    }

    public void setContractorName(String contractorName) {
        this.contractorName = contractorName;
    }

    public String getContractorPhone() {
        return contractorPhone;
    }

    public void setContractorPhone(String contractorPhone) {
        this.contractorPhone = contractorPhone;
    }

    public String getContractorAddress() {
        return contractorAddress;
    }

    public void setContractorAddress(String contractorAddress) {
        this.contractorAddress = contractorAddress;
    }

    public String getContractorImageURL() {
        return contractorImageURL;
    }

    public void setContractorImageURL(String contractorImageURL) {
        this.contractorImageURL = contractorImageURL;
    }
}
