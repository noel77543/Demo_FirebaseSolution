package tw.noel.sung.com.demo_firebasesolution.talk.list.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import tw.noel.sung.com.demo_firebasesolution.R;
import tw.noel.sung.com.demo_firebasesolution.talk.list.board.model.Navigation;

/**
 * Created by noel on 2019/1/14.
 */
public class RoomAdapter extends RecyclerView.Adapter<RoomAdapter.ViewHolder> {

    private ArrayList<Navigation.BoardBean> boardBeans;
    private LayoutInflater layoutInflater;
    private OnItemClickListener onItemClickListener;
    //-------

    public RoomAdapter(Context context) {
        layoutInflater = LayoutInflater.from(context);
        boardBeans = new ArrayList<>();
    }

    //-------

    public void setData(ArrayList<Navigation.BoardBean> boardBeans) {
        this.boardBeans = boardBeans;
        notifyDataSetChanged();
    }


    //-------
    @NonNull
    @Override
    public RoomAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        return new ViewHolder(layoutInflater.inflate(R.layout.list_data, viewGroup, false));
    }
    //-------

    @Override
    public void onBindViewHolder(@NonNull RoomAdapter.ViewHolder viewHolder, int position) {
        Navigation.BoardBean boardBean = boardBeans.get(position);
        viewHolder.textViewMessage.setText(boardBean.getMessage());
        viewHolder.textViewName.setText(boardBean.getName());
        viewHolder.textViewTime.setText(boardBean.getTime());
    }
    //-------

    @Override
    public int getItemCount() {
        return boardBeans.size();
    }

    //-------

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.text_view_name)
        TextView textViewName;
        @BindView(R.id.text_view_message)
        TextView textViewMessage;
        @BindView(R.id.text_view_time)
        TextView textViewTime;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (onItemClickListener != null) {
                onItemClickListener.onItemClicked(v, getLayoutPosition());
            }
        }
    }

    //--------------------

    public interface OnItemClickListener {
        void onItemClicked(View view, int position);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
}
