package org.guis.booking.injector.components

import dagger.Component
import org.guis.booking.activities.MainActivity
import org.guis.booking.injector.modules.RetrofitModule
import org.guis.booking.injector.modules.SwapiModule

@Component(modules = [SwapiModule::class], dependencies = [CoreComponent::class])
interface PeopleComponent {
    fun inject(mainActivity: MainActivity)
    @Component.Builder
    interface Builder {
        fun build(): PeopleComponent
        fun coreComponent(coreComponent: CoreComponent): Builder
    }
}