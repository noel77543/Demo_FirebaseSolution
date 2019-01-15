package tw.noel.sung.com.demo_firebasesolution.talk.list.board.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import tw.noel.sung.com.demo_firebasesolution.R;
import tw.noel.sung.com.demo_firebasesolution.talk.list.board.model.Board;

/**
 * Created by noel on 2019/1/12.
 */
public class TalkBoardAdapter extends RecyclerView.Adapter<TalkBoardAdapter.ViewHolder> {

    private ArrayList<Board> boards;
    private LayoutInflater layoutInflater;
    private OnItemClickListener onItemClickListener;
    //-------

    public TalkBoardAdapter(Context context) {
        layoutInflater = LayoutInflater.from(context);
        boards = new ArrayList<>();
    }

    //-------

    public void setData(ArrayList<Board> boards) {
        if(boards != null){
            this.boards = boards;
            notifyDataSetChanged();
        }
    }


    //-------
    @NonNull
    @Override
    public TalkBoardAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        return new ViewHolder(layoutInflater.inflate(R.layout.list_message, viewGroup, false));
    }

    //-------

    @Override
    public void onBindViewHolder(@NonNull TalkBoardAdapter.ViewHolder viewHolder, int position) {
        Board board = boards.get(position);
        viewHolder.textViewMessage.setText(board.getMessage());
        viewHolder.textViewName.setText(board.getName());
        viewHolder.textViewTime.setText(board.getTime());
    }
    //-------

    @Override
    public int getItemCount() {
        return boards.size();
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
