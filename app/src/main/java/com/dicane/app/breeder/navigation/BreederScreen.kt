package com.dicane.app.breeder.navigation

sealed class BreederScreen(
    val route: String
) {
    object FormInitialMessage : BreederScreen("form_initial_message")
    object FormPhoto : BreederScreen("form_photo")
    object FormCnpjEmailPassword : BreederScreen("form_cnpj_email_password")
    object FormNamePicDesc : BreederScreen("form_name_pic_desc")
    object FormCertifications : BreederScreen("form_certifications")
    object FormAwards : BreederScreen("form_awards")
    object BreederHome : BreederScreen("breeder_home")
}
