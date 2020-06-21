package com.haphap.sosialmediaapp.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.haphap.sosialmediaapp.R;
import com.haphap.sosialmediaapp.activity.SearchResultActivity;

public class SearchFragment extends Fragment {

    private EditText etSearch;
    private Button btnSearch;
    private String name;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_search, container, false);

        etSearch = root.findViewById(R.id.et_search);
        btnSearch = root.findViewById(R.id.btn_search);

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        name = getActivity().getIntent().getStringExtra("NAME");

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String search = etSearch.getText().toString();
                if (search.trim().isEmpty()) {
                    Toast.makeText(getActivity(), "Silahkan masukan nama pencarian !",Toast.LENGTH_SHORT).show();
                } else if (search.trim().equals(name)){
                    Intent intentResult = new Intent(getActivity(), SearchResultActivity.class);
                    intentResult.putExtra("NAME", name);
                    startActivity(intentResult);
                } else {
                    Intent intentTanpaData = new Intent(getActivity(), SearchResultActivity.class);
                    startActivity(intentTanpaData);
                }
            }
        });

    }
}
