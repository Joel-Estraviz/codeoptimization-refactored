/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.dam.codeoptimization.fantasy;

import es.dam.codeoptimization.PlayerStats;

/**
 * THE CLASS YOU HAVE TO MODIFY
 *
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

        final String GOALKEEPER_STRING = "PORTERO";
        final String DEFENCE_STRING = "DEFENSA";
        final String MIDFIELDER_STRING = "MEDIO";
        final String FORWARD_STRING = "DELANTERO";

        result += calculateMinutesPlayed(minutes);
        result += calculateYellowCard(yellowCard);
        result += calculateRedCard(redCard);
        result += calculateMatchResult(matchResult);
        if (position.equals(GOALKEEPER_STRING)) {
            result += calculateGoals(goals);
            result += calculateAssists(assists);
            result += calculateSaves(saves);
            result += calculateGoalsReceived(goalsAgainst);
        } else if (position.equals(DEFENCE_STRING)) {
            result += calculateGoalsReceived(goalsAgainst);
            result += calculateGoals(goals);
            result += calculateAssists(assists);
        } else if (position.equals(MIDFIELDER_STRING)) {
            result += calculateGoals(goals);
            result += calculateAssists(assists);
        } else if (position.equals(FORWARD_STRING)) {
            result += calculateGoalsForward(goals);
            result += calculateAssistsForward(assists);
        }

        return result;
    }

    private static int calculateAssistsForward(int assists) {
        final int POINTS_PER_ASSIST = 5;

        return assists * POINTS_PER_ASSIST;
    }

    private static int calculateAssists(int assists) {
        final int POINTS_PER_ASSIST = 6;

        return assists * POINTS_PER_ASSIST;
    }

    private static int calculateSaves(int saves) {
        final int POINTS_PER_SAVE = 1;

        return saves * POINTS_PER_SAVE;
    }

    private static int calculateGoalsForward(int goals) {
        final int POINTS_PER_GOAL = 6;

        return goals * POINTS_PER_GOAL;
    }

    private static int calculateMatchResult(char matchResult) {
        final char MATCH_WON = 'G';
        final char MATCH_DRAW = 'E';
        final int POINTS_FOR_WINNING_MATCH = 5;
        final int POINTS_FOR_DRAWING_MATCH = 2;
        final int POINTS_FOR_LOSING_MATCH = 0;
        int matchResultPoints;

        if (matchResult == MATCH_WON) {
            matchResultPoints = POINTS_FOR_WINNING_MATCH;
        } else if (matchResult == MATCH_DRAW) {
            matchResultPoints = POINTS_FOR_DRAWING_MATCH;
        } else {
            matchResultPoints = POINTS_FOR_LOSING_MATCH;
        }
        return matchResultPoints;
    }

    private static int calculateRedCard(boolean redCard) {
        final int POINTS_FOR_RED_CARD = -5;
        int redCardPointsObtained = 0;

        if (redCard == true) {
            redCardPointsObtained = POINTS_FOR_RED_CARD;
        }        
        
        return redCardPointsObtained;
    }

    private static int calculateYellowCard(boolean yellowCard) {
        final int POINTS_FOR_YELLOW_CARD = -3;
        int yellowCardPointsObtained = 0;

        if (yellowCard == true) {
            yellowCardPointsObtained = POINTS_FOR_YELLOW_CARD;
        }        
        
        return yellowCardPointsObtained;
    }

    private static int calculateGoalsReceived(int goalsAgainst) {
        final int POINTS_FOR_ZERO_GOALS_RECEIVED = 5;
        final int POINTS_FOR_ONE_GOAL_RECEIVED = 3;
        final int POINTS_FOR_TWO_GOALS_RECEIVED = 1;
        int pointsForGoalsReceived;

        if (goalsAgainst == 0) {
            pointsForGoalsReceived = POINTS_FOR_ZERO_GOALS_RECEIVED;
        } else if (goalsAgainst == 1) {
            pointsForGoalsReceived = POINTS_FOR_ONE_GOAL_RECEIVED;
        } else if (goalsAgainst == 2) {
            pointsForGoalsReceived = POINTS_FOR_TWO_GOALS_RECEIVED;
        } else {
            pointsForGoalsReceived = 0;
        }
        return pointsForGoalsReceived;
    }

    private static int calculateGoals(int goals) {
        final int POINTS_PER_GOAL = 5;

        return goals * POINTS_PER_GOAL;
    }

    private static int calculateMinutesPlayed(int minutes) {
        final int POINTS_PLAYED_SOME_MINUTES = 3;
        final int POINTS_PLAYED_MOST_MINUTES = 5;
        final int MINUTES_LIMIT_FOR_MOST_MINUTES = 60;
        int pointsForMinutesPlayed;

        if (minutes > 0 && minutes < MINUTES_LIMIT_FOR_MOST_MINUTES) {
            pointsForMinutesPlayed = POINTS_PLAYED_SOME_MINUTES;
        } else if (minutes >= MINUTES_LIMIT_FOR_MOST_MINUTES) {
            pointsForMinutesPlayed = POINTS_PLAYED_MOST_MINUTES;
        } else {
            pointsForMinutesPlayed = 0;
        }
        return pointsForMinutesPlayed;
    }
}
