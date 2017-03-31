package vamp.ifpiprojetos.com.vamp.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import vamp.ifpiprojetos.com.vamp.fragments.DonorListFragment;
import vamp.ifpiprojetos.com.vamp.fragments.HospitalListFragment;
import vamp.ifpiprojetos.com.vamp.fragments.MapaFragment;

/**
 * Created by Jefferson Lima on 29/03/2017.
 */

public class TabAdapter extends FragmentStatePagerAdapter {

    private String[] tituloAbas = {"DOADORES", "HOSPITAIS"};

    public TabAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position){
            case 0:
                fragment = new DonorListFragment();
                break;
            case 1:
                fragment = new HospitalListFragment();
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return tituloAbas.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tituloAbas[position];
    }
}
