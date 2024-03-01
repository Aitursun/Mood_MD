package com.example.astronaut_md;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText messageEditText;
    private ImageView celebrityImageView;
    private TextView celebrityNameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Находим элементы интерфейса
        messageEditText = findViewById(R.id.messageEditText);
        celebrityImageView = findViewById(R.id.celebrityImageView);
        celebrityNameTextView = findViewById(R.id.celebrityNameTextView);
        Button sendButton = findViewById(R.id.sendButton);

        // Устанавливаем имя и изображение знаменитости
        String celebrityName = "Валентина Терешкова";
        int celebrityImageResource = R.drawable.valentina;
        celebrityNameTextView.setText(celebrityName);
        celebrityImageView.setImageResource(celebrityImageResource);

        // Обработчик нажатия на кнопку отправки
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Получаем текст из EditText
                String message = messageEditText.getText().toString();

                // Создаем новый Intent для отправки сообщения
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, message);
                sendIntent.setType("text/plain");

                // Запускаем Intent
                startActivity(Intent.createChooser(sendIntent, "Выберите приложение для отправки"));
            }
        });
    }
}
