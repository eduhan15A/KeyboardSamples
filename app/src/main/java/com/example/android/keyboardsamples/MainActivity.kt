package com.example.android.keyboardsamples

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.Spinner
import android.widget.ArrayAdapter






class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    private var mSpinnerLabel = ""
    companion object {
         var TAG = MainActivity::class.java.simpleName;
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spinner = findViewById<View>(R.id.label_spinner) as Spinner
        if (spinner != null) {
            spinner.onItemSelectedListener = this
        }

        // Create ArrayAdapter using the string array and default spinner layout.
        val adapter = ArrayAdapter.createFromResource(this,
                R.array.labels_array, android.R.layout.simple_spinner_item)

        // Specify the layout to use when the list of choices appears.
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner.
        if (spinner != null) {
            spinner.setAdapter(adapter);
        }

    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

        mSpinnerLabel = parent?.getItemAtPosition(position).toString();
        showText( view!! )
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        Log.d(TAG, getString(R.string.nothing_selected));

    }


    fun showText (view: View){

            val showString = editText_main.text.toString()+ " - " + mSpinnerLabel
            text_phoneLabel.text = showString
            Toast.makeText(this, showString, Toast.LENGTH_SHORT).show()
        }

    }

