package com.levko.roma.levkohomework10.fragments;

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
    private final static int DURATION_ANIM = 800;
    private final static float PARAMS = 100.0f;

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


    private void setAnim(LinearLayout container, SeekBar seekBar, Boolean state, int duration) {
        if (state) {
            final ObjectAnimator objectAnimator =
                    ObjectAnimator.ofFloat(container, "translationX", 0.0f, -seekBar.getWidth());
            objectAnimator.setDuration(duration);
            objectAnimator.start();
        } else {
            final ObjectAnimator objectAnimator =
                    ObjectAnimator.ofFloat(container, "translationX", -seekBar.getWidth(), 0.0f);
            objectAnimator.setDuration(duration);
            objectAnimator.start();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_visible_HF:
                isVisibleShow = !isVisibleShow;
                setAnim(llVisible, sbVisible, isVisibleShow, DURATION_ANIM);
                break;
            case R.id.iv_rotate_HF:
                isRotateShow = !isRotateShow;
                setAnim(llRotate, sbRotate, isRotateShow, DURATION_ANIM);
                break;
            case R.id.iv_scale_HF:
                isScaleShow = !isScaleShow;
                setAnim(llScale, sbScale, isScaleShow, DURATION_ANIM);
                break;
        }
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

        switch (seekBar.getId()) {
            case R.id.sb_visible_HF:
                mViewHeart.setAlpha(progress / PARAMS);
                break;
            case R.id.sb_rotate_HF:
                mViewHeart.setRotation(progress / 0.27f);
                break;
            case R.id.sb_scale_HF:
                mViewHeart.setScaleX(progress / PARAMS);
                mViewHeart.setScaleY(progress / PARAMS);
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
