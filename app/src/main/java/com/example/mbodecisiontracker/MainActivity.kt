package com.example.mbodecisiontracker

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_main.*
import java.io.File
import java.nio.file.Paths
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
        //val outputString: String = "defaultOutputString"
        val tv1 =findViewById<TextView>(R.id.tv1)
        val tv2 =findViewById<TextView>(R.id.tv2)

        val btn1 = findViewById<Button>(R.id.button)
        btn1?.setOnClickListener {
            createEntry(true, tv1)
            createEntryWithClass(true)
        }

        val btn2 = findViewById<Button>(R.id.button2)
        btn2?.setOnClickListener {
            createEntry(false, tv1)
            createEntryWithClass(false)
        }

        val btndatum = findViewById<Button>(R.id.btnDatum)
        btndatum?.setOnClickListener {
            createDateEntry(tv1,tv2)
            }


    }

    private fun createEntryWithClass(wert: Boolean) {
        val current = LocalDateTime.now()
        val uhrzeit = current.format(DateTimeFormatter.ofPattern("HH:mm:ss"))
        val datum = current.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
        if (wert) {
            var entryobject: entryClass = entryClass(datum,uhrzeit,"wahr")

            // content to be appended to file
            var content:String = " This is additional content added to the File."
            // using extension function appendText
            File("MbhDecisionTrackerTest1.csv").appendText(content)

        }
        if (!wert) {
            var entryobject: entryClass = entryClass(datum,uhrzeit,"falsch")
        }
    }

    private fun createEntry(boolean: Boolean, tv1: TextView) {

        if (boolean) {
            //tv1.text="wahr"
            val path = System.getProperty("user.dir")
            tv1.text= createDateString() + ";wahr;" + path
            Toast.makeText(this, "Hi there! This is a Toast.", Toast.LENGTH_SHORT).show()
        }
        if (!boolean) {
            //tv1.text="falsch"
            val path = Paths.get("").toAbsolutePath().toString()
            tv1.text= createDateString() + ";falsch;" + path
            Toast.makeText(this, "Hi there! This is a Toast.", Toast.LENGTH_LONG).show()
        }
    }
    private fun createDateEntry(tv1: TextView, tv2:TextView) {

        //val date =
        val current = LocalDateTime.now()
        //Date(2020, 01, 15, 20, 24, 22)
        //current.year.toString()
        var output: String= createDateString()
       /* output += current.year.toString()
        output += current.monthValue.toString()
        output += current.dayOfMonth.toString()
        output += ";"
        //output += current.toLocalTime().toString()
        output += current.hour.toString()
        output += current.minute.toString()
        output += current.second.toString()
        output += ";"*/
        output += tv1.text.toString()
            tv1.text=current.year.toString()
            tv2.text=output

    }

    private fun createDateString(): String {
        val current = LocalDateTime.now()

        return current.format(DateTimeFormatter.ofPattern("yyyy-MM-dd;HH:mm:ss"))


        //Date(2020, 01, 15, 20, 24, 22)
        //current.year.toString()
        var output: String = ""
        output += current.year.toString()
        output += current.monthValue.toString()
        output += current.dayOfMonth.toString()
        output += ";"
        //output += current.toLocalTime().toString()
        //output += current.toLocalTime().format("hhmmss")
        output += current.minute.toString()
        output += current.second.toString()
        output += ";"
        //return output
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
class entryClass {
  //var id: String? = null
  var datum: String? = null
  var uhrzeit: String? = null
  var wert: String? = null

  constructor() {}
  constructor(datum: String?, uhrzeit: String?, wert: String?) {
    this.datum = datum
    this.uhrzeit = uhrzeit
    this.wert = wert
  }

  override fun toString(): String {
    //return "Eintrag [id=" + id + ", name=" + name + ", address=" + address + ", age=" + age + "]"
    return datum + ";" + uhrzeit + ";" + wert
  }
}