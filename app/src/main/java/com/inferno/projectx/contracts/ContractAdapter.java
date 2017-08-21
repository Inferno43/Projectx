package com.inferno.projectx.contracts;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.inferno.projectx.OnclickListener;
import com.inferno.projectx.R;
import com.inferno.projectx.model.ContractorModel;

import java.util.ArrayList;
import java.util.HashMap;

import io.realm.RealmList;

/**
 * Created by saravana.subramanian on 8/21/17.
 */

public class ContractAdapter  extends RecyclerView.Adapter<ContractAdapter.ViewHolder> {

    private RealmList<ContractorModel> contractorList;
    private Context context;
    OnclickListener onClickListener;

    public ContractAdapter(Context context, RealmList<ContractorModel>  contractorList, OnclickListener onClickListener) {
        this.contractorList = contractorList;
        this.context = context;
        this.onClickListener = onClickListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{


        private CardView mItemContainer;
        private TextView name;
        private ImageView image;
        private TextView description;

        private ViewHolder(View itemView) {
            super(itemView);

            mItemContainer = (CardView) itemView.findViewById(R.id.item_container);
            name = (TextView) itemView.findViewById(R.id.name);
            description = (TextView) itemView.findViewById(R.id.description);
            image = (ImageView)itemView.findViewById(R.id.image);
        }
    }

    @Override
    public ContractAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.contractor_item, parent, false);
        return new ContractAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ContractAdapter.ViewHolder holder, final int position) {

        if(null != contractorList){
                holder.name.setText(contractorList.get(position).getName());
                holder.description.setText(contractorList.get(position).getDescription());
                holder.image.setImageDrawable(null);
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
        if(null != contractorList)
            return contractorList.size();
        else
            return 0;

    }
}