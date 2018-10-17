package Adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.myapplication.LocationChooseActivity;
import com.example.administrator.myapplication.R;

import java.util.List;

import Entity.LocationName;
import Entity.ScrollPage;

public class ScrollPageAdapter extends RecyclerView.Adapter<ScrollPageAdapter.ViewHolder> {

    private List<ScrollPage> list;
   static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView1;
        TextView text1;
        public ViewHolder(View view){
            super(view);
            imageView1=(ImageView) view.findViewById(R.id.image1);

            text1=(TextView)view.findViewById(R.id.text1);
            /*imageView2=(ImageView)view.findViewById(R.id.image2);
            text2=(TextView)view.findViewById(R.id.text2);*/

        }

    }
    public ScrollPageAdapter(List<ScrollPage> list){
        this.list=list;
    }
    @Override
    public ScrollPageAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewtype){
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.scrollbar,parent,false);
        final ScrollPageAdapter.ViewHolder viewHolder=new ScrollPageAdapter.ViewHolder(view);
        viewHolder.imageView1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                int position=viewHolder.getAdapterPosition();
                ScrollPage scrollPage=list.get(position);

                Toast.makeText(view.getContext(),scrollPage.getText1(),Toast.LENGTH_SHORT).show();

            }
        });
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(ScrollPageAdapter.ViewHolder viewHolder, int position){
        ScrollPage scrollPage=list.get(position);
        viewHolder.imageView1.setImageResource(scrollPage.getImageView1());
        viewHolder.text1.setText(scrollPage.getText1());
    }
    @Override
    public int getItemCount(){
        return list.size();
    }

}