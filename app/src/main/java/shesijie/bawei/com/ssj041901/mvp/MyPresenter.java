package shesijie.bawei.com.ssj041901.mvp;

import android.graphics.ColorSpace;

public class MyPresenter implements Constant.IPresenter {
    MyModel  model;
    Constant.IView iView1;
    @Override
    public void getMOdel() {

    }

    @Override
    public void Attch(final Constant.IView iView) {

        this.iView1 = iView;
        model = new MyModel ();
        model.Show ( new Constant.IModel.ModelCallBack () {
            @Override
            public void onSuccess(String data) {
                iView.getPredenter ( data );
            }

            @Override
            public void onFail() {

            }
        } );
    }

    @Override
    public void Deach() {
        if (model != null) {
            model = null;
        }
        if (iView1 != null) {
            iView1 = null;
        }
        System.gc ();
    }
}
