package tejapps.bioanalytical

import android.content.Context
import org.json.JSONArray
import org.json.JSONObject

class BookmarkManager(

    context: Context

) {

    private val preferences =

        context.getSharedPreferences(

            "bookmarks",

            Context.MODE_PRIVATE

        )

}
   fun addBookmark(bookmark: Bookmark) {

    val bookmarks = getBookmarks().toMutableList()

    // Remove existing bookmark for the same chapter
    bookmarks.removeAll {

        it.chapter.menuId == bookmark.chapter.menuId

    }

    // Add the newest bookmark at the top
    bookmarks.add(0, bookmark)

    // Limit to the latest 100 bookmarks
    if (bookmarks.size > 100) {

        bookmarks.subList(100, bookmarks.size).clear()

    }

    val array = JSONArray()

    bookmarks.forEach { item ->

        val obj = JSONObject()

        obj.put(
            "menuId",
            item.chapter.menuId
        )

        obj.put(
            "timestamp",
            item.timestamp
        )

        array.put(obj)

    }

    preferences.edit()
        .putString(
            "items",
            array.toString()
        )
        .apply()

}

  fun getBookmarks(): List<Bookmark> {

    val bookmarks = mutableListOf<Bookmark>()

    val array = JSONArray(
        preferences.getString("items", "[]")
    )

    for (i in 0 until array.length()) {

        val obj = array.getJSONObject(i)

        val menuId = obj.getInt("menuId")

        val chapter = ChapterRepository.getChapterByMenuId(menuId)

        if (chapter != null) {

            bookmarks.add(

                Bookmark(

                    chapter = chapter,

                    timestamp = obj.getLong("timestamp")

                )

            )

        }

    }

    return bookmarks

}
    fun clearBookmarks() {

    preferences.edit()
        .remove("items")
        .apply()

}

        val list = mutableListOf<String>()

        for(i in 0 until array.length()){

            list.add(array.getString(i))

        }

        return list

    }

}
