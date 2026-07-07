package tejapps.bioanalytical.preferences

import android.content.Context

class PreferenceManager(context: Context) {

    private val preferences =
        context.getSharedPreferences(
            "bioanalytical",
            Context.MODE_PRIVATE
        )

    fun saveLastPage(page: String) {

        preferences.edit()
            .putString("last_page", page)
            .apply()

    }

    fun getLastPage(): String {

        return preferences.getString(
            "last_page",
            "index.html"
        )!!

    }

}
