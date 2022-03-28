package com.example.layousexample

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView

class BaselineLastLineTextView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : AppCompatTextView(context, attrs) {

    override fun getBaseline(): Int {
        val layout = layout ?: return super.getBaseline()
        val baselineOffset = super.getBaseline() - layout.getLineBaseline(0)
        return baselineOffset + layout.getLineBaseline(layout.lineCount - 1)
    }
}