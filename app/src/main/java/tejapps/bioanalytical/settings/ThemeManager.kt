package tejapps.bioanalytical.settings

import androidx.appcompat.app.AppCompatDelegate

class ThemeManager(
    private val preference: ThemePreference
) {

    fun applyTheme() {

        when (preference.getTheme()) {

            1 -> AppCompatDelegate.setDefaultNightMode(
                AppCompatDelegate.MODE_NIGHT_NO
            )

            2 -> AppCompatDelegate.setDefaultNightMode(
                AppCompatDelegate.MODE_NIGHT_YES
            )

            else -> AppCompatDelegate.setDefaultNightMode(
                AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM
            )

        }

    }

}
