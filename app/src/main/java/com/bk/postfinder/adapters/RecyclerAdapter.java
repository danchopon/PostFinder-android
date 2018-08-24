package com.bk.postfinder.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bk.androidlocation.R;
import com.bk.postfinder.models.PostOfficeModel;
import com.bk.postfinder.views.PostOfficeActivity;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    private static final String TAG = "RecyclerAdapter";

    private Context mContext;
    private List<PostOfficeModel> postOfficeModelList;

    public RecyclerAdapter(Context mContext, List<PostOfficeModel> postOfficeModelList) {
        this.mContext = mContext;
        this.postOfficeModelList = postOfficeModelList;
    }

    @Override
    public RecyclerAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.post_office_row, parent,false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerAdapter.MyViewHolder holder, int position) {

        Log.d(TAG, "onBindViewHolder: called");

        holder.txtPostOfficeName.setText(postOfficeModelList.get(position).getName());
        holder.txtPostOfficeLatitude.setText(postOfficeModelList.get(position).getLatitude());
        holder.txtPostOfficeLongitude.setText(postOfficeModelList.get(position).getLongitude());

        holder.parentLayout.setOnClickListener((view -> {

            Intent intent = new Intent(mContext, PostOfficeActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.putExtra("postOfficeName", postOfficeModelList.get(position).getName());
            intent.putExtra("postOfficeLatitude", postOfficeModelList.get(position).getLatitude());
            intent.putExtra("postOfficeLongitude", postOfficeModelList.get(position).getLongitude());
            mContext.startActivity(intent);

        }));
    }

    @Override
    public int getItemCount() {
        return postOfficeModelList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView txtPostOfficeName, txtPostOfficeLatitude, txtPostOfficeLongitude;
        CardView parentLayout;

        public MyViewHolder(View itemView) {
            super(itemView);
            txtPostOfficeName = (TextView) itemView.findViewById(R.id.txt_postOffice_name);
            txtPostOfficeLatitude = (TextView) itemView.findViewById(R.id.txt_postOffice_latitude);
            txtPostOfficeLongitude = (TextView) itemView.findViewById(R.id.txt_postOffice_longitude);
            parentLayout = (CardView) itemView.findViewById(R.id.parent_layout);
        }

    }
}
