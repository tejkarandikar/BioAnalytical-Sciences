package tejapps.bioanalytical.settings

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import tejapps.bioanalytical.R

class SettingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_settings)

        supportActionBar?.title = "Settings"

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }

    override fun onSupportNavigateUp(): Boolean {

        finish()

        return true

    }

}
