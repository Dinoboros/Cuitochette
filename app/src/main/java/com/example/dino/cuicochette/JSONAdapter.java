package com.example.dino.cuicochette;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by dino on 11/02/2018.
 */

public class JSONAdapter extends BaseAdapter implements ListAdapter {

    private final Activity activity;
    private final JSONArray jsonArray;

    protected JSONAdapter(Activity activity, JSONArray jsonArray) {
        this.jsonArray = jsonArray;
        this.activity = activity;
    }


    @Override public int getCount() {
        if(null==jsonArray)
            return 0;
        else
            return jsonArray.length();
    }

    @Override public JSONObject getItem(int position) {
        if(null==jsonArray) return null;
        else
            return jsonArray.optJSONObject(position);
    }

    @Override public long getItemId(int position) {
        JSONObject jsonObject = getItem(position);

        return jsonObject.optLong("id");
    }

    @Override public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null)
            convertView = activity.getLayoutInflater().inflate(R.layout.plats, null);

        TextView text =(TextView)convertView.findViewById(R.id.plat);

        JSONObject json_data = getItem(position);
        String jj= null;
        try {
            jj = json_data.getString("plats");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        text.setText(jj);


        return convertView;
    }
}
