package com.example.monthly

import android.app.Application
import com.example.monthly.utils.Injector

class MonthlyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        Injector.getInjector().setupExpenseDb(this)
    }


}