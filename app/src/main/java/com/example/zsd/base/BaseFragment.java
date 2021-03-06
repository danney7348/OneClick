package com.example.zsd.base;
        import android.content.Context;
        import android.content.Intent;
        import android.os.Bundle;
        import android.support.annotation.Nullable;
        import android.support.v4.app.Fragment;
        import android.util.Log;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.Toast;

        import butterknife.ButterKnife;

        /**
         * 作者： 张少丹
         * 时间：  2017/11/28.
         * 邮箱：1455456581@qq.com
         * 类的用途：
         */
public abstract class BaseFragment<T extends BasePresenter> extends Fragment {

            private static final String TAGF = "BaseFragment";
            public View view;
    public T presenter;
    public abstract T initPresenter();





    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        if(view==null)
        {
            view = LayoutInflater.from(getActivity()).inflate(getViewId(),null);
        }
        Log.d(TAGF,"******************onCreateView******************=");
        ViewGroup viewGroup= (ViewGroup) view.getParent();
        if(viewGroup!=null)
        {
            viewGroup.removeView(view);
        }
        ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        presenter=initPresenter();
        Log.d(TAGF,"******************onActivityCreated******************=");
        initFragment();
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAGF,"******************onResume******************=");
        resumFragment();
    }
    public void start(Class<?> tclass,boolean isFinish){
        startActivity(new Intent(getActivity(),tclass));
        if(isFinish)
        {
            getActivity().finish();
        }
    }
    public void start(Class<?> tclass,boolean isFinish,Bundle bundle){
        Intent intent = new Intent(getActivity(), tclass);
        intent.putExtras(bundle);
        startActivity(intent);
        if(isFinish)
        {
            getActivity().finish();
        }
    }
    public void showToast(String msg){
        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
    }

    public abstract int getViewId();
    public abstract void initFragment();
    public abstract void resumFragment();

            @Override
            public void onAttach(Context context) {
                super.onAttach(context);
                Log.d(TAGF,"******************onAttach******************=");
            }

            @Override
            public void onCreate(@Nullable Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                Log.d(TAGF,"******************onCreate******************=");
            }

            @Override
            public void onStart() {
                super.onStart();
                Log.d(TAGF,"******************onStart******************=");
            }

            @Override
            public void onPause() {
                super.onPause();
                Log.d(TAGF,"******************onPause******************=");
            }

            @Override
            public void onStop() {
                super.onStop();
                Log.d(TAGF,"******************onStop******************=");
            }

            @Override
            public void onDestroyView() {
                super.onDestroyView();
                Log.d(TAGF,"******************onDestroyView******************=");
            }

            @Override
            public void onDestroy() {
                super.onDestroy();
                Log.d(TAGF,"******************onDestroy******************=");
            }

            @Override
            public void onDetach() {
                super.onDetach();
                Log.d(TAGF,"******************onDetach******************=");
            }
        }
