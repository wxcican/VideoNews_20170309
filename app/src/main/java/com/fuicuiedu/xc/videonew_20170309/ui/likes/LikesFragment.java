package com.fuicuiedu.xc.videonew_20170309.ui.likes;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fuicuiedu.xc.videonew_20170309.R;

/**
 * Created by Administrator on 2017/3/15 0015.
 */

public class LikesFragment extends Fragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_test,container,false);
        TextView textView = (TextView) view.findViewById(R.id.fragment_test_tv);
        textView.setText("我的收藏Fragment（待实现）");
        return view;
    }
}
