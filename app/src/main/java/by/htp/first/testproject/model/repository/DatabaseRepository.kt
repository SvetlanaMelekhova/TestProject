package by.htp.first.testproject.model.repository

import by.htp.first.testproject.model.data.StartData

interface DatabaseRepository {

    suspend fun addData(startData: StartData)
}