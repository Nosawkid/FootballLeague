import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class League
{
    private Fixture[] fixtures;
    private Result[] results;

    public Result[] getResults()
    {
        return this.results;
    }

    public void setResults(Result[] results)
    {
        this.results = results;
    }

    public Fixture[] getFixtures()
    {
        return this.fixtures;
    }

    public void setFixtures(Fixture[] fixtures)
    {
        this.fixtures = fixtures;
    }

    public Team[] removeFirstTeam(Team[] teams)
    {
        Team[] resTeam = new Team[teams.length - 1];
        int idx = 0;
        for (int i = 1; i < teams.length; i++)
        {
            resTeam[idx++] = teams[i];
        }
        return resTeam;
    }

    public Team[] rotateTeamArray(Team[] teams)
    {
        Team[] resTeam = new Team[teams.length];
        resTeam[0] = teams[teams.length - 1];
        int idx = 1;
        for (int i = 0; i < teams.length - 1; i++)
        {
            resTeam[idx++] = teams[i];
        }
        return resTeam;
    }

    public void genereateLeagueFixture(Team[] teams)
    {
        List<Team> teamList = Arrays.asList(teams);
        Collections.shuffle(teamList);
        Team[] shuffledTeams = teamList.toArray(new Team[0]);
        Team firstTeam = shuffledTeams[0];
        int totalMatches = (shuffledTeams.length * (shuffledTeams.length - 1)) / 2;
        int matchesPerRound = shuffledTeams.length / 2;
        Team[] allOtherTeams = removeFirstTeam(shuffledTeams);
        Fixture[] fixtureArray = new Fixture[totalMatches];
        int matchCount = 0;
        int totalRounds = shuffledTeams.length - 1;

        for (int round = 0; round < totalRounds; round++)
        {
            fixtureArray[matchCount] = new Fixture(firstTeam,
                    allOtherTeams[allOtherTeams.length - 1]);
            matchCount++;
            for (int j = 0; j < matchesPerRound - 1; j++)
            {
                fixtureArray[matchCount] = new Fixture(allOtherTeams[j],
                        allOtherTeams[allOtherTeams.length - j - 2]);
                matchCount++;
            }
            allOtherTeams = rotateTeamArray(allOtherTeams);
        }

        this.fixtures = fixtureArray;
        results = new Result[fixtures.length];
    }

    public int[] deterMineMatchResult(Team[] teams)
    {

        int[] res = new int[3];
        Random random = new Random();
        Team team1 = teams[0];
        Team team2 = teams[1];
        int team1TotalMatches = team1.getMatchesPlayed();
        int team1Points = team1.getPoints();
        int team1TotalGoals = team1.getGoalsScored();
        int team1TotalConcededGoals = team1.getGoalsConceded();
        int team1Wins = team1.getWins();
        int team1Loses = team1.getLosses();
        int team1Draws = team1.getDraws();

        int team2TotalMatches = team2.getMatchesPlayed();
        int team2Points = team2.getPoints();
        int team2TotalGoals = team2.getGoalsScored();
        int team2TotalConcededGoals = team2.getGoalsConceded();
        int team2Loses = team2.getLosses();
        int team2Wins = team2.getWins();
        int team2Draw = team2.getDraws();

        int team1Score = random.nextInt(5);
        int team2Score = random.nextInt(5);

        team1TotalGoals += team1Score;
        team1TotalConcededGoals += team2Score;

        team2TotalGoals += team2Score;
        team2TotalConcededGoals += team1Score;

        team1.setMatchesPlayed(team1TotalMatches + 1);
        team1.setGoalsScored(team1TotalGoals);
        team1.setGoalsConceded(team1TotalConcededGoals);
        team1.setGoalDifference(team1TotalGoals - team1TotalConcededGoals);

        team2.setMatchesPlayed(team2TotalMatches + 1);
        team2.setGoalsScored(team2TotalGoals);
        team2.setGoalsConceded(team2TotalConcededGoals);
        team2.setGoalDifference(team2TotalGoals - team2TotalConcededGoals);

        if (team1Score > team2Score)
        {

            team1.setPoints(team1Points + 3);
            team1.setWins(team1Wins + 1);
            team2.setLosses(team2Loses + 1);
            res[0] = 0;
            res[1] = team1Score;
            res[2] = team2Score;

        } else
            if (team2Score > team1Score)
            {

                team2.setPoints(team2Points + 3);
                team2.setWins(team2Wins + 1);
                team1.setLosses(team1Loses + 1);
                res[0] = 1;
                res[1] = team2Score;
                res[2] = team1Score;
            } else
            {
                team1.setPoints(team1Points + 1);
                team2.setPoints(team2Points + 1);
                team1.setDraws(team1Draws + 1);
                team2.setDraws(team2Draw + 1);
                res[0] = 2;
                res[1] = team1Score;
                res[2] = team2Score;
            }
        return res;

    }

    public void simulateLeage()
    {
        for (int i = 0; i < fixtures.length; i++)
        {
            Team[] teams =
            {
                    fixtures[i].getTeamOne(), fixtures[i].getTeamTwo()
            };
            int[] res = deterMineMatchResult(teams);
            if (res[0] != 2)
            {
                results[i] = new Result(teams[res[0]].getTeamName(), teams[1 - res[0]].getTeamName(), res[1], res[2],
                        false);
            } else
            {
                results[i] = new Result(teams[0].getTeamName(), teams[1].getTeamName(), res[1], res[2],
                        true);
            }
        }
    }

    public void sortByPoints(Team[] teams)
    {
        Arrays.sort(teams, new Comparator<Team>()
        {
            @Override
            public int compare(Team t1, Team t2)
            {
                int pointComparison = Integer.compare(t2.getPoints(), t1.getPoints());
                if (pointComparison == 0)
                {
                    return Integer.compare(t2.getGoalDifference(), t1.getGoalDifference());
                }
                return pointComparison;
            }
        });
    }

}