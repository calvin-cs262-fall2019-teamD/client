import java.util.Date;
import java.sql.Timestamp;
import game.java;
import java.lang.Math;

class Player {
  private string snapID;
  private string username;
  private int myElo;
  private Timestamp birthtime;
  private float constant;


  void main (string ID, string user, int e, Timestamp t){
    snapID = ID;
    username = user;
    myElo = e;
    birthtime = t;
  }

  string getsnapID(){
    return snapID;
  }

  string getusername(){
    return username;
  }

  string getelo(){
    return myElo;
  }

  Timestamp getbirthtime(){
    return birthtime;
  }

  void changeElo(int change, boolean direction){
    if(direction){
      myElo += change;
    }

    else{
        myElo -= change;
    }
  }

  void reRank(Game g){
    Player player1 = g.getfirstPlayer();
    Player player2 = g.getsecondPlayer();
    float P1 = (1.0 / (1.0 + pow(10, ((player1.getelo - player2.getelo) / 400))));
    float P2 = (1.0 / (1.0 + pow(10, ((player2.getelo - player1.getelo) / 400))))
    player2.getelo + constant * ()

  }



}
