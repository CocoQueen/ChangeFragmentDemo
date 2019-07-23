package com.example.coco.changefragmentdemo;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * @author：86135 date：2019/7/23
 * description:PayFragment
 */
public class PayFragment extends Fragment {
    Context context;
    List<String> list = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.pay, container, false);
        EditText editText = view.findViewById(R.id.ed);
        Button button = view.findViewById(R.id.btn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.add("数据");
                Toast.makeText(context, list.size() + "", Toast.LENGTH_SHORT).show();

                if (context instanceof MainActivity) {
                    MainActivity mainActivity = (MainActivity) context;
                    if (null != list && list.size() != 0) {
                        mainActivity.isClick(true);
                    } else {
                        mainActivity.isClick(false);
                    }
                }
            }
        });

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }
}
