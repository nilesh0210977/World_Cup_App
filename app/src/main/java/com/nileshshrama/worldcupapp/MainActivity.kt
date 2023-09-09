package com.nileshshrama.worldcupapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Data_Source

        fun generateresults():ArrayList<CountryModel>{
            var CountryList=ArrayList<CountryModel>()
             var country1:CountryModel=CountryModel(
                 "Brazil",
                    "5",
                 R.drawable.brazil
             )
            var country2:CountryModel= CountryModel(
                "India",
                "3",
                R.drawable.india
            )
            var country3:CountryModel= CountryModel(
                "South Africa",
                "1",
                R.drawable.southfrica
            )
            var country4:CountryModel= CountryModel(
                "United Kingdom",
                "0",
                R.drawable.unitedkingdom
            )
            CountryList.add(country1)
            CountryList.add(country2)
            CountryList.add(country3)
            CountryList.add(country4)
            return CountryList

        }
    //adapter
        var adapter=Adapters(this,generateresults())


        //adapters viwe
        var listview:ListView=findViewById(R.id.listView)

        listview?.adapter=adapter
        adapter?.notifyDataSetChanged()

    }
}