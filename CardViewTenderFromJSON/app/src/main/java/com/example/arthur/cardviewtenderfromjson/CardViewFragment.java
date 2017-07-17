package com.example.arthur.cardviewtenderfromjson;

import android.os.AsyncTask;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class CardViewFragment extends Fragment implements RVAdapter.OnRecyclerViewItemClickListener {

    public static final String TAG = "CardViewFragment";

    Bundle bundle;
    private List<DataJSON> dataJSONList;
    RVAdapter rvAdapter;

    MoreDetailFragment moreDetailFragment;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.activity_card_view_fragment, container, false);

        bundle = new Bundle();

        moreDetailFragment = new MoreDetailFragment();

        dataJSONList = new ArrayList<>();
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);

        loadDataFromServer();

        rvAdapter = new RVAdapter(this, dataJSONList);
        recyclerView.setAdapter(rvAdapter);

        getActivity();
        return rootView;
    }

    String strJson;
    private void loadDataFromServer()  {

        AsyncTask<Void, Void, String> task = new AsyncTask<Void, Void, String>(){
            @Override
            protected String doInBackground(Void... voids) {
                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder()
                        .url("https://gesmetrics.ru/testpiers.php").build();
                Response response;

                try {
                    response = client.newCall(request).execute();
                    strJson = response.body().string();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                return strJson;
            }

            @Override
            protected void onPostExecute(String strJson) {
                super.onPostExecute(strJson);
                Log.d("myLog", strJson);

                try {
                    JSONArray jsonArray = new JSONArray(strJson);
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject object = jsonArray.getJSONObject(i);

                        int id = object.getInt("pierId");
                        String name = object.getString("pierName");
                        String region = object.getString("region");
                        String description = object.getString("description");
                        DataJSON data = new DataJSON(i, name, region, description);
                        dataJSONList.add(data);
                    }
                } catch (JSONException e) {
                    System.out.println("Issue");
                }
                rvAdapter.notifyDataSetChanged();
            }

        };
        task.execute();
    }

    @Override
    public void onClick(int parameter) {
        Log.d("myLog", "Click from CardViewFragment");

        bundle.putInt("itemParameter", parameter);
        bundle.putString("PierName", dataJSONList.get(parameter).getPierName());
        bundle.putString("Region", dataJSONList.get(parameter).getRegion());
        bundle.putString("Description", dataJSONList.get(parameter).getDescription());
        moreDetailFragment.setArguments(bundle);

        Log.d("myLog", "parametr = " + String.valueOf(parameter));

        getFragmentManager().beginTransaction()
                .replace(R.id.container, moreDetailFragment, MoreDetailFragment.TAG).commit();
    }
}




