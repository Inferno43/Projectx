package com.inferno.projectx.workers;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.inferno.projectx.OnclickListener;
import com.inferno.projectx.R;
import com.inferno.projectx.model.WorkerModel;
import com.inferno.projectx.toolbox.ServerConstants;

import java.util.ArrayList;

import io.realm.RealmList;

/**
 * Created by saravana.subramanian on 8/22/17.
 */

public class WorkerAdapter extends RecyclerView.Adapter<WorkerAdapter.ViewHolder> {

    private ArrayList<WorkerModel> workerList;
    private Context context;
    OnclickListener onClickListener;

    public WorkerAdapter(Context context, ArrayList<WorkerModel>  workerList, OnclickListener onClickListener) {
        this.workerList = workerList;
        this.context = context;
        this.onClickListener = onClickListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{


        private CardView mItemContainer;
        private TextView name;
        private ImageView image;
        private TextView address;

        private ViewHolder(View itemView) {
            super(itemView);

            mItemContainer = (CardView) itemView.findViewById(R.id.item_container);
            name = (TextView) itemView.findViewById(R.id.name);
            address = (TextView) itemView.findViewById(R.id.address);
            image = (ImageView)itemView.findViewById(R.id.image);
        }
    }

    @Override
    public WorkerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.worker_list_item, parent, false);
        return new WorkerAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final WorkerAdapter.ViewHolder holder, final int position) {

        if(null != workerList){
            holder.name.setText(workerList.get(position).getWorkerName());
            holder.address.setText(workerList.get(position).getWorkerAddress());
            Glide.with(context)
                    .load(ServerConstants.SERVER_BASEURL+workerList.get(position).getWorkerImageURL().substring(1))
                    .into(holder.image);
        }else{
            //
        }
        holder.mItemContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickListener.onClick(position);
            }
        });


    }

    @Override
    public int getItemCount() {
        if(null != workerList)
            return workerList.size();
        else
            return 0;

    }
}
