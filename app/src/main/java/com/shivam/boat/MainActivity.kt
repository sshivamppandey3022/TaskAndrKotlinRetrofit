package com.shivam.boat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.shivam.boat.Adapters.RecyclerViewAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    companion object {
        lateinit var list: MutableList<Model>
    }
    override fun onCreate(savedInstanceState: Bundle?) {



        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)


        val request = RetrofitClient.buildService(ApiService::class.java)
        val call = request.getPosts()


            call.enqueue(object : Callback<MutableList<Model>>{
                override fun onResponse(call: Call<MutableList<Model>>, response: Response<MutableList<Model>>)
                {
                    if (response.isSuccessful){
                        recyclerView.apply {
                            layoutManager = LinearLayoutManager(this@MainActivity)
                            Log.e("success", response.body().toString())
                            list = response.body()!!
                            adapter = RecyclerViewAdapter(response.body()!!)
                        }
                    }

                }

                override fun onFailure(call: Call<MutableList<Model>>, t: Throwable) {
                    t.printStackTrace()
                    Log.e("error", t.message.toString())


                }

            })

        }
}





//        val lists: List<String> = listOf("Hello", "Saurabh", "Anubhav", "Arun", "Prateek", "Rana", "Saurabh", "Anubhav", "Arun", "Prateek", "Rana")
//
//
//        recyclerView.layoutManager = LinearLayoutManager(this)
//        val adapter = RecyclerViewAdapter(lists)
//        recyclerView.adapter = adapter





