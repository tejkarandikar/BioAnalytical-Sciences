package tejapps.bioanalytical.managers

import androidx.fragment.app.FragmentManager

import tejapps.bioanalytical.bottomsheet.AboutBottomSheet
import tejapps.bioanalytical.bottomsheet.BookmarksBottomSheet
import tejapps.bioanalytical.bottomsheet.HistoryBottomSheet
import tejapps.bioanalytical.bottomsheet.PrivacyBottomSheet
import tejapps.bioanalytical.bottomsheet.SearchBottomSheet
import tejapps.bioanalytical.bottomsheet.SettingsBottomSheet
import tejapps.bioanalytical.bookmark.Bookmark
import tejapps.bioanalytical.bookmark.BookmarkManager
import tejapps.bioanalytical.history.HistoryItem
import tejapps.bioanalytical.managers.HistoryManager
class BottomSheetManager(

    private val fragmentManager: FragmentManager

) { 
  fun showBookmarks(

    bookmarkManager: BookmarkManager,

    onBookmarkSelected: (Bookmark) -> Unit

) {

    BookmarksBottomSheet(

        bookmarkManager,

        onBookmarkSelected

    ).show(

        fragmentManager,

        "BookmarksBottomSheet"

    )

}
  fun showHistory(

    historyManager: HistoryManager,

    onHistorySelected: (HistoryItem) -> Unit

) {

    HistoryBottomSheet(

        historyManager,

        onHistorySelected

    ).show(

        fragmentManager,

        "HistoryBottomSheet"

    )

}
  fun showSearch() {

    SearchBottomSheet()

        .show(

            fragmentManager,

            "SearchBottomSheet"

        )

}
  fun showSettings() {

    SettingsBottomSheet()

        .show(

            fragmentManager,

            "SettingsBottomSheet"

        )

}
  fun showAbout() {

    AboutBottomSheet()

        .show(

            fragmentManager,

            "AboutBottomSheet"

        )

}
  fun showPrivacy() {

    PrivacyBottomSheet()

        .show(

            fragmentManager,

            "PrivacyBottomSheet"

        )

}
}
