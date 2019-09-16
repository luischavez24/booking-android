package org.guis.booking.injector.modules

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import org.guis.booking.utils.TokenUtils
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module(includes = [HttpClientModule::class])
class RetrofitModule{
    @Provides
    fun retrofit(httpClientBuilder: OkHttpClient.Builder, tokenUtils: TokenUtils) : Retrofit {
        val httpClientWithInteceptor = httpClientBuilder
            .addInterceptor {
                val token = tokenUtils.getToken()
                val request = it.request().newBuilder()
                    .addHeader("DUMMY_AUTH", token)
                    .build()
                it.proceed(request)
            }.build()

        return Retrofit.Builder()
            .baseUrl("https://swapi.co/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .client(httpClientWithInteceptor)
            .build()
    }
}