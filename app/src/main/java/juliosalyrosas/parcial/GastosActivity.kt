package juliosalyrosas.parcial

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class GastosActivity : AppCompatActivity() {

    private lateinit var activityName: EditText
    private lateinit var activityValue: EditText
    private lateinit var activityDays: EditText
    private lateinit var addActivityButton: Button
    private lateinit var totalBudget: TextView

    private var total = 0.0 // Almacena el total acumulado de todas las actividades

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gastos)

        // Inicializar las vistas del layout
        activityName = findViewById(R.id.activity_name)
        activityValue = findViewById(R.id.activity_value)
        activityDays = findViewById(R.id.activity_days)
        addActivityButton = findViewById(R.id.add_activity_button)
        totalBudget = findViewById(R.id.total_budget)


        addActivityButton.setOnClickListener {
            val name = activityName.text.toString()
            val valueString = activityValue.text.toString()
            val daysString = activityDays.text.toString()


            if (name.isNotEmpty() && valueString.isNotEmpty() && daysString.isNotEmpty()) {
                val name =valueString.toDoubleOrNull()
                val value = valueString.toDoubleOrNull()
                val days = daysString.toDoubleOrNull()


                if (value != null && days != null && name != null) {
                    // Aqui la operacion
                    total +=   name-(days+value)
                    // Formato de salida
                    totalBudget.text = String.format("%.2f", total)
                } else {
                    // Erros Msg
                    Toast.makeText(this, "Por favor, ingresa valores numéricos válidos", Toast.LENGTH_SHORT).show()
                }
            } else {
                // Validar campos llenos
                Toast.makeText(this, "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show()
            }
        }
    }
}