package info.cukes.feature.ast;

import org.netbeans.api.languages.ASTNode;

public class Helper {

    private static String featureDefinition = "FeatureDefinition";
    private static String featureIdentifier = "FeatureIdentifier";
    private static String featureDescription = "FeatureDescription";
    private static String backgroundIdentifier = "BackgroundIdentifier";
    private static String description = "Description";
    private static String basicScenario = "BasicScenario";
    private static String tableScenario = "TableScenario";
    private static String basicScenarioIdentifier = "BasicScenarioIdentifier";
    private static String tableScenarioIdentifier = "TableScenarioIdentifier";
    private static String scenarioDescription = "ScenarioDescription";
    private static String examplesIdentifier = "ExamplesIdentifier";

// FEATURE ---------------------------------------------------------------------
    public static ASTNode getFeatureNode(ASTNode parent) {
        if (parent != null) {
            return parent.getNode(featureDefinition);
        } else {
            return null;
        }
    }

    public static ASTNode getFeatureIdentifierNode(ASTNode parent) {
        if (parent != null) {
            return parent.getNode(featureIdentifier);
        } else {
            return null;
        }
    }

    public static ASTNode getFeatureDescriptionNode(ASTNode parent) {
        if (parent != null) {
            return parent.getNode(featureDescription);
        } else {
            return null;
        }
    }
// BACKGROUND ------------------------------------------------------------------

    public static ASTNode getBackgroundIdentifierNode(ASTNode parent) {
        if (parent != null) {
            return parent.getNode(backgroundIdentifier);
        } else {
            return null;
        }
    }

    public static ASTNode getDescriptionNode(ASTNode parent) {
        if (parent != null) {
            return parent.getNode(description);
        } else {
            return null;
        }
    }
// SCENARIO --------------------------------------------------------------------

    public static ASTNode getScenarioNode(ASTNode parent) {
        if (parent != null) {
            ASTNode node1 = parent.getNode(basicScenario);
            return node1 != null ? node1 : parent.getNode(tableScenario);
        } else {
            return null;
        }
    }

    public static ASTNode getScenarioDescriptionNode(ASTNode parent) {
        if (parent != null) {
            return parent.getNode(scenarioDescription);
        } else {
            return null;
        }
    }

    public static ASTNode getScenarioIdentifierNode(ASTNode parent) {
        if (parent != null) {
            ASTNode node1 = parent.getNode(basicScenarioIdentifier);
            return node1 != null ? node1 : parent.getNode(tableScenarioIdentifier);
        } else {
            return null;
        }
    }

// EXAMPLES --------------------------------------------------------------------
    public static ASTNode getExamplesIdentifierNode(ASTNode parent) {
        if (parent != null) {
            return parent.getNode(examplesIdentifier);
        } else {
            return null;
        }
    }
// RESULT STRING ---------------------------------------------------------------

    public static String getResultString(ASTNode head, ASTNode body, String error_case) {
        if (head != null) {
            if (body != null) {
                return head.getAsText().trim() + ": " + body.getAsText().trim();
            } else {
                return head.getAsText().trim();
            }
        } else {
            return error_case;
        }
    }
}
