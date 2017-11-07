# PROJECT Design Documentation
## Executive Summary
The WebCheckers is a web based game, which must allow players to play checkers with other signed-in players. The game user interface (UI) will support drag-and-drop browser capabilities for making moves according to the American rules.
### Purpose
> The purpose of this Design Document is to describe the WebCheckers system and its implementation by showcasing the high level description of the architecture and its components. 
> The WebCheckers is a web application designed to allow players to log in to the system and play Checkers game as per the American rules.
## Requirements

This section describes the features of the application.

> In this section you do not need to be exhaustive and list every story.  Focus on top-level features from the Vision document and maybe Epics and critical Stories.

### Definition of MVP
> Provide a simple description of the Minimum Viable Product.

### MVP Features
The minimal viable product includes these features:
> Every player must sign-in before playing a game.


### Roadmap of Enhancements
The minimal viable product includes these features:
> Provide a list of top-level features in order you plan to consider them.
> Two players must be able to play a game of checkers based upon the American rules.
> Either player of a game may choose to resign, which ends the game.
We have covered the following MVP in our Sprint 1:
> Every player is able to sign-in with a unique name before playing a game
> The player who is logged in, is able to see the players who are online and available to play. 
> Once the player selects an opponent, he/she can start a game which shows the initial layout of the game. 


## Application Domain

This section describes the application domain.

### Overview of Major Domain Areas
> Provide a high-level overview of the

### Details of each Domain Area
> If necessary, high-light certain areas of the Domain model that have a focused purpose.  Create textual narrative that describes the purpose and how that relates to the associated domain model.

## MVP Features
These are the features that we have implemented and tested in our Sprint 1

### Feature 1(Sign-In) :
> A player navigates to the Signin page from the Home page.
> The system rejects any sign-in using an existing name.
> A player can sign-out, which ends that player's session and frees up the name.
> The system does not persist player information. Furthermore, a given player name is first-come-first-serve. 

### Feature 2 (Game Start) :
> The player picks an opponent from a list of all players signed-in that are not currently playing a game.
> This selection launches the Game view that includes a complete board with rows, spaces and pieces with initial layout.
> Sends the player back to the Home page if the requested opponent is already engaged in a game.

### Feature 3 (Disk Assignment) :
> In the Game view, the player making the request for opponent, is assigned the red colored disks, while his opponent is assigned the white colored disks.
> The player assigned the red colored disks makes the first move.
> The player assigned the white colored disks will make the second move.
> The players play the game in alternate turns.

### Feature 4 (Game Movement) :
> The players can only move in forward diagonal directions.
> A player can make a move. If the move is valid, the movement is saved and a message is displayed stating “Its a valid move”. The player needs to click on Submit Turn.
> If the move is invalid, the piece goes back to its original position, and an error message is displayed stating “Invalid Move”.
> A player can undo his/her move by clicking on the Backup one Move button which will take the piece back to the previous position.

### Feature 5 (Game Waiting) :
> A player can only play when it is his/her turn. He/she needs to await his/her turn.

### Feature 6 (Disk Capture) :
> A player needs to jump over opponent’s piece to be able to capture it.
> If a player gets the chance to capture an opponent’s piece, he/she has to make the capture.
> The backup move will not work and will give an error when you are capturing a move. 

## Roadmap of Enhancements
These are the enhancement that we have planned to achieve. These will be done as we complete our MVP. 
> Games can be stored for later review.
> Other players may view an on-going game that they are not playing.

## Application Domain
// Diagram

For the Webchecker game, players need to sign-in with their account in order to play and each player can compete against another player. The game is played by moving the disks using the game rules(American checkers rules), where there is an 8X8 board consisting of 64 squares of alternating black and white colors. Each player is assigned 12 disks of either red or black color and these disks are placed on the squares and the game can be started.

## Architecture
In Sprint 1, we have used the following technologies:

> Spark Framework
> FreeMarker Template
> Maven Template
> Java 8
> Json

Our Architecture contains the following components.
> Client UI, which contains the css, javascript and generated HTML. 
> Server UI, which contains the FTL files, and the UI Java classes which acts as a controller for the GET and POST methods, it also sends the data to the ftl files. 
> Application, where our game logic and login logic is going to exists. 
> Model, which will contain the data for the board, rows, spaces and pieces and the player’s information. 


### Summary
> Provide a brief summary of the architecture.  Also provide one or two models (diagrams) that describe the architecture.  Hint: review the Architecture lecture slides for ideas.

### Overview of User Interface
> Provide a summary of the application's user interface.
> This includes the UI state model.

### Tier X
> Provide a summary of each tier of your architecture.  Thus replicate this heading for each tier.
> In each section describe the types of components in the tier and describe their responsibilities.


## Sub-system X
> Provide a section for each major sub-system within the tiers of the architecture.  Replace 'X' with the name of the sub-system.
> A sub-system would exist within one of the application tiers and is a group of components cooperating on a significant purpose within the application.  For example, in WebCheckers all of the UI Controller components for the Game view would be its own sub-system.

This section describes the detail design of sub-system X.

### Purpose of the sub-system
> Provide a summary of the purpose of this sub-system.

### Static models
> Provide one or more static models (UML class or object diagrams) with some details such as critical attributes and methods.  If the sub-system is large (over 10 classes) then consider decomposing into multiple, smaller, more focused diagrams.

### Dynamic models
> Provide any dynamic model, such as state and sequence diagrams, as is relevant to a particularly significant user story.
> For example, in WebCheckers you might create a sequence diagram of the `POST /validateMove` HTTP request processing or you might use a state diagram if the Game component uses a state machine to manage the game.
