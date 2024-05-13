package com.example.apiexample

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    lateinit var myRec: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        isOnline(this)
        myRec=findViewById(R.id.rv)
        myRec.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        val allFunctions = RetroClient().getRetrofitClients()
        allFunctions.getComments().enqueue(object : Callback<PostComment> {
            override fun onResponse(call: Call<PostComment>, response: Response<PostComment>) {
                if (response.isSuccessful) {
                    val responseBody = response.body()
                    myRec.adapter=CustomAdapter(responseBody)
                }
            }

            override fun onFailure(call: Call<PostComment>, t: Throwable) {
            }

        })
//        allFunctions.getPosts().enqueue(object : Callback<PostResponse> {
//            override fun onResponse(call: Call<PostResponse>, response: Response<PostResponse>) {
//                if (response.isSuccessful) {
//                    val responseBody = response.body()
//                    var titles = ""
//                    for (item in responseBody!!) {
//                        titles+=item.title
//                    }
//                    texxt.text=titles+"\n"
//                }
//            }
//            override fun onFailure(call: Call<PostResponse>, t: Throwable) {
//            }
//
//        })


    }

    fun isOnline(context: Context) {
        val connectivityManager =
            context.getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
        if (connectivityManager != null) {

            val capabilities =
                connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
            if (capabilities != null) {
                if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
                    Toast.makeText(
                        context,
                        "NetworkCapabilities.TRANSPORT_CELLULAR",
                        Toast.LENGTH_SHORT
                    ).show()
                } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {
                    Toast.makeText(
                        context,
                        "NetworkCapabilities.TRANSPORT_WIFI",
                        Toast.LENGTH_SHORT
                    ).show()
                } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)) {
                    Toast.makeText(
                        context,
                        "NetworkCapabilities.TRANSPORT_ETHERNET",
                        Toast.LENGTH_SHORT
                    ).show()
                }

            }
            else  {
                Toast.makeText(
                    context,
                    "No Connection",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }



    }
}