# [COMPLETE] GitHub User Activity CLI App

A simple command line interface (CLI) app to fetch the recent activity of a GitHub user and display it in the terminal. Uses [Gson](https://github.com/google/gson) library for object mapping. JAR file includes Gson JAR file.

### Installation
1. Clone the repo
```bash
git clone git@github.com:avinashee0012/GitHubUserActivityCLIApp.git
cd GitHubUserActivityCLIApp
```
2. Run the jar file
```bash
java -jar GitHubUserActivityCLIApp.jar <username>
```

### Usage Example
```bash
java -jar GitHubUserActivityCLIApp.jar avinashee0012
```
Output:
~~~
********* Fetching Recent Github Activity for "avinashee0012" *********
- PushEvent: avinashee0012/GitHubUserActivityCLIApp ---> 4 times
- PushEvent: avinashee0012/TaskTrackerCLIApp ---> 15 times
- PushEvent: avinashee0012/HotelRoomBookingCLIApp ---> 2 times
- CreateEvent: avinashee0012/GitHubUserActivityCLIApp ---> 3 times
- CreateEvent: avinashee0012/CLITaskTracker ---> 2 times
- PushEvent: avinashee0012/CLITaskTracker ---> 1 times
- PushEvent: avinashee0012/crm ---> 3 times
~~~
_____
####
Project Idea: [roadmap.sh](https://roadmap.sh/projects/github-user-activity)
