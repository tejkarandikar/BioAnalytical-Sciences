package tejapps.bioanalytical

import android.content.Context

class ThemePreference(context: Context) {

 companion object {

    const val SYSTEM = "SYSTEM"

    const val LIGHT = "LIGHT"

    const val DARK = "DARK"

    private const val KEY_THEME = "theme"

}
    private val preferences =
        context.getSharedPreferences(
            PreferenceManager.PREF_NAME,
            Context.MODE_PRIVATE
        )

    fun saveTheme(theme: String) {

        preferences.edit()

            .putString(KEY_THEME, theme)

            .apply()

    }

    fun getTheme(): String {

    return preferences.getString(

        KEY_THEME,

        SYSTEM

    ) ?: SYSTEM
}
}
