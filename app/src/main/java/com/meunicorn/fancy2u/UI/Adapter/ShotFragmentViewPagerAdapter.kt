package com.meunicorn.fancy2u.UI.Adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import java.util.*

/**
 * Created by Fancy on 2016/2/29.
 */
class ShotFragmentViewPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    internal var fragmentList:MutableList<Fragment> =ArrayList()
    internal var titleList:MutableList<String> =ArrayList()

    override fun getItem(position: Int): Fragment? {
        return fragmentList.get(position)
    }

    override fun getCount(): Int {
        return fragmentList.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return titleList.get(position)
    }

    override fun getItemPosition(`object`: Any?): Int {
        return super.getItemPosition(`object`)
    }

    fun addFragment(fragment: Fragment,title:String){
        fragmentList.add(fragment)
        titleList.add(title)
    }


}
