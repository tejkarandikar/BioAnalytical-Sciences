package tejapps.bioanalytical.drawer

import com.google.android.material.navigation.NavigationView
import androidx.drawerlayout.widget.DrawerLayout
import tejapps.bioanalytical.data.ChapterRepository
import tejapps.bioanalytical.webview.WebViewManager

class DrawerManager(

    private val drawerLayout: DrawerLayout,

    private val navigationView: NavigationView,

    private val webViewManager: WebViewManager

) {

    fun initialize() {

        navigationView.setNavigationItemSelectedListener { item ->

            val chapter = ChapterRepository.chapters.find {

                it.menuId == item.itemId

            }

            chapter?.let {

                webViewManager.loadPage(it.assetFile)

            }

            drawerLayout.closeDrawers()

            true

        }

    }

}
