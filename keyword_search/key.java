import java.util.Scanner;

public class key {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // conversation histo from member 1

        String[] userMessages = { "Hello!", "Tell me a joke", "What's the weather?" };
        String[] botResponses = { "Hi there!", "Why don’t skeletons fight? They don’t have the guts!",
                "It’s sunny today." };

        String[] stopWords = { "is", "my", "name", "can", "you", "me", "a", "the", "what", "it", "i" };


        // get search keyword from user
        System.out.print("Enter a keyword to search: ");
        String inpt = scan.nextLine().toLowerCase();

        String[] keywords = inpt.split(" "); // Split by space to get words

        // perform keyword search

        boolean found = false;

        for (int i = 0; i < userMessages.length; i++) {
            boolean matched = false;
            for (String keyword : keywords) {
                if(isStopWord(keyword, stopWords)){
                    continue;
                }
                
                if (userMessages[i].toLowerCase().contains(keyword)
                        || botResponses[i].toLowerCase().contains(keyword)) {
                    matched = true;
                    found = true;
                    break;
                }
            }
            if (matched) {
                System.out.println("Bot: " + botResponses[i]);
            }

        }
        System.out.println("--------------");


        // if no matches found
        if (!found) {
            System.out.println("no matching data");
        }

scan.close();
    }
    private static boolean isStopWord(String word, String[] stopWords) {
        for (String stopWord : stopWords) {
            if (word.equals(stopWord)) {
                return true;
            }
        }
        return false;
    }

}