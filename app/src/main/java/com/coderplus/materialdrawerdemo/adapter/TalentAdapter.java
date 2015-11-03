package com.coderplus.materialdrawerdemo.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.coderplus.materialdrawerdemo.R;
import com.coderplus.materialdrawerdemo.model.CoderModel;
import com.coderplus.materialdrawerdemo.model.OnItemClickListener;

import java.util.ArrayList;

/**
 * Created by xiejianchao on 2015/10/8.
 */
public class TalentAdapter extends RecyclerView.Adapter<TalentAdapter.MyViewHolder> {

    private ArrayList<CoderModel> coders;

    private OnItemClickListener onItemClicklistener;

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClicklistener = listener;
    }

    public TalentAdapter(ArrayList<CoderModel> coders) {
        this.coders = coders;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardview_item_talent, parent, false);
        view.setPadding(0, 0, 0, 10);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder viewHolder, final int position) {
        viewHolder.tvName.setText(coders.get(position).getName());
        viewHolder.tvJobType.setText(coders.get(position).getJobType());
        viewHolder.ivCover.setImageResource(coders.get(position).getCoverResId());

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
        return coders.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        public CardView mCardView;
        private ImageView ivCover;
        public TextView tvName;
        public TextView tvJobType
                ;
        public MyViewHolder(View itemView) {
            super(itemView);
            mCardView = (CardView) itemView.findViewById(R.id.card_view);
            ivCover = (ImageView) itemView.findViewById(R.id.iv_cover);
            tvName = (TextView) itemView.findViewById(R.id.tv_count);
            tvJobType = (TextView) itemView.findViewById(R.id.tv_job_type);
        }
    }

    public void addItemAtIndex(int index, CoderModel coder) {
        coders.add(index, coder);
//        notifyDataSetChanged();
        notifyItemInserted(index);
    }

}
