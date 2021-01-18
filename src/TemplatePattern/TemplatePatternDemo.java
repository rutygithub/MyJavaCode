package TemplatePattern;

//https://www.tutorialspoint.com/design_pattern/template_pattern.htm
public class TemplatePatternDemo {
    public static void main(String[] args) {

        Game game = new Cricket();
        game.play();
        System.out.println();
        game = new Football();
        game.play();
    }
}
