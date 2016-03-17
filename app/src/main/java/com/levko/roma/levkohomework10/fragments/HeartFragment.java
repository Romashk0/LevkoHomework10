package com.levko.roma.levkohomework10.fragments;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;

import com.levko.roma.levkohomework10.R;

/**
 * Created by User on 16.03.2016.
 */
public class HeartFragment extends Fragment implements View.OnClickListener, SeekBar.OnSeekBarChangeListener {

    private View mViewHeart;
    private Animation mAnimation;
    private ImageView ivVisible, ivRotate, ivScale;
    private SeekBar sbVisible, sbRotate, sbScale;
    private LinearLayout llVisible, llRotate, llScale;
    private boolean isVisibleShow = false, isRotateShow = false, isScaleShow = false;
    private AnimatorSet firstAnim, secondAnim;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.heart_fragment, container, false);
        findViews(view);
        setOnListeners();
        startAnimation(mViewHeart);
        return view;
    }

    private void setOnListeners() {
        ivVisible.setOnClickListener(this);
        ivRotate.setOnClickListener(this);
        ivScale.setOnClickListener(this);

        sbVisible.setOnSeekBarChangeListener(this);
        sbRotate.setOnSeekBarChangeListener(this);
        sbScale.setOnSeekBarChangeListener(this);
    }

    private void findViews(View view) {
        mViewHeart = (View) view.findViewById(R.id.heart_HF);

        ivVisible = (ImageView) view.findViewById(R.id.iv_visible_HF);
        ivRotate = (ImageView) view.findViewById(R.id.iv_rotate_HF);
        ivScale = (ImageView) view.findViewById(R.id.iv_scale_HF);

        sbVisible = (SeekBar) view.findViewById(R.id.sb_visible_HF);
        sbRotate = (SeekBar) view.findViewById(R.id.sb_rotate_HF);
        sbScale = (SeekBar) view.findViewById(R.id.sb_scale_HF);

        llVisible = (LinearLayout) view.findViewById(R.id.ll_visible_HF);
        llRotate = (LinearLayout) view.findViewById(R.id.ll_rotate_HF);
        llScale = (LinearLayout) view.findViewById(R.id.ll_scale_HF);
    }

    private void startAnimation(View v) {
        mAnimation = AnimationUtils.loadAnimation(this.getActivity(), R.anim.heart);
        v.startAnimation(mAnimation);
    }


    private void setAnim(LinearLayout container, SeekBar seekBar, Boolean state) {
        if (state) {
            final ObjectAnimator objAnim =
                    ObjectAnimator.ofFloat(container, "translationX", 0.0f, -seekBar.getWidth());
            objAnim.setDuration(1000);
            objAnim.start();
        } else {
            final ObjectAnimator objAnim =
                    ObjectAnimator.ofFloat(container, "translationX", -seekBar.getWidth(), 0.0f);
            objAnim.setDuration(1000);
            objAnim.start();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_visible_HF:
                setAnim(llVisible, sbVisible, isVisibleShow);
                isVisibleShow = !isVisibleShow;
                break;
            case R.id.iv_rotate_HF:
                setAnim(llRotate, sbRotate, isRotateShow);
                isRotateShow = !isRotateShow;
                break;
            case R.id.iv_scale_HF:
                setAnim(llScale, sbScale, isScaleShow);
                isScaleShow = !isScaleShow;
                break;
        }
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

        switch (seekBar.getId()) {
            case R.id.sb_visible_HF:
                mViewHeart.setAlpha(progress / 100.0f);
                break;
            case R.id.sb_rotate_HF:
                mViewHeart.setRotation(progress);
                break;
            case R.id.sb_scale_HF:
                mViewHeart.setScaleX(progress / 100.0f);
                mViewHeart.setScaleY(progress / 100.0f);
                break;
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
