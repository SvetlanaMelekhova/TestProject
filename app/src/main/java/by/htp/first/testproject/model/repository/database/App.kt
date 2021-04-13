package by.htp.first.testproject.model.repository.database

import android.app.Application
import by.htp.first.testproject.model.repository.DatabaseRepositoryImpl

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        DatabaseRepositoryImpl.initDatabase(applicationContext)
    }
}