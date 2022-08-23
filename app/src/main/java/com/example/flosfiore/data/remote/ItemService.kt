package com.example.flosfiore.data.remote

import android.util.Log
import com.example.flosfiore.data.entities.ItemResponse
import com.example.flosfiore.utils.getRetrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ItemService() {
    private lateinit var hydraView: HydraView
    private lateinit var roseView: RoseView
    private lateinit var mistView: MistView
    private lateinit var lisianView: LisianView

    fun setHydraView(hydraView: HydraView){
        this.hydraView = hydraView
    }

    fun getHydra(){
        val hydraService = getRetrofit().create(ItemRetrofitInterfaces::class.java)

        hydraView.onGetHydraLoading()

        hydraService.getHydra().enqueue(object : Callback<ItemResponse>{
            override fun onResponse(call: Call<ItemResponse>, response: Response<ItemResponse>) {
                if(response.isSuccessful && response.code() == 200){
                    val itemResponse: ItemResponse = response.body()!!

                    Log.d("HYDRA-RESPONSE", itemResponse.toString())

                    when (val code = itemResponse.code){
                        1000 -> {
                            hydraView.onGetHydraSuccess(code, itemResponse.result!!)
                        }

                        else -> hydraView.onGetHydraFailure(code, itemResponse.message)
                    }
                }
            }

            override fun onFailure(call: Call<ItemResponse>, t: Throwable) {
                hydraView.onGetHydraFailure(400, "네크워크 오류가 발생했습니다.")
            }
        })
    }


    fun setRoseView(roseView: RoseView){
        this.roseView = roseView
    }

    fun getRose(){
        val roseService = getRetrofit().create(ItemRetrofitInterfaces::class.java)

        roseView.onGetRoseLoading()

        roseService.getRose().enqueue(object : Callback<ItemResponse>{
            override fun onResponse(call: Call<ItemResponse>, response: Response<ItemResponse>) {
                if(response.isSuccessful && response.code() == 200){
                    val itemResponse: ItemResponse = response.body()!!

                    Log.d("ROSE-RESPONSE", itemResponse.toString())

                    when (val code = itemResponse.code){
                        1000 -> {
                            roseView.onGetRoseSuccess(code, itemResponse.result!!)
                        }

                        else -> roseView.onGetRoseFailure(code, itemResponse.message)
                    }
                }
            }

            override fun onFailure(call: Call<ItemResponse>, t: Throwable) {
                roseView.onGetRoseFailure(400, "네크워크 오류가 발생했습니다.")
            }
        })
    }



    fun setMistView(mistView: MistView){
        this.mistView = mistView
    }

    fun getMist(){
        val mistService = getRetrofit().create(ItemRetrofitInterfaces::class.java)

        mistView.onGetMistLoading()

        mistService.getMist().enqueue(object : Callback<ItemResponse>{
            override fun onResponse(call: Call<ItemResponse>, response: Response<ItemResponse>) {
                if(response.isSuccessful && response.code() == 200){
                    val itemResponse: ItemResponse = response.body()!!

                    Log.d("MIST-RESPONSE", itemResponse.toString())

                    when (val code = itemResponse.code){
                        1000 -> {
                            mistView.onGetMistSuccess(code, itemResponse.result!!)
                        }

                        else -> mistView.onGetMistFailure(code, itemResponse.message)
                    }
                }
            }

            override fun onFailure(call: Call<ItemResponse>, t: Throwable) {
                mistView.onGetMistFailure(400, "네크워크 오류가 발생했습니다.")
            }
        })
    }



    fun setLisianView(lisianView: LisianView){
        this.lisianView = lisianView
    }

    fun getLisian(){
        val lisianService = getRetrofit().create(ItemRetrofitInterfaces::class.java)

        lisianView.onGetLisianLoading()

        lisianService.getLisian().enqueue(object : Callback<ItemResponse>{
            override fun onResponse(call: Call<ItemResponse>, response: Response<ItemResponse>) {
                if(response.isSuccessful && response.code() == 200){
                    val itemResponse: ItemResponse = response.body()!!

                    Log.d("LISIAN-RESPONSE", itemResponse.toString())

                    when (val code = itemResponse.code){
                        1000 -> {
                            lisianView.onGetLisianSuccess(code, itemResponse.result!!)
                        }

                        else -> lisianView.onGetLisianFailure(code, itemResponse.message)
                    }
                }
            }

            override fun onFailure(call: Call<ItemResponse>, t: Throwable) {
                lisianView.onGetLisianFailure(400, "네크워크 오류가 발생했습니다.")
            }
        })
    }
}