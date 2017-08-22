package com.inferno.projectx.workers;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.inferno.projectx.BaseActivity;
import com.inferno.projectx.OnclickListener;
import com.inferno.projectx.R;
import com.inferno.projectx.contractors.AddContractor;
import com.inferno.projectx.contractors.ContractAdapter;
import com.inferno.projectx.model.ContractorModel;
import com.inferno.projectx.model.WorkerModel;
import com.inferno.projectx.toolbox.AppConstants;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmList;

public class WorkerList extends BaseActivity {

    private Context context;
    private Realm realm;
    private RealmList<WorkerModel> workerList;
    private RecyclerView workerListView;
    private RecyclerView.LayoutManager mLayoutManager;
    private WorkerAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.worker_list);
        context = this;
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        workerListView = (RecyclerView) findViewById(R.id.workerList);
        mLayoutManager = new LinearLayoutManager(this);
        workerListView.setLayoutManager(mLayoutManager);

        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder().build();
        realm = Realm.getInstance(realmConfiguration);

        Log.i("WorkerModel",""+realm.where(WorkerModel.class).count());


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(AddWorker.class,null, AppConstants.VIEW_ADD_WORKER);
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
                workerList = new RealmList<>();
                workerList.addAll(realm.where(WorkerModel.class).findAll());
                mAdapter = new WorkerAdapter(context, workerList, new OnclickListener() {
                    @Override
                    public void onClick(int position) {

                    }
                });

                for(WorkerModel workerModel:workerList){
                    Log.i("WorkerModel",workerModel.toString());//test log
                }
                workerListView.setAdapter(mAdapter);
            }

        }catch (Exception e){
        }
    }
}
