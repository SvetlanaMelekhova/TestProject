package by.htp.first.testproject.model.repository.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import by.htp.first.testproject.model.data.StartData

@Database(entities = [StartData::class], version = 1, exportSchema = false)
abstract class StartDataDatabase : RoomDatabase() {

    abstract fun getStartDatabaseDao(): DaoDatabase

    companion object {
        private var INSTANSE: StartDataDatabase? = null
        fun getDatabase(context: Context): StartDataDatabase {
            if (INSTANSE == null) {
                INSTANSE =
                    Room.databaseBuilder(context, StartDataDatabase::class.java, "start_data")
                        .build()
            }
            return INSTANSE as StartDataDatabase
        }
    }
}
