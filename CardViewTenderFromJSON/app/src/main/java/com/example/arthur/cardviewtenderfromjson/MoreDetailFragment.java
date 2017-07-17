package com.example.arthur.cardviewtenderfromjson;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MoreDetailFragment extends Fragment implements View.OnClickListener{

    public static final String TAG = "MoreDetailFragment";

    private List<DataJSON> dataJSONList;

    TextView textViewInfoName;
    TextView textViewInfoRegion;
    TextView textViewInfoDescription;
    Button btnBack;
    int parameter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_more_detail_fragment, container, false);

        textViewInfoName = (TextView) rootView.findViewById(R.id.textViewInfoName);
        textViewInfoRegion = (TextView) rootView.findViewById(R.id.textViewInfoRegion);
        textViewInfoDescription = (TextView) rootView.findViewById(R.id.textViewInfoDescription);
        btnBack = (Button) rootView.findViewById(R.id.btnBack);
        btnBack.setOnClickListener(this);

        Bundle bundle = this.getArguments();
        if (bundle != null) {
            Log.d("myLog", "bundle != null");
            parameter = bundle.getInt("itemParameter");

            textViewInfoName.setText(bundle.getString("PierName"));
            textViewInfoRegion.setText(bundle.getString("Region"));
            textViewInfoDescription.setText(bundle.getString("Description"));
        } else Log.d("myLog", "bundle = null");

        getActivity();
        return rootView;
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnBack:
                Log.d("myLog", "click btnClick");
                getFragmentManager().beginTransaction().add(R.id.container, new CardViewFragment(), CardViewFragment.TAG).commit();
        }
    }
}
