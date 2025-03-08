import java.util.*;

class Match {
    String teamA, teamB;
    int goalsA, goalsB, shotsA, shotsB, possessionA, possessionB;

    public Match(String teamA, String teamB, int goalsA, int goalsB, int shotsA, int shotsB, int possessionA, int possessionB) {
        this.teamA = teamA;
        this.teamB = teamB;
        this.goalsA = goalsA;
        this.goalsB = goalsB;
        this.shotsA = shotsA;
        this.shotsB = shotsB;
        this.possessionA = possessionA;
        this.possessionB = possessionB;
    }
}

public class FootballPrediction {
    public static String predictWinner(List<Match> history, String teamX, String teamY) {
        int teamXWins = 0, teamYWins = 0, draws = 0;

        for (Match match : history) {
            if ((match.teamA.equals(teamX) && match.teamB.equals(teamY)) || 
                (match.teamA.equals(teamY) && match.teamB.equals(teamX))) {

                if (match.goalsA > match.goalsB) {
                    if (match.teamA.equals(teamX)) teamXWins++;
                    else teamYWins++;
                } else if (match.goalsA < match.goalsB) {
                    if (match.teamA.equals(teamX)) teamYWins++;
                    else teamXWins++;
                } else {
                    draws++;
                }
            }
        }

        if (teamXWins > teamYWins) return teamX + " is more likely to win!";
        else if (teamYWins > teamXWins) return teamY + " is more likely to win!";
        else return "It's likely to be a draw!";
    }

    public static void main(String[] args) {
        List<Match> history = new ArrayList<>();
        history.add(new Match("TeamA", "TeamB", 2, 1, 10, 7, 55, 45));
        history.add(new Match("TeamB", "TeamA", 1, 1, 8, 8, 50, 50));
        history.add(new Match("TeamA", "TeamC", 3, 0, 12, 5, 60, 40));
        history.add(new Match("TeamC", "TeamA", 0, 2, 6, 11, 45, 55));

        System.out.println(predictWinner(history, "TeamA", "TeamB"));
    }
}
