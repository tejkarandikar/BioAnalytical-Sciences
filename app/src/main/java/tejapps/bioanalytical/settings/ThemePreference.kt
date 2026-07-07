package tejapps.bioanalytical.settings

import android.content.Context

class ThemePreference(context: Context) {

    private val preferences =
        context.getSharedPreferences(
            "theme_preferences",
            Context.MODE_PRIVATE
        )

    fun saveTheme(theme: Int) {
        preferences.edit()
            .putInt("theme_mode", theme)
            .apply()
    }

    fun getTheme(): Int {
        return preferences.getInt("theme_mode", 0)
    }
}
