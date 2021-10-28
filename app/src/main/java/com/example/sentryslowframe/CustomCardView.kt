package com.example.sentryslowframe

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import com.google.android.material.R
import com.google.android.material.card.MaterialCardView

class CustomCardView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = R.attr.materialCardViewStyle
) : MaterialCardView(context, attributeSet, defStyleAttr) {

    override fun onDraw(canvas: Canvas?) {
        Thread.sleep(1000)
        super.onDraw(canvas)
    }

}