package fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.myapplication.R;

/**
 * Created by Administrator on 2018/10/11.
 */

public class BottomNavigation extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup containter, Bundle bundle){
        View view=inflater.inflate(R.layout.bottomnavigation,containter,false);
        return view;
    }
}
