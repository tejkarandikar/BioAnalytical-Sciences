package tejapps.bioanalytical.bottomsheet
import tejapps.bioanalytical.bookmark
import android.view.View
import android.widget.Button
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


    override fun initializeViews(view: View) {


        recyclerView = view.findViewById(R.id.recyclerBookmarks)

        recyclerView.layoutManager = LinearLayoutManager(requireContext())

       adapter = BookmarkAdapter(

    bookmarkManager.getBookmarks()

) { bookmark ->

    onBookmarkSelected(bookmark)

    dismiss()
    

}

        recyclerView.adapter = adapter

        val clearButton = view.findViewById<Button>(R.id.btnClearBookmarks)

        clearButton.setOnClickListener {

            bookmarkManager.clearBookmarks()

            adapter.submitList(emptyList())
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

}
