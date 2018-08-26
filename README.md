
Assuming you are in the directory containing this README:

# very important to read required format (given below) for input instructions before trying this application. However a sample input file is provided within app, which you can use as it is initially, and then can modify it for testing application.

-----------------------------------------------------------------------

# Provide on command line interface for running

First argument as input file (String).
Second argument as outfile (String).
Third argument as debuglevel (integer).

ALL arguments are validated against MissingArgumentException, FileNotFoundException, NumberFormatException

-----------------------------------------------------------------------

## In input.txt provide traffic instructions in restricted format only.

input.txt is provided beside README.md and the format currently used
in specifying signals and directions should be used as it is. Using the instructions one can add cars to specific directions or remove cars by specifiyng direction and green as color.

There are only 2 types of instructions and that also following format compulsory

1. if you want to add 5 cars to North direction ==> ADD NORTH 5
    i.e. ADD {direction} {number of cars to add in this direction}

    on the basis of direction mentioned the state is changed carrying the previous signal set. (color persists)

2. if you want to change NORTH signal to green ==> NORTH GREEN
    i.e. {direction} {color of light/signal}

    this instruction specifies direction as well color so both matters for state transition. previous color set is replaced by new color. Again if new color is Green then only cars are removed


-----------------------------------------------------------------------

## Follow following debug level

Level 2: debugLevel ==> DebugLevel.CONSTRUCTOR;
Level 3: debugLevel ==> DebugLevel.GreenEast;
Level 4: debugLevel ==> DebugLevel.GreenWest;
Level 5: debugLevel ==> DebugLevel.GreenSouth;
Level 6: debugLevel ==> DebugLevel.GreenNorth;
Level 7: debugLevel ==> DebugLevel.RedEast;
Level 8: debugLevel ==> DebugLevel.RedWest;
Level 9: debugLevel ==> DebugLevel.RedNorth;
Level 10: debugLevel ==> DebugLevel.RedSouth;
Level 11: debugLevel ==> DebugLevel.StretLightsContext;
Level 11: debugLevel ==> NONE

-----------------------------------------------------------------------

## Assuming you are at level below in project directory provided to you
cd Desktop/fourWayStreetLights/

## To clean:
ant -buildfile src/build.xml clean

-----------------------------------------------------------------------
## To compile:
ant -buildfile src/build.xml all

-----------------------------------------------------------------------
## To run by specifying arguments from command line
## We will use this to run this application
ant -buildfile src/build.xml run -Darg0=FIRST -Darg1=SECOND -Darg2=THIRD

First argument as input file.
Second argument as outfile.
Third argument as debuglevel.

-----------------------------------------------------------------------

## To create tarball for submission
ant -buildfile src/build.xml tarzip or tar -zcvf firstName_secondName_assign_number.tar.gz firstName_secondName_assign_number
