package info.cukes.feature;

import org.netbeans.api.languages.ASTNode;
import org.netbeans.api.languages.ASTPath;
import org.netbeans.api.languages.SyntaxContext;
import info.cukes.feature.ast.Helper;

public class Feature {

    private static ASTNode getActualNode(SyntaxContext context) {
        ASTPath path = context.getASTPath();
        return (ASTNode) path.getLeaf();
    }

    public static String featureName(SyntaxContext context) {
        ASTNode node = getActualNode(context);
        ASTNode feature_node = Helper.getFeatureNode(node);
        ASTNode desc_node = Helper.getFeatureDescriptionNode(feature_node);
        ASTNode id_node = Helper.getFeatureIdentifierNode(feature_node);
        return Helper.getResultString(id_node, desc_node, "Feature");
    }

    public static String featureIcon(SyntaxContext context) {
        return "/info/cukes/feature/resources/cucumber.png";
    }

    public static String scenarioName(SyntaxContext context) {
        ASTNode node = getActualNode(context);
        ASTNode scenario_node = Helper.getScenarioNode(node);
        ASTNode desc_node = Helper.getScenarioDescriptionNode(scenario_node);
        ASTNode id_node = Helper.getScenarioIdentifierNode(scenario_node);
        return Helper.getResultString(id_node, desc_node, "Scenario");
    }

    public static String scenarioIcon(SyntaxContext context) {
        return "info/cukes/feature/resources/scenario.png";
    }

    public static String backgroundName(SyntaxContext context) {
        ASTNode node = getActualNode(context);
        ASTNode id_node = Helper.getBackgroundIdentifierNode(node);
        ASTNode desc_node = Helper.getDescriptionNode(node);
        return Helper.getResultString(id_node, desc_node, "Background");
    }

    public static String backgroundIcon(SyntaxContext context) {
        return "info/cukes/feature/resources/background.png";
    }

    public static String examplesName(SyntaxContext context) {
        ASTNode node = getActualNode(context);
        ASTNode id_node = Helper.getExamplesIdentifierNode(node);
        ASTNode desc_node = Helper.getDescriptionNode(node);
        return Helper.getResultString(id_node, desc_node, "Examples");
    }

    public static String examplesIcon(SyntaxContext context) {
        return "/info/cukes/feature/resources/limwire.png";
    }

    public static String tableName(SyntaxContext context) {
        return "Table";
    }

    public static String tableIcon(SyntaxContext context) {
        return "/info/cukes/feature/resources/table.png";
    }
}
