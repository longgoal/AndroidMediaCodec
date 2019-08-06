package com.yocn.meida.view.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.WindowManager;

import com.yocn.media.R;
import com.yocn.meida.JumpBean;
import com.yocn.meida.codec.jni;
import com.yocn.meida.util.LogUtil;
import com.yocn.meida.view.adapter.MainAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yocn
 */
public class MainActivity extends Activity {
    RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        View rootView = getLayoutInflater().inflate(R.layout.activity_main, null);
        setContentView(rootView);
        initView(rootView);
        initData();
    }

    private void initView(View root) {
        mRecyclerView = root.findViewById(R.id.rv_main);
        LogUtil.d(new jni().stringFromJNI());
    }

    private void initData() {
        List<JumpBean> list = new ArrayList<>();
        list.add(new JumpBean("TextureView预览", PurePreviewActivity.class));
        list.add(new JumpBean("预览并获取数据", PreviewDataActivity.class));
        list.add(new JumpBean("Yuv数据获取", PreviewYUVDataActivity.class));
        list.add(new JumpBean("Native转换Yuv", PreviewNativeYUVActivity.class));
        list.add(new JumpBean("1", PreviewNativeYUVActivity.class));
        list.add(new JumpBean("2", PreviewNativeYUVActivity.class));
        list.add(new JumpBean("", PreviewNativeYUVActivity.class));
        list.add(new JumpBean("", PreviewNativeYUVActivity.class));
        list.add(new JumpBean("", PreviewNativeYUVActivity.class));
        list.add(new JumpBean("", PreviewNativeYUVActivity.class));
        MainAdapter mMainAdapter = new MainAdapter(list);
        mMainAdapter.setmContext(this);
        mRecyclerView.setAdapter(mMainAdapter);
        int spanCount = 1;
        if (list.size() < 6) {
            spanCount = 2;
        } else if (list.size() < 18) {
            spanCount = 3;
        } else {
            spanCount = 4;
        }
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, spanCount));
    }

}
