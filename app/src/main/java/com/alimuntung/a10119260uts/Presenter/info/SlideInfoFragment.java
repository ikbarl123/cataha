package com.alimuntung.a10119260uts.Presenter.info;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alimuntung.a10119260uts.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SlideInfoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SlideInfoFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return (ViewGroup) inflater.inflate(
                R.layout.fragment_slide_info, container, false);
    }
}