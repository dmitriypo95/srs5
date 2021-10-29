package com.example.srs5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import kotlin.random.Random

private const val LOG_TAG = "MyLog"
private const val VALUE = "Value"

class MainActivity : AppCompatActivity() {
    private lateinit var textViewMain : TextView
    private lateinit var buttonM : Button

    private var loop = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(LOG_TAG, getString(R.string.one))
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textViewMain = findViewById(R.id.text_view_main)
        buttonM = findViewById(R.id.button_main)

        if (savedInstanceState != null)
            textViewMain.text = savedInstanceState.getString(VALUE)
        else
            randomize()
        buttonM.setOnClickListener{
            loop = 0
            randomize()
        }
    }
    private fun randomize(){
        val randomVal = Random.nextInt(100)
        textViewMain.text = randomVal.toString()
    }

    override fun onStart() {
        if (loop == 0)
            Log.d(LOG_TAG, getString(R.string.two))
        else if (loop == 1)
            Log.d(LOG_TAG, getString(R.string.seven))
        else
            Log.d(LOG_TAG, getString(R.string.twelve))
        super.onStart()
    }
    override fun onResume() {
        if (loop == 0)
            Log.d(LOG_TAG, getString(R.string.three))
        else if (loop == 1)
            Log.d(LOG_TAG, getString(R.string.eight))
        else
            Log.d(LOG_TAG, "The End")
        super.onResume()
    }
    override fun onPause() {
        if (loop == 0){
            Log.d(LOG_TAG, getString(R.string.four))
        }
        else if (loop == 1)
            Log.d(LOG_TAG, getString(R.string.nine))
        super.onPause()
    }
    override fun onStop() {
        if (loop == 0) {
            Log.d(LOG_TAG, getString(R.string.five))
        }
        else if (loop == 1){
            Log.d(LOG_TAG, getString(R.string.ten))
            loop++
        }
        super.onStop()
    }

    override fun onRestart() {
       if(loop == 0){
             Log.d(LOG_TAG,getString(R.string.six))
             loop++
       }
       else
            Log.d(LOG_TAG,getString(R.string.eleven))
        super.onRestart()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(VALUE, textViewMain.text.toString())
    }

}