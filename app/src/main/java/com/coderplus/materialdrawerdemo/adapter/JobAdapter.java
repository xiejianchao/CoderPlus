package com.coderplus.materialdrawerdemo.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.coderplus.materialdrawerdemo.R;
import com.coderplus.materialdrawerdemo.model.JobModel;
import com.coderplus.materialdrawerdemo.model.OnItemClickListener;

import java.util.ArrayList;

/**
 * Created by xiejianchao on 2015/10/8.
 */
public class JobAdapter extends RecyclerView.Adapter<JobAdapter.MyViewHolder> {

    private ArrayList<JobModel> jobs;

    private OnItemClickListener onItemClicklistener;

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClicklistener = listener;
    }

    public JobAdapter(ArrayList<JobModel> jobs) {
        this.jobs = jobs;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardview_item_jobs, parent, false);
        view.setPadding(0, 0, 0, 10);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder viewHolder, final int position) {
        viewHolder.ivCompnayLogo.setImageResource(jobs.get(position).getCompanyLogoResId());
        viewHolder.tvJobTitle.setText(jobs.get(position).getJobTitle());
        viewHolder.tvCompanyName.setText(jobs.get(position).getCompany());
        viewHolder.tvJobSalary.setText(jobs.get(position).getSalary() + "k");
        viewHolder.tvJobIntroduction.setText(jobs.get(position).getJobIntroduction());
        viewHolder.tvJobPublishDate.setText(jobs.get(position).getPublishDate());

        if (onItemClicklistener != null) {
            viewHolder.mCardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClicklistener.onItemclick(viewHolder.mCardView, position);
                }
            });

        }
    }

    @Override
    public int getItemCount() {
        return jobs.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        public CardView mCardView;
        private ImageView ivCompnayLogo;
        public TextView tvJobTitle;
        public TextView tvCompanyName;
        public TextView tvJobSalary;
        public TextView tvJobIntroduction;
        public TextView tvJobPublishDate;
                ;
        public MyViewHolder(View itemView) {
            super(itemView);
            mCardView = (CardView) itemView.findViewById(R.id.card_view);
            ivCompnayLogo = (ImageView) itemView.findViewById(R.id.iv_company_logo);
            tvJobTitle = (TextView) itemView.findViewById(R.id.tv_job_title);
            tvCompanyName = (TextView) itemView.findViewById(R.id.tv_company_name);
            tvJobSalary = (TextView) itemView.findViewById(R.id.tv_job_salary);
            tvJobIntroduction = (TextView) itemView.findViewById(R.id.tv_job_introduction);
            tvJobPublishDate = (TextView) itemView.findViewById(R.id.tv_job_publish_date);

        }
    }

    public void addItemAtIndex(int index, JobModel job) {
        jobs.add(index, job);
//        notifyDataSetChanged();
        notifyItemInserted(index);
    }
}
