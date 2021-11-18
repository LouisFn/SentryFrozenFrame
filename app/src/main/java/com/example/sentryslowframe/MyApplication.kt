package com.example.sentryslowframe

import android.app.Application
import android.util.Log
import io.sentry.Sentry
import io.sentry.SentryLevel
import io.sentry.android.core.SentryAndroid
import io.sentry.android.fragment.FragmentLifecycleIntegration
import io.sentry.protocol.User
import kotlin.random.Random

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        setupSentry()
    }

    private fun setupSentry() {
        SentryAndroid.init(this) { options ->
            with(options) {
                dsn = DSN
                environment = BuildConfig.BUILD_TYPE
                isAnrEnabled = false
                isAnrReportInDebug = false
                isEnableAutoSessionTracking = true

                options.tracesSampleRate = 1.0

                setDebug(BuildConfig.DEBUG)
                setDiagnosticLevel(SentryLevel.DEBUG)

                addIntegration(
                    FragmentLifecycleIntegration(
                        this@MyApplication,
                        enableFragmentLifecycleBreadcrumbs = true,
                        enableAutoFragmentLifecycleTracing = true
                    )
                )
            }
        }

        Sentry.setUser(User().apply {
            username = "MyUsername"
        })
    }

    companion object {
        private const val TAG = "MyApplication"
        private const val DSN = ""
    }

}