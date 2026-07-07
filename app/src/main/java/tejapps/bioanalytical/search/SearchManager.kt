package tejapps.bioanalytical.search

import androidx.appcompat.widget.SearchView
import tejapps.bioanalytical.models.Chapter

class SearchManager(

    private val searchView: SearchView,

    private val onResult: (List<Chapter>) -> Unit

) {

    fun initialize() {

        searchView.setOnQueryTextListener(

            object : SearchView.OnQueryTextListener {

                override fun onQueryTextSubmit(query: String?): Boolean {

                    val results = SearchRepository.search(query ?: "")

                    onResult(results)

                    return true
                }

                override fun onQueryTextChange(newText: String?): Boolean {

                    val results = SearchRepository.search(newText ?: "")

                    onResult(results)

                    return true
                }

            }

        )

    }

}
