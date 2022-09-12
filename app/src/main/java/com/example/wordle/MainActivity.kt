package com.example.wordle

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.wordle.FourLetterWordList.getRandomFourLetterWord

class MainActivity : AppCompatActivity() {
    var counter = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.button)
        val textView = findViewById<TextView>(R.id.textView)
        val textView2 = findViewById<TextView>(R.id.textView2)
        val textView3 = findViewById<TextView>(R.id.textView3)
        val textView4 = findViewById<TextView>(R.id.textView4)
        val textView5 = findViewById<TextView>(R.id.textView5)
        val textView6 = findViewById<TextView>(R.id.textView6)
        val textView7 = findViewById<TextView>(R.id.textView7)
        val textView8 = findViewById<TextView>(R.id.textView8)
        val textView9 = findViewById<TextView>(R.id.textView9)
        val textView10 = findViewById<TextView>(R.id.textView10)
        val textView11 = findViewById<TextView>(R.id.textView11)
        val textView12 = findViewById<TextView>(R.id.textView12)
        val textView13 = findViewById<TextView>(R.id.textView13)
        val editText = findViewById<EditText>(R.id.editText)
        button.setOnClickListener {
            //Toast.makeText(it.context, "Clicked Button!", Toast.LENGTH_SHORT).show()
            counter++
            if (counter == 1) {
                textView7.text = editText.text.toString().uppercase()
                textView8.text = checkGuess(textView7.text.toString())

                // if guessed correctly toast - u guessed correctly
                // else toast u have 2 more tries
            }
            if (counter == 2) {
                textView9.text = editText.text.toString().uppercase()
                textView10.text = checkGuess(textView9.text.toString())
                //val guess2 = checkGuess(textView9.text as String)
                //textView10.text = guess2

                // else toast u have 1 more try

            }
            if (counter == 3) {
                textView11.text = editText.text.toString().uppercase()
                textView12.text = checkGuess(textView11.text.toString())
                //val guess3 = checkGuess(textView11.text as String)
                //textView13.text = guess3
                // show check guess check guess 1

                // if guessed correctly toast - u guessed correctly
                // sorry u lose and display the hidden word (invisible to visible)

            }

            if (counter > 3) {
                button.setClickable(false);
                textView13.text = wordToGuess
                textView13.visibility = View.VISIBLE
                button.setBackgroundColor(Color.GRAY)
                Toast.makeText(this, "Max tries reached", Toast.LENGTH_SHORT).show()

                //show the hidden word

            }

        }
    }

    // grab a random four letter and save that as the word to guess
    val wordToGuess = getRandomFourLetterWord()


     fun checkGuess(guess: String) : String {
        var result = ""
        for (i in 0..3) {
            if (guess[i] == wordToGuess[i]) {
                result += "O"
            }
            else if (guess[i] in wordToGuess) {
                result += "+"
            }
            else {
                result += "X"
            }
        }
        return result
    }

    //we can use the invisible feature on the button so that when counter = 1 show this, and then
    // check and show y
    // clear the edittext upon submitting an input
    // we need to save the users input to a variable
    // we need to connect the button and the input so that when clicked the input is saved to a variable



}