package tejapps.bioanalytical

import androidx.appcompat.app.AppCompatDelegate

class ThemeManager(

    private val themePreference: ThemePreference

) {

    fun applyTheme() {

   fun applyTheme() {

    when (themePreference.getTheme()) {

        AppTheme.LIGHT -> {

            AppCompatDelegate.setDefaultNightMode(

                AppCompatDelegate.MODE_NIGHT_NO

            )

        }

        AppTheme.DARK -> {

            AppCompatDelegate.setDefaultNightMode(

                AppCompatDelegate.MODE_NIGHT_YES

            )

        }

        AppTheme.SYSTEM -> {

            AppCompatDelegate.setDefaultNightMode(

                AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM

            )

        }

    }

}
        else -> {

            AppCompatDelegate.setDefaultNightMode(

                AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM

            )

        }

    }

}
    fun setTheme(theme: AppTheme) {

    themePreference.saveTheme(theme)

    applyTheme()

}
