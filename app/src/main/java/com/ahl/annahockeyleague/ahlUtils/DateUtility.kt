package com.ahl.annahockeyleague.ahlUtils

import java.text.SimpleDateFormat
import java.util.*

object DateUtility {

    fun formattedDate(timeInMillis : Long): String {

        val pattern = "dd MMM yyyy - hh:mm a"
        val date = Date(timeInMillis)
        val sdf = SimpleDateFormat(pattern, Locale.getDefault())
        return sdf.format(date)
    }
}