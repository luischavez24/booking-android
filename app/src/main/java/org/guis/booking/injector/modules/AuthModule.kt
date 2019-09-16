package org.guis.booking.injector.modules

import android.content.Context
import dagger.Module
import dagger.Provides
import org.guis.booking.utils.TokenUtils
import javax.inject.Inject

@Module
class AuthModule (val applicationContext: Context){

    @Provides
    fun tokenUtils() : TokenUtils {
        return TokenUtils(applicationContext)
    }

}