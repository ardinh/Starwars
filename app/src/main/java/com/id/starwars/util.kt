package com.id.starwars

object util {
    fun convertCurrency(
        jumlah: String, npemecah: Int,
        insert: Char
    ): String {
        var jumlah = jumlah
        if (jumlah == "" || jumlah == "null") {
            return "0"
        }
        val data = jumlah.toCharArray()
        jumlah = ""
        for (i in data.indices) {
            if ((data.size - i) % npemecah == 0) {
                jumlah += insert
            }
            jumlah += data[i]
        }
        if (data.size % npemecah == 0) {
            jumlah = jumlah.substring(1, jumlah.length)
        }
        return "$jumlah"
    }
}