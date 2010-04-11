package qubit.cucumber.editor;

import org.netbeans.api.languages.ASTNode;
import org.netbeans.api.languages.ASTPath;
import org.netbeans.api.languages.ASTToken;
import org.netbeans.api.languages.SyntaxContext;
import qubit.cucumber.editor.ast.Helper;

public class Feature {

    private static final String resourcesDirectory = "/qubit/cucumber/editor/resources";

    private static ASTNode getActualNode(SyntaxContext context) {
        ASTPath path = context.getASTPath();
        return (ASTNode) path.getLeaf();
    }

    public static String featureName(SyntaxContext context) {
        ASTNode node = getActualNode(context);
        ASTNode feature_node = Helper.getFeatureNode(node);
        ASTNode desc_node = Helper.getFeatureDescriptionNode(feature_node);
        ASTToken id_node = Helper.getFeatureToken(feature_node);
        return Helper.getResultString(id_node, desc_node, "Feature");
    }

    public static String featureIcon(SyntaxContext context) {
        return resourcesDirectory+"/icons/cucumber16.png";
    }

    public static String scenarioName(SyntaxContext context) {
        ASTNode node = getActualNode(context);
        ASTNode scenario_node = Helper.getScenarioNode(node);
        ASTNode desc_node = Helper.getScenarioDescriptionNode(scenario_node);
        ASTToken id_node = Helper.getScenarioToken(scenario_node);
        return Helper.getResultString(id_node, desc_node, "Scenario");
    }

    public static String scenarioIcon(SyntaxContext context) {
        return resourcesDirectory+"/icons/scenario16.png";
    }

    public static String backgroundName(SyntaxContext context) {
        ASTNode node = getActualNode(context);
        ASTNode desc_node = Helper.getDescriptionNode(node);
        ASTToken id_node = Helper.getBackgroundToken(node);
        return Helper.getResultString(id_node, desc_node, "Background");
    }

    public static String backgroundIcon(SyntaxContext context) {
        return resourcesDirectory+"/icons/background16.png";
    }

    public static String examplesName(SyntaxContext context) {
        ASTNode node = getActualNode(context);
        ASTNode desc_node = Helper.getDescriptionNode(node);
        ASTToken id_node = Helper.getExamplesToken(node);
        return Helper.getResultString(id_node, desc_node, "Examples");
    }

    public static String examplesIcon(SyntaxContext context) {
        return resourcesDirectory+"/icons/examples16.png";
    }

    public static String tableName(SyntaxContext context) {
        return "Table";
    }

    public static String tableIcon(SyntaxContext context) {
        return resourcesDirectory+"/icons/table16.png";
    }
}
