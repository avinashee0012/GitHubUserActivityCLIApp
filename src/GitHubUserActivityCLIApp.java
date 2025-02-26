

public class GitHubUserActivityCLIApp {

    private static String username;

    public static void main(String[] args) {
        try {
            username = args[0];
            GithubUtility githubUtility = new GithubUtility();
            System.out.println(githubUtility.fetchGithubActivity(username));
        } catch (Exception e) {
            System.out.println("################### Invalid argument. Syntax: java GitHubUserActivityCLIApp <github-username>");
        }
    }
}