package com.razvanpopescu.socialresp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.razvanpopescu.socialresp.R.id.text_view
import kotlinx.android.synthetic.main.activity_test.*


class TestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

        // Get the support action bar
        val actionBar = supportActionBar

        // Set the action bar title, subtitle and elevation
        actionBar!!.title = "Kotlin"
        actionBar.subtitle = "Many useful kotlin examples."
        actionBar.elevation = 4.0F
    }


    /*
        *** reference source developer.android.com ***

        boolean onCreateOptionsMenu (Menu menu)
            Initialize the contents of the Activity's standard options menu.
            You should place your menu items in to menu.

            This is only called once, the first time the options menu is displayed

        Parameters
            menu Menu : The options menu in which you place your items.
        Returns
            boolean : You must return true for the menu to be displayed;
                      if you return false it will not be shown.


        MenuInflater
            This class is used to instantiate menu XML files into Menu objects.
            For performance reasons, menu inflation relies heavily on pre-processing of XML files
            that is done at build time.

        void inflate (int menuRes, Menu menu)
            Inflate a menu hierarchy from the specified XML resource.
            Throws InflateException if there is an error.

        Parameters
            menuRes int : Resource ID for an XML layout resource to load (e.g., R.menu.main_activity)
            menu Menu : The Menu to inflate into. The items and submenus will be added to this Menu.
    */
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu to use in the action bar
        val inflater = menuInflater
        inflater.inflate(R.menu.menutest, menu)
        return super.onCreateOptionsMenu(menu)
    }


    /*
        *** reference source developer.android.com ***

        boolean onOptionsItemSelected (MenuItem item)
            This hook is called whenever an item in your options menu is selected. The default
            implementation simply returns false to have the normal processing happen (calling the
            item's Runnable or sending a message to its Handler as appropriate). You can use this
            method for any items for which you would like to do processing
            without those other facilities.

            Derived classes should call through to the base class for it to
            perform the default menu handling.

        Parameters
            item MenuItem : The menu item that was selected.
        Returns
            boolean : boolean Return false to allow normal menu processing to proceed,
                      true to consume it here.
    */
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle presses on the action bar menu items
        when (item.itemId) {
            R.id.action_cut -> {
                text_view.text = "Cut"
                return true
            }
            R.id.action_paste -> {
                text_view.text = "Paste"
                return true
            }
            R.id.action_new -> {
                text_view.text = "New"
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
