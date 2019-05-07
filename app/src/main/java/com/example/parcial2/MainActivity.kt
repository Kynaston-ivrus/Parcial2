package com.example.parcial2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import android.view.View
import android.content.Intent
import android.net.Uri
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn2.setOnClickListener {
            val openURL = Intent(android.content.Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://github.com/daniel7799/Parcial2.git")
            startActivity(openURL)
        }
    }

    override fun onStart() {
        super.onStart()
        Toast.makeText(this,"Preparando",Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(this,"Listo",Toast.LENGTH_SHORT).show()
    }

    override fun onPause() {
        super.onPause()
        Toast.makeText(this,"En Pausa",Toast.LENGTH_SHORT).show()
    }

    override fun onStop() {
        super.onStop()
        Toast.makeText(this,"Deteniendo",Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this,"App Cerrada",Toast.LENGTH_SHORT).show()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu1, menu)
        return super.onCreateOptionsMenu(menu)
    }

    var EsFrag1 = true
    var EsFrag2 = true
    fun CambiarFragmento(view: View){
        val fragmento1 = BlankFragment1()
        val fragmento2 = BlankFragment2()
        val fragmento3 = BlankFragment3()
        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        if(EsFrag1){
            EsFrag1 = false
            transaction.replace(R.id.reemplazar, fragmento1)
            transaction.addToBackStack(null)
            transaction.commit()
        }
        else if (EsFrag2){
            EsFrag2 = false
            transaction.replace(R.id.reemplazar, fragmento2)
            transaction.addToBackStack(null)
            transaction.commit()
        }
        else{
            EsFrag1 = true
            EsFrag2 = true
            transaction.replace(R.id.reemplazar, fragmento3)
            transaction.addToBackStack(null)
            transaction.commit()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId){
            R.id.item1->{
                Toast.makeText(this,"tacostaurino@gmail.com",Toast.LENGTH_LONG).show()
                return true
            }
            R.id.item2->{
                Toast.makeText(this,"(+503)  2669 1212",Toast.LENGTH_LONG).show()
                return true
            }
            R.id.item3->{
                Toast.makeText(this,"Calle La Paz 136, San Miguel",Toast.LENGTH_LONG).show()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
