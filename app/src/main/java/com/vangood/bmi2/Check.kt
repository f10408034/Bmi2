package com.vangood.bmi2

class Check {
    fun checkRange( bmi: Float ) :String {
        if (bmi < 18.5) {
            return ("underweight")
        } else {
            if ((bmi >= 18.5) && (bmi < 24f)) {
                return ("normal range")
            } else return ("overweight")
        }
    }
}