import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.Container;
/**
 * The main class of the game. It sets the game up, and then
 * enters a loop to read and execute commands. 
 * 
 * @author Anthony Barker 
 * @version 11.20.2020
 */

public class Game
{
    private Parser parser;
    private Player player;
    JFrame window;
    Container con;
    JPanel titleNamePanel, startButtonPanel;
    JLabel titleNameLabel;
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 30);
    JButton startButton;
    
    ImageIcon titleImage;
    JPanel titleImagePanel;
    JLabel titleImageLabel;
    /**
     * Constructor for objects of class Game
     */
    public Game()
    {
        createRooms();     
        parser = new Parser();        
        createCommands();
        window = new JFrame();
        window.setSize(1280, 720);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);
        window.setVisible(true);
        con = window.getContentPane();
        
        //titleImage = new ImageIcon(getClass().getClassLoader().getResource("garrylivingroom"));
        
        titleImagePanel = new JPanel();
        titleImagePanel.setBounds(0, 0, 800, 600);
        
        titleImageLabel = new JLabel();
        titleImageLabel.setIcon(titleImage);
        titleImagePanel.add(titleImageLabel);
        
        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(450, 100, 600, 150);
        titleNamePanel.setBackground(Color.black);
        titleNameLabel = new JLabel("Project Visage");
        titleNameLabel.setForeground(Color.white);
        titleNameLabel.setFont(titleFont);
        
        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(650, 400, 200, 100);
        startButtonPanel.setBackground(Color.black);
        
        startButton = new JButton("START");
        startButton.setBackground(Color.black);
        startButton.setForeground(Color.white);
        startButton.setFont(normalFont);
        
        titleNamePanel.add(titleNameLabel);
        startButtonPanel.add(startButton);
        
        con.add(titleNamePanel);
        con.add(startButtonPanel);
        con.add(titleImagePanel);
    }

    /**
     * main class method to play the game livingRoom BlueJ
     */
    public static void main(String[] args)
    {
        Game game = new Game();
        game.play();
    }
    
    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms()
    {
        TransporterRoom transporter;
        RoomRandomizer roomRandomizer;
        Room livingRoom, parentsBedroom, kitchen, diningRoom, basement, basementCorridor, basementBrickWall, cellar;
        Item tome, beamer;
        
        // locked room keys
        Item basementKey = new Item("key", "A rusted key to the basement.", 1);
        Item sledgeHammer = new Item("sledgehammer", "can smash something with this", 10);
        
        // create the rooms
        livingRoom = new Room("in the living room of the home. \n" +
                           "To the north, you see the kitchen. \n" +
                           "To the east, you see the parents bedroom.");
        
        parentsBedroom = new Room("in the parents bedroom");
        
        kitchen = new Room("in a dirty kitchen. It's full of dirty dishes, unknown bloody meats, and rotten fruits.");
        
        basement = new LockedRoom("in a dusty, damp and putrid smelling basement.", basementKey);
        
        basementCorridor = new Room("further in the basement. You notice a weak looking brick wall ahead of you.");
        
        basementBrickWall = new LockedRoom(" in an unknown room. What is this room...", sledgeHammer);
        
        diningRoom = new Room("in a nice dining room. The rug underneath the table looks like it's been tampered with.");
         
        cellar = new Room("in a hidden cellar");
        
        // initialise room exits and its items
        livingRoom.setExit("east", parentsBedroom);
        livingRoom.setExit("north", kitchen);
        
        parentsBedroom.setExit("west", livingRoom);
        parentsBedroom.addItem(basementKey);
        
        kitchen.setExit("south", livingRoom);
        kitchen.setExit("east", basement);
        kitchen.setExit("west", diningRoom);
                
        basement.setExit("west", kitchen);
        basement.setExit("south", basementCorridor);
        
        basementCorridor.setExit("north", basement);
        basementCorridor.setExit("south", basementBrickWall);
        
        basementBrickWall.setExit("north", basement);
        
        diningRoom.setExit("east", kitchen);
        diningRoom.setExit("down", cellar);
        
        cellar.setExit("up", diningRoom);
        cellar.addItem(sledgeHammer);
        
        
        // place items in the rooms
        tome = new Item("tome", "definitely not a language for humans.", 1);
        cellar.addItem(tome);
        
        
        // place characters in the rooms
        Character jimmy = new Character("???", "Bring me my tome.");
        jimmy.setToken(tome, "Theres another room in the basement.");
        parentsBedroom.addCharacter(jimmy);
        
       
        // add some rooms to the room randomizer. The RoomRandomizer is
        // used by any transporter room to beam the player to a random room.
        roomRandomizer = new RoomRandomizer();
        roomRandomizer.addRoom(livingRoom);
        roomRandomizer.addRoom(parentsBedroom);
        roomRandomizer.addRoom(kitchen);
        roomRandomizer.addRoom(diningRoom);
        roomRandomizer.addRoom(cellar);

        // create a transporter room
        transporter = new TransporterRoom("in a weird dimensional room", roomRandomizer);
        transporter.setExit("south", cellar);
        cellar.setExit("north", transporter);
        beamer = new Item("beamer", "this device mirrors a room for me to return to upon activation", 5);
        transporter.addItem(beamer);
        // start game livingRoom
        player = new Player("player", livingRoom);
    }
    
    /**
     * Create game commands.
     */
    private void createCommands()
    {
        CommandWords commands = parser.getCommands();
        commands.addCommand("quit", new QuitCommand());
        commands.addCommand("help", new HelpCommand(commands));        
        commands.addCommand("go", new GoCommand(player));
        commands.addCommand("items", new ItemsCommand(player));
        commands.addCommand("look", new LookCommand(player));
        commands.addCommand("take", new TakeCommand(player));
        commands.addCommand("drop", new DropCommand(player));
        commands.addCommand("back", new BackCommand(player));
        commands.addCommand("unlock", new UnlockCommand(player));
        commands.addCommand("give", new GiveCommand(player));
    }
    
    /**
     * Main game loop.
     */
    public void play()
    {
        printWelcome();
        
        boolean finished = false;
        while (!finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        
        System.out.println("Thank you for playing. Good bye.");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to Project Visage.");
        System.out.println("You wake up, sore, and in a daze. What's going on?");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
        Command command = new LookCommand(player);
        command.execute();
    }
    
    private void charge()
    {
        player.setChargedRoom();
    }
    
    private void activate()
    {
        player.activate();
    }
    
    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;
        
        if(command instanceof QuitCommand) {
            wantToQuit = true;
        }

        command.execute();        
        return wantToQuit;
    }
}
