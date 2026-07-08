package tejapps.bioanalytical.bottomsheet
import tejapps.bioanalytical.bookmark
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import tejapps.bioanalytical.R
import tejapps.bioanalytical.adapters.BookmarkAdapter
import tejapps.bioanalytical.managers.BookmarkManager
import androidx.recyclerview.widget.ItemTouchHelper

class BookmarksBottomSheet(

    private val bookmarkManager: BookmarkManager,

    private val onBookmarkSelected: (Bookmark) -> Unit

) : BaseBottomSheet(R.layout.bottom_sheet_bookmarks) {
    private lateinit var recyclerView: RecyclerView

    private lateinit var adapter: BookmarkAdapter
    private lateinit var emptyLayout: LinearLayout


    override fun initializeViews(view: View) {


        recyclerView = view.findViewById(R.id.recyclerBookmarks)

        recyclerView.layoutManager = LinearLayoutManager(requireContext())

       adapter = BookmarkAdapter(

    bookmarkManager.getBookmarks()

) { bookmark ->

    onBookmarkSelected(bookmark)

    dismiss()
    emptyLayout =

    view.findViewById(

        R.id.layoutEmpty

    )
    

}

        recyclerView.adapter = adapter
        updateEmptyState()

        val clearButton = view.findViewById<Button>(R.id.btnClearBookmarks)

     clearButton.setOnClickListener {

    bookmarkManager.clearBookmarks()

    adapter.submitList(emptyList())

    updateEmptyState()

}

            bookmarkManager.clearBookmarks()

            adapter.submitList(emptyList())
            updateEmptyState()
val swipeHandler =

    object : ItemTouchHelper.SimpleCallback(

        0,

        ItemTouchHelper.LEFT

    ) {

        override fun onMove(

            recyclerView: RecyclerView,

            viewHolder: RecyclerView.ViewHolder,

            target: RecyclerView.ViewHolder

        ): Boolean {

            return false

        }
ItemTouchHelper(

    swipeHandler

).attachToRecyclerView(

    recyclerView

)
        override fun onSwiped(

            viewHolder: RecyclerView.ViewHolder,

            direction: Int

        ) {

            val position = viewHolder.adapterPosition

            val bookmark =

                bookmarkManager

                    .getBookmarks()[position]

            bookmarkManager.removeBookmark(bookmark)

            adapter.submitList(

                bookmarkManager.getBookmarks()

            )

        }

    }
        }

    }
private fun updateEmptyState() {

    if (adapter.itemCount == 0) {

        recyclerView.visibility = View.GONE

        emptyLayout.visibility = View.VISIBLE

    } else {

        recyclerView.visibility = View.VISIBLE

        emptyLayout.visibility = View.GONE

    }

}
}
