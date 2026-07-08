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
import tejapps.bioanalytical.history.HistoryItem
class HistoryAdapter(

    private var history: List<HistoryItem>,

    private val onHistoryClick: (HistoryItem) -> Unit

) : RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder>() {
  class HistoryViewHolder(

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

): HistoryViewHolder {

    val view = LayoutInflater.from(parent.context)

        .inflate(

            R.layout.item_bookmark,

            parent,

            false

        )

    return HistoryViewHolder(view)

}
  override fun onBindViewHolder(

    holder: HistoryViewHolder,

    position: Int

) {

    val item = history[position]

    holder.title.text = item.chapter.title

    val formatter = SimpleDateFormat(

        "dd MMM yyyy, hh:mm a",

        Locale.getDefault()

    )

    holder.time.text = formatter.format(

        Date(item.timestamp)

    )

    holder.itemView.setOnClickListener {

        onHistoryClick(item)

    }

}
  override fun getItemCount(): Int {

    return history.size

}
  fun submitList(

    newHistory: List<HistoryItem>

) {

    history = newHistory

    notifyDataSetChanged()

}
  }
