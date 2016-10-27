package com.text.ysq.lanrenzhoumo.Fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.text.ysq.lanrenzhoumo.R;


public class AssistantFragment extends Fragment {

    private TextView mTextView;

    public static AssistantFragment newInstance() {
        AssistantFragment fragment = new AssistantFragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_assistant,container,false);
        mTextView = (TextView) view.findViewById(R.id.assistant_txt3);
        SpannableString content = new SpannableString("懒喵助手");
        content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
        mTextView.setText(content);
        return view;
    }


}
