package com.anthonycomeaux.kotlincounterapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

private const val TEXT_CONTENT = "content"

class MainActivity : AppCompatActivity() {


    private var editText: EditText? = null
    private var submitButton: Button? = null
    private var clearButton: Button? = null
    private var textView: TextView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        editText = findViewById(R.id.edit_text)
        submitButton = findViewById(R.id.button_id)
        clearButton = findViewById(R.id.clear_id)
        textView = findViewById(R.id.textView)
        textView?.movementMethod = ScrollingMovementMethod()
        submitButton?.setOnClickListener {
            var text = if (editText?.text.isNullOrBlank()) "" else "${ Typography.bullet }  ${ editText?.editableText } \n"
            textView?.append(text)
            editText?.text?.clear()
        }
        clearButton?.setOnClickListener {
            textView?.text = ""
            editText?.text?.clear()
        }
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        textView?.text = savedInstanceState?.getString(TEXT_CONTENT, "")
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putString(TEXT_CONTENT, textView?.text.toString())
    }

}
