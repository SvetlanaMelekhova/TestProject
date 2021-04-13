package by.htp.first.testproject.model.repository

import android.content.Context
import by.htp.first.testproject.model.data.StartData
import by.htp.first.testproject.model.repository.database.StartDataDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DatabaseRepositoryImpl(): DatabaseRepository {

    companion object{
        private lateinit var database: StartDataDatabase
        fun initDatabase(context: Context){
            database = StartDataDatabase.getDatabase(context)
        }
    }

    private val threadIO = Dispatchers.IO

    override suspend fun addData(startData: StartData) {
        withContext(threadIO) {
            database.getStartDatabaseDao().addData(startData)
        }
    }
}