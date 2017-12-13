package com.shantanu.okcalc

import java.util.StringTokenizer

/**
 * Created by Shaan on 12-12-2017.
 */

object ConvertToNumber {
    val DIGITS = arrayOf("one", "two", "three", "four", "five", "six", "seven", "eight", "nine")
    val TENS = arrayOf<String>("", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety")
    val TEENS = arrayOf("ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen")
    val MAGNITUDES = arrayOf("hundred", "thousand", "million", "point")
    val ZERO = arrayOf("zero", "oh")

    fun replaceNumbers(input: String): String {
        var result = ""
        val decimal = input.split(MAGNITUDES[3].toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
        val millions = decimal[0].split(MAGNITUDES[2].toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()

        for (i in millions.indices) {
            val thousands = millions[i].split(MAGNITUDES[1].toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()

            for (j in thousands.indices) {
                val triplet = intArrayOf(0, 0, 0)
                val set = StringTokenizer(thousands[j])

                if (set.countTokens() == 1) { //If there is only one token given in triplet
                    val uno = set.nextToken()
                    triplet[0] = 0
                    for (k in DIGITS.indices) {
                        if (uno == DIGITS[k]) {
                            triplet[1] = 0
                            triplet[2] = k + 1
                        }
                        if (uno == TENS[k]) {
                            triplet[1] = k + 1
                            triplet[2] = 0
                        }
                    }
                } else if (set.countTokens() == 2) {  //If there are two tokens given in triplet
                    val uno = set.nextToken()
                    val dos = set.nextToken()
                    if (dos == MAGNITUDES[0]) {  //If one of the two tokens is "hundred"
                        for (k in DIGITS.indices) {
                            if (uno == DIGITS[k]) {
                                triplet[0] = k + 1
                                triplet[1] = 0
                                triplet[2] = 0
                            }
                        }
                    } else {
                        triplet[0] = 0
                        for (k in DIGITS.indices) {
                            if (uno == TENS[k]) {
                                triplet[1] = k + 1
                            }
                            if (dos == DIGITS[k]) {
                                triplet[2] = k + 1
                            }
                        }
                    }
                } else if (set.countTokens() == 3) {  //If there are three tokens given in triplet
                    val uno = set.nextToken()
                    val dos = set.nextToken()
                    val tres = set.nextToken()
                    for (k in DIGITS.indices) {
                        if (uno == DIGITS[k]) {
                            triplet[0] = k + 1
                        }
                        if (tres == DIGITS[k]) {
                            triplet[1] = 0
                            triplet[2] = k + 1
                        }
                        if (tres == TENS[k]) {
                            triplet[1] = k + 1
                            triplet[2] = 0
                        }
                    }
                } else if (set.countTokens() == 4) {  //If there are four tokens given in triplet
                    val uno = set.nextToken()
                    val dos = set.nextToken()
                    val tres = set.nextToken()
                    val cuatro = set.nextToken()
                    for (k in DIGITS.indices) {
                        if (uno == DIGITS[k]) {
                            triplet[0] = k + 1
                        }
                        if (cuatro == DIGITS[k]) {
                            triplet[2] = k + 1
                        }
                        if (tres == TENS[k]) {
                            triplet[1] = k + 1
                        }
                    }
                } else {
                    triplet[0] = 0
                    triplet[1] = 0
                    triplet[2] = 0
                }

                result = result + Integer.toString(triplet[0]) + Integer.toString(triplet[1]) + Integer.toString(triplet[2])
            }
        }

        if (decimal.size > 1) {  //The number is a decimal
            val decimalDigits = StringTokenizer(decimal[1])
            result = result + "."
            println(decimalDigits.countTokens().toString() + " decimal digits")
            while (decimalDigits.hasMoreTokens()) {
                val w = decimalDigits.nextToken()
                println(w)

                if (w == ZERO[0] || w == ZERO[1]) {
                    result = result + "0"
                }
                for (j in DIGITS.indices) {
                    if (w == DIGITS[j]) {
                        result = result + Integer.toString(j + 1)
                    }
                }

            }
        }

        return result
    }
}
