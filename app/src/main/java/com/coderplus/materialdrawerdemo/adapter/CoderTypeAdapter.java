package com.coderplus.materialdrawerdemo.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.coderplus.materialdrawerdemo.R;
import com.coderplus.materialdrawerdemo.model.CoderTypeModel;
import com.coderplus.materialdrawerdemo.model.OnItemClickListener;

import java.util.ArrayList;

/**
 * Created by xiejianchao on 2015/10/8.
 */
public class CoderTypeAdapter extends RecyclerView.Adapter<CoderTypeAdapter.MyViewHolder> {

    private static final String TAG = CoderTypeAdapter.class.getSimpleName();
    private ArrayList<CoderTypeModel> coderTypes;
    private Context context;
    private OnItemClickListener onItemClicklistener;

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClicklistener = listener;
    }


    public CoderTypeAdapter(ArrayList<CoderTypeModel> coderTypes) {
        this.coderTypes = coderTypes;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(context)
                .inflate(R.layout.cardview_item_coder_type, parent, false);
        view.setPadding(0, 0, 0, 10);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder viewHolder, final int position) {

        viewHolder.tvJobType.setText(coderTypes.get(position).getName());
        viewHolder.tvJobCount.setText("10");
        viewHolder.ivCover.setImageResource(coderTypes.get(position).getCoverResId());

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
        return coderTypes.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        public CardView mCardView;
        private ImageView ivCover;
        public TextView tvJobCount;
        public TextView tvJobType
                ;
        public MyViewHolder(View itemView) {
            super(itemView);
            mCardView = (CardView) itemView.findViewById(R.id.card_view);
            ivCover = (ImageView) itemView.findViewById(R.id.iv_cover);
            tvJobCount = (TextView) itemView.findViewById(R.id.tv_count);
            tvJobType = (TextView) itemView.findViewById(R.id.tv_job_type);
        }
    }

    public void addItemAtIndex(int index, CoderTypeModel type) {
        coderTypes.add(index, type);
//        notifyDataSetChanged();
        notifyItemInserted(index);
    }
}
