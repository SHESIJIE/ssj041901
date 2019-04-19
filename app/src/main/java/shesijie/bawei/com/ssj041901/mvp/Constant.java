package shesijie.bawei.com.ssj041901.mvp;

public interface Constant {
    public interface IView{
        void getPredenter(String data);
    }
    public interface IModel{
        void Show(IModel.ModelCallBack modelCallBack);
        public interface ModelCallBack{
            void onSuccess(String data);
            void onFail();
        }
    }
    public interface IPresenter{
        void getMOdel();
        void Attch(IView iView);
        void Deach();
    }
}
