package com.vangood.bmi2

class Check {
    enum class checkState{
        UNDER, NORMAL, OVER
    }

    fun checkRange( bmi: Float ) :checkState {

        val message = if (bmi < 18.5) checkState.UNDER
        else if ((bmi >= 18.5) && (bmi < 24f)) checkState.NORMAL
        else checkState.OVER

        return message
    }
}