package com.levko.roma.levkohomework10.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.BounceInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;

import com.levko.roma.levkohomework10.R;

/**
 * Created by User on 16.03.2016.
 */
public class BallFragment extends Fragment implements View.OnClickListener {

    private View mView;
    private FrameLayout mViewParent;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.ball_fragment, container, false);

        findViews(view);
        setListeners();
        return view;
    }

    private void findViews(View v) {
        this.mView = v.findViewById(R.id.ball_BF);
        this.mViewParent = (FrameLayout) this.mView.getParent();
    }

    private void setListeners() {
        this.mView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        this.mView.startAnimation(getAnimation());

    }

    private AnimationSet getAnimation() {
        float parameters = ((float) this.mViewParent.getWidth()) / ((float) this.mView.getWidth());
        final TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, ((float) (this.mViewParent.getHeight() - this.mViewParent.getWidth())) / parameters);
        final ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, parameters, 1.0f, parameters, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.0f);
        translateAnimation.setRepeatCount(1);
        translateAnimation.setRepeatMode(Animation.REVERSE);
        scaleAnimation.setRepeatCount(1);
        scaleAnimation.setRepeatMode(Animation.REVERSE);
        AnimationSet animation = new AnimationSet(true);
        animation.setDuration(3000);
        animation.setInterpolator(new BounceInterpolator());
        animation.setFillEnabled(true);
        animation.addAnimation(translateAnimation);
        animation.addAnimation(scaleAnimation);
        return animation;
    }
}
