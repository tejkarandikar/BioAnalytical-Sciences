package tejapps.bioanalytical.bottomsheet

import tejapps.bioanalytical.R

class BookmarksBottomSheet :

    BaseBottomSheet(

        R.layout.bottom_sheet_bookmarks

    )
    adapter = BookmarkAdapter(

    bookmarkManager.getBookmarks()

) { bookmark ->

    openChapter(bookmark.chapter)

}
