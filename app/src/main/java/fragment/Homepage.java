package fragment;

import android.content.Intent;
import android.os.Bundle;

import android.os.Handler;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;

import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.myapplication.LocationChooseActivity;
import com.example.administrator.myapplication.R;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import Adapter.ViewPagerAdapter;

/**
 * Created by Administrator on 2018/9/30.
 */

public class Homepage extends android.support.v4.app.Fragment {
    private TextView location;
    private View mView;


    private ViewPager mViewPaper;
    private List<ImageView> images;
    private List<View> dots;
    private int currentItem;
    //记录上一次点的位置
    private int oldPosition = 0;
    //存放图片的id
    private int[] imageIds = new int[]{
            R.drawable.cycle_img1,
            R.drawable.cycle_img2,
            R.drawable.cycle_img3,
            R.drawable.cycle_img4,
    };
    //存放图片的标题
    private String[] titles = new String[]{
            "郭富城",
            "张国荣",
            "刘德华",
            "黎明",
    };
    private TextView title;
    private ViewPagerAdapter adapter;
    private ScheduledExecutorService scheduledExecutorService;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        mView =inflater.inflate(R.layout.homepage,container,false);
       setView();
       return mView;
}


    @Override
    public void onActivityCreated(Bundle bundle){
        super.onActivityCreated(bundle);
        location=(TextView) getActivity().findViewById(R.id.location);
        View.OnClickListener locationOnclick=new View.OnClickListener(){
            @Override
            public void onClick(View v){
                /* You are calling startActivityForResult() from your Fragment. When you do this, the requestCode is changed by the Activity that owns the Fragment.
                If you want to get the correct requestCode in your activity try this:

                Change:
                startActivityForResult(intent, 1);
                To:
                getActivity().startActivityForResult(intent, 1);*/

                Intent intent=new Intent(getActivity(),LocationChooseActivity.class);
                getActivity().startActivityForResult(intent,1);

            }
        };
        location.setOnClickListener(locationOnclick);

    }

    private void setView(){
        mViewPaper = (ViewPager)mView.findViewById(R.id.vp);

        //显示的图片
        images = new ArrayList<ImageView>();
        ImageView imageView;
        for(int i = 0; i < imageIds.length; i++){
             imageView = new ImageView(getActivity());
            imageView.setBackgroundResource(imageIds[i]);
            imageView.setId(imageIds[i]);
            imageView.setOnClickListener(new ImageOnclick());
            images.add(imageView);
        }
        //显示的小点
        dots = new ArrayList<View>();
        dots.add(mView.findViewById(R.id.dot_0));
        dots.add(mView.findViewById(R.id.dot_1));
        dots.add(mView.findViewById(R.id.dot_2));
        dots.add(mView.findViewById(R.id.dot_3));


        title = (TextView) mView.findViewById(R.id.title);
        title.setText(titles[0]);

        adapter = new ViewPagerAdapter(images);
        mViewPaper.setAdapter(adapter);

        mViewPaper.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {


            @Override
            public void onPageSelected(int position) {
                title.setText(titles[position]);
                dots.get(position).setBackgroundResource(R.drawable.black);
                dots.get(oldPosition).setBackgroundResource(R.drawable.point);

                oldPosition = position;
                currentItem = position;
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int arg0) {

            }
        });
    }


    /**
     * 利用线程池定时执行动画轮播
     */
    @Override
    public void onStart() {
        // TODO Auto-generated method stub
        super.onStart();
        scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.scheduleWithFixedDelay(
                new ViewPageTask(),
                2,
                2,
                TimeUnit.SECONDS);
    }
    /**
     * 接收子线程传递过来的数据
     */
    private Handler mHandler = new Handler(){
        public void handleMessage(android.os.Message msg) {
            mViewPaper.setCurrentItem(currentItem);
        };
    };

    /**
     * 图片轮播任务
     * @author liuyazhuang
     *
     */
    private class ViewPageTask implements Runnable{

        @Override
        public void run() {
            currentItem = (currentItem + 1) % imageIds.length;
            mHandler.sendEmptyMessage(0);
        }
    }


    @Override
    public void onStop() {
        // TODO Auto-generated method stub
        super.onStop();
        if(scheduledExecutorService != null){
            scheduledExecutorService.shutdown();
            scheduledExecutorService = null;
        }
    }

    public class ImageOnclick implements View.OnClickListener{
@Override
        public void onClick(View view){




    switch (view.getId()) {
        case R.drawable.cycle_img1:
            Toast.makeText(view.getContext(), "图片1被点击", Toast.LENGTH_SHORT).show();
            break;
        case R.drawable.cycle_img2:
            Toast.makeText(view.getContext(), "图片2被点击", Toast.LENGTH_SHORT).show();
            break;
        case R.drawable.cycle_img3:
            Toast.makeText(view.getContext(), "图片3被点击", Toast.LENGTH_SHORT).show();
            break;
        case R.drawable.cycle_img4:
            Toast.makeText(view.getContext(), "图片4被点击", Toast.LENGTH_SHORT).show();

            break;
        default:
    }
}
    }



}
