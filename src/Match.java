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

        League demo = new League();
        demo.generateFixture(teams);
        demo.printAllFixtures();

    }
}
