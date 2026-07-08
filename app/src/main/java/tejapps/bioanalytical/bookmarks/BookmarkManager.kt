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
    fun addBookmark(

    bookmark: Bookmark

) {

    val array = JSONArray(

        preferences.getString(

            "items",

            "[]"

        )

    )

    val obj = JSONObject()

    obj.put(

        "title",

        bookmark.chapter.title

    )

    obj.put(

        "assetFile",

        bookmark.chapter.assetFile

    )

    obj.put(

        "menuId",

        bookmark.chapter.menuId

    )

    obj.put(

        "timestamp",

        bookmark.timestamp

    )

    array.put(obj)

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

        val chapter = Chapter(

            menuId = obj.getInt("menuId"),

            title = obj.getString("title"),

            assetFile = obj.getString("assetFile")

        )

        bookmarks.add(

            Bookmark(

                chapter = chapter,

                timestamp = obj.getLong("timestamp")

            )

        )

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
