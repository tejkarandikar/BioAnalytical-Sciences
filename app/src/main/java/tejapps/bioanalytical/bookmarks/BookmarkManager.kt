package tejapps.bioanalytical.bookmarks

import android.content.Context
import org.json.JSONArray

class BookmarkManager(

    context: Context,

    private val onBookmarkSelected: (Bookmark) -> Unit

)
bookmark?.let {

    onBookmarkSelected(it)

}

    fun addBookmark(bookmark: Bookmark) {

        val array = JSONArray(
            preferences.getString(
                "items",
                "[]"
            )
        )

        array.put(bookmark.assetFile)

        preferences.edit()
            .putString(
                "items",
                array.toString()
            )
            .apply()

    }

    fun getBookmarks(): List<String> {

        val array = JSONArray(
            preferences.getString(
                "items",
                "[]"
            )
        )

        val list = mutableListOf<String>()

        for(i in 0 until array.length()){

            list.add(array.getString(i))

        }

        return list

    }

}
