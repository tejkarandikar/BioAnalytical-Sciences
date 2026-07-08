package tejapps.bioanalytical.managers

import androidx.fragment.app.FragmentManager

import tejapps.bioanalytical.bottomsheet.AboutBottomSheet
import tejapps.bioanalytical.bottomsheet.BookmarksBottomSheet
import tejapps.bioanalytical.bottomsheet.HistoryBottomSheet
import tejapps.bioanalytical.bottomsheet.PrivacyBottomSheet
import tejapps.bioanalytical.bottomsheet.SearchBottomSheet
import tejapps.bioanalytical.bottomsheet.SettingsBottomSheet
class BottomSheetManager(

    private val fragmentManager: FragmentManager

) { 
  fun showBookmarks() {

    BookmarksBottomSheet()

        .show(

            fragmentManager,

            "BookmarksBottomSheet"

        )

}
  fun showHistory() {

    HistoryBottomSheet()

        .show(

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
