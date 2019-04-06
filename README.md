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
* `VideoGame` : a video game is one line of the `CSV` file. We keep all 
  columns .
* `VideoGamesRepository` : It groups all video games in a list. It can also :
    1. add a video game
    2. return a sorted list of video games. 
    3. return video games annual sales grouped by platform or genre.
* `StartupListener` : Reads the `CSV` and creates video games of it.
  Then, it adds them to the repository and the context.
* `VideoGamesServlet` : a servlet for showing data in a static table.
* `ApiVideoGames`: an api servlet that returns a `Json` containing :
  1. raw video games data. But limited to a certain amount of rows (10
     per page by default)
  2. or annual sales of video games grouped by platform or genre

### Frontend
 
As said above, in **frontend** we used `Jquery` for data manipulation
and `ChartistJs` for data plotting. I added `Bootstrap 4` for better
styling.

#### `/added_chartist`
I added some plugins and `CSS` related to `ChartistJs` :
1. `chartist-plugin-legend.js` : to add a legend to charts
   *  added `CSS` to it because it is provided without any styling (you
      may find it in `my_chartist-plugins.legend.css`)
2. `chartist-plugin-axistitle.js` : to add axis labels
3. `my_chartist.css` : to add colors to some series that were left
   without coloring. In the default `ChartistJs` `CSS`, they provided
   coloring for only the first 15 series in a chart.

#### `/pics`
Contains Home page image and logo.

#### `/index.html`
The home page. Like all the other pages, it contains a navigation bar.

#### `/chart.html`
Contains a dynamic chart for which we can change two parameters :
1. **Type of sales** : Global, Europe, North America, Japan...
2. **Grouping param** : we can group sales by **Platform** (PS2, Xbox,
   DS ...) or **Genre** (Action, Strategy, Sport ...) 
   
#### `/videogames.html`
Contains a dynamic table that :
1. shows data of video games (10 per page)
2. can be sorted by columns (by clicking on the header of the column)

#### `/script.js`
Contains all the functions necessary for `/videogames.html` and `/chart.html`

#### `/videoGamesStatic.jsp`
Contains a static table that :
1. shows data of video games (10 per page)