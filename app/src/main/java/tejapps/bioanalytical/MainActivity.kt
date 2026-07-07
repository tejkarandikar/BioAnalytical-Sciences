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

    private var backPressedTime: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

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
