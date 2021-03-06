package com.example.shaur.nimblenavigationdrawer;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by shaur on 24-11-2017.
 */

public class MySingleton {

    private static MySingleton mInstance;
    private RequestQueue requestQueue;
    private static Context mcontext;

    private MySingleton(Context context) {
        mcontext = context;
        requestQueue = getResquestQueue();
    }

    public RequestQueue getResquestQueue() {
        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(mcontext.getApplicationContext());
        }
        return requestQueue;
    }

    public static synchronized MySingleton getInstance(Context context){
        if(mInstance == null){
            mInstance = new MySingleton(context);
        }
        return mInstance;
    }

    public void addToRequestQueue(Request request){
        requestQueue.add(request);
    }

}
