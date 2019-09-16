package org.guis.booking.injector.modules

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit


@Module
class HttpClientModule {
    @Provides
    fun httpClientBuilder() : OkHttpClient.Builder {
        return OkHttpClient.Builder()
    }
}