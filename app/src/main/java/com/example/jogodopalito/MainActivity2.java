package com.example.jogodopalito;

import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity2 extends AppCompatActivity {
    TextView qntPalitos1, qntPalitos2, apostaCPU, jogaPalitoCPU, result;
    EditText jogaPalito, apostaPlayer;
    VideoView maoJogador, maoCPU;
    Button btJogar;
    Random rnd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        qntPalitos1 = (TextView) findViewById(R.id.qntPalitos1);
        qntPalitos2 = (TextView) findViewById(R.id.qntPalitos2);
        jogaPalito = (EditText) findViewById(R.id.jogaPalito);
        jogaPalitoCPU = (TextView) findViewById(R.id.jogaPalitoCPU);
        apostaPlayer = (EditText) findViewById(R.id.apostaPlayer);
        apostaCPU = (TextView) findViewById(R.id.apostaCPU);
        btJogar = (Button) findViewById(R.id.btJogar);
        maoJogador = (VideoView) findViewById(R.id.maoJogador);
        maoCPU = (VideoView) findViewById(R.id.maoCPU);
        rnd = new Random();
        result = (TextView) findViewById(R.id.result);


        Palitos player = new Palitos();
        Palitos cpu = new Palitos();

        player.setContPalito(3);
        cpu.setContPalito(3);

        btJogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Handler handler = new Handler();

                if (Integer.parseInt(jogaPalito.getText().toString()) > player.getContPalito()) {
                    jogaPalito.setError("Palitos insuficientes.");
                } else if (Integer.parseInt(apostaPlayer.getText().toString()) > (cpu.getContPalito() + player.getContPalito())) {
                    apostaPlayer.setError("Aposta Invalida!");
                } else {

                    if (cpu.getContPalito() == 3) {
                        cpu.setJogadaPalito(rnd.nextInt(3));
                    } else if (cpu.getContPalito() == 2) {
                        cpu.setJogadaPalito(rnd.nextInt(2));
                    } else if (cpu.getContPalito() == 1) {
                        cpu.setJogadaPalito(rnd.nextInt(1));
                    }

                    jogaPalitoCPU.setText(String.valueOf(cpu.getJogadaPalito()));

                    if ((cpu.getContPalito()+player.getContPalito())== 6) {
                        cpu.setApostaPalito(rnd.nextInt(6));
                    } else if ((cpu.getContPalito()+player.getContPalito())== 5) {
                        cpu.setApostaPalito(rnd.nextInt(5));
                    } else if ((cpu.getContPalito()+player.getContPalito())== 4) {
                        cpu.setApostaPalito(rnd.nextInt(4));
                    } else if ((cpu.getContPalito()+player.getContPalito())== 3) {
                        cpu.setApostaPalito(rnd.nextInt(3));
                    } else if ((cpu.getContPalito()+player.getContPalito())== 2) {
                        cpu.setApostaPalito(rnd.nextInt(2));
                    }

                    apostaCPU.setText(String.valueOf(cpu.getApostaPalito()));

                    maoJogador.setVisibility(View.VISIBLE);
                    maoCPU.setVisibility(View.VISIBLE);
                    String videoPath00 = "android.resource://" + getPackageName() + "/" + R.raw.palito0;
                    Uri uri0 = Uri.parse(videoPath00);
                    maoJogador.setVideoURI(uri0);
                    maoJogador.start();
                    maoCPU.setVideoURI(uri0);
                    maoCPU.start();


                    if (Integer.parseInt(jogaPalito.getText().toString()) == 0) {
                        maoJogador.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.palito0);
                        maoJogador.start();
                        handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                maoJogador.setVisibility(View.INVISIBLE);
                            }
                        }, 5000);
                    } else if (Integer.parseInt(jogaPalito.getText().toString()) == 1) {
                        maoJogador.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.palito1);
                        maoJogador.start();
                        handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                maoJogador.setVisibility(View.INVISIBLE);
                            }
                        }, 5000);
                    } else if (Integer.parseInt(jogaPalito.getText().toString()) == 2) {
                        maoJogador.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.palito2);
                        maoJogador.start();
                        handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                maoJogador.setVisibility(View.INVISIBLE);
                            }
                        }, 5000);
                    } else if (Integer.parseInt(jogaPalito.getText().toString()) == 3) {
                        maoJogador.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.palito3);
                        maoJogador.start();
                        handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                maoJogador.setVisibility(View.INVISIBLE);
                            }
                        }, 5000);
                    }


                    if (cpu.getJogadaPalito() == 0) {
                        maoCPU.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.palito0);
                        maoCPU.start();
                        handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                maoCPU.setVisibility(View.INVISIBLE);
                            }
                        }, 5000);
                    } else if (cpu.getJogadaPalito() == 1) {
                        maoCPU.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.palito1);
                        maoCPU.start();
                        handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                maoCPU.setVisibility(View.INVISIBLE);
                            }
                        }, 5000);
                    } else if (cpu.getJogadaPalito() == 2) {
                        maoCPU.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.palito2);
                        maoCPU.start();
                        handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                maoCPU.setVisibility(View.INVISIBLE);
                            }
                        }, 5000);
                    } else if (cpu.getJogadaPalito() == 3) {
                        maoCPU.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.palito3);
                        maoCPU.start();
                        handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                maoCPU.setVisibility(View.INVISIBLE);
                            }
                        }, 5000);
                    }

                    int calc1 = Integer.parseInt(jogaPalito.getText().toString()) + cpu.getJogadaPalito();

                    if (Integer.parseInt(apostaPlayer.getText().toString()) == calc1 && cpu.getApostaPalito() == calc1 ) {
                        Toast.makeText(getApplicationContext(), "Empate, jogar novamente!", Toast.LENGTH_LONG).show();
                    } else if (calc1 == Integer.parseInt(apostaPlayer.getText().toString())) {
                        player.setContPalito(player.getContPalito() - 1);
                        qntPalitos1.setText(String.valueOf(player.getContPalito()));
                        Toast.makeText(getApplicationContext(), "Player ganhou (-1 palito)", Toast.LENGTH_LONG).show();
                    } else if (calc1 == cpu.getApostaPalito()) {
                        cpu.setContPalito(cpu.getContPalito() - 1);
                        qntPalitos2.setText(String.valueOf(cpu.getContPalito()));
                        Toast.makeText(getApplicationContext(), "CPU ganhou (-1 palito)", Toast.LENGTH_LONG).show();
                    } else if (Integer.parseInt(apostaPlayer.getText().toString()) == calc1 && cpu.getApostaPalito() == calc1 ) {
                        Toast.makeText(getApplicationContext(), "Empate, jogar novamente!", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Sem vencedores, jogar novamente!", Toast.LENGTH_LONG).show();
                    }

                    result.setText(String.valueOf(cpu.getJogadaPalito()+Integer.parseInt(jogaPalito.getText().toString())));

                    if (player.getContPalito() == 0 || cpu.getContPalito() == 0) {

                        if (player.getContPalito() == 0) {
                            AlertDialog.Builder vencedor = new AlertDialog.Builder(MainActivity2.this);
                            vencedor.setTitle("VENCEDOR DO JOGO DOS PALITOS");
                            vencedor.setMessage("JOGADOR VENCEU");
                            vencedor.setCancelable(false);
                            vencedor.setPositiveButton("OK", null);
                            vencedor.create().show();
                        } else if (cpu.getContPalito() == 0) {
                            AlertDialog.Builder vencedor = new AlertDialog.Builder(MainActivity2.this);
                            vencedor.setTitle("VENCEDOR DO JOGO DOS PALITOS");
                            vencedor.setMessage("CPU VENCEU");
                            vencedor.setCancelable(false);
                            vencedor.setPositiveButton("OK", null);
                            vencedor.create().show();
                        }
                        player.setContPalito(3);
                        cpu.setContPalito(3);
                        qntPalitos1.setText(String.valueOf(player.getContPalito()));
                        qntPalitos2.setText(String.valueOf(cpu.getContPalito()));
                    }
                }
            }
        });
    }
}