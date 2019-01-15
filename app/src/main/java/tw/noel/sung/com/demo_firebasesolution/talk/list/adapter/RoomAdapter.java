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
import tw.noel.sung.com.demo_firebasesolution.talk.list.model.UserList;

/**
 * Created by noel on 2019/1/14.
 */
public class RoomAdapter extends RecyclerView.Adapter<RoomAdapter.ViewHolder> {

    private ArrayList<UserList.RoomsBean> roomsBeans;
    private LayoutInflater layoutInflater;
    private OnItemClickListener onItemClickListener;
    //-------

    public RoomAdapter(Context context) {
        layoutInflater = LayoutInflater.from(context);
        roomsBeans = new ArrayList<>();
    }

    //-------

    public void setData(ArrayList<UserList.RoomsBean> roomsBeans) {
        this.roomsBeans = roomsBeans;
        notifyDataSetChanged();
    }


    //-------
    @NonNull
    @Override
    public RoomAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        return new ViewHolder(layoutInflater.inflate(R.layout.list_room, viewGroup, false));
    }
    //-------

    @Override
    public void onBindViewHolder(@NonNull RoomAdapter.ViewHolder viewHolder, int position) {
        UserList.RoomsBean roomsBean = roomsBeans.get(position);
        viewHolder.textViewName.setText(roomsBean.getRoomId());

    }
    //-------

    @Override
    public int getItemCount() {
        return roomsBeans.size();
    }

    //-------

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.text_view_name)
        TextView textViewName;

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
