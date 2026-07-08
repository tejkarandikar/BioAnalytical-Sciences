package tejapps.bioanalytical

import android.content.Context
import org.json.JSONArray
import org.json.JSONObject
class HistoryManager(

    context: Context

) {

    private val preferences =
        context.getSharedPreferences(
            "history",
            Context.MODE_PRIVATE
        )

}
    fun addHistory(item: HistoryItem) {

    val array = JSONArray(
        preferences.getString("items", "[]")
    )

    val obj = JSONObject()

    obj.put(
        "menuId",
        item.chapter.menuId
    )

    obj.put(
        "title",
        item.chapter.title
    )

    obj.put(
        "assetFile",
        item.chapter.assetFile
    )

    obj.put(
        "timestamp",
        item.timestamp
    )

    array.put(obj)

    preferences.edit()
        .putString(
            "items",
            array.toString()
        )
        .apply()

}

        val objectItem = JSONObject()

        objectItem.put("title", item.title)
        objectItem.put("assetFile", item.assetFile)
        objectItem.put("timestamp", item.timestamp)

        array.put(objectItem)

        preferences.edit()
            .putString(
                "items",
                array.toString()
            )
            .apply()

    }

   fun getHistory(): List<HistoryItem> {

    val history = mutableListOf<HistoryItem>()

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

        history.add(

            HistoryItem(

                chapter = chapter,

                timestamp = obj.getLong("timestamp")

            )

        )

    }

    return history

}
   fun clearHistory() {

    preferences.edit()
        .remove("items")
        .apply()

}
