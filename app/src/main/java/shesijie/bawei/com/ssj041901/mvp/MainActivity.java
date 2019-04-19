package shesijie.bawei.com.ssj041901.mvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;

import shesijie.bawei.com.ssj041901.R;
import shesijie.bawei.com.ssj041901.adapter.MyAdapter;
import shesijie.bawei.com.ssj041901.bean.MyBean;

public class MainActivity extends AppCompatActivity implements Constant.IView {

    MyPresenter presenter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );
        recyclerView = findViewById ( R.id.main_rec );
        recyclerView.setLayoutManager ( new  LinearLayoutManager(this) );
        presenter = new MyPresenter ();
        presenter.Attch ( this );
    }

    @Override
    public void getPredenter(String data) {
        Gson gson = new Gson ();
        MyBean myBean = gson.fromJson ( data , MyBean.class );
        recyclerView.setAdapter ( new MyAdapter ( this,myBean ) );
    }
}
