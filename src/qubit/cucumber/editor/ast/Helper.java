package qubit.cucumber.editor.ast;

import org.netbeans.api.languages.ASTNode;
import org.netbeans.api.languages.ASTToken;

public class Helper {

    private static String languageIdentifier = "language";
    private static String featureDefinition = "FeatureDefinition";
    private static String featureIdentifier = "feature";
    private static String featureDescription = "FeatureDescription";
    private static String backgroundIdentifier = "background";
    private static String description = "Description";
    private static String basicScenarioIdentifier = "scenario";
    private static String tableScenarioIdentifier = "scenario_outline";
    private static String scenarioDescription = "ScenarioDescription";
    private static String examplesIdentifier = "examples";

// FEATURE ---------------------------------------------------------------------
    public static ASTToken getLanguageToken(ASTNode parent) {
        if (parent != null) {
            return parent.getTokenType(languageIdentifier);
        } else {
            return null;
        }
    }

    public static ASTNode getFeatureNode(ASTNode parent) {
        if (parent != null) {
            return parent.getNode(featureDefinition);
        } else {
            return null;
        }
    }

    public static ASTToken getFeatureToken(ASTNode parent) {
        if (parent != null) {
            return parent.getTokenType(featureIdentifier);
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

    public static ASTToken getBackgroundToken(ASTNode parent) {
        if (parent != null) {
            return parent.getTokenType(backgroundIdentifier);
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

    public static ASTNode getScenarioDescriptionNode(ASTNode parent) {
        if (parent != null) {
            return parent.getNode(scenarioDescription);
        } else {
            return null;
        }
    }

    public static ASTToken getScenarioToken(ASTNode parent) {
        if (parent != null) {
            return parent.getTokenType(basicScenarioIdentifier);
        } else {
            return null;
        }
    }

    public static ASTToken getScenarioOutlineToken(ASTNode parent) {
        if (parent != null) {
            return parent.getTokenType(tableScenarioIdentifier);
        } else {
            return null;
        }
    }

// EXAMPLES --------------------------------------------------------------------
    public static ASTToken getExamplesToken(ASTNode parent) {
        if (parent != null) {
            return parent.getTokenType(examplesIdentifier);
        } else {
            return null;
        }
    }
// RESULT STRING ---------------------------------------------------------------

    public static String getResultString(ASTToken head, ASTNode body, String error_case) {
        if (head != null) {
            if (body != null) {
                return head.getIdentifier().trim() + ": " + body.getAsText().split("\n")[0].trim();
            } else {
                return head.getIdentifier().trim();
            }
        } else {
            return error_case;
        }
    }
}
