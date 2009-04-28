package info.cukes.feature;

import org.netbeans.api.languages.ASTNode;
import org.netbeans.api.languages.ASTPath;
import org.netbeans.api.languages.SyntaxContext;

public class Feature {

    public static String scenarioName(SyntaxContext context) {
        ASTPath path = context.getASTPath();
        ASTNode node = (ASTNode) path.getLeaf();
        node = node.getNode("Scenario->ScenarioDefinition->ScenarioDescription->Text->Words");
        if (node != null) {
            return "Does not work.";
        }
        return "Scenario";
    }

    public static String featureName(SyntaxContext context) {
        ASTPath path = context.getASTPath();
        ASTNode node = (ASTNode) path.getLeaf();
        node = node.getNode("Feature->FeatureDefinition->FeatureDescription->Text->Words");
        if (node != null) {
            return "Does not work.";
        }
        return "Feature";
    }

    public static String scenarioIcon(SyntaxContext context) {
        ASTPath path = context.getASTPath();
        ASTNode node = (ASTNode) path.getLeaf();
        node = node.getNode("Scenario");
        if (node != null) {
            return "/org/netbeans/modules/languages/resources/variable.gif";
        }

        return "/org/netbeans/modules/languages/resources/method.gif";
    }

    public static String featureIcon(SyntaxContext context) {
        ASTPath path = context.getASTPath();
        ASTNode node = (ASTNode) path.getLeaf();
        node = node.getNode("Feature");
        if (node != null) {
            return "/org/netbeans/modules/languages/resources/variable.gif";
        }

        return "/org/netbeans/modules/languages/resources/method.gif";
    }
}
