package com.inferno.projectx.materials;

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
import com.inferno.projectx.model.MaterialModel;
import com.inferno.projectx.model.WorkerModel;
import com.inferno.projectx.toolbox.AppConstants;
import com.inferno.projectx.workers.WorkerAdapter;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmList;

public class MaterialList extends BaseActivity {
    private Context context;
    private Realm realm;
    //private RealmList<MaterialModel> materialList;
    private RecyclerView materialListView;
    private RecyclerView.LayoutManager mLayoutManager;
    private MaterialAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.material_list);
        context = this;
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        materialListView = (RecyclerView) findViewById(R.id.materialList);
        mLayoutManager = new LinearLayoutManager(this);
        materialListView.setLayoutManager(mLayoutManager);

        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder().build();
        realm = Realm.getInstance(realmConfiguration);

        //Log.i("WorkerModel",""+realm.where(WorkerModel.class).count());


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(AddMaterial.class,null, AppConstants.VIEW_ADD_MATERIAL);
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
               /* materialList = new RealmList<>();
                materialList.addAll(realm.where(MaterialModel.class).findAll());
                mAdapter = new MaterialAdapter(context, materialList, new OnclickListener() {
                    @Override
                    public void onClick(int position) {

                    }
                });

                for(MaterialModel materialModel:materialList){
                    Log.i("materialModel",materialModel.toString());//test log
                }
                materialListView.setAdapter(mAdapter);*/
            }

        }catch (Exception e){
        }
    }
}
