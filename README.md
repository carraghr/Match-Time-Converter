# Paddy Power Coding Assessment
## Match Time Converter

### How to build project
To build the project run the following command in the location

/paddy-power-assessment> gradle clean build

### How to run
To run the project run the following command:

/paddy-power-assessment> java -jar "./build/libs/PaddyPower-v1.jar" "[PM] 0:00.000"

### Problems
The program runs as expected for all the cases provided in the assessment sheet apart from the line

"[FT] 90:00.000" --> "90:00 +00:00 – FULL_TIME"

This line shows full time with additional minutes and seconds. However bases on the following lines 

"[HT] 45:00.000" "45:00 – HALF_TIME" 

"[H1] 45:00.001" "45:00 +00:00 – FIRST_HALF" 

I assumed that for the additional minutes and seconds to be displayed you would need at least one millisecond over its bounded time. As in the case of the second line above.

I would normally get conformation on something like this however I was working on this Friday night when I spotted it and I'm unable to work on it Monday when the deadline for submission is.
All the test cases on the assessment spec are included in the FormatterTest.java file. Only the situation of the line talked about here is different.

There was also one other thing which was the case of input in the format of [FT] 0:00:000 which would return 00:00 FULL_TIME. I also assumed this was valid as no information was given on bounded time that had to be meet for under time just overtime.
The reason for this logic was that a game could be called off before it started or during the match so a record of FT not been at 90 minutes could happen.
I don't know if this is how it would be recorded as I know nothing about matches/sports.
