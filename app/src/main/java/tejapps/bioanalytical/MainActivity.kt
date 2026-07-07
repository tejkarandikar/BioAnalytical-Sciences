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

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
drawerLayout = findViewById(R.id.drawer_layout)

navigationView = findViewById(R.id.nav_view)

webView = findViewById(R.id.webView)
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

        webViewManager.loadHomePage()

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
