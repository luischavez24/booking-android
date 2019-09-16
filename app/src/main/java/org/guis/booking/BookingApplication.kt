package org.guis.booking

import android.app.Application
import android.content.Context
import org.guis.booking.injector.components.CoreComponent
import org.guis.booking.injector.components.DaggerCoreComponent
import org.guis.booking.injector.modules.AuthModule

class BookingApplication : Application(){
    private val coreComponent: CoreComponent by lazy {
        DaggerCoreComponent
            .builder()
            .authModule(AuthModule(applicationContext))
            .build()
    }
    companion object {
        @JvmStatic fun coreComponent(context: Context) = (context.applicationContext as BookingApplication).coreComponent
    }
}