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

        result = calculateMinutesPlayed(minutes, result);
        result = calculateYellowCard(yellowCard, result);
        result = calculateRedCard(redCard, result);
        result = calculateMatchResult(matchResult, result);
        if (position.equals(GOALKEEPER_STRING)) {
            result = calculateGoals(goals, result);
            result = calculateAssists(result, assists);
            result = calculateSaves(result, saves);
            result = calculateGoalsReceived(goalsAgainst, result);
        } else if (position.equals(DEFENCE_STRING)) {
            result = calculateGoalsReceived(goalsAgainst, result);
            result = calculateGoals(goals, result);
            result = calculateAssists(result, assists);
        } else if (position.equals(MIDFIELDER_STRING)) {
            result = calculateGoals(goals, result);
            result = calculateAssists(result, assists);
        } else if (position.equals(FORWARD_STRING)) {
            result = calculateGoalsForward(goals, result);
            result = calculateAssistsForward(result, assists);
        }

        return result;
    }

    private static int calculateAssistsForward(int result, int assists) {
        final int POINTS_PER_ASSIST = 5;

        result = result + (assists * POINTS_PER_ASSIST);
        return result;
    }

    private static int calculateAssists(int result, int assists) {
        final int POINTS_PER_ASSIST = 6;

        result = result + (assists * POINTS_PER_ASSIST);
        return result;
    }

    private static int calculateSaves(int result, int saves) {
        final int POINTS_PER_SAVE = 1;

        result = result + saves * POINTS_PER_SAVE;
        return result;
    }

    private static int calculateGoalsForward(int goals, int result) {
        final int POINTS_PER_GOAL = 6;

        for (int i = 0; i < goals; i++) {
            result = result + POINTS_PER_GOAL;
        }
        return result;
    }

    private static int calculateMatchResult(char matchResult, int result) {
        final char MATCH_WON = 'G';
        final char MATCH_DRAW = 'E';
        final int POINTS_FOR_WINNING_MATCH = 5;
        final int POINTS_FOR_DRAWING_MATCH = 2;

        if (matchResult == MATCH_WON) {
            result = result + POINTS_FOR_WINNING_MATCH;
        } else if (matchResult == MATCH_DRAW) {
            result = result + POINTS_FOR_DRAWING_MATCH;
        }
        return result;
    }

    private static int calculateRedCard(boolean redCard, int result) {
        final int POINTS_FOR_RED_CARD = -5;

        if (redCard == true) {
            result = result + POINTS_FOR_RED_CARD;
        }
        return result;
    }

    private static int calculateYellowCard(boolean yellowCard, int result) {
        final int POINTS_FOR_YELLOW_CARD = -3;

        if (yellowCard == true) {
            result = result + POINTS_FOR_YELLOW_CARD;
        }
        return result;
    }

    private static int calculateGoalsReceived(int goalsAgainst, int result) {
        final int POINTS_FOR_ZERO_GOALS_RECEIVED = 5;
        final int POINTS_FOR_ONE_GOAL_RECEIVED = 3;
        final int POINTS_FOR_TWO_GOALS_RECEIVED = 1;

        if (goalsAgainst == 0) {
            result = result + POINTS_FOR_ZERO_GOALS_RECEIVED;
        } else if (goalsAgainst == 1) {
            result = result + POINTS_FOR_ONE_GOAL_RECEIVED;
        } else if (goalsAgainst == 2) {
            result = result + POINTS_FOR_TWO_GOALS_RECEIVED;
        }
        return result;
    }

    private static int calculateGoals(int goals, int result) {
        final int POINTS_PER_GOAL = 5;

        for (int i = 0; i < goals; i++) {
            result = result + POINTS_PER_GOAL;
        }
        return result;
    }

    private static int calculateMinutesPlayed(int minutes, int result) {
        final int POINTS_PLAYED_SOME_MINUTES = 3;
        final int POINTS_PLAYED_MOST_MINUTES = 5;
        final int MINUTES_LIMIT_FOR_MOST_MINUTES = 60;

        if (minutes > 0 && minutes < MINUTES_LIMIT_FOR_MOST_MINUTES) {
            result = result + POINTS_PLAYED_SOME_MINUTES;
        } else if (minutes >= MINUTES_LIMIT_FOR_MOST_MINUTES) {
            result = result + POINTS_PLAYED_MOST_MINUTES;
        }
        return result;
    }
}
