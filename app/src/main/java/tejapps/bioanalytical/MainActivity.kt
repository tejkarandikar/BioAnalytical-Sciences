package tejapps.bioanalytical
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.webkit.WebView
import android.widget.ProgressBar
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.navigation.NavigationView
class MainActivity : AppCompatActivity() {
    private lateinit var drawerLayout: DrawerLayout

    private lateinit var navigationView: NavigationView

    private lateinit var toolbar: MaterialToolbar

    private lateinit var webView: WebView

    private lateinit var progressBar: ProgressBar

    private lateinit var webViewManager: WebViewManager

    private lateinit var drawerManager: DrawerManager

    private lateinit var bookmarkManager: BookmarkManager

    private lateinit var historyManager: HistoryManager

    private lateinit var shareManager: ShareManager

    private lateinit var themePreference: ThemePreference

    private lateinit var themeManager: ThemeManager

    private lateinit var toggle: ActionBarDrawerToggle
    private lateinit var preferenceManager: PreferenceManager
        super.onCreate(savedInstanceState)
        private var currentChapter: Chapter? = null
            override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        initializeViews()

        initializeToolbar()

        initializeManagers()
        preferenceManager = PreferenceManager(this)
         bookmarkManager = BookmarkManager(this)

    historyManager = HistoryManager(this)

    shareManager = ShareManager(this)

    themePreference = ThemePreference(this)

   themeManager = ThemeManager(

    this,

    themePreference

)

        initializeDrawer()

        loadHomePage()

        setupBackPressed()
        override fun onCreateOptionsMenu(menu: Menu?): Boolean {

    menuInflater.inflate(R.menu.toolbar_menu, menu)

    return true

}
        override fun onOptionsItemSelected(item: MenuItem): Boolean {

    return when (item.itemId) {

        R.id.action_bookmark -> {

            addCurrentPageBookmark()

            true

        }

        R.id.action_share -> {

            shareCurrentPage()

            true

        }

        R.id.action_settings -> {

            openSettings()

            true

        }

        else -> super.onOptionsItemSelected(item)

    }

}
        private fun addCurrentPageBookmark() {

    bookmarkManager.addBookmark(

        Bookmark(

            title = "Current Chapter",

            assetFile = webViewManager.getCurrentPage(),

            timestamp = System.currentTimeMillis()

        )

    )

}

    }
            private fun initializeViews() {

    drawerLayout = findViewById(R.id.drawer_layout)

    navigationView = findViewById(R.id.nav_view)

    toolbar = findViewById(R.id.toolbar)

    webView = findViewById(R.id.webView)

    progressBar = findViewById(R.id.progressBar)

}
            private fun initializeToolbar() {

    setSupportActionBar(toolbar)

    toggle = ActionBarDrawerToggle(

        this,

        drawerLayout,

        toolbar,

        R.string.navigation_drawer_open,

        R.string.navigation_drawer_close

    )

    drawerLayout.addDrawerListener(toggle)

    toggle.syncState()

}
            private fun initializeManagers() {

    webViewManager = WebViewManager(

        webView,

        progressBar

    )

   

}
    private fun initializeDrawer() {

    drawerManager = DrawerManager(

    drawerLayout,

    navigationView,

    onChapterSelected = { chapter ->

        openChapter(chapter)

    },

    onHomeSelected = {

        openHome()

    }

)
    private fun openChapter(chapter: Chapter) {

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

        },

        onHomeSelected = {

            webViewManager.loadHomePage()

            preferenceManager.saveLastPage("index.html")

        }

    )

    drawerManager.initialize()

}
           private fun loadHomePage() {

    val lastPage = preferenceManager.getLastPage()

    webViewManager.loadPage(lastPage)

}
            private fun setupBackPressed() {

    onBackPressedDispatcher.addCallback(

        this,

        object : OnBackPressedCallback(true) {

            override fun handleOnBackPressed() {

                when {

                    drawerLayout.isDrawerOpen(
                        navigationView
                    ) -> {

                        drawerLayout.closeDrawer(
                            navigationView
                        )

                    }

                    webView.canGoBack() -> {

                        webView.goBack()

                    }

                    else -> {

                        finish()

                    }

                }

            }

        }

    )

}
            private fun shareCurrentPage() {

    shareManager.share(


        webViewManager.getCurrentPage()

    )

}
            private fun openSettings() {

    startActivity(

        Intent(

            this,

            SettingsActivity::class.java

        )

    )

}
        setContentView(R.layout.activity_main)
        package tejapps.bioanalytical.bookmarks
import android.content.Context
import org.json.JSONArray
class BookmarkManager(context: Context) {
    private val preferences =
        context.getSharedPreferences(
            "bookmarks",
            Context.MODE_PRIVATE
        )

    fun addBookmark(bookmark: Bookmark) {

        val array = JSONArray(
            preferences.getString(
                "items",
                "[]"
            )
        )

        array.put(bookmark.assetFile)

        preferences.edit()
            .putString(
                "items",
                array.toString()
            )
            .apply()

    }

    fun getBookmarks(): List<String> {

        val array = JSONArray(
            preferences.getString(
                "items",
                "[]"
            )
        )

        val list = mutableListOf<String>()

        for(i in 0 until array.length()){

            list.add(array.getString(i))

        }

        return list

    }

}
drawerLayout = findViewById(R.id.drawer_layout)

navigationView = findViewById(R.id.nav_view)

binding.webView
progressBar = findViewById(R.id.progressBar)                      
val toolbar = findViewById<MaterialToolbar>(R.id.toolbar)

setSupportActionBar(toolbar)

val toggle = ActionBarDrawerToggle(

    this,

    drawerLayout,

    toolbar,

    R.string.navigation_drawer_open,

    R.string.navigation_drawer_close

)

drawerLayout.addDrawerListener(toggle)

toggle.syncState()

webViewManager = WebViewManager(webView)

webViewManager.initialize()

drawerManager = DrawerManager(

    drawerLayout,

    navigationView,

    webViewManager,
    historyManager

)

drawerManager.initialize()

webViewManager.loadHomePage()
        webView = findViewById(R.id.webView)

        webViewManager = WebViewManager(webView)

        webViewManager.initialize()

        val lastPage = preferenceManager.getLastPage()

webViewManager.loadPage(lastPage)

    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {

        if (webViewManager.goBack()) {
            return
        }

        if (System.currentTimeMillis() - backPressedTime < 2000) {

            finish()

        } else {

            Toast.makeText(
                this,
                "Press BACK again to exit",
                Toast.LENGTH_SHORT
            ).show()

            backPressedTime = System.currentTimeMillis()

        }

    }

}
override fun onOptionsItemSelected(item: MenuItem): Boolean {

    when (item.itemId) {

        R.id.action_bookmark -> {

            bookmarkManager.addBookmark(

                Bookmark(

                    "Current Page",

                    webViewManager.getCurrentPage()
                    R.id.action_share -> {
    shareManager.share(

        "Current Chapter",

        webViewManager.getCurrentPage()
        R.id.action_settings -> {

    startActivity(

        Intent(

            this,

            SettingsActivity::class.java

        )

    )

    true

}

    )

    return true

}

                )

            )

            Toast.makeText(
                this,
                "Bookmark added",
                Toast.LENGTH_SHORT
            ).show()

            return true
        }

    }

    return super.onOptionsItemSelected(item)
}
    
