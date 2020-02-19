package org.d3if1088.courtcounter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.Menu
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import org.d3if1088.courtcounter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private var pointA = 0
    private var pointB = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        if (savedInstanceState != null){
            pointA = savedInstanceState.getInt("pointAState")
            pointB = savedInstanceState.getInt("pointBState")
        }

        viewPoint()

        binding.btnPlus3A.setOnClickListener {
            onPointClicked("A",3)
        }

        binding.btnPlus2A.setOnClickListener {
            onPointClicked("A",2)
        }

        binding.btnFreeA.setOnClickListener {
            onPointClicked("A",1)
        }

        binding.btnPlus3B.setOnClickListener {
            onPointClicked("B",3)
        }

        binding.btnPlus2B.setOnClickListener {
            onPointClicked("B",2)
        }

        binding.btnFreeB.setOnClickListener {
            onPointClicked("B",1)
        }

        binding.btnReset.setOnClickListener{
            pointA = 0
            pointB = 0
            viewPoint()
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt("pointAState",pointA)
        outState.putInt("pointBState",pointB)
        super.onSaveInstanceState(outState)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val intent = Intent(this,AboutActivity::class.java)
        when(item.itemId){
            R.id.about_menu -> startActivity(intent)
        }
        return super.onOptionsItemSelected(item)
    }

    fun onPointClicked(team : String, point : Int){
        if (team == "A"){
            pointA += point
        }else{
            pointB += point
        }
        viewPoint()
    }

    fun viewPoint(){
        binding.pointTeamA.text = pointA.toString()
        binding.pointTeamB.text = pointB.toString()
    }

}
