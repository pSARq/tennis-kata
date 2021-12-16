
public class TennisGame2 implements TennisGame
{
    public int player1Point = 0;
    public int player2Point = 0;
    
    public String player1Result = "";
    public String player2Result = "";
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
        return isPlayer1FirstMarkPoint(player1Point, player2Point) || isPlayer1FirstMarkPoint(player2Point, player1Point);
    }

    private boolean isPointHigher() {
        return isPoint1HighThanPoint2(player2Point, player1Point) || isPoint1HighThanPoint2(player1Point, player2Point);
    }

    private boolean isAdvantage() {
        return isPoint1AdvantagePoint2(player1Point, player2Point) || isPoint1AdvantagePoint2(player2Point, player1Point);
    }

    private boolean isWinner() {
        return isFirstPointWinner(player1Point, player2Point) || isFirstPointWinner(player2Point, player1Point);
    }

    //Son los métodos para validar condiciones de los puntajes
    private boolean isPlayer1FirstMarkPoint(int firstPoint, int secondPoint) {
        return firstPoint > 0 && secondPoint==0;
    }

    private boolean isDeduce() {
        return player1Point==player2Point && player1Point>=3;
    }

    private boolean isPointEqual() {
        return player1Point == player2Point && player1Point < 4;
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
        if (isPlayer1FirstMarkPoint(player1Point, player2Point)){
            player1Result = calculatePointPlayer(player1Point);
            addLovePlayer(player1Result);
            return addScore();
        }
        player2Result = calculatePointPlayer(player2Point);
        addLovePlayer(player2Result);
        return addScore();
    }

    private String getAdvantagePlayer(){
        return isPoint1AdvantagePoint2(player1Point, player2Point) == true ? "Advantage "+ player1Name : "Advantage "+ player2Name;
    }

    private String getWinner(){
        return isFirstPointWinner(player1Point, player2Point) == true ? "Win for "+ player1Name : "Win for "+ player2Name;
    }

    private String getPointPlayers(){
        if (isFirstPointGame()){
            return getFirstPointGame();
        }
        player1Result=calculatePointPlayer(player1Point);
        player2Result=calculatePointPlayer(player2Point);
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
        switch (player1Point){
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
        return player1Result + "-" + player2Result;
    }

    private void addLovePlayer(String playerResult) {
        if (playerResult.equals(player1Result)){
            player2Result = "Love";
            return;
        }
        player1Result = "Love";
    }

    //Metodos para puntaje

    public void P1Score(){
        player1Point++;
    }

    public void P2Score(){
        player2Point++;
    }

    public void wonPoint(String player) {
        if (player.equals(player1Name)){
            P1Score();
            return;
        }
        P2Score();
    }
}