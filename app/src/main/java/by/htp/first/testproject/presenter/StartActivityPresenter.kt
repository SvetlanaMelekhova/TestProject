package by.htp.first.testproject.presenter

import by.htp.first.testproject.model.data.StartData

interface StartActivityPresenter {

    fun addData(startData: StartData)

    fun close()
}