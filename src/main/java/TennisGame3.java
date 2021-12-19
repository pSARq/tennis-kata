
public class TennisGame3 implements TennisGame {
    
    private int pointPlayer1;
    private int pointPlayer2;
    private String player1Name;
    private String player2Name;

    public TennisGame3(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore() {
        if (isGame()) {
            return getResultScore();
        }
        if (isPointPlayerEqual()){
            return "Deuce";
        }
        return getLeadingPlayer();
    }

    private String getLeadingPlayer() {
        String nameWinner = pointPlayer1 > pointPlayer2 ? player1Name : player2Name;
        return getResultLeadingPLayer(nameWinner);
    }

    private String getResultLeadingPLayer(String nameWinner) {
        return isPointsPlayerEqual1() ? "Advantage " + nameWinner : "Win for " + nameWinner;
    }

    private boolean isPointsPlayerEqual1() {
        return (pointPlayer1-pointPlayer2)*(pointPlayer1-pointPlayer2) == 1;
    }

    private boolean isPointPlayerEqual() {
        return pointPlayer1 == pointPlayer2;
    }

    private String getResultScore() {
        String[] listScore = new String[]{"Love", "Fifteen", "Thirty", "Forty"};
        String score = listScore[pointPlayer1];
        return (isPointPlayerEqual()) ? score + "-All" : score + "-" + listScore[pointPlayer2];
    }

    private boolean isGame() {
        return isPointPlayerLessThan4() && pointPlayer1 + pointPlayer2 != 6;
    }

    private boolean isPointPlayerLessThan4() {
        return pointPlayer1 < 4 && pointPlayer2 < 4;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(player1Name)){
            this.pointPlayer1 += 1;
            return;
        }
        this.pointPlayer2 += 1;
    }

}
