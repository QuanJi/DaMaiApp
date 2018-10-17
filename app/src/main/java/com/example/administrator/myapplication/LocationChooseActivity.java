package com.example.administrator.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import Entity.LocationName;

/**
 * Created by Administrator on 2018/10/11.
 */

public class LocationChooseActivity extends AppCompatActivity {
    private List<LocationName> locationList=new ArrayList<>();
    @Override
    public void onCreate(Bundle bundle){
        super.onCreate(bundle);
        setContentView(R.layout.locationchoose);
        initLocation();

        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.location_choose);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
       // layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);
        LocationAdapter adapter=new LocationAdapter(locationList);
        recyclerView.setAdapter(adapter);

    }

    public void initLocation(){
        LocationName yubei=new LocationName("渝北区");
        locationList.add(yubei);
        LocationName jiangbei=new LocationName("江北区");
        locationList.add(jiangbei);
        LocationName qijiang=new LocationName("綦江区");
        locationList.add(qijiang);
        LocationName wanzhou=new LocationName("万州区");
        locationList.add(wanzhou);
        LocationName dazu=new LocationName("大足区");
        locationList.add(dazu);
        LocationName jiangjin=new LocationName("江津区");
        locationList.add(jiangjin);
        LocationName yuzhong=new LocationName("渝中区");
        locationList.add(yuzhong);
        LocationName banan=new LocationName("巴南区");
        locationList.add(banan);
        LocationName yongchuan=new LocationName("永川区");
        locationList.add(yongchuan);
        LocationName hechuan=new LocationName("合川区");
        locationList.add(hechuan);
        LocationName changshou=new LocationName("长寿区");
        locationList.add(changshou);
        LocationName dadukou=new LocationName("大渡口");
        locationList.add(dadukou);
        LocationName wulong=new LocationName("武隆区");
        locationList.add(wulong);
        LocationName jiulongpo=new LocationName("九龙坡");
        locationList.add(jiulongpo);
        LocationName nanan=new LocationName("南岸区");
        locationList.add(nanan);
        LocationName kaizhou=new LocationName("开州区");
        locationList.add(kaizhou);
        LocationName rongchang=new LocationName("荣昌区");
        locationList.add(rongchang);
        LocationName tongliang=new LocationName("铜梁区");
        locationList.add(tongliang);
        LocationName fuling=new LocationName("涪陵区");
        locationList.add(fuling);
        }

    public class LocationAdapter extends RecyclerView.Adapter<LocationAdapter.ViewHolder>  {
        private List<LocationName> locationlist;
        class ViewHolder extends RecyclerView.ViewHolder{
            TextView textView;
            public ViewHolder(View view){
                super(view);
                textView=(TextView)view.findViewById(R.id.location_name);
            }

        }
        public LocationAdapter(List<LocationName> list){
            locationlist=list;
        }
        @Override
        public ViewHolder onCreateViewHolder(final ViewGroup parent, int viewtype){
            View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.location_view,parent,false);
            final ViewHolder viewHolder=new ViewHolder(view);
            viewHolder.textView.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View view) {

                    int position=viewHolder.getAdapterPosition();
                    LocationName locationName=locationlist.get(position);

                    Toast.makeText(view.getContext(),locationName.getName(),Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent();
                    intent.putExtra("locationName",locationName.getName());
                    setResult(RESULT_OK,intent);
                    finish();



                }
            });
            return viewHolder;
        }
        @Override
        public void onBindViewHolder(ViewHolder viewHolder,int position){
            LocationName locationName=locationlist.get(position);
            viewHolder.textView.setText(locationName.getName());
        }
        @Override
        public int getItemCount(){
            return locationlist.size();
        }

    }


}
