package tejapps.bioanalytical.drawer

import com.google.android.material.navigation.NavigationView
import androidx.drawerlayout.widget.DrawerLayout
import tejapps.bioanalytical.data.ChapterRepository
import tejapps.bioanalytical.webview.WebViewManager

class DrawerManager(

    private val drawerLayout: DrawerLayout,

    private val navigationView: NavigationView,

    private val webViewManager: WebViewManager,

    private val historyManager: HistoryManager,

    private val preferenceManager: PreferenceManager

)
{

    fun initialize() {

        navigationView.setNavigationItemSelectedListener { item ->

            val chapter = ChapterRepository.chapters.find {

                it.menuId == item.itemId

            }

            chapter?.let {

                webViewManager.loadPage(it.assetFile)
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
