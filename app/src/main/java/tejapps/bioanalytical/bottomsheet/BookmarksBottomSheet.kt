package tejapps.bioanalytical.bottomsheet

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import tejapps.bioanalytical.R
import tejapps.bioanalytical.adapters.BookmarkAdapter
import tejapps.bioanalytical.managers.BookmarkManager

class BookmarksBottomSheet :
private lateinit var recyclerView: RecyclerView

private lateinit var adapter: BookmarkAdapter

private lateinit var bookmarkManager: BookmarkManager
override fun initializeViews(view: View) {
    bookmarkManager = BookmarkManager(requireContext())

recyclerView = view.findViewById(R.id.recyclerBookmarks)

recyclerView.layoutManager =

    LinearLayoutManager(requireContext())
   BookmarksBottomSheet(

    onBookmarkSelected = {

        openChapter(it.chapter)

    }

)
recyclerView.adapter = adapter
    val clearButton =

    view.findViewById<Button>(

        R.id.btnClearBookmarks

    )
    clearButton.setOnClickListener {

    bookmarkManager.clearBookmarks()

    adapter.submitList(

        emptyList()

    )

}
}
    BaseBottomSheet(

        R.layout.bottom_sheet_bookmarks

    )
    adapter = BookmarkAdapter(

    bookmarkManager.getBookmarks()

) { bookmark ->

    openChapter(bookmark.chapter)

}
