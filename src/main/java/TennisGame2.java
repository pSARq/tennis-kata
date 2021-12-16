
public class TennisGame2 implements TennisGame
{
    public int P1point = 0;
    public int P2point = 0;
    
    public String P1res = "";
    public String P2res = "";
    private String player1Name;
    private String player2Name;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore(){
        String score = "";

        if (isTie()) {
            score = calculateScore();
        }

        if (isPointHigher()) {
            score = getPointPlayers();
        }

        if (isAdvantage()) {
            score = getAdvantagePlayer();
        }

        if (isWinner()){
            score = getWinner();
        }

        return score;
    }

    //Métodos para validar los metodos de los if dentro de getScore()
    private boolean isTie() {
        return isPointEqual() || isDeduce();
    }

    private boolean isFirstPointGame() {
        return isPlayer1FirstMarkPoint(P1point, P2point) || isPlayer1FirstMarkPoint(P2point, P1point);
    }

    private boolean isPointHigher() {
        return isPoint1HighThanPoint2(P2point, P1point) || isPoint1HighThanPoint2(P1point, P2point);
    }

    private boolean isAdvantage() {
        return isPoint1AdvantagePoint2(P1point, P2point) || isPoint1AdvantagePoint2(P2point, P1point);
    }

    private boolean isWinner() {
        return isFirstPointWinner(P1point, P2point) || isFirstPointWinner(P2point, P1point);
    }

    //Son los métodos para validar condiciones de los puntajes
    private boolean isPlayer1FirstMarkPoint(int firstPoint, int secondPoint) {
        return firstPoint > 0 && secondPoint==0;
    }

    private boolean isDeduce() {
        return P1point==P2point && P1point>=3;
    }

    private boolean isPointEqual() {
        return P1point == P2point && P1point < 4;
    }

    private boolean isFirstPointWinner(int firstPoint, int secondPoint) {
        return isPoint1winner(firstPoint, secondPoint) && isSubtractionPointsHigher1(firstPoint, secondPoint);
    }

    private boolean isSubtractionPointsHigher1(int firstPoint, int secondPoint) {
        return (firstPoint - secondPoint) >= 2;
    }

    private boolean isPoint1winner(int firstPoint, int secondPoint) {
        return firstPoint >= 4 && secondPoint >= 0;
    }

    private boolean isPoint1HighThanPoint2(int firstPoint, int secondPoint) {
        return secondPoint > firstPoint && secondPoint < 4;
    }

    private boolean isPoint1AdvantagePoint2(int firstPoint, int secondPoint) {
        return firstPoint > secondPoint && secondPoint >= 3;
    }

    //Son los métodos para obtener resultados
    //Metodos get
    private String getFirstPointGame() {
        if (isPlayer1FirstMarkPoint(P1point, P2point)){
            P1res = calculatePointPlayer(P1point);
            addLovePlayer(P1res);
            return addScore();
        }
        P2res = calculatePointPlayer(P2point);
        addLovePlayer(P2res);
        return addScore();
    }

    private String getAdvantagePlayer(){
        return isPoint1AdvantagePoint2(P1point, P2point) == true ? "Advantage "+ player1Name : "Advantage "+ player2Name;
    }

    private String getWinner(){
        return isFirstPointWinner(P1point, P2point) == true ? "Win for "+ player1Name : "Win for "+ player2Name;
    }

    private String getPointPlayers(){
        if (isFirstPointGame()){
            return getFirstPointGame();
        }
        P1res=calculatePointPlayer(P1point);
        P2res=calculatePointPlayer(P2point);
        return addScore();
    }


    //Metodos calculate
    private String calculatePointPlayer(int PlayerPoint) {
        switch (PlayerPoint){
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
            case 3:
                return "Forty";
            default:
                return "Love";
        }
    }

    private String calculateScore() {
        switch (P1point){
            case 0:
                return "Love-All";
            case 1:
                return "Fifteen-All";
            case 2:
                return "Thirty-All";
            default:
                return "Deuce";
        }
    }

    //Métodos add
    private String addScore() {
        return P1res + "-" + P2res;
    }

    private void addLovePlayer(String playerResult) {
        if (playerResult.equals(P1res)){
            P2res = "Love";
            return;
        }
        P1res = "Love";
    }

    //Metodos para puntaje

    public void P1Score(){
        P1point++;
    }

    public void P2Score(){
        P2point++;
    }

    public void wonPoint(String player) {
        if (player.equals(player1Name)){
            P1Score();
            return;
        }
        P2Score();
    }
}