package com.nileshshrama.worldcupapp

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast


class Adapters(private var activity: Activity,private var items:ArrayList<CountryModel>) :BaseAdapter(){
    override fun getCount(): Int {
        return items.size
    }

    override fun getItem(position: Int): CountryModel {
        return items[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, ConvertView: View?, p2: ViewGroup?): View {
        val view:View?
        val viewHolder:ViewHolder

        if (ConvertView==null)
        {
            val inflater=activity?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            view=inflater.inflate(R.layout.list_item_view,null)
            viewHolder = ViewHolder(view)
            view?.tag=viewHolder
        }
        else{
            view=ConvertView
            viewHolder=view.tag as ViewHolder
        }
        var countries=items[position]
        viewHolder.txtname?.text=countries.name
        viewHolder.txtCupwins?.text=countries.cupWins
        viewHolder.flagImage?.setImageResource(countries.flag_img)

        view?.setOnClickListener{
            Toast.makeText(activity,"you selected ${countries.name}",Toast.LENGTH_SHORT).show()
        }

        return view as View

    }

    private class ViewHolder(view:View?){
        var txtname:TextView?=null
        var txtCupwins:TextView?=null
        var flagImage:ImageView?=null

        init {
            this.txtname=view?.findViewById(R.id.textView)
            this.txtCupwins=view?.findViewById(R.id.textView2)
            this.flagImage=view?.findViewById(R.id.imageView)
        }

    }
}