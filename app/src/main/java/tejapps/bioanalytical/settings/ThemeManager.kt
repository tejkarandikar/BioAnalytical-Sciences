package tejapps.bioanalytical

import androidx.appcompat.app.AppCompatDelegate

class ThemeManager(

    private val themePreference: ThemePreference

) {

    fun applyTheme() {

    when (themePreference.getTheme()) {

        ThemePreference.LIGHT -> {

            AppCompatDelegate.setDefaultNightMode(

                AppCompatDelegate.MODE_NIGHT_NO

            )

        }

        ThemePreference.DARK -> {

            AppCompatDelegate.setDefaultNightMode(

                AppCompatDelegate.MODE_NIGHT_YES

            )

        }

        else -> {

            AppCompatDelegate.setDefaultNightMode(

                AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM

            )

        }

    }

}
    fun setTheme(theme: String) {

    themePreference.saveTheme(theme)

    applyTheme()

}
}
