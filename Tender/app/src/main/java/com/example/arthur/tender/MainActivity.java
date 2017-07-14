package com.example.arthur.tender;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.arthur.tender.SupportClasses.JSONData;
import com.example.arthur.tender.SupportClasses.RVAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class MainActivity extends AppCompatActivity {

    public static String LOG_TAG = "my_log";

    private RVAdapter rvAdapter;
    private List<JSONData> dataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        dataList = new ArrayList<>();
        loadDataFromServer(0);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);

        rvAdapter = new RVAdapter(dataList);
        recyclerView.setAdapter(rvAdapter);

        //new ParseTask().execute();
    }

    private void loadDataFromServer(int id) {
        AsyncTask<Integer, Void, Void> task = new AsyncTask<Integer, Void, Void>() {
            @Override
            protected Void doInBackground(Integer... integers) {

                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder().url("https://gesmetrics.ru/testpiers.php")
                        .build();
                try {
                    Response response = client.newCall(request).execute();
                    String strJSON = response.body().string();

                    Log.d(LOG_TAG, strJSON);

                    JSONArray jsonArray = new JSONArray(strJSON);

                    for (int i = 0; i < jsonArray.length(); i++){
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        JSONData jsonData = new JSONData(jsonObject.getInt("pierId"),
                                jsonObject.getString("pierName"), jsonObject.getString("piercing"),
                                jsonObject.getString("pierLat"), jsonObject.getString("region"),
                                jsonObject.getString("description"));
                        dataList.add(jsonData);
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    System.out.println("End of content");
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void strJson) {
                 //rvAdapter.notifyDataSetChanged();
            }
        };
        task.execute(id);
    }

//    private class ParseTask extends AsyncTask<Void, Void, String> {
//        HttpURLConnection urlConnection;
//        BufferedReader bufferedReader;
//        String resultJson;
//
//        @Override
//        protected String doInBackground(Void... params) {
//            // получаем данные с внешнего ресурса
//            try {
//                URL url = new URL("https://gesmetrics.ru/testpiers.php");
//
//                urlConnection = (HttpURLConnection) url.openConnection();
//                urlConnection.setRequestMethod("GET");
//                urlConnection.setDoInput(true);
//                urlConnection.connect();
//
//                InputStream inputStream = urlConnection.getInputStream();
//                StringBuilder stringBuffer = new StringBuilder();
//
//                bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
//
//                String line;
//                while ((line = bufferedReader.readLine()) != null) {
//                    stringBuffer.append(line);
//                }
//
//                resultJson = stringBuffer.toString();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            return resultJson;
//        }
//
//        @Override
//        protected void onPostExecute(String strJson) {
//            super.onPostExecute(strJson);
//            // выводим целиком полученную json-строку
//            //Log.d(LOG_TAG, strJson);
//
//            JSONObject jsonObject;
//            Log.d(LOG_TAG, "Text before try");
//            try {
//                JSONArray jsonArray = new JSONArray(strJson);
//                for (int i = 0; i < jsonArray.length(); ++i){
//                    jsonObject = jsonArray.getJSONObject(i);
//                    JSONData jsonData = new JSONData(jsonObject.getInt("pierId"),
//                            jsonObject.getString("pierName"), jsonObject.getString("piercing"),
//                            jsonObject.getString("pierLat"), jsonObject.getString("region"),
//                            jsonObject.getString("description"));
//                    dataList.add(jsonData);
//
////                    int pierId = jsonObject.getInt("pierId");
////                    String pierName = jsonObject.optString("pierName");
////                    String piercing = jsonObject.optString("piercin  g");
////                    String pierLat = jsonObject.optString("pierLat");
////                    String region = jsonObject.optString("region");
////                    String description = jsonObject.optString("description");
//
//
//                    //Log.d(LOG_TAG, "It's" + pierId + " " + pierName + " " + piercing + " " + pierLat + " " + region + " " + description);
//                }
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
//
//            rvAdapter.notifyDataSetChanged();
//            Log.d(LOG_TAG, "text after try");
//
//        }
//    }
}
