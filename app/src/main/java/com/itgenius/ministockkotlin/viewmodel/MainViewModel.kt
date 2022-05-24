package com.itgenius.ministockkotlin.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.itgenius.ministockkotlin.model.ProductModelItem
import com.itgenius.ministockkotlin.repository.MainRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel constructor(private val repository: MainRepository): ViewModel(){

    val productList = MutableLiveData<List<ProductModelItem>>()
    val errorMessage = MutableLiveData<String>()

    // สร้างฟังก์ชันดึงสินค้า
    fun getAllProducts(){
        val response = repository.getAllProducts()
        response.enqueue(object: Callback<List<ProductModelItem>> {

            override fun onResponse(
                call: Call<List<ProductModelItem>>,
                response: Response<List<ProductModelItem>>
            ) {
                productList.postValue(response.body())

                Log.d("data viewmodel success ",response.body().toString())
            }

            override fun onFailure(call: Call<List<ProductModelItem>>, t: Throwable) {
                errorMessage.postValue(t.message)

                Log.d("data viewmodel error ",t.message!!)
            }

        })
    }

}