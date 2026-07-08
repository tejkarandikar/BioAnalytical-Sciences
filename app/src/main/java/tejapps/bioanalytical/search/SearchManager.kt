package tejapps.bioanalytical
import androidx.appcompat.widget.SearchView
class SearchManager(

    private val searchView: SearchView,

    private val onChapterSelected: (Chapter) -> Unit

) {

    fun initialize() {

    searchView.setOnQueryTextListener(

        object : SearchView.OnQueryTextListener {

            override fun onQueryTextSubmit(query: String?): Boolean {

                search(query)

                return true

            }

            override fun onQueryTextChange(newText: String?): Boolean {

                return false

            }

        }

    )

}
    private fun search(query: String?) {

    if (query.isNullOrBlank()) return

    val chapter = ChapterRepository

.search(query)

.firstOrNull()

           it.title.contains(
    query,
    ignoreCase = true
)

||

it.keywords.any {

    keyword ->

    keyword.contains(

        query,

        ignoreCase = true

    )

}

        }

    chapter?.let {

        onChapterSelected(it)

    }

}
    }
