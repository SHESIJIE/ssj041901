package shesijie.bawei.com.ssj041901.mvp;

import com.android.volley.VolleyError;

import shesijie.bawei.com.ssj041901.net.HttpVolley;

public class MyModel implements Constant.IModel {
    private String url = "http://172.17.8.100/small/commodity/v1/commodityList";
    @Override
    public void Show(final ModelCallBack modelCallBack) {
        HttpVolley.getIntance ().GetHttp ( url , new HttpVolley.VolleyCallBack () {
            @Override
            public void onSuccess(String tesult) {
                modelCallBack.onSuccess ( tesult );
            }

            @Override
            public void onError(VolleyError error) {

            }
        } );
    }
}
