package com.haozhuwang.task_code2.fragment;

import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.haozhuwang.task_code2.base.BaseFragment;


/**
 * Created by arldr on 2017/12/17
 * 首页
 */

public class HomeFragment extends BaseFragment {

    private TextView mTextView;

    @Override
    protected View initView() {
        mTextView = new TextView(mContext);
        mTextView.setTextColor(Color.RED);
        mTextView.setTextSize(20);
        mTextView.setGravity(Gravity.CENTER);

        return mTextView;
    }

    @Override
    protected void initData() {
        super.initData();
        mTextView.setText("首页请求数据");
    }
}
