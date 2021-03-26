package gaur.himanshu.august.reversebits

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val enterNumber = findViewById<EditText>(R.id.expression_edit_text)
        val button = findViewById<Button>(R.id.check_expression)
        val actualBitsTextView = findViewById<TextView>(R.id.actual_bits)
        val reversedbits = findViewById<TextView>(R.id.reversed_bits)
        val result = findViewById<TextView>(R.id.final_result)




        button.setOnClickListener {
            val number = enterNumber.text.toString().trim()
            if (number.isEmpty()) {
                return@setOnClickListener
            }

            val binary = convertDecimalToBinary(number.toInt())
            actualBitsTextView.text = "Bits of the Given Number is :  ${binary}"
            reversedbits.text = "Reversed Bits is :  ${binary.toString().reversed()}"

            val finalResult = convertBinaryToDecimal(binary.toString())
            result.text = "Final Number is :  ${finalResult}"

        }





    }


    private fun convertDecimalToBinary(num: Int): Int {
        return if (num == 0) {
            0
        } else {
            num % 2 + 10 * (convertDecimalToBinary(num / 2))
        }

    }

    private fun convertBinaryToDecimal(num: String): Int {
        var result = 0
        var numLength = 0
        num.forEach {
            val power = 2.0.pow(numLength.toDouble()).toInt()
            val binary = it.toString().toInt()
            result += binary * power
            numLength += 1;
        }

        return result
    }


}