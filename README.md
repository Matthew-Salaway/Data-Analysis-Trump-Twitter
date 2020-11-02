# Data Analysis On Trump's Twitter
# Purpose
If Trump remains president, what projections can be made about his Twitter statistics? How many tweets per day must Trump make if his twitter habits continue form Jan. 2020 to Nov. 2020? Regardless of policy, the evidence shows Trump spends a lot of time tweeting. I will try to find how many tweets he may tweet in the future and how many tweets that will come out to be per day.
# The Data
I will use one data set to answer my question. It can be found on Kaggle. I found this data set through the search engine under datasets, searched Trump Twitter, and filtered the results to the hottest. The dataset I chose is called “Trump Tweets Tweets from @realdonaldtrump scraped January 20th, 2020”. The data set consists of the date, tweet, favorites, and retweets. https://www.kaggle.com/austinreese/trump-tweets/version/1
# The Plan
First I wanted to play around with the data. I used Apache Poi to scrape the data off the excel spreadsheet. I used a for-loop to store the selected boxes using cells and rows, into an array starting the zero index on August 1, 2016, and last index (1247) on December 29, 2019.  I made several arrays. One to store the date, one to store the total number of retweets per day, one to store the total number of tweets per day, and one to store all of the tweets of that day into a string. From there I was able to calculate: The most retweets in a single day, most retweets per tweet in a single day. I had a for loop find the index of the day. I could then print the other arrays at that index and it would give me that day’s statistics. I also found: Sum of retweets and sum of tweets from August 1, 2016, to December 29, 2019, and the average retweet per tweet during that timeline. I then made new arrays that would store the data by month instead of by day. I made an array for the month/year, total retweets that month, total tweets that month, and average retweet per tweet that month. With this data, I entered the retweet per tweet in each month into logger pro and found the linear best fit line. I then calculated the projected number of retweets per tweet in November 2024, the percent increase in retweets per a tweet from when Trump first elected and 2024 election, number of tweets projected in the month of November 2024, the percent increase in the number of tweets tweeted by Trump from Nov 2016 to Nov 2024, project number of tweets from Jan 2020 to Nov 2024, and the average number of tweets per day needed to meet this projection. 
# The Structure
The class I made consisted of one main method that ran all of my code. I found this to be the most simple layout. I commented on all of my work to make sure I didn’t get lost in all of my different arrays, for-loops, and variables. My instance variables were named for convenience and for my personal thought. The simple counter variables I named short 1-2 letters. The other instance variables I used names that directly correlated with the array. The instance variables stored and added the data together before being stored into the array. I then traversed through the spreadsheet, storing the data I wanted such as tweets, retweets, and dates into the arrays I created.
# The Results (Projections based on data analysis)
Projected number of retweets per tweet in November 2024 is  30567.600000000002

Percent increase in Retweets per tweet from when Trump first elected and 2024 election is  159.88796094612417

Number of tweets projected in the month of November 2024 is  745.529

Percent increase in number of tweets tweeted by Trump from Nov 2016 to Nov 2024 is  409.63131868131865

Project number of tweets from Jan 2020 to Nov 2024 is  32853.200999999994

On average  15.416800093852649 tweets are needed per day to maintain this projection.
