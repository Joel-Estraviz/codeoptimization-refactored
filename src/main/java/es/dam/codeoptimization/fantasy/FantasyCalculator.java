/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.dam.codeoptimization.fantasy;
import es.dam.codeoptimization.PlayerStats;

/**
 * THE CLASS YOU HAVE TO MODIFY
 * @author Boris
 */
public class FantasyCalculator {

    public static int calculatePoints(PlayerStats stats) {
        int result = 0; 
        
        int minutes = stats.minutes;
        int goals = stats.goals;
        int assists = stats.assists;
        boolean yellowCard = stats.yellowCard;
        boolean redCard = stats.redCard;
        int saves = stats.saves;
        int goalsAgainst = stats.goalsAgainst;
        char matchResult = stats.matchResult;
        String position = stats.position;

        if (position.equals("PORTERO")) {
            result = calculateMinutesPlayed(minutes, result);
            result = calculateGoals(goals, result);
            result = calculateAssists(result, assists);
            result = calculateSaves(result, saves);            
            result = calculateGoalsAgainst(goalsAgainst, result);
            result = calculateYellowCard(yellowCard, result); 
            result = calculateRedCard(redCard, result);            
            result = calculateMatchResult(matchResult, result);
        } else if (position.equals("DEFENSA")) {
            result = calculateMinutesPlayed(minutes, result);
            result = calculateGoals(goals, result);
            result = calculateAssists(result, assists);
            result = calculateGoalsAgainst(goalsAgainst, result);
            result = calculateYellowCard(yellowCard, result);
            result = calculateRedCard(redCard, result);            
            result = calculateMatchResult(matchResult, result);
        } else if (position.equals("MEDIO")) {
            result = calculateMinutesPlayed(minutes, result);
            result = calculateGoals(goals, result);
            result = calculateAssists(result, assists);
            result = calculateYellowCard(yellowCard, result);
            result = calculateRedCard(redCard, result);            
            result = calculateMatchResult(matchResult, result);
        } else if (position.equals("DELANTERO")) {
            result = calculateMinutesPlayed(minutes, result);
            result = calculateGoalsForward(goals, result);
            result = calculateAssistsForward(result, assists);
            result = calculateYellowCard(yellowCard, result);
            result = calculateRedCard(redCard, result);            
            result = calculateMatchResult(matchResult, result);
        }

        return result;
    }

    private static int calculateAssistsForward(int result, int assists) {
        result = result + (assists * 5);
        return result;
    }

    private static int calculateAssists(int result, int assists) {
        result = result + (assists * 6);
        return result;
    }

    private static int calculateSaves(int result, int saves) {
        result = result + saves;
        return result;
    }

    private static int calculateGoalsForward(int goals, int result) {
        for (int i = 0; i < goals; i++) {
            result = result + 6;
        }
        return result;
    }

    private static int calculateMatchResult(char matchResult, int result) {
        if (matchResult == 'G') {
            result = result + 5;
        } else if (matchResult == 'E') {
            result = result + 2;
        }
        return result;
    }

    private static int calculateRedCard(boolean redCard, int result) {
        if (redCard == true) result = result - 5;
        return result;
    }

    private static int calculateYellowCard(boolean yellowCard, int result) {
        if (yellowCard == true) result = result - 3;
        return result;
    }

    private static int calculateGoalsAgainst(int goalsAgainst, int result) {
        if (goalsAgainst == 0) {
            result = result + 5;
        } else if (goalsAgainst == 1) {
            result = result + 3;
        } else if (goalsAgainst == 2) {
            result = result + 1;
        }
        return result;
    }

    private static int calculateGoals(int goals, int result) {
        for (int i = 0; i < goals; i++) {
            result = result + 5;
        }
        return result;
    }

    private static int calculateMinutesPlayed(int minutes, int result) {
        if (minutes > 0 && minutes < 60) {
            result = result + 3;
        } else if (minutes >= 60) {
            result = result + 5;
        }
        return result;
    }
}
