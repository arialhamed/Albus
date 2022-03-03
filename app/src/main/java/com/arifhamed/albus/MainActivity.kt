package com.arifhamed.albus

import android.R.attr
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.core.app.ActivityCompat.startActivityForResult

import android.content.Intent
import android.R.attr.data
import android.net.Uri


class MainActivity : AppCompatActivity() {
    private val CHOOSE_FILE_REQUESTCODE = 8777
    private val PICKFILE_RESULT_CODE = 8778

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.mainAddAlbum){
            var chooseFile = Intent(Intent.ACTION_GET_CONTENT)
            chooseFile.type = "*/*"
            chooseFile = Intent.createChooser(chooseFile, "Choose a file")
            startActivityForResult(chooseFile, PICKFILE_RESULT_CODE)

        }
        if (item.itemId == R.id.mainQuit){
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        val uri: Uri? = data?.data
        val src: String? = uri?.path
        super.onActivityResult(requestCode, resultCode, data)
    }
}