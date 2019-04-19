package shesijie.bawei.com.ssj041901.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import shesijie.bawei.com.ssj041901.R;
import shesijie.bawei.com.ssj041901.bean.MyBean;

public class MyAdapter extends RecyclerView.Adapter {
    private Context context;
    private MyBean myBean;
    private int PzshType = 1;
    private int MlssType = 2;
    private int RxxpType = 3;
    int itemViewType;
    MyBean.ResultBean.RxxpBean rxxpBean;
    MyBean.ResultBean.MlssBean mlssBean;
    MyBean.ResultBean.PzshBean pzshBean;
    PzshAdapter pzshAdapter;
    MlssAdapter mlssAdapter;
    RxxpAdapter rxxpAdapter;
    LinearLayoutManager rxxpmanage;
    LinearLayoutManager pzshmanage;
    LinearLayoutManager mlssmanage;

    public MyAdapter(Context context , MyBean myBean) {
        this.context = context;
        this.myBean = myBean;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup , int i) {
        int viewType = getItemViewType ( i );
        if (viewType == RxxpType) {
            View RxxpView = LayoutInflater.from ( context ).inflate ( R.layout.item_list_rxxp,null );
            return new ViewHoldelRxxp ( RxxpView );

        } else if (viewType == MlssType) {
            View MlssView = LayoutInflater.from ( context ).inflate ( R.layout.item_list_mlss,null );
            return new ViewHoldelMlss ( MlssView );
        } else {
            View PzshView = LayoutInflater.from ( context ).inflate ( R.layout.item_list_pzsh,null );
            return new ViewHoldelPzsh ( PzshView );
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder , int i) {
        itemViewType = viewHolder.getItemViewType ();
        if (itemViewType == RxxpType) {

            ViewHoldelRxxp viewHoldelRxxp = (ViewHoldelRxxp)viewHolder;

            rxxpBean = myBean.getResult ().getRxxp ();

            LinearLayoutManager rxxpmanagr = new LinearLayoutManager ( context );

            rxxpmanagr.setOrientation ( LinearLayoutManager.VERTICAL );

            viewHoldelRxxp.rxxp_rc.setLayoutManager ( rxxpmanagr );

            viewHoldelRxxp.rxxp_tv.setText ( myBean.getResult ().getRxxp ().getName () );

            rxxpmanage = new GridLayoutManager (context,2);

            rxxpAdapter = new RxxpAdapter (context,myBean.getResult ().getRxxp ().getCommodityList ());

            viewHoldelRxxp.rxxp_rc.setAdapter ( rxxpAdapter );
        } else if (itemViewType == MlssType) {

            ViewHoldelMlss viewHoldelMlss = (ViewHoldelMlss) viewHolder;

            mlssBean = myBean.getResult ().getMlss ();

            mlssmanage = new LinearLayoutManager (context );

            mlssmanage.setOrientation ( LinearLayoutManager.HORIZONTAL);

            viewHoldelMlss.mlss_rc.setLayoutManager ( mlssmanage );

            viewHoldelMlss.mlss_tv.setText ( myBean.getResult ().getMlss ().getName () );

            mlssAdapter = new MlssAdapter ( context , myBean.getResult ().getMlss ().getCommodityList () );

            viewHoldelMlss.mlss_rc.setAdapter ( mlssAdapter );
        } else {

            ViewHoldelPzsh viewHoldelPzsh = (ViewHoldelPzsh)viewHolder;

            pzshBean = myBean.getResult ().getPzsh ();

            viewHoldelPzsh.pzsh_tv.setText ( myBean.getResult ().getPzsh ().getName () );

            pzshmanage = new GridLayoutManager ( context,2 );

            pzshmanage.setOrientation ( LinearLayoutManager.VERTICAL );

            viewHoldelPzsh.pzsh_rc.setLayoutManager ( pzshmanage );

            pzshAdapter = new PzshAdapter ( context , myBean.getResult ().getPzsh ().getCommodityList () );

            viewHoldelPzsh.pzsh_rc.setAdapter ( pzshAdapter );
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 1) {
            return PzshType;
        } else if (position == 2) {
            return MlssType;
        } else {
            return RxxpType;
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
    public class ViewHoldelRxxp extends RecyclerView.ViewHolder{
        TextView rxxp_tv;
        RecyclerView rxxp_rc;
        public ViewHoldelRxxp(@NonNull View itemView) {
            super ( itemView );
            rxxp_rc = itemView.findViewById ( R.id.rxxp_rc );
            rxxp_tv = itemView.findViewById ( R.id.rxxp_tv );
        }
    }
    public class ViewHoldelPzsh extends RecyclerView.ViewHolder{
        TextView pzsh_tv;
        RecyclerView pzsh_rc;
        public ViewHoldelPzsh(@NonNull View itemView) {
            super ( itemView );
            pzsh_tv = itemView.findViewById ( R.id.pzsh_tv );
            pzsh_rc = itemView.findViewById ( R.id.pzsh_rc );
        }
    }
    public class ViewHoldelMlss extends RecyclerView.ViewHolder{
        TextView mlss_tv;
        RecyclerView mlss_rc;
        public ViewHoldelMlss(@NonNull View itemView) {
            super ( itemView );
            mlss_rc = itemView.findViewById ( R.id.mlss_rc );
            mlss_tv = itemView.findViewById ( R.id.mlss_tv );
        }
    }

}
