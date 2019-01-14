package tw.noel.sung.com.demo_firebasesolution.util.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import tw.noel.sung.com.demo_firebasesolution.talk.TalkActivity;


/**
 * Created by noel on 2019/1/14.
 * 頁面式 fragment
 */

public abstract class BasePageFragment extends Fragment {

    public Activity activity;
    protected View view;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof TalkActivity) {
            activity = (TalkActivity) context;
        }
    }


    //-----------


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (view == null) {
            view = LayoutInflater.from(getActivity()).inflate(getContentView(), container, false);
            ButterKnife.bind(this, view);
            init();
        } else {
            ViewGroup parent = (ViewGroup) view.getParent();
            if (parent != null) {
                parent.removeView(view);
            }
        }
        return view;
    }

    //----------------------

    /**
     * 無bundle
     */
    public void replacePageFragment(int layoutId, Fragment fragment, boolean addToBackStack) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        if (addToBackStack) {
            transaction.addToBackStack(null);
        }
        transaction.replace(layoutId, fragment);
        transaction.commit();
        getFragmentManager().executePendingTransactions();
    }
    //----------------------

    /**
     * 有 bundle
     */
    public void replacePageFragment(int layoutId, Fragment fragment, boolean addToBackStack, Bundle bundle) {
        fragment.setArguments(bundle);
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        if (addToBackStack) {
            transaction.addToBackStack(null);
        }
        transaction.replace(layoutId, fragment);
        transaction.commit();
        getFragmentManager().executePendingTransactions();
    }


    //設置XML
    protected abstract int getContentView();
    //初始化
    protected abstract void init();

}
