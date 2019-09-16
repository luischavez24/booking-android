package org.guis.booking.injector.modules

import dagger.Module
import dagger.Provides
import org.guis.booking.data.SwapiService
import retrofit2.Retrofit
import javax.inject.Inject

@Module
class SwapiModule{
    @Provides
    fun swapiService(retrofit: Retrofit) : SwapiService {
        return retrofit.create(SwapiService::class.java)
    }
}