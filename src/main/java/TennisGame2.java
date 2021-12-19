
public class TennisGame2 implements TennisGame
{
    public int player1Point = 0;
    public int player2Point = 0;

    private String player1Name;
    private String player2Name;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore(){
        if (isGame()) {
            return getResultScore();
        }

        if (isDeduce()) {
            return "Deuce";
        }

        return getResultPlayer();

    }

    //Métodos para validar los metodos de los if dentro de getScore()
    private boolean isGame(){
       return isPointLessThan3() || isPointEqualAndNotDeuce();
    }

    private boolean isDeduce() {
        return isPointPlayerEqual() && player1Point >= 3;
    }

    //Son los métodos para validar condiciones de los puntajes

    private boolean isPointLessThan3() {
        return isPoint2HighThanPoint1(player2Point, player1Point) || isPoint2HighThanPoint1(player1Point, player2Point);
    }

    private boolean isAdvantage(int result) {
        return result == 1 || result == -1;
    }

    private boolean isPointPlayerEqual() {
        return player1Point == player2Point;
    }

    private boolean isPointEqualAndNotDeuce() {
        return isPointPlayerEqual() && !isDeduce();
    }

    private boolean isPoint2HighThanPoint1(int firstPoint, int secondPoint) {
        return secondPoint > firstPoint && secondPoint <= 3;
    }


    //Son los métodos para obtener resultados
    //Metodos get
    private String getAdvantagePlayer(){
        String namePlayer = player1Point > player2Point ? player1Name : player2Name;
        return "Advantage "+ namePlayer;
    }

    private String getWinner(int result){
        String winner = result >= 2 ? player1Name : player2Name;
        return "Win for "+ winner;
    }

    private String getResultPlayer() {
        int result = player1Point - player2Point;
        if (isAdvantage(result)){
            return getAdvantagePlayer();
        }
        return getWinner(result);
    }


    //Metodos calculate
    private String getResultScore() {
        String[] listScore = new String[]{"Love", "Fifteen", "Thirty", "Forty"};
        String score = listScore[player1Point];
        return (isPointPlayerEqual()) ? score + "-All" : score + "-" + listScore[player2Point];
    }

    //Metodo para puntaje
    public void wonPoint(String player) {
        if (player.equals(player1Name)){
            player1Point++;
            return;
        }
        player2Point++;
    }
}