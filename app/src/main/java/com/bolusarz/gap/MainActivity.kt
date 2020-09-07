package com.bolusarz.gap

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.bolusarz.gap.ui.main.LearnerPlaceholderFragment
import com.bolusarz.gap.ui.main.SectionsPagerAdapter
import com.google.android.material.tabs.TabLayout
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.toolbar_header.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val sectionsPagerAdapter = SectionsPagerAdapter(supportFragmentManager).apply {
            addFragment(LearnerPlaceholderFragment
                .newInstance(LearnerPlaceholderFragment.TOP_LEARNER), getString(R.string.tab_text_1))
            addFragment(LearnerPlaceholderFragment
                .newInstance(LearnerPlaceholderFragment.TOP_SKILL_IQ), getString(R.string.tab_text_2))
        }
        val viewPager: ViewPager = findViewById(R.id.view_pager)
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = findViewById(R.id.tabs)
        tabs.setupWithViewPager(viewPager)
        submitBtn.setOnClickListener {
            startActivity(Intent(this, GFormActivity::class.java))
        }
    }
}