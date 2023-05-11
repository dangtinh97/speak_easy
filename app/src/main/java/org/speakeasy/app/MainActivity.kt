package org.speakeasy.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.messaging.FirebaseMessaging

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getToken()
    }

    private fun getToken()
    {
        FirebaseMessaging.getInstance().token.addOnCompleteListener(OnCompleteListener { task ->
            if (!task.isSuccessful) {
                Toast.makeText(this,"Fetching FCM registration token failed",Toast.LENGTH_LONG).show()
                return@OnCompleteListener
            }

            // Get new FCM registration token
            val token = task.result
            println("====>token ${token} |")
            Toast.makeText(baseContext, "Get token successfuly!", Toast.LENGTH_SHORT).show()
        })
    }
}