package tejapps.bioanalytical

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import android.webkit.WebView

class MainActivity : AppCompatActivity() {
private lateinit var drawerLayout: DrawerLayout
private lateinit var navigationView: NavigationView
    private lateinit var webView: WebView
    private lateinit var webViewManager: WebViewManager
    private lateinit var progressBar: ProgressBar

    private var backPressedTime: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        private lateinit var themePreference: ThemePreference
private lateinit var themeManager: ThemeManager
        themePreference = ThemePreference(this)

themeManager = ThemeManager(themePreference)

themeManager.applyTheme()

        super.onCreate(savedInstanceState)

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

    webViewManager

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
