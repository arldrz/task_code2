package com.haozhuwang.task_code2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioGroup;

import com.haozhuwang.task_code2.base.BaseFragment;
import com.haozhuwang.task_code2.fragment.HomeFragment;
import com.haozhuwang.task_code2.fragment.LiveFragment;
import com.haozhuwang.task_code2.fragment.MyFragment;
import com.haozhuwang.task_code2.fragment.WishFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity {

    private RadioGroup mRadioGroup;
    private List<BaseFragment> mBaseFragment;
    private int position;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initFragment();
        setListener();
    }

    private void setListener() {
        mRadioGroup.setOnCheckedChangeListener(new MyOnCheckedChangeListener());
        mRadioGroup.check(R.id.home);
    }

    public BaseFragment getFragment() {
        BaseFragment fragment = mBaseFragment.get(position);
        return fragment;
    }

    class MyOnCheckedChangeListener implements RadioGroup.OnCheckedChangeListener {

        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
            switch (checkedId) {
                case R.id.home_bg:
                    position = 0;
                    break;
                case R.id.wish_bg:
                    position = 1;
                    break;
                case R.id.live_bg:
                    position = 2;
                    break;
                case R.id.my_bg:
                    position = 3;
                    break;
                default:
            }
            BaseFragment fragment=getFragment();
            switchFragment(fragment);
        }
    }

    private void switchFragment(BaseFragment fragment) {
        //打到管理器
        FragmentManager sm = getSupportFragmentManager();
        //开启事务
        FragmentTransaction bt = sm.beginTransaction();
        //替换
        bt.replace(R.id.fl_content,fragment);
        bt.commit();

    }

    private void initFragment() {
        mBaseFragment = new ArrayList<>();
        mBaseFragment.add(new HomeFragment());
        mBaseFragment.add(new LiveFragment());
        mBaseFragment.add(new MyFragment());
        mBaseFragment.add(new WishFragment());
    }

    private void initView() {
        mRadioGroup = (RadioGroup) findViewById(R.id.rg_main);

    }
}
