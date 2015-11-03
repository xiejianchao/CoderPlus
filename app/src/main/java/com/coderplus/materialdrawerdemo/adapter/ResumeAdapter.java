package com.coderplus.materialdrawerdemo.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.coderplus.materialdrawerdemo.R;
import com.coderplus.materialdrawerdemo.model.OnItemClickListener;
import com.coderplus.materialdrawerdemo.model.ResumeModel;
import com.coderplus.materialdrawerdemo.utils.Logger;

import java.util.ArrayList;

/**
 * Created by xiejianchao on 2015/10/8.
 */
public class ResumeAdapter extends RecyclerView.Adapter<ResumeAdapter.MyViewHolder> {

    private static final String TAG = "ResumeAdapter";
    private ArrayList<ResumeModel> resumes;

    private OnItemClickListener onItemClicklistener;

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClicklistener = listener;
    }

    public ResumeAdapter(ArrayList<ResumeModel> resumes) {
        this.resumes = resumes;
    }

    public void updateData(ArrayList<ResumeModel> resumes) {
        this.resumes = resumes;
        notifyDataSetChanged();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_item_resume, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder viewHolder, final int position) {
        ResumeModel model = resumes.get(position);
        viewHolder.tvTypeTitle.setText(model.getTitle());
        ArrayList<String> details = model.getDetails();
        viewHolder.tvResumeDetails.setText(null);
        if (details != null && !details.isEmpty()) {
            for (int i = 0; i < details.size(); i++) {
                viewHolder.tvResumeDetails.append(details.get(i));
                Logger.d(TAG,"details : " + details.get(i));
                if (i < details.size() - 1) {
                    viewHolder.tvResumeDetails.append("\n");
                }
            }
        }

        Logger.d(TAG,"onBindViewHolder " + position + " title:" + model.getTitle() + " details:" + model.getDetails());

        if (onItemClicklistener != null) {
            viewHolder.rootView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClicklistener.onItemclick(viewHolder.rootView, position);
                }
            });

        }
    }

    @Override
    public int getItemCount() {
        return resumes == null ? 0 : resumes.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        public View rootView;
        public TextView tvTypeTitle;
        public TextView tvResumeDetails;

        public MyViewHolder(View itemView) {
            super(itemView);
            rootView = (View) itemView.findViewById(R.id.root_view);
            tvTypeTitle = (TextView) itemView.findViewById(R.id.tv_type_title);
            tvResumeDetails = (TextView) itemView.findViewById(R.id.tv_resume_details);


        }
    }

    public void addItemAtIndex(int index, ResumeModel resume) {
        resumes.add(index, resume);
//        notifyDataSetChanged();
        notifyItemInserted(index);
    }
}
