package com.haphap.sosialmediaapp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.haphap.sosialmediaapp.R;

public class ProfileFragment extends Fragment {

    TextView tvName, tvUsername;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_profile, container, false);

        tvName = root.findViewById(R.id.tv_name);
        tvUsername = root.findViewById(R.id.tv_username);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String name = getActivity().getIntent().getStringExtra("NAME");
        String username = getActivity().getIntent().getStringExtra("USERNAME");

        tvName.setText(name);
        tvUsername.setText(username);
    }
}
