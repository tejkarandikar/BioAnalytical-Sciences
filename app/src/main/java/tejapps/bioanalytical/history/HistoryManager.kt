package tejapps.bioanalytical.history

import android.content.Context
import org.json.JSONArray
import org.json.JSONObject

class HistoryManager(

    context: Context,

    private val onHistorySelected: (HistoryItem) -> Unit

)
    fun addHistory(item: HistoryItem) {

        val array = JSONArray(
            preferences.getString(
                "items",
                "[]"
            )
        )

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

    fun getHistory(): JSONArray {

        return JSONArray(
            preferences.getString(
                "items",
                "[]"
            )
        )

    }

}
