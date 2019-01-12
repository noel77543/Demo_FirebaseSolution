package tw.noel.sung.com.demo_firebasesolution.db.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import tw.noel.sung.com.demo_firebasesolution.R;
import tw.noel.sung.com.demo_firebasesolution.db.model.FirebaseData;

public class MyFirebaseDataBaseAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<FirebaseData> firebaseDataArrayList;
    private LayoutInflater layoutInflater;

    //-------

    public MyFirebaseDataBaseAdapter(Context context) {
        layoutInflater = LayoutInflater.from(context);
        firebaseDataArrayList = new ArrayList<>();
    }

    //-------

    public void setData(ArrayList<FirebaseData> firebaseDataArrayList) {
        this.firebaseDataArrayList = firebaseDataArrayList;
        notifyDataSetChanged();
    }


    //-------
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        return new ViewHolder(layoutInflater.inflate(R.layout.list_data, viewGroup, false));
    }
    //-------

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        FirebaseData firebaseData = firebaseDataArrayList.get(position);
        if (viewHolder instanceof ViewHolder) {
            ViewHolder holder = (ViewHolder) viewHolder;


        }
    }
    //-------

    @Override
    public int getItemCount() {
        return firebaseDataArrayList.size();
    }

    //-------


    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewName;
        public TextView textViewAge;

        public ViewHolder(View v) {
            super(v);
            textViewName = (TextView) v.findViewById(R.id.text_view_name);
            textViewAge = (TextView) v.findViewById(R.id.text_view_age);

        }
    }

}
