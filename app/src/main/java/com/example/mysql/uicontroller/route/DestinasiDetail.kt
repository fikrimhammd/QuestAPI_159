package com.example.mysql.uicontroller.route

import com.example.mysql.R

object DestinasiDetail : DestinasiNavigasi {
    override val route = "item_details"
    override val titleRes = R.string.detail_siswa
    const val siswaIdArg = "itemId" // Kunci argumen navigasi
    val routeWithArgs = "$route/{$siswaIdArg}"
}