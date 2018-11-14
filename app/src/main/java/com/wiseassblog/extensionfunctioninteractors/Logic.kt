package com.wiseassblog.extensionfunctioninteractors

import com.wiseassblog.domain.ServiceLocator
import com.wiseassblog.domain.getStringData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

//Garden variety Presenter/Controller thing
class Logic(val locator: ServiceLocator,
            val uiContext: CoroutineContext,
            val ioContext: CoroutineContext,
            val view: IView): CoroutineScope {

    protected lateinit var jobTracker: Job

    override val coroutineContext: CoroutineContext
        get() = uiContext + jobTracker

    init {
        jobTracker = Job()
    }

    fun onStart() = launch {
        val result = getStringData(locator)

        updateView(result)
    }

    fun updateView(result:String){
        view.updateUI(result)
    }
}