package by.htp.first.testproject.presenter.impl

import by.htp.first.testproject.model.data.StartData
import by.htp.first.testproject.model.repository.DatabaseRepository
import by.htp.first.testproject.model.repository.DatabaseRepositoryImpl
import by.htp.first.testproject.presenter.StartActivityPresenter
import kotlinx.coroutines.*

class StartActivPresenterImpl : StartActivityPresenter {

    private val databaseRepository: DatabaseRepository = DatabaseRepositoryImpl()
    private val scope: CoroutineScope = CoroutineScope(Dispatchers.Main + Job())

    override fun addData(startData: StartData) {
        scope.launch {
            databaseRepository.addData(startData)
        }
    }

    override fun close() {
        scope.cancel()
    }
}