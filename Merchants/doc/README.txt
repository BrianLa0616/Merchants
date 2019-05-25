--------------------Merchants--------------------


-----General Information-----
Merchants is an all-new strategy game written by famed developers Eylam Tagor, Ansen Tsan, and Brian La in May 2019.


-----Program Description-----
Merchants is a unique strategy game that involves conquering land using proper management of capital and merchants to expand one’s territory, eventually peacefully invading another territory. Acquiring land will be primarily achieved through auctioning land, although favors, trade deals and forbearances can be verbally instituted between players.


While inspecting modern strategy games, we were introduced to the problem that most of these games share: they were nearly all the same in terms of both rules and strategy, which was to “conquer land by terrorizing the opponent’s people given a constant amount of capital each turn”. To counter this norm, we created Merchants to introduce a new and completely unique mechanic of truly managing capital in addition to merchants, instead of having a set amount of capital given to each player each turn like most other games. With this mechanic, this game is able to deliver an entirely new element to a player’s gameplan, including negotiating with others while developing a multitude of ways to increase capital and therefore gain territory in a nonviolent manner. With this new complexity built in to a strategy game, players do not have to face the continuous norm of violent conquering.


The rules to play Merchants are: utilize capital and merchants to gain more territory than the opposing player(s). The options to gain capital are to receive capital based on capital-specialized merchants, request landmass-based bonuses each turn, negotiate with other players, and generally progress in the game. The ways to gain territory are to purchase it, trade it, utilize land-specialized merchants, or generally progress in the game. The ultimate goal of each game is to conquer the most territory at the end of the match.


Our target audience for Merchants are anyone who enjoys either managing anything or competing against peers, as this game delivers both management and competition to a full extent.


The primary features of our program include the turn-based goal to purchase territory and expand across the world, and doing this by trading, increasing capital, and exploring with merchants.


-----Instructions-----
Merchants: How to Play


Goal:
Defeat all other players by acquiring their Home Tile.


Start:
Each player starts with a Home Tile, a Merchant, and $100.


Basic Mechanics:
Merchants can move around the map and acquire Tiles which provide income. Income increases the player's balance, which is used to buy Merchants and Checkpoints, upgrade Merchants, and enter Tile auctions.


Acquiring Tiles:
Tiles are acquired by entering auctions. To enter an auction, select a Merchant and right-click on an adjacent (diagonals included) Tile to that Merchant. That will enter the player in an auction for that Tile. At the end of each turn round, all auctions are taken care of in Auction Rooms. In an Auction Room, all the players participating in an auction for a specific Tile may enter bids or withdraw. Based on the bids, the winner is automatically decided and the Tile in question becomes a part of the winner's territory.


Merchants:
Merchants are the key to winning the game, as they are used to expand the player's territory and potentially block opponents' movement. Here are the different types of Specialized Merchants:
AuctionMerchant: gives its player a bonus in an auction this Merchant is participating in.
MoneyMerchant: Increases income for Tiles acquired.
SpeedMerchant: Can move more Tiles per turn than other Merchants.
RadarMerchant: Can uncover a higher radius of Tiles when moving.
InvisibleMerchant: Is unseen to other players, until deep enough in enemy territory.
Merchants can be further upgraded to increase the effects of their specialized ability.


Checkpoints:
Each player has the ability to convert each of their Tiles into Checkpoints for a price. Checkpoints serve as teleportation points for Merchants, meaning Merchants can move to Checkpoints from anywhere on the map! Keep in mind that after moving to a Checkpoint, Merchants cannot move anymore for the rest of that turn. When a Checkpoint becomes owned by another player, it then become a Checkpoint for that player.




-----Features-----
1. Must have
   1. Map with land. DONE (Board)
   2. Multiple players in a single game. DONE
   3. Different players' characters with benefits that can travel around one’s territory. DONE (Merchants of different players can interact, block and auction)
   4. Interactions between players to obtain a certain piece of land. DONE (Auctions)
   5. Ability to click on land to find characteristics. DONE (Coordinates, cost, etc.)
1. Want to have
   1. Randomized map with randomized placements. NOT DONE
   2. Different graphics for different land. DONE (Checkpoints are flagged)
   3. Different types of land that provide extra benefits. DONE (Checkpoints and Home Tile)
   4. Ability to trade land. NOT DONE
   5. Menu screen with instructions and ability to change settings. DONE
   6. Obstacles within board NOT DONE
   7. Penalty for crossing other player’s land DONE (InvisibleMerchant loses invisibility, etc.)
1. Stretch feature
   1. Ability to play over different devices. NOT DONE
   2. Character animations when traveling through land. NOT DONE
   3. Graphics for announcements and achievements. NOT DONE
   4. Sound effects for each interaction. NOT DONE
   5. Have “sets” like Monopoly. NOT DONE


-----Class List-----
* Board represents the board that the characters move on.
* Merchant represents a merchant with different abilities.
* Tile represent a piece of a grid on the board.
* Player represents the different players on the board.
* Main represents the class that runs the program.
* Checkpoint represents a travelling spot for merchants on the board.
* MoneyMerchant represents money-specialized merchant.
* AuctionMerchant represents auction-specializing merchant.
* SpeedMerchant represents movement-specializing merchant.
* InvisibleMerchant represents a merchant that cannot be seen by other players
* RadarMerchant represents a merchant with a longer radius of view, uncovering more  tiles
* Button represents the generic button for pressing
* TextButton represents a button with text in it
* ImageButton represents a button with an image as the clickable button instead of text
* Auction represents an auction for a tile, with all participants and bids, etc.
* Bid represents a bid by a player with a certain amount
* Screen the generic screen that is to be displayed in the program at some point
* AuctionScreen represents the screen in which all auctions are run
* InstructionsScreen represents the screen on which the instructions for how to play are displayed
* IntroScreen represents the start menu including buttons for entering the game or instructions, and the game’s title
* TransScreen represents the transition screen between turns
* ScreenHandler represents the main PApplet that decides which screen to draw


-----Credit List-----
* Eylam
   * Screen
   * AuctionScreen (part)
   * Board (part)
   * Player (most)
   * TransScreen
   * InstructionsScreen
   * ScreenHandler
   * Auction (most)
   * Bid
   * Button
   * TextButton
   * ImageButton
   * Role: general structure of whole program, big picture, making sure code makes sense, etc.
* Brian
   * Board (most)
   * Tile
   * Checkpoint
   * Role: little picture/functionality, making sure code works
* Ansen
   * Merchant
   * AuctionMerchant
   * MoneyMerchant
   * SpeedMerchant
   * RadarMerchant
   * InvisibleMerchant
   * Role: making merchants upgradeable into different types (listed above), and after that being able to level up.
* * Of course, all of us had at least a small part in  every class, so we decided to leave those out of the class list above for the sake of simplification, and show the big parts like this: “(part)” indicates a significant part of that class (up to 50%), and “(most)” indicates most of the class (over 50%).
* Outside resources
   * Google for flag icons (as in Google’s Android icons, free for use). Used for marking Checkpoints.
   * Mr. Shelby for the Screen idea, originally suggested for CGS. Used for the structure of the whole program.
                
-----Notes-----
* Auctions for surrounding lands
* All characters have a limited amount of steps per turn
* Starts off with a village, with everyone else being a normal person
* Checkpoints: can build towns so that merchants can teleport there
* Can upgrade people to provide benefits (ex. Upgraded person’s effect will reduce prices of lands)
* Having certain lands will form a “set” and provide extra benefits (ex. money/troops)
* Start with set amount of money
* Can earn money: each turn gets miniscule amount of money, quests will be main way to get money
* Tribes: each person can choose different tribes, each tribe starts off with something different
* Set amount of turns: blitz or long end game
* Each person has radius of what can see: can’t see whole map at start
* To win: whoever is in the best position by the end of set amount of turns
* Penalty for crossing other player’s land
* Extra tax feature?