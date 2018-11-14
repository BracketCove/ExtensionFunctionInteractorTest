package com.wiseassblog.extensionfunctioninteractors

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.wiseassblog.data.DataSourecImpl
import com.wiseassblog.domain.ServiceLocator
import kotlinx.coroutines.Dispatchers

class MainActivity : AppCompatActivity(), IView {
    lateinit var logic: Logic

    override fun updateUI(result: String) {
        findViewById<TextView>(R.id.lbl_blin).text = result
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        logic = Logic(
            ServiceLocator(DataSourecImpl()),
            Dispatchers.Main,
            Dispatchers.IO,
            this
        )

        findViewById<Button>(R.id.button)
            .setOnClickListener {
                logic.onStart()
            }

    }
}
