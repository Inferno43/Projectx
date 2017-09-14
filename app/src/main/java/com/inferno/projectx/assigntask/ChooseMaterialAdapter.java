package com.inferno.projectx.assigntask;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.inferno.projectx.ChooseItem;
import com.inferno.projectx.R;
import com.inferno.projectx.model.MaterialModel;

import java.util.ArrayList;

import io.realm.Realm;

/**
 * Created by saravana.subramanian on 9/14/17.
 */

public class ChooseMaterialAdapter extends RecyclerView.Adapter<ChooseMaterialAdapter.ViewHolder> {

    private ArrayList<MaterialModel> materialList;
    private Context context;
    ChooseItem onClickListener;

    public ChooseMaterialAdapter(Context context, ArrayList<MaterialModel>  materialList, ChooseItem onClickListener) {
        this.materialList = materialList;
        this.context = context;
        this.onClickListener = onClickListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{


        private CardView mItemContainer;
        private TextView materialName;
        private ImageView image;
        private TextView units;
        private TextView price;

        private ViewHolder(View itemView) {
            super(itemView);

            mItemContainer = (CardView) itemView.findViewById(R.id.item_container);
            materialName = (TextView) itemView.findViewById(R.id.name);
            units = (TextView) itemView.findViewById(R.id.units);
            price = (TextView) itemView.findViewById(R.id.price);
            image = (ImageView)itemView.findViewById(R.id.image);
        }
    }

    @Override
    public ChooseMaterialAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.material_list_item, parent, false);
        return new ChooseMaterialAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ChooseMaterialAdapter.ViewHolder holder, final int position) {

        if(null != materialList){
            holder.materialName.setText(materialList.get(position).getMaterialName());
            holder.units.setText(materialList.get(position).getMaterialUnit());
            holder.price.setText(materialList.get(position).getMaterialUnitPrice());
            holder.image.setImageDrawable(null);
        }else{
            //
        }
        holder.mItemContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            materialList.get(position).setMaterialSelected(!materialList.get(position).isMaterialSelected());
            holder.itemView.setBackgroundColor(materialList.get(position).isMaterialSelected() ? Color.YELLOW : Color.WHITE);

            onClickListener.onItemClicked(position,materialList.get(position).isMaterialSelected());
            }
        });


    }

    @Override
    public int getItemCount() {
        if(null != materialList)
            return materialList.size();
        else
            return 0;

    }
}
