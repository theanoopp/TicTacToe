package in.tc.www.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageButton button1,button2,button3,button4,button5,button6,button7,button8,button9;

    private TextView playerInfo;

    private String playerName1 = "Player 1",playerName2 = "Player 2";

    private Boolean player1Chance = true;//true means p1 chance false means p2 chance P1=X,P2=O//

    private ArrayList<String> pList1 = new ArrayList<>();

    private ArrayList<String> pList2 = new ArrayList<>();

    private Boolean p1WinStatus = false;

    private Boolean p2WinStatus = false;

    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        button1 = findViewById(R.id.b1);
        button2 = findViewById(R.id.b2);
        button3 = findViewById(R.id.b3);
        button4 = findViewById(R.id.b4);
        button5 = findViewById(R.id.b5);
        button6 = findViewById(R.id.b6);
        button7 = findViewById(R.id.b7);
        button8 = findViewById(R.id.b8);
        button9 = findViewById(R.id.b9);

        playerInfo = findViewById(R.id.player_info);

        Button resetButton = findViewById(R.id.resetBT);

        playerInfo.setText("Turn : "+playerName1);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);

        resetButton.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.b1: buttonClicked(button1,"1");break;
            case R.id.b2 : buttonClicked(button2,"2");break;
            case R.id.b3 : buttonClicked(button3,"3");break;
            case R.id.b4 : buttonClicked(button4,"4");break;
            case R.id.b5 : buttonClicked(button5,"5");break;
            case R.id.b6 : buttonClicked(button6,"6");break;
            case R.id.b7 : buttonClicked(button7,"7");break;
            case R.id.b8 : buttonClicked(button8,"8");break;
            case R.id.b9 : buttonClicked(button9,"9");break;
            case R.id.resetBT : resetGame();
        }



    }

    private void resetGame() {

        playerInfo.setText("Turn : "+playerName1);
        player1Chance = true;

        count=0;

        pList1.clear();
        pList2.clear();

        p1WinStatus = false;

        p2WinStatus = false;

        button1.setImageResource(R.color.transparentColor);
        button1.setClickable(true);

        button2.setImageResource(R.color.transparentColor);
        button2.setClickable(true);

        button3.setImageResource(R.color.transparentColor);
        button3.setClickable(true);

        button4.setImageResource(R.color.transparentColor);
        button4.setClickable(true);

        button5.setImageResource(R.color.transparentColor);
        button5.setClickable(true);

        button6.setImageResource(R.color.transparentColor);
        button6.setClickable(true);

        button7.setImageResource(R.color.transparentColor);
        button7.setClickable(true);

        button8.setImageResource(R.color.transparentColor);
        button8.setClickable(true);

        button9.setImageResource(R.color.transparentColor);
        button9.setClickable(true);

    }

    private void changePlayerTurn() {

        if(player1Chance){

            playerInfo.setText("Turn : "+playerName2);
            player1Chance=false;
        }else {

            playerInfo.setText("Turn : "+playerName1);
            player1Chance=true;
        }

    }

    private void buttonClicked(ImageButton button,String value) {

        count++;

        if(player1Chance){

            pList1.add(value);

            button.setImageResource(R.drawable.cross);
            button.setClickable(false);
            changePlayerTurn();

            p1WinStatus = checkWin(pList1);


        }else {

            pList2.add(value);

            button.setImageResource(R.drawable.circle);
            button.setClickable(false);
            changePlayerTurn();

            p2WinStatus = checkWin(pList2);

        }

        if(p1WinStatus){

            WinnerDialog winnerDialog = new WinnerDialog();
            Bundle args = new Bundle();
            args.putString("winnerName",playerName1);
            winnerDialog.setArguments(args);
            winnerDialog.show(getFragmentManager(),"tag");

            endGame();

        }else if(p2WinStatus){

            WinnerDialog winnerDialog = new WinnerDialog();
            Bundle args = new Bundle();
            args.putString("winnerName",playerName2);
            winnerDialog.setArguments(args);
            winnerDialog.show(getFragmentManager(),"tag");

            endGame();

        }else if(count==9) {

            Toast.makeText(GameActivity.this,"Draw",Toast.LENGTH_SHORT).show();

        }

    }

    private void endGame() {

        button1.setClickable(false);
        button2.setClickable(false);
        button3.setClickable(false);
        button4.setClickable(false);
        button5.setClickable(false);
        button6.setClickable(false);
        button7.setClickable(false);
        button8.setClickable(false);
        button9.setClickable(false);

    }

    private Boolean checkWin(List<String> pList) {

        Boolean isWinner = false;

        if(pList.containsAll(Const.set1)){
            isWinner=true;
        }else if(pList.containsAll(Const.set2)){
            isWinner=true;
        }else if(pList.containsAll(Const.set3)){
            isWinner=true;
        }else if(pList.containsAll(Const.set4)){
            isWinner=true;
        }else if(pList.containsAll(Const.set5)){
            isWinner=true;
        }else if(pList.containsAll(Const.set6)){
            isWinner=true;
        }else if(pList.containsAll(Const.set7)){
            isWinner=true;
        }else if(pList.containsAll(Const.set8)){
            isWinner=true;
        }

        return isWinner;

    }
}
