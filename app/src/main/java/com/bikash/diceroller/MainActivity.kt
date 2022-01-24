package com.bikash.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

/**
 * this activity allows the user to roll the dice and view the result
 * on screen
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener {
            rollDice()

        }
        // do a dice roll when a app start
        rollDice()
    }

    /**
     * roll the dice and update the screen with result
     */
    private fun rollDice() {
        //create new dice object with sides 6 and roll it
        val dice = Dice(6)
        val diceRoll = dice.roll()
        //find the image view onm the layout
        val diceImage: ImageView = findViewById(R.id.imageView5)

        //determine which dice roll to updated on the screen

        val drawableResource = when(diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        //update the image view with coreect resource id
        diceImage.setImageResource(drawableResource)

        //update the content description

        diceImage.contentDescription = diceRoll.toString()
    }
}

class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}