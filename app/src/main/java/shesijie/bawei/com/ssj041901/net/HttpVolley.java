package shesijie.bawei.com.ssj041901.net;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import shesijie.bawei.com.ssj041901.app.MyApp;

public class HttpVolley {
    private static HttpVolley httpVolley = new HttpVolley ();
    public static HttpVolley getIntance(){
        return httpVolley;
    }
    public void GetHttp(String url, final VolleyCallBack volleyCallBack){
        StringRequest stringRequest = new StringRequest ( Request.Method.GET , url , new Response.Listener<String> () {
            @Override
            public void onResponse(String response) {
                volleyCallBack.onSuccess ( response );
            }
        } ,new Response.ErrorListener () {
            @Override
            public void onErrorResponse(VolleyError error) {
                volleyCallBack.onError ( error );
            }
        });
        MyApp.getQueue ().add ( stringRequest );
    }
    public interface VolleyCallBack{
        void onSuccess(String tesult);
        void onError(VolleyError error);
    }
}
