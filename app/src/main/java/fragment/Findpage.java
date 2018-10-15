package fragment;


import android.os.Bundle;

import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.myapplication.R;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/9/30.
 */

public class Findpage extends Fragment {




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup containter, Bundle bundle) {
        View view = inflater.inflate(R.layout.findpage, containter, false);
        return view;
    }
}
