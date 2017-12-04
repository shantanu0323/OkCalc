package com.shantanu.okcalc

import android.graphics.Color
import android.graphics.Typeface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class HomeActivity : AppCompatActivity(), View.OnClickListener {

    private val TAG = "MainActivity"
    private var tvResult: TextView? = null
    private var tvQuery: TextView? = null
    private var bClear: Button? = null
    private var b1: Button? = null
    private var b2: Button? = null
    private var b3: Button? = null
    private var bAdd: Button? = null
    private var b4: Button? = null
    private var b5: Button? = null
    private var b6: Button? = null
    private var bSub: Button? = null
    private var b7: Button? = null
    private var b8: Button? = null
    private var b9: Button? = null
    private var bDot: Button? = null
    private var bMul: Button? = null
    private var bCE: Button? = null
    private var b0: Button? = null
    private var bEq: Button? = null
    private var bDiv: Button? = null
    private var str: String? = null
    private var calculated: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        findViews()

        var regularFont = Typeface.createFromAsset(getAssets(), "open_sans_regular.ttf") as Typeface
        var lightFont = Typeface.createFromAsset(getAssets(), "open_sans_light.ttf") as Typeface
        tvResult?.setTypeface(regularFont)
        tvQuery?.setTypeface(lightFont)
        bClear?.setTypeface(lightFont)
        bDot?.setTypeface(lightFont)
        b1?.setTypeface(lightFont)
        b2?.setTypeface(lightFont)
        b3?.setTypeface(lightFont)
        b4?.setTypeface(lightFont)
        b5?.setTypeface(lightFont)
        b6?.setTypeface(lightFont)
        b7?.setTypeface(lightFont)
        b8?.setTypeface(lightFont)
        b9?.setTypeface(lightFont)
        b0?.setTypeface(lightFont)
        bAdd?.setTypeface(lightFont)
        bSub?.setTypeface(lightFont)
        bMul?.setTypeface(lightFont)
        bDiv?.setTypeface(lightFont)
        bCE?.setTypeface(lightFont)
        bEq?.setTypeface(lightFont)
    }

    private fun findViews() {
        tvResult = findViewById<TextView>(R.id.tvResult)
        tvQuery = findViewById<TextView>(R.id.tvQuery)
        bClear = findViewById<Button>(R.id.bClear)
        bDot = findViewById<Button>(R.id.bDot)
        b1 = findViewById<Button>(R.id.b1)
        b2 = findViewById<Button>(R.id.b2)
        b3 = findViewById<Button>(R.id.b3)
        bAdd = findViewById<Button>(R.id.bAdd)
        b4 = findViewById<Button>(R.id.b4)
        b5 = findViewById<Button>(R.id.b5)
        b6 = findViewById<Button>(R.id.b6)
        bSub = findViewById<Button>(R.id.bSub)
        b7 = findViewById<Button>(R.id.b7)
        b8 = findViewById<Button>(R.id.b8)
        b9 = findViewById<Button>(R.id.b9)
        bMul = findViewById<Button>(R.id.bMul)
        bCE = findViewById<Button>(R.id.bCE)
        b0 = findViewById<Button>(R.id.b0)
        bEq = findViewById<Button>(R.id.bEq)
        bDiv = findViewById<Button>(R.id.bDiv)

        bClear?.setOnClickListener(this)
        b1?.setOnClickListener(this)
        b2?.setOnClickListener(this)
        b3?.setOnClickListener(this)
        bAdd?.setOnClickListener(this)
        b4?.setOnClickListener(this)
        b5?.setOnClickListener(this)
        b6?.setOnClickListener(this)
        bSub?.setOnClickListener(this)
        b7?.setOnClickListener(this)
        b8?.setOnClickListener(this)
        b9?.setOnClickListener(this)
        bMul?.setOnClickListener(this)
        bCE?.setOnClickListener(this)
        b0?.setOnClickListener(this)
        bEq?.setOnClickListener(this)
        bDiv?.setOnClickListener(this)
        bDot?.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (calculated) {
            tvResult?.setText("")
            tvQuery?.setText("")
            calculated = false
        }
        if (v === b1) {
            str = tvQuery?.getText().toString()
            tvQuery?.setText(str + "1")
        } else if (v === b2) {
            str = tvQuery?.getText().toString()
            tvQuery?.setText(str + "2")
        } else if (v === b3) {
            str = tvQuery?.getText().toString()
            tvQuery?.setText(str + "3")
        } else if (v === b4) {
            str = tvQuery?.getText().toString()
            tvQuery?.setText(str + "4")
        } else if (v === b5) {
            str = tvQuery?.getText().toString()
            tvQuery?.setText(str + "5")
        } else if (v === b6) {
            str = tvQuery?.getText().toString()
            tvQuery?.setText(str + "6")
        } else if (v === b7) {
            str = tvQuery?.getText().toString()
            tvQuery?.setText(str + "7")
        } else if (v === b8) {
            str = tvQuery?.getText().toString()
            tvQuery?.setText(str + "8")
        } else if (v === b9) {
            str = tvQuery?.getText().toString()
            tvQuery?.setText(str + "9")
        } else if (v === b0) {
            str = tvQuery?.getText().toString()
            tvQuery?.setText(str + "0")
        } else if (v === bDot) {
            str = tvQuery?.getText().toString()
            if (str?.endsWith("+ ")!! || str?.endsWith("- ")!! || str?.endsWith("* ")!! || str?.endsWith("/ ")!! ||
                    str == "") {
                tvQuery?.setText(str + "0.")
            } else if (str?.endsWith(".")!!) {
                // Do Nothing
            } else {
                tvQuery?.setText(str + ".")
            }
        } else if (v === bAdd) {
            str = tvQuery?.getText().toString()
            if (str?.endsWith(".")!!) {
                tvQuery?.setText(str + "0 + ")
            } else if (str?.endsWith("+ ")!! || str?.endsWith("- ")!! || str?.endsWith("* ")!! || str?.endsWith("/ ")!! ||
                    str?.equals("")!!) {
                // Do Nothing
            } else {
                tvQuery?.setText(str + " + ")
            }
        } else if (v === bSub) {
            str = tvQuery?.getText().toString()
            if (str?.endsWith(".")!!) {
                tvQuery?.setText(str + "0 - ")
            } else if (str!!.endsWith("+ ") || str!!.endsWith("- ") || str!!.endsWith("* ") || str!!.endsWith("/ ") ||
                    str == "") {
                // Do Nothing
            } else {
                tvQuery?.setText(str + " - ")
            }
        } else if (v === bMul) {
            str = tvQuery?.getText().toString()
            if (str!!.endsWith(".")) {
                tvQuery?.setText(str + "0 * ")
            } else if (str!!.endsWith("+ ") || str!!.endsWith("- ") || str!!.endsWith("* ") || str!!.endsWith("/ ") ||
                    str == "") {
                // Do Nothing
            } else {
                tvQuery?.setText(str + " * ")
            }
        } else if (v === bDiv) {
            str = tvQuery?.getText().toString()
            if (str!!.endsWith(".")) {
                tvQuery?.setText(str + "0 / ")
            } else if (str!!.endsWith("+ ") || str!!.endsWith("- ") || str!!.endsWith("* ") || str!!.endsWith("/ ") ||
                    str == "") {
                // Do Nothing
            } else {
                tvQuery?.setText(str + " / ")
            }
        } else if (v === bClear) {
            // Handle clicks for bClear
            str = tvQuery?.getText().toString()
            if (str == "") {
                // Do Nothing
            } else if (str!!.endsWith("+ ") || str!!.endsWith("- ") || str!!.endsWith("* ") || str!!.endsWith("/ ")) {
                tvQuery?.setText(str!!.substring(0, str!!.length - 3))
            } else {
                tvQuery?.setText(str!!.substring(0, str!!.length - 1))
            }
        } else if (v === bCE) {
            str = ""
            tvQuery?.setText("")
            tvResult?.setText("")
        } else if (v === bEq) {
            str = tvQuery?.getText().toString()
            if (str!!.length == 0 || str!!.endsWith(" ")) {
                tvResult?.setText("Complete the Expression")
                tvResult?.setTextColor(Color.rgb(200, 0, 0))
            } else {
                if (str!!.endsWith(".")) {
                    str += "0"
                }
                tvQuery?.setText(str)
                var result = ""
                result = calculate(str!!)
                try {
                    result = calculate(str!!)
                } catch (e: Exception) {
                    result = "ERROR"
                    tvResult?.setTextColor(Color.rgb(200, 0, 0))
                    Toast.makeText(applicationContext, "ERROR : " + e.message, Toast.LENGTH_LONG).show()
                }

                tvResult?.setText(result)
                calculated = true
            }
        }
    }

    private fun calculate(str: String): String {
        var str = str
        var result = 0.0f
        Log.i(TAG, "calculate: started")
        str = str.replace(" ", "")
        str += "#"

        var s = ""
        var ch: Char
        var i: Int
        var startIndex = 0
        var endIndex = 0
        var reset = true
        var operator = false

        if (str.contains("/")) {
            i = 0
            while (i < str!!.length) {
                Log.i(TAG, "calculate: i = " + i)
                ch = str[i]
                Log.i(TAG, "calculate: ch = '$ch'")
                if (Character.isDigit(ch) || ch == '.' || ch == '/') {
                    s += ch
                    Log.i(TAG, "calculate: s = '$s'")
                    if (reset) {
                        startIndex = i
                        Log.i(TAG, "calculate: startIndex = " + startIndex)
                        reset = false
                        Log.i(TAG, "calculate: reset = " + reset)
                    }
                    if (ch == '/') {
                        operator = true
                        Log.i(TAG, "calculate: operator = " + operator)
                    }
                } else if (ch == '-' || ch == '*' || ch == '+' || ch == '#') {
                    if (!operator) {
                        s = ""
                        reset = true
                        operator = false
                    } else {
                        endIndex = i
                        Log.i(TAG, "calculate: endIndex = " + endIndex)
                        val num = s.split("/".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
                        var res = java.lang.Float.parseFloat(num[0])
                        for (x in 1 until num.size) {
                            res /= java.lang.Float.parseFloat(num[x])
                        }
                        Log.i(TAG, "calculate: res(float) = '$res'")
                        val resStr = res.toString() //String.format("%.02f", res);
                        Log.i(TAG, "calculate: resStr = '$resStr'")
                        str = str.replace(s, resStr)
                        Log.i(TAG, "calculate: str(changed) = '$str'")
                        i = startIndex + resStr.length
                        Log.i(TAG, "calculate: i(changed) = " + i)
                        s = ""
                        reset = true
                        operator = false
                    }
                }
                i++
            }
        }


        Log.i(TAG, "\n\ncalculate: str = '$str'")

        if (str.contains("*")) {
            i = 0
            while (i < str.length) {
                Log.i(TAG, "calculate: i = " + i)
                ch = str[i]
                Log.i(TAG, "calculate: ch = '$ch'")
                if (Character.isDigit(ch) || ch == '.' || ch == '*') {
                    s += ch
                    Log.i(TAG, "calculate: s = '$s'")
                    if (reset) {
                        startIndex = i
                        Log.i(TAG, "calculate: startIndex = " + startIndex)
                        reset = false
                        Log.i(TAG, "calculate: reset = " + reset)
                    }
                    if (ch == '*') {
                        operator = true
                        Log.i(TAG, "calculate: operator = " + operator)
                    }
                } else if (ch == '-' || ch == '+' || ch == '#') {
                    if (!operator) {
                        s = ""
                        reset = true
                        operator = false
                    } else {
                        endIndex = i
                        Log.i(TAG, "calculate: endIndex = " + endIndex)
                        val num = s.split("[*]".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
                        var res = 1.0f
                        for (x in num.indices) {
                            res *= java.lang.Float.parseFloat(num[x])
                        }
                        Log.i(TAG, "calculate: res(float) = '$res'")
                        val resStr = res.toString() //String.format("%.02f", res);
                        Log.i(TAG, "calculate: resStr = '$resStr'")
                        str = str.replace(s, resStr)
                        Log.i(TAG, "calculate: str(changed) = '$str'")
                        i = startIndex + resStr.length
                        Log.i(TAG, "calculate: i(changed) = " + i)
                        s = ""
                        reset = true
                        operator = false
                    }
                }
                i++
            }
        }

        Log.i(TAG, "\n\ncalculate: str = '$str'")

        if (str.contains("+") || str.contains("-")) {
            var pos = 0.0f
            var neg = 0.0f
            var negative = false
            s = ""
            i = 0
            while (i < str.length) {
                Log.i(TAG, "calculate: i = " + i)
                ch = str[i]
                Log.i(TAG, "calculate: ch = '$ch'")
                if (Character.isDigit(ch) || ch == '.') {
                    s += ch
                    Log.i(TAG, "calculate: s = '$s'")
                } else {
                    if (s.length != 0) {
                        if (negative) {
                            neg += java.lang.Float.parseFloat(s)
                            Log.i(TAG, "calculate: neg = " + neg)
                        } else {
                            pos += java.lang.Float.parseFloat(s)
                            Log.i(TAG, "calculate: pos = " + pos)
                        }
                    }
                    if (ch == '-') {
                        negative = true
                    } else if (ch == '+') {
                        negative = false
                    }
                    s = ""
                }
                i++
            }
            str = "" + (pos - neg)
        }

        if (str.contains("#")) {
            str = str.substring(0, str.length - 1)
        }
        result = java.lang.Float.parseFloat(str)
        if (result == result.toInt().toFloat()) {
            str = "" + result.toInt()
        }
        Log.i(TAG, "\n\ncalculate: str = '$str'")
        return str
    }

}

