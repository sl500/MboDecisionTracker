package com.example.mbodecisiontracker

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView

import kotlinx.android.synthetic.main.activity_main.*
import java.time.LocalDateTime

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        val tv1 =findViewById<TextView>(R.id.tv1)

        val btn1 = findViewById<Button>(R.id.button)
        btn1?.setOnClickListener {
            createEntry(true, tv1)
        }

        val btn2 = findViewById<Button>(R.id.button2)
        btn2?.setOnClickListener {
            createEntry(false, tv1)
        }

        val btndatum = findViewById<Button>(R.id.btnDatum)
        btndatum?.setOnClickListener {
            createDateEntry(tv1)
            }


    }
    private fun createEntry(boolean: Boolean, tv1: TextView) {

        if (boolean) {
            tv1.text="wahr"
        }
        if (!boolean) {
            tv1.text="falsch"
        }
    }
    private fun createDateEntry(tv1: TextView) {

        //val date =
        val current = LocalDateTime.now()
        //Date(2020, 01, 15, 20, 24, 22)
        //current.year.toString()


            tv1.text=current.year.toString()

    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}