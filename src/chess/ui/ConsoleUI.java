package chess.ui;

public final class ConsoleUI {
    public static void border(int width){
        String border = "=".repeat(width);
        System.out.println(border);
    }

    public static void inner(int width){
        String inner = "-".repeat(width - 2);
        System.out.printf("|%s|%n", inner);
    }

    public static void titleCase(String text, int width){
        if(width < text.length()){
            System.out.println();
            return;
        }
        System.out.println("|" + center(text.toUpperCase(), width-2) + "|");
    }

    public static void subtitleCase(String text, int width){
        if(width < text.length()){
            System.out.println();
            return;
        }
        String space = " ".repeat(width - text.length() - 3);
        System.out.printf("| %s%s|%n", text, space);
    }

    public static void optionsCase(String[] options, int width){
        for(int i = 0; i < options.length; i++){
            String option = String.format("| %d. %s", i+1, options[i]);
            String space = " ".repeat(width - option.length() - 1);
            System.out.printf("%s%s|%n", option, space);
        }
    }

    public static void p(String text, int width){

    }

    public static void listCase(String[] list, int width){
        for(String l : list){
            String objList = String.format("| - %s", l);
            String space = " ".repeat(width - objList.length() - 1);
            System.out.printf("%s%s|%n", objList, space);
        }
    }

    public static void lnCase(int width){
        String space = " ".repeat(width - 2);
        System.out.printf("|%s|", space);
    }

    public static String center(String text, int width){
        int cantSpace = (width - text.length())/2;
        return " ".repeat(cantSpace) + text + " ".repeat((text.length()%2==1)?cantSpace:cantSpace+1);
    }
}
