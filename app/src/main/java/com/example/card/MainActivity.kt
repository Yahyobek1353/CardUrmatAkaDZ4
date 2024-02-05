package com.example.card
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.card.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val navController: NavController by lazy {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment_container) as NavHostFragment
        navHostFragment.navController
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        hideBottomNav()
        initBottomNav()
        initBottom()
        showBottomNav()
    }
    private fun initBottom(){
        navController.addOnDestinationChangedListener { _, destination, _ ->
            if(destination.id == R.id.onBoard) {
                binding.bottomNav.visibility = View.GONE
            } else {

                binding.bottomNav.visibility = View.VISIBLE
            }
            if(destination.id == R.id.categoryFragment) {

                binding.bottomNav.visibility = View.GONE

            } else {

                binding.bottomNav.visibility = View.VISIBLE
            }
            if(destination.id == R.id.addCategoryFragment) {

                binding.bottomNav.visibility = View.GONE

            } else {

                binding.bottomNav.visibility = View.VISIBLE
            }
        }
    }

    private fun initBottomNav() {
        binding.bottomNav.apply {
            setupWithNavController(navController)
            itemIconTintList = null
        }
    }

    fun hideBottomNav() {
        binding.bottomNav.visibility = View.GONE
    }
    fun showBottomNav() {
        binding.bottomNav.visibility = View.VISIBLE
    }
}