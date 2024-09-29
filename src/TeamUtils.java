public class TeamUtils
{
    public void printTable(Team[] teams)
    {
        // Print the header with proper formatting
        System.out.printf("%-30s %-3s %-3s %-3s %-3s %-3s %-3s %-3s %-3s%n",
                "Club", "MP", "W", "D", "L", "GF", "GA", "GD", "PTS");

        // Print each team's data
        for (Team team : teams)
        {
            System.out.printf("%-30s %-3d %-3d %-3d %-3d %-3d %-3d %-3d %-3d%n",
                    team.getTeamName(),
                    team.getMatchesPlayed(),
                    team.getWins(),
                    team.getDraws(),
                    team.getLosses(),
                    team.getGoalsScored(),
                    team.getGoalsConceded(),
                    team.getGoalDifference(),
                    team.getPoints());
        }
    }
}
