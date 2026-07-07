package tejapps.bioanalytical

import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class DrawerManager(

    private val drawerLayout: DrawerLayout,

    private val navigationView: NavigationView,

    private val webViewManager: WebViewManager,

    private val historyManager: HistoryManager,

    private val preferenceManager: PreferenceManager

) {

    fun initialize() {

    navigationView.setNavigationItemSelectedListener { item ->

        when (item.itemId) {

            R.id.nav_home -> {

                webViewManager.loadHomePage()

                preferenceManager.saveLastPage("index.html")

            }

            else -> {

                openChapter(item.itemId)

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
