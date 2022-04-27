public class Classes {
    
    public void cyborgInfo(){

        // Cyborg
        System.out.println();
        Printer.printColor("Cyborg:", "blue");

        // character description
        Printer.printItalizcizedColor(
                        "The Cyborg is a well rounded assault unit with strong offensive and defensive abilities. "
                                        + "\nCyborgs are highly skilled in hand to hand combat and with laser rifles. \n",
                        "white");

        Printer.printColor("HP: 200" + '\n' + "MP: 100" + '\n' + "SPD: 1.00" + '\n' + "ATK: 5" + '\n'
                        + "DEF: 5", "blue");  

    }

    public void hackerInfo() {

         // Hacker
         System.out.println();
         Printer.printColor("Hacker: ", "green");

         // character description
         Printer.printItalizcizedColor("Unparalleled in their mastery and knowledge of all technology related," +
                         "\nthe Hacker is a tank unit who wields control over an arsenal of automated technological weaponry. \n",
                         "white");
         Printer.printColor("HP: 300" + '\n' + "MP: 80" + '\n' + "SPD: 0.75" + '\n' + "ATK: 3" + '\n'
                         + "DEF: 7", "green");

    }

    public void terminatorInfo() {
        System.out.println();
        Printer.printColor("Terminator: ", "red");

        // character description
        Printer.printItalizcizedColor(
                        "The Terminator is an unpredictable aggressive beast who specializes in close-range combat."
                                        + "\nBlinded by fury, these individuals wreak havoc on anything that may get on their nerves.\n",
                        "white");
        Printer.printColor("HP: 250" + '\n' + "MP: 50" + '\n' + "SPD: 1.00" + '\n' + "ATK: 6"
                        + '\n' + "DEF: 3", "red");
    }

    public void lazerSwordsmanInfo() {
        // Lazer Swordsman
        System.out.println();
        Printer.printColor("Lazer Swordsman: ", "cyan");

        // character description
        Printer.printItalizcizedColor("The Lazer Swordsman is a composed, well-balanced and versatile individual."
                        + "\nJack of all trades yet master of none. \n", "white");
        Printer.printColor(
                        "HP: 200" + '\n' + "MP: 100" + '\n' + "SPD: 1.25" + '\n' + "ATK: 5"
                                        + '\n' + "DEF: 6",
                        "cyan");
    }

    public void rogueInfo(){
        System.out.println();
        Printer.printColor("Rogue: ", "yellow");

        // character description
        Printer.printItalizcizedColor(
                        "The Rogue is sneaky, speedy thief. They make up for their fragility with their evasion and high damage output."
                                        + "\nA glass cannon of sorts. \n",
                        "white");
        Printer.printColor(
                        "HP: 150" + '\n' + "MP: 100" + '\n' + "SPD: 1.50" + '\n' + "ATK: 7"
                                        + '\n' + "DEF: 2",
                        "yellow");
    }

    public void mysticInfo() {
        System.out.println();
                Printer.printColor("Mystic ", "purple");

                // character description
                Printer.printItalizcizedColor(
                                "The Mystic is a mysterious individual; while their origins, and their tools-of-the-trade are unknown,"
                                                +
                                                "\nthey offer a service irrefutable for the rebels. Blessed by the Gods, the mystic specializes in magic of many elements. \n",
                                "white");
                Printer.printColor(
                    "HP: 200" + '\n' + "MP: 100" + '\n' + "SPD: 1.25" + '\n' + "ATK: 7"
                                    + '\n' + "DEF: 3",
                    "purple");
    }

    public void reverendInfo() {
        System.out.println();
        Printer.printColor("Reverend", "white");

        // character description 
        Printer.printItalizcizedColor("Often associated to dieties, the Reverend is a patient, devoted individual. \nFavoured by the Holy Order, the Reverend uses his abilities to strengthen the weakened, and cure the infected. ","yellow"); 
        Printer.printColor(
            "HP: 100" + '\n' + "MP: 200" + '\n' + "SPD: 1.25" + '\n' + "ATK: 3"
                            + '\n' + "DEF: 3",
            "white");
    }

}
