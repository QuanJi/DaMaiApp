package fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.myapplication.R;

/**
 * Created by Administrator on 2018/9/30.
 */

public class Ticketpage extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup containter, Bundle bundle){
        View view=inflater.inflate(R.layout.ticketpage,containter,false);
        return view;
    }
}
