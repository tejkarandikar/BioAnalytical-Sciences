package tejapps.bioanalytical.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import tejapps.bioanalytical.R
import tejapps.bioanalytical.models.Bookmark
class BookmarkAdapter(

    private var bookmarks: List<Bookmark>,

    private val onBookmarkClick: (Bookmark) -> Unit

) : RecyclerView.Adapter<BookmarkAdapter.BookmarkViewHolder>() {
  class BookmarkViewHolder(

    itemView: View

) : RecyclerView.ViewHolder(itemView) {

    val title: TextView =
        itemView.findViewById(R.id.txtBookmarkTitle)

    val time: TextView =
        itemView.findViewById(R.id.txtBookmarkTime)

}
  override fun onCreateViewHolder(

    parent: ViewGroup,

    viewType: Int

): BookmarkViewHolder {

    val view = LayoutInflater.from(parent.context)

        .inflate(

            R.layout.item_bookmark,

            parent,

            false

        )

    return BookmarkViewHolder(view)

}
  override fun onBindViewHolder(

    holder: BookmarkViewHolder,

    position: Int

) {

    val bookmark = bookmarks[position]

    holder.title.text = bookmark.chapter.title

    val formatter = SimpleDateFormat(

        "dd MMM yyyy, hh:mm a",

        Locale.getDefault()

    )

    holder.time.text = formatter.format(

        Date(bookmark.timestamp)

    )

    holder.itemView.setOnClickListener {

        onBookmarkClick(bookmark)

    }

}
  override fun getItemCount(): Int {

    return bookmarks.size

}
  fun submitList(

    newBookmarks: List<Bookmark>

) {

    bookmarks = newBookmarks

    notifyDataSetChanged()

}
}
