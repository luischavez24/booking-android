package org.guis.booking.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.guis.booking.BookingApplication
import org.guis.booking.R
import org.guis.booking.data.SwapiService
import org.guis.booking.injector.components.DaggerPeopleComponent
import org.guis.booking.utils.TokenUtils
import retrofit2.HttpException
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var swapiService: SwapiService

    @Inject
    lateinit var tokenUtils: TokenUtils

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    fun coreComponent() = BookingApplication.coreComponent(this)

    fun init() {

        DaggerPeopleComponent.builder()
            .coreComponent(coreComponent())
            // modules
            .build()
            .inject(this)

        tokenUtils.saveToken("TEST_TOKEN")

        GlobalScope.launch {
            try {
                textView.text = "Loading..."
                textView.text = swapiService.findPerson(1)
                    .await()
                    .toString()
            } catch (e : HttpException) {
                Toast.makeText(applicationContext, "${e.code()}, ${e.message()}", Toast.LENGTH_LONG).show()
            }

        }

        btnHelloWorld.setOnClickListener {
            Toast.makeText(applicationContext, "Message", Toast.LENGTH_LONG).show()
        }
    }
}
