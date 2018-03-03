package com.acme.tipcalculator.viewmodel

import android.databinding.Bindable
import com.acme.tipcalculator.BR
import com.acme.tipcalculator.model.Calculator
import com.acme.tipcalculator.model.TipCalculation
import timber.log.Timber

class CalculatorViewModel constructor(private val calculator: Calculator = Calculator()) : BaseObservableViewModel() {

    var checkAmtInput = ""
    var tipPctInput = ""

    init {
        Timber.d("Init")
    }

    @Bindable
    var tipCalculation = TipCalculation()

    fun calculateTip() {

        val checkAmt = checkAmtInput.toDoubleOrNull()
        val tipPctAmt = tipPctInput.toIntOrNull()

        if(checkAmt != null && tipPctAmt != null) {
            tipCalculation = calculator.calculateTip(checkAmt, tipPctAmt)
            notifyPropertyChanged(BR.tipCalculation)
        }

    }

    fun loadTipCalc(tc: TipCalculation) {
        checkAmtInput = tc.checkAmount.toString()
        tipPctInput = tc.tipPct.toString()
        tipCalculation = tc
        notifyChange()
    }

}