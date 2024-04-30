package com.corevalue.mymodule.data.network

import android.util.Log
import com.corevalue.mymodule.data.AppSharedPreference
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException
import javax.inject.Inject
import javax.inject.Named

class AuthenticationInterceptor(private val sharedPreference: AppSharedPreference) : Interceptor {


    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val token =  sharedPreference.getValueString("Token").toString()
        Log.d("TADSFASFASFAS", "intercept: $token")
        return try {
            if (token != "null") {
                val builder = original.newBuilder()
                    .addHeader("Authorization", "Bearer " + token)
                /*       .addHeader("Accept", "application/json")
                       .addHeader("Content-Type", "application/json")*/
                //    .addHeader("lang",langValue)

                val request = builder.build()
                chain.proceed(request)
            } else {
                chain.proceed(original)
            }
        }catch (e:Exception){
            e.printStackTrace()
            chain.proceed(original)
        }
    }

}