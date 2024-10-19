package juliosalyrosas.parcial

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MenuActivity : AppCompatActivity() {

    private lateinit var gastosButton: Button
    private lateinit var tareasButton: Button
    private lateinit var equiposButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        gastosButton = findViewById(R.id.presupuesto_button)
        tareasButton = findViewById(R.id.seguros_button)
        equiposButton = findViewById(R.id.hoteles_button)

       gastosButton.setOnClickListener {
            val intent = Intent(this, GastosActivity::class.java)
            startActivity(intent)
        }

        tareasButton.setOnClickListener {
            val intent = Intent(this, TareasActivity::class.java)
            startActivity(intent)
        }

        equiposButton.setOnClickListener {
            val intent = Intent(this, EquiposActivity::class.java)
            startActivity(intent)
        }
    }
}