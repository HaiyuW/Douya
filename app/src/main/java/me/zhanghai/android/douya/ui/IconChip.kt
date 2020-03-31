/*
 * Copyright (c) 2020 Hai Zhang <dreaming.in.code.zh@gmail.com>
 * All Rights Reserved.
 */

package me.zhanghai.android.douya.ui

import android.content.Context
import android.util.AttributeSet
import com.google.android.material.chip.Chip

class IconChip : Chip {
    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context, attrs, defStyleAttr
    )

    override fun setText(text: CharSequence?, type: BufferType?) {
        super.setText(text, type)

        updateTextStartPadding()
    }

    private fun updateTextStartPadding() {
        textStartPadding = if (text.isNotEmpty()) chipEndPadding else 0f
        // Work around bug in Chip.updatePaddingInternal().
        if (text.isEmpty()) {
            setPaddingRelative(0, 0, 0, 0)
        }
    }
}