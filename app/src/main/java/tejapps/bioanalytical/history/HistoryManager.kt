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

    val history = getHistory().toMutableList()


    history.removeAll {

        it.chapter.menuId == item.chapter.menuId

    }


    history.add(0, item)

    
    if (history.size > 50) {

        history.subList(50, history.size).clear()

    }

    val array = JSONArray()

    history.forEach { historyItem ->

        val obj = JSONObject()

        obj.put(
            "menuId",
            historyItem.chapter.menuId
        )

        obj.put(
            "title",
            historyItem.chapter.title
        )

        obj.put(
            "assetFile",
            historyItem.chapter.assetFile
        )

        obj.put(
            "timestamp",
            historyItem.timestamp
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

        val menuId = obj.getInt("menuId")

        val chapter = ChapterRepository.chapters.find {

            it.menuId == menuId

        }

        if (chapter != null) {

            history.add(

                HistoryItem(

                    chapter = chapter,

                    timestamp = obj.getLong("timestamp")

                )

            )

        }

    }

    return history

}
   fun clearHistory() {

    preferences.edit()
        .remove("items")
        .apply()

}
