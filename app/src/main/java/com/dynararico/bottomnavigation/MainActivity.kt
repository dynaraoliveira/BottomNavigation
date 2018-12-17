package com.dynararico.bottomnavigation

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                trocaFragment("Home")
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                trocaFragment("Dashboard")
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                trocaFragment("Notificacao")
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    private fun trocaFragment(texto: String) {
        val ft = supportFragmentManager.beginTransaction()
        val fragment = BlankFragment().newInstance(texto)
        ft.replace(R.id.flContainer, fragment)
        ft.commit()

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }
}
