package com.wiseassblog.extensionfunctioninteractors

import com.wiseassblog.domain.ServiceLocator
import com.wiseassblog.domain.getStringData
import io.mockk.coEvery
import io.mockk.mockk
import io.mockk.mockkStatic
import io.mockk.verify
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class LogicTest {

    val locator: ServiceLocator = mockk()
    val view: IView = mockk(relaxed = true)
    val testData = "Oy Blin"

    lateinit var logic: Logic


    /**
     * On start, get data from datasource
     */
    @Test
    fun `On Start Event`() = runBlocking{
        logic = Logic(locator,
            Dispatchers.Unconfined,
            Dispatchers.Unconfined,
            view
        )

        mockkStatic("com.wiseassblog.domain.InteractorExtKt")

        logic.onStart()

        coEvery{
            getStringData(locator)
        } returns testData

        verify { view.updateUI(testData) }
    }
}
