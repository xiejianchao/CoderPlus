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
import com.coderplus.materialdrawerdemo.model.DatingModel;
import com.coderplus.materialdrawerdemo.model.OnItemClickListener;

import java.util.ArrayList;

/**
 * Created by xiejianchao on 2015/10/8.
 */
public class DatingAdapter extends RecyclerView.Adapter<DatingAdapter.MyViewHolder> {

    private static final String TAG = DatingAdapter.class.getSimpleName();
    private ArrayList<DatingModel> datingList;
    private Context context;
    private OnItemClickListener onItemClicklistener;

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClicklistener = listener;
    }


    public DatingAdapter(ArrayList<DatingModel> datingList) {
        this.datingList = datingList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(context)
                .inflate(R.layout.cardview_item_dating, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder viewHolder, final int position) {

        DatingModel coderType = datingList.get(position);

        viewHolder.tvJobCount.setText(coderType.getTitle());
        viewHolder.ivCover.setImageResource(datingList.get(position).getCoverResId());

        if (onItemClicklistener != null) {
            viewHolder.mCardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClicklistener.onItemclick(viewHolder.mCardView, position);
                }
            });

            viewHolder.getLayoutPosition();

        }

    }

    @Override
    public int getItemCount() {
        return datingList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        public CardView mCardView;
        private ImageView ivCover;
        public TextView tvJobCount;

        public MyViewHolder(View itemView) {
            super(itemView);
            mCardView = (CardView) itemView.findViewById(R.id.card_view);
            ivCover = (ImageView) itemView.findViewById(R.id.iv_cover);
            tvJobCount = (TextView) itemView.findViewById(R.id.tv_dating_title);
        }
    }

    public void addItemAtIndex(int index, DatingModel model) {
        datingList.add(index, model);
//        notifyDataSetChanged();
        notifyItemInserted(index);
    }
}
