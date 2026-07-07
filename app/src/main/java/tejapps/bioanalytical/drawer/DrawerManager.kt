package tejapps.bioanalytical.drawer

import android.webkit.WebView
import com.google.android.material.navigation.NavigationView
import tejapps.bioanalytical.data.ChapterRepository

class DrawerManager(
    private val navigationView: NavigationView,
    private val webView: WebView
) {

    fun initialize() {

        navigationView.setNavigationItemSelectedListener { item ->

            val chapter = ChapterRepository.chapters.find {

                it.menuId == item.itemId

            }

            chapter?.let {

                webView.loadUrl(
                    "file:///android_asset/${it.assetFile}"
                )

            }

            navigationView.setCheckedItem(item.itemId)

            true

        }

    }

}
