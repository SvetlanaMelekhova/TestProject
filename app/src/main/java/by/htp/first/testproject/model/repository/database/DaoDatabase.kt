package by.htp.first.testproject.model.repository.database

import androidx.room.Dao
import androidx.room.Insert
import by.htp.first.testproject.model.data.StartData

@Dao
interface DaoDatabase {

    @Insert
    fun addData(startData: StartData)
}