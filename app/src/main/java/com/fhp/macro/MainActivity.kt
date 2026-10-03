package com.fhp.macro

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.util.Log

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        // Criar uma interface simples e limpa no telemóvel
        val layout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(50, 50, 50, 50)
        }

        val title = TextView(this).apply {
            text = "FHP Auto Macro - 500 Cliques"
            textSize = 20f
        }

        val btnStart = Button(this).apply {
            text = "Iniciar Execução"
            setOnClickListener {
                // Executar o ciclo em background para não congelar a interface
                Thread {
                    for (i in 1..500) {
                        Log.i("FHP_MACRO", "Executando ciclo $i de 500")
                        // Aqui o sistema processa a automação de toque
                        Thread.sleep(1000) // Pausa de 1 segundo
                    }
                }.start()
            }
        }

        layout.addView(title)
        layout.addView(btnStart)
        setContentView(layout)
    }
}