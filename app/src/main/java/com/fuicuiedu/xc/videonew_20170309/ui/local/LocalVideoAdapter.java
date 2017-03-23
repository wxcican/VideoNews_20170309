package com.fuicuiedu.xc.videonew_20170309.ui.local;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CursorAdapter;

/**
 * Created by Administrator on 2017/3/23 0023.
 */

//看类的继承关系，，，ctrl + h

public class LocalVideoAdapter extends CursorAdapter{

    //构造方法（上下文，游标，是否要自动获取数据）
    public LocalVideoAdapter(Context context) {
        super(context, null, true);
    }

    //创建子视图
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return new LocalVideoItem(context);
    }
    //绑定数据
    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        LocalVideoItem item = (LocalVideoItem) view;
        item.bind(cursor);
    }
}
