import StoryInformation.*;
import Tools.Printer;

public class Main {
        public static void main(String[] args) {
           
        MainStory story = new MainStory();
        story.startStory();

        Printer.printItalizcizedColor("\nThank you for playing the beta version of Insurgence!", "yellow");

    }
}
