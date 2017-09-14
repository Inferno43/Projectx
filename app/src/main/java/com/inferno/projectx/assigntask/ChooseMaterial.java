package com.inferno.projectx.assigntask;


import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.inferno.projectx.BaseFragment;
import com.inferno.projectx.ChooseItem;
import com.inferno.projectx.R;
import com.inferno.projectx.model.ContractorModel;
import com.inferno.projectx.model.MaterialModel;
import com.inferno.projectx.model.WorkerModel;
import com.inferno.projectx.toolbox.AppConstants;
import com.inferno.projectx.toolbox.NetworkService;
import com.inferno.projectx.toolbox.ServerConstants;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class ChooseMaterial extends BaseFragment {
    private View rootView;
    private Context context;
    private RecyclerView materialListView;
    private RecyclerView.LayoutManager mLayoutManager;
    private ChooseMaterialAdapter mAdapter;

    Retrofit retrofit;
    NetworkService networkService;
    private ArrayList<MaterialModel> materialArrayList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

            Log.i("WorkerModel",""+((ContractorModel)getArguments().get(AppConstants.EXTRA_CONTRACTOR)).getContractorName());//test log
            Log.i("WorkerModel",""+((ArrayList<WorkerModel>)getArguments().get(AppConstants.EXTRA_WORKER_LIST)).get(0).getWorkerName());//test log
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.choose_material, container, false);
        context = getActivity();
        setHasOptionsMenu(true);

        retrofit = new Retrofit.Builder()
                .baseUrl(ServerConstants.SERVER_BASEURL)
                .build();
        networkService = retrofit.create(NetworkService.class);
        materialListView = (RecyclerView) rootView.findViewById(R.id.addmaterialsList);
        mLayoutManager = new LinearLayoutManager(context);
        materialListView.setLayoutManager(mLayoutManager);
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        getMaterialList();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

        inflater.inflate(R.menu.chooseworker, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.done:
                /*Bundle extras = new Bundle();
                extras.putParcelableArrayList(AppConstants.EXTRA_WORKER_LIST,getSelectedMaterials(materialArrayList));
                extras.putParcelable(AppConstants.EXTRA_CONTRACTOR, (Parcelable) getArguments().get(AppConstants.EXTRA_CONTRACTOR));
                startFrgament(getFragmentManager(),new ChooseMaterial(),false,extras);*/
                break;

        }
        return true;

    }

    void getMaterialList(){
        try{
            networkService.getAllResources().enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    try {
                        JSONObject reponseBody = new JSONObject(response.body().string());
                        if(reponseBody.has("materials")){
                            JSONArray materials = reponseBody.getJSONArray("materials");
                            materialArrayList = new ArrayList<>();
                            for(int i=0;i<materials.length();i++) {
                                JSONObject materialObject = materials.getJSONObject(i);
                                materialArrayList.add(new MaterialModel(materialObject.getInt("mid"),materialObject.getString("material_name"),
                                        materialObject.getString("material_unit"), materialObject.getString("material_price"),
                                        materialObject.getString("picture"),false));
                            }
                            mAdapter = new ChooseMaterialAdapter(context, materialArrayList, new ChooseItem() {
                                @Override
                                public void onItemClicked(int position, boolean isSelected) {
                                    materialArrayList.get(position).setMaterialSelected(isSelected);
                                    Toast.makeText(context,""+materialArrayList.get(position).getMaterialName(),Toast.LENGTH_LONG).show();
                                }

                            });
                            materialListView.setAdapter(mAdapter);
                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    }catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {

                }
            });
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    ArrayList<MaterialModel> getSelectedMaterials(ArrayList<MaterialModel> materialArrayList){
        ArrayList<MaterialModel> selectedMaterialsList = new ArrayList<>();
        for(MaterialModel workerModel:materialArrayList){
            if (workerModel.isMaterialSelected())
                selectedMaterialsList.add(workerModel);
        }
        return  selectedMaterialsList;
    }

}
