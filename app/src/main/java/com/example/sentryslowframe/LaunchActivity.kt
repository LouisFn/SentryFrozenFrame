package com.example.sentryslowframe

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import java.util.concurrent.TimeUnit

class LaunchActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val testWorkRequest =
            OneTimeWorkRequestBuilder<TestWorker>()
                .setInitialDelay(30, TimeUnit.SECONDS)
                .build()

        WorkManager
            .getInstance(this)
            .enqueue(testWorkRequest)

        startActivity(Intent(this, MainActivity::class.java))
    }
}