[GitLab repository](https://gitlab.univ-lille.fr/lahoucine.elaidous.etu/java-web/)

# Java-Web project

**This is a school web project.**

## Goals
1. Understanding **MVC Architecture**
2. Using **Java** in backend
    * `Jsp`
    * `Servlets`
3. Using **JavaScript** in frontend
    * `Jquery`
    * `ChartistJs` : for charts
## General description

The project consists of building a web site that uses data from a `CSV` file.
This website has two parts :

1. Static 
    * Show video games data in a **static** table
2. Dynamic
    * Show video games data in a **dynamic** table
    * Plot video games data in a **dynamic** chart
    
## Detailed description

As all web projects, we have a **backend** and a **frontend**.

### Backend
Consists of 5 java classes :
* `VideoGame`            : a video game is one line of the `CSV` file. It contains all the information in the 
`CSV` file.
* `VideoGamesRepository` : It groups all the video games in a list. It can also :
    1. add a video game
    2. return a sorted list of video games. 
    3. return the sum of video games annual sales grouped by platform or genre
* `StartupListener`      : Reads the `CSV` and creates video games, adds them to the repository and then to context. 
* `VideoGamesServlet`    : a Servlet for showing data in a static table.
* `ApiVideoGames`       : an api Servlet It can returns : 
    1. a `JSON` containing video games.
    2. or a `JSON` containing grouped annual sales of video games.

### Frontend
 
