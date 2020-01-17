package com.example.amst_2ep_grupo9_torres_ochoa_espinales;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;

public class MainActivity extends AppCompatActivity {
    View v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            buscarHeroe();
        } catch (Exception e) {
            System.out.println(e);
        }
        /*
        v.getId("button_buscar");
        R.id.button_buscar;

         */
    }

    public void buscarHeroe(){
        String url_api = "https://superheroapi.com/api/2979915212042299/1";

        JSONObject j = new JSONObject();

        /*
        JsonArrayRequest request_heroes = new JsonArrayRequest(url_api,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        System.out.println(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
        });
        */

        JsonObjectRequest heroes = new JsonObjectRequest(Request.Method.GET, url_api, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    System.out.println(response.get("response"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                System.out.println(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //System.out.println(error);
            }
        });
        System.out.println(heroes);
        System.out.println(j);


    }
}
