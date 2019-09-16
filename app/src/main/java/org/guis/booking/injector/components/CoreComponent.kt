package org.guis.booking.injector.components

import dagger.Component;
import org.guis.booking.activities.MainActivity
import org.guis.booking.injector.modules.AuthModule
import org.guis.booking.injector.modules.HttpClientModule
import org.guis.booking.injector.modules.RetrofitModule
import org.guis.booking.utils.TokenUtils
import retrofit2.Retrofit

@Component(modules = [RetrofitModule::class, AuthModule::class])
interface CoreComponent {
    fun retrofit() : Retrofit
    fun tokenUtils(): TokenUtils
}