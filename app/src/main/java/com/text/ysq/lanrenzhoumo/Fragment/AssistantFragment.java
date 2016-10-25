package com.text.ysq.lanrenzhoumo.Fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.text.ysq.lanrenzhoumo.R;


public class AssistantFragment extends Fragment {

    public static AssistantFragment newInstance() {
        AssistantFragment fragment = new AssistantFragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_assistant,container,false);
    }
}
