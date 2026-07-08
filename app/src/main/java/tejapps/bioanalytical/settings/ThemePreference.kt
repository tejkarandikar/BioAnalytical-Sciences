package tejapps.bioanalytical

import android.content.Context

class ThemePreference(context: Context) {

 companion object {

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
fun saveTheme(theme: AppTheme) {

    preferences.edit()

        .putString(KEY_THEME, theme.name)

        .apply()

}
    fun getTheme(): AppTheme {

    val value = preferences.getString(

        KEY_THEME,

        AppTheme.SYSTEM.name

    ) ?: AppTheme.SYSTEM.name

    return AppTheme.valueOf(value)

}
