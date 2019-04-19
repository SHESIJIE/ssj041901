package shesijie.bawei.com.ssj041901.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import shesijie.bawei.com.ssj041901.R;
import shesijie.bawei.com.ssj041901.bean.MyBean;


public class RxxpAdapter extends RecyclerView.Adapter<RxxpAdapter.ViewHolder> {
    private Context context;
    private List<MyBean.ResultBean.RxxpBean.CommodityListBean> listBeans;
    public RxxpAdapter(Context context , List<MyBean.ResultBean.RxxpBean.CommodityListBean> commodityList) {
        this.context = context;
        this.listBeans = commodityList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup , int i) {
        View view = LayoutInflater.from ( context ).inflate ( R.layout.item_rxxp_zi,null );
        return new ViewHolder ( view ) ;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder , int i) {
        viewHolder.name.setText ( listBeans.get ( i ).getCommodityName () );
        viewHolder.price.setText ( listBeans.get ( i ).getPrice () );
        Glide.with ( context ).load ( listBeans.get ( i ).getMasterPic () ).into ( viewHolder.imageView );
    }

    @Override
    public int getItemCount() {
        return listBeans.size ();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name,price;
        ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super ( itemView );
            name = itemView.findViewById ( R.id.rxxp_zi_na );
            price = itemView.findViewById ( R.id.rxxp_zi_pi );
            imageView = itemView.findViewById ( R.id.rxxp_zi_ima );
        }
    }
}
