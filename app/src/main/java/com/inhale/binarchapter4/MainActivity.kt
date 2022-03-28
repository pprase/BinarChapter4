package com.inhale.binarchapter4


import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.cardview.widget.CardView

class MainActivity : AppCompatActivity() {

    var playerChoice: String = ""
    var comChoice: String = ""

    var cardView4: CardView? = null
    var cardView5: CardView? = null
    var cardView6: CardView? = null
    var textVs: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonRetry = findViewById<Button>(R.id.button1)

        val cardview1 = findViewById<CardView>(R.id.cardimage1)
        val cardView2 = findViewById<CardView>(R.id.cardimage2)
        val cardView3 = findViewById<CardView>(R.id.cardimage3)

        cardView4 = findViewById(R.id.cardimage4)
        cardView5 = findViewById(R.id.cardimage5)
        cardView6 = findViewById(R.id.cardimage6)
        textVs = findViewById(R.id.vsTengah)


        fun background() {
            cardview1.setCardBackgroundColor(Color.TRANSPARENT)
            cardView2.setCardBackgroundColor(Color.TRANSPARENT)
            cardView3.setCardBackgroundColor(Color.TRANSPARENT)
            cardView4?.setCardBackgroundColor(Color.TRANSPARENT)
            cardView5?.setCardBackgroundColor(Color.TRANSPARENT)
            cardView6?.setCardBackgroundColor(Color.TRANSPARENT)
            textVs?.text = getString(R.string.VsTengah)
            textVs?.setBackgroundColor(Color.TRANSPARENT)
        }

        fun retryButton(): Boolean {
            var flag = true
            if (cardview1.cardBackgroundColor.isOpaque || cardView2.cardBackgroundColor.isOpaque || cardView3.cardBackgroundColor.isOpaque) flag =
                false
            return flag
        }
        background()

        cardview1.setOnClickListener {
            if (retryButton()) {
                background();cardview1.setCardBackgroundColor(Color.parseColor("#CAA947"));playerChoice =
                    "gunting";Log.d("Player Memilih:", "Gunting");hasil()
            }
        }
        cardView2.setOnClickListener {
            if (retryButton()) {
                background();cardView2.setCardBackgroundColor(Color.parseColor("#CAA947"));playerChoice =
                    "kertas";Log.d("Player Memilih:", "Kertas");hasil()
            }
        }

        cardView3.setOnClickListener {
            if (retryButton()) {
                background(); cardView3.setCardBackgroundColor(Color.parseColor("#CAA947"));playerChoice =
                    "batu";Log.d("Player Memilih:", "Batu");hasil()
            }
        }
        buttonRetry.setOnClickListener { background() }
    }
    private fun hasil() {
        val cpu = (1..3).random()
        if (cpu == 1) {
            comChoice = "gunting";cardView4?.setCardBackgroundColor(Color.parseColor("#c3dae9"))
        }
        if (cpu == 2) {
            comChoice = "kertas";cardView5?.setCardBackgroundColor(Color.parseColor("#c3dae9"))
        }
        if (cpu == 3) {
            comChoice = "batu";cardView6?.setCardBackgroundColor(Color.parseColor("#c3dae9"))
        }
        when (playerChoice) {
            comChoice -> {
                textVs?.text = getString(R.string.hasilDraw);Log.d("Hasil Permainan:", "Draw")
            }
            "gunting" -> {
                when (comChoice) {
                    "kertas" -> {
                        textVs?.text = getString(R.string.player1Menang);Log.d(
                            "Result Permainan:",
                            "Pemain 1 Menang"
                        );textVs?.setBackgroundColor(Color.CYAN)
                    }
                    "batu" -> {
                        textVs?.text = getString(R.string.computerMenang);Log.d(
                            "Result Permainan:",
                            "COM Menang"
                        );textVs?.setBackgroundColor(Color.MAGENTA)
                    }
                }
            }
            "kertas" -> {
                when (comChoice) {
                    "batu" -> {
                        textVs?.text = getString(R.string.player1Menang);Log.d(
                            "Hasil Permainan:",
                            "Pemain 1 Menang"
                        );textVs?.setBackgroundColor(Color.CYAN)
                    }
                    "gunting" -> {
                        textVs?.text = getString(R.string.computerMenang);Log.d(
                            "Hasil Permainan:",
                            "COM Menang"
                        );textVs?.setBackgroundColor(Color.MAGENTA)
                    }
                }
            }
            "batu" -> {
                when (comChoice) {
                    "gunting" -> {
                        textVs?.text = getString(R.string.player1Menang);Log.d(
                            "Hasil Permainan:",
                            "Pemain 1 Menang"
                        );textVs?.setBackgroundColor(Color.CYAN)
                    }
                    "kertas" -> {
                        textVs?.text = getString(R.string.computerMenang);Log.d(
                            "Hasil Permainan:",
                            "COM Menang"
                        );textVs?.setBackgroundColor(Color.MAGENTA)
                    }
                }
            }
        }
    }

}
