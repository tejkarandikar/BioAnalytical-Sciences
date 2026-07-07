package tejapps.bioanalytical

import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class DrawerManager(

    private val drawerLayout: DrawerLayout,

    private val navigationView: NavigationView,

    private val onChapterSelected: (Chapter) -> Unit,

    private val onHomeSelected: () -> Unit

) { chapter ->

    webViewManager.loadChapter(chapter)

    historyManager.addHistory(...)

    preferenceManager.saveLastPage(...)

}
 {

   fun initialize() {

    navigationView.setNavigationItemSelectedListener { item ->

        when (item.itemId) {

            R.id.nav_home -> {

                onHomeSelected()

            }

            else -> {

                val chapter = ChapterRepository.chapters.find {

                    it.menuId == item.itemId

                }

                chapter?.let {

                    onChapterSelected(it)

                }

            }

        }

        drawerLayout.closeDrawers()

        true

    }

}
    private fun openChapter(menuId: Int) {

    val chapter = ChapterRepository.chapters.find {

        it.menuId == menuId

    } ?: return

    webViewManager.loadChapter(chapter)

    historyManager.addHistory(

        HistoryItem(

            chapter.title,

            chapter.assetFile,

            System.currentTimeMillis()

        )

    )

    preferenceManager.saveLastPage(

        chapter.assetFile

    )

}

            chapter?.let {

                webViewManager.loadChapter(chapter)
                preferenceManager.saveLastPage(it.assetFile)
                webViewManager.loadPage(chapter.assetFile)
                historyManager.addHistory(

    HistoryItem(

        chapter.title,

        chapter.assetFile,

        System.currentTimeMillis()

    )

)

            }

            drawerLayout.closeDrawers()

            true

        }

    }

}
