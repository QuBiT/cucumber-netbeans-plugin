package info.cukes.feature;

import org.netbeans.api.languages.ASTNode;
import org.netbeans.api.languages.ASTPath;
import org.netbeans.api.languages.SyntaxContext;

public class Feature {

    private static ASTNode getActualNode(SyntaxContext context) {
        ASTPath path = context.getASTPath();
        return (ASTNode) path.getLeaf();
    }

    public static String featureName(SyntaxContext context) {
        ASTNode node = getActualNode(context);
        node = node.getNode("FeatureDefinition");
        if (node != null) {
            node = node.getNode("FeatureDescription");
            if (node != null) {
                return "Feature: " + node.getAsText().trim();
            }
        }
        return "Feature";
    }

    public static String scenarioName(SyntaxContext context) {
        ASTNode node = getActualNode(context);
        ASTNode snode = node.getNode("BasicScenario");
        if (snode != null) {
            node = snode.getNode("ScenarioDescription");
            if (node != null) {
                return "Scenario: " + node.getAsText().trim();
            }
        } else {
            snode = node.getNode("TableScenario");
            if (snode != null) {
                node = snode.getNode("ScenarioDescription");
                if (node != null) {
                    return "Scenario Outline: " + node.getAsText().trim();
                }
            }
        }
        return "Scenario";
    }

    public static String backgroundName(SyntaxContext context) {
        ASTNode node = getActualNode(context);
        node = node.getNode("Description");
        if (node != null) {
            return "Background: " + node.getAsText().trim();
        }
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
