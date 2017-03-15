package com.darwindeveloper.wcviewpagerindicatorsv3;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Darwin Morocho on 11/3/2017.
 */

public class PageFragment extends Fragment {

    public static final String PAGE = "com.darwindeveloper.wcviewpager.PAGE";

    private Context context;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = LayoutInflater.from(context).inflate(R.layout.fragment_page, container, false);
        TextView textView = (TextView) rootView.findViewById(R.id.textView);

        int numPage = getArguments().getInt(PAGE);
        textView.setText(numPage + "");

        return rootView;
    }
}
