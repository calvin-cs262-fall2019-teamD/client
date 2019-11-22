import player.java;
class Game {
  private Player firstPlayer;
  private Player secondPlayer;
  private Timestamp time;
  private int 1score;
  private int 2score;
  void main( Player P1, Player P2, intArray[] score, Timestamp t ){
    firstPlayer = P1;
    secondPlayer = P2;
    1score = score[0];
    2score = score[1];
    time = t;
  }

  Player getfirstPlayer(){
    return firstPlayer;
  }

  Player getsecondPlayer(){
    return secondPlayer;
  }

  Timestamp getTime(){
    return time;
  }

  int get1score(){
    return 1score;
  }

  int get2score(){
    return 2score;
  }

}
