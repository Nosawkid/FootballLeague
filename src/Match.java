public class Match
{
    public static void main(String[] args) throws Exception
    {
        Team[] teams = new Team[20];
        teams[0] = new Team("Arsenal");
        teams[1] = new Team("Aston Villa");
        teams[2] = new Team("Bournemouth");
        teams[3] = new Team("Brentford");
        teams[4] = new Team("Brighton");
        teams[5] = new Team("Chelsea");
        teams[6] = new Team("Crystal Palace");
        teams[7] = new Team("Everton");
        teams[8] = new Team("Fulham");
        teams[9] = new Team("Liverpool");
        teams[10] = new Team("Manchester City");
        teams[11] = new Team("Manchester United");
        teams[12] = new Team("Newcastle United");
        teams[13] = new Team("Nottingham Forest");
        teams[14] = new Team("Sheffield United");
        teams[15] = new Team("Tottenham Hotspur");
        teams[16] = new Team("West Ham United");
        teams[17] = new Team("Wolverhampton Wanderers");
        teams[18] = new Team("Luton Town");
        teams[19] = new Team("Burnley");

        TeamUtils teamUtils = new TeamUtils();
        League league = new League();
        league.genereateLeagueFixture(teams);

        teamUtils.printTable(teams);
        System.out.println(" ");
        System.out.println("************************");
        for (int i = 1; i <= 2; i++)
        {
            league.simulateLeage();
        }
        league.sortByPoints(teams);
        System.out.println("Result After Simulation");
        System.out.println("********************");
        teamUtils.printTable(teams);
        System.out.println("*************");
        System.out.println("Title Winner: " + teams[0].getTeamName());

        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");

        System.out.println("Result of Each Match");
        Result[] results = league.getResults();
        for (Result res : results)
        {
            if (res.isIsDraw())
            {
                System.out.println(" ");
                System.out.println("Match Draw");
                System.out.println(res.getWinnerTeam() + " : " + res.getWinnerGoals());
                System.out.println(res.getLoserTeam() + " : " + res.getLoserGoals());
                System.out.println(" ");

            } else
            {
                System.out.println(" ");
                System.out.println("Match Winner: " + res.getWinnerTeam());
                System.out.println(res.getWinnerTeam() + " : " + res.getWinnerGoals());
                System.out.println(res.getLoserTeam() + " : " + res.getLoserGoals());
                System.out.println(" ");

            }
        }

    }
}
