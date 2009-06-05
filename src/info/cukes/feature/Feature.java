package info.cukes.feature;

import org.netbeans.api.languages.SyntaxContext;

public class Feature {

    public static String scenarioName(SyntaxContext context) {
        return "Scenario";
    }

    public static String featureName(SyntaxContext context) {
        return "Feature";
    }
    
    public static String backgroundName(SyntaxContext context) {
        return "Background";
    }

    public static String backgroundIcon(SyntaxContext context) {
        return "info/cukes/feature/resources/background.png";
    }

    public static String scenarioIcon(SyntaxContext context) {
        return "info/cukes/feature/resources/scenario.png";
    }

    public static String featureIcon(SyntaxContext context) {
        return "/info/cukes/feature/resources/cucumber.png";
    }

    public static String examplesIcon(SyntaxContext context) {
        return "/info/cukes/feature/resources/limwire.png";
    }
}
