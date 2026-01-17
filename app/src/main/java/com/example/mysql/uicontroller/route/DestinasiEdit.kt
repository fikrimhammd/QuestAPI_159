package com.example.mysql.uicontroller.route

import com.example.mysql.R

object DestinasiEdit : DestinasiNavigasi {
    override val route = "item_edit"
    override val titleRes = R.string.edit_siswa
    // Pastikan nama variabel ini siswaIdArg
    const val siswaIdArg = "itemId"
    val routeWithArgs = "$route/{$siswaIdArg}"
}