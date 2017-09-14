package com.inferno.projectx.contractors;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.inferno.projectx.BaseActivity;
import com.inferno.projectx.OnclickListener;
import com.inferno.projectx.R;
import com.inferno.projectx.model.ContractorModel;
import com.inferno.projectx.toolbox.AppConstants;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmList;

public class ContractorList extends BaseActivity {

    private Context context;
    private Realm realm;
    //private RealmList<ContractorModel> contractorList;
    private RecyclerView contractorListView;
    private RecyclerView.LayoutManager mLayoutManager;
    private ContractAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contractor_list);
        context = this;
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        contractorListView = (RecyclerView) findViewById(R.id.contractorList);
        mLayoutManager = new LinearLayoutManager(this);
        contractorListView.setLayoutManager(mLayoutManager);

        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder().build();
        realm = Realm.getInstance(realmConfiguration);

       // Log.i("ContractorModel",""+realm.where(ContractorModel.class).count());


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(AddContractor.class,null, AppConstants.VIEW_ADD_CONTRACTOR);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        showList();
    }

    void showList(){
        try{
            if(!realm.isEmpty()){
                /*contractorList = new RealmList<>();
                contractorList.addAll(realm.where(ContractorModel.class).findAll());
                mAdapter = new ContractAdapter(context, contractorList, new OnclickListener() {
                    @Override
                    public void onClick(int position) {

                    }
                });

                for(ContractorModel contractorModel:contractorList){
                    Log.i("contractorModel",contractorModel.toString());//test log
                }
                contractorListView.setAdapter(mAdapter);*/
            }

        }catch (Exception e){
        }
    }
}
