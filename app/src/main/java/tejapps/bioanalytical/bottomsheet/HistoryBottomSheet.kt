package tejapps.bioanalytical.bottomsheet

package tejapps.bioanalytical.bottomsheet

import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import tejapps.bioanalytical.R
import tejapps.bioanalytical.adapters.HistoryAdapter
import tejapps.bioanalytical.managers.HistoryManager
import.tejapps.bioanalytical.history.HistoryItem
class HistoryBottomSheet(

    private val historyManager: HistoryManager,

    private val onHistorySelected: (HistoryItem) -> Unit

) : BaseBottomSheet(
    R.layout.bottom_sheet_history
) {
    private lateinit var recyclerView: RecyclerView

private lateinit var adapter: HistoryAdapter

private lateinit var emptyLayout: LinearLayout
    override fun initializeViews(view: View) {
        recyclerView = view.findViewById(R.id.recyclerHistory)

emptyLayout = view.findViewById(R.id.layoutEmpty)

val clearButton = view.findViewById<Button>(
    R.id.btnClearHistory
)
recyclerView.layoutManager =
    LinearLayoutManager(requireContext())
    adapter = HistoryAdapter(

    historyManager.getHistory()

) { historyItem ->

    onHistorySelected(historyItem)

    dismiss()

}
    recyclerView.adapter = adapter

updateEmptyState()
        private fun updateEmptyState() {

    if (adapter.itemCount == 0) {

        recyclerView.visibility = View.GONE

        emptyLayout.visibility = View.VISIBLE

    } else {

        recyclerView.visibility = View.VISIBLE

        emptyLayout.visibility = View.GONE

    }
    clearButton.setOnClickListener {

    historyManager.clearHistory()

    adapter.submitList(emptyList())

    updateEmptyState()

}

}
