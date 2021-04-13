package by.htp.first.testproject.model.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "start_data")
data class StartData(
    @ColumnInfo val operator: String,
    @ColumnInfo val customer: String,
    @ColumnInfo val farm: String,
    @ColumnInfo val field: String
){
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo var id: Long? = null
}