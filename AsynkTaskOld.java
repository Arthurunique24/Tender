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
