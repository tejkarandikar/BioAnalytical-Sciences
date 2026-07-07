package tejapps.bioanalytical

import android.content.Context

class PreferenceManager(context: Context) {

    private val preferences =
        context.getSharedPreferences(
            "bioanalytical_preferences",
            Context.MODE_PRIVATE
        )

    companion object {

        private const val LAST_PAGE = "last_page"

    }

    fun saveLastPage(assetFile: String) {

        preferences.edit()
            .putString(LAST_PAGE, assetFile)
            .apply()

    }

    fun getLastPage(): String {

        return preferences.getString(
            LAST_PAGE,
            "index.html"
        ) ?: "index.html"

    }

}
