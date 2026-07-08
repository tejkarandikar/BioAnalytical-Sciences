package tejapps.bioanalytical

import android.content.Context

class PreferenceManager(context: Context) {

    companion object {

    const val PREF_NAME = "bioanalytical_preferences"

    private const val LAST_PAGE = "last_page"

    private const val LAST_TITLE = "last_title"

}
        )
private val preferences =
    context.getSharedPreferences(
        PREF_NAME,
        Context.MODE_PRIVATE
    )
}

    companion object {

        private const val LAST_PAGE = "last_page"

        private const val LAST_TITLE = "last_title"

    }

    fun saveLastChapter(chapter: Chapter) {

        preferences.edit()

            .putString(LAST_PAGE, chapter.assetFile)

            .putString(LAST_TITLE, chapter.title)

            .apply()

    }

    fun getLastPage(): String {

        return preferences.getString(
            LAST_PAGE,
            "index.html"
        ) ?: "index.html"

    }

    fun getLastTitle(): String {

        return preferences.getString(
            LAST_TITLE,
            "Home"
        ) ?: "Home"

    }

    fun clearLastChapter() {

        preferences.edit()

            .remove(LAST_PAGE)

            .remove(LAST_TITLE)

            .apply()

    }

}
