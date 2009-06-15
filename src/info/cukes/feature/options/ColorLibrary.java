package info.cukes.feature.options;

import java.util.prefs.PreferenceChangeEvent;
import java.util.prefs.PreferenceChangeListener;
import java.util.prefs.Preferences;
import org.openide.util.NbPreferences;

public class ColorLibrary {

    private static String featureColor = "#3366CC";
    private static String scenarioColor = "#3366CC";
    private static String backgroundColor = "#336600";
    private static String stepsColor = "#3366CC";
    private static String examplesColor = "#336600";
    private static String stringsColor = "#FF9900";
    private static String pyStringsColor = "#663333";
    private static String numbersColor = "#336600";
    private static String variablesColor = "#336600";
    private static String commentsColor = "#8F8F8F";
    private static Preferences pref = NbPreferences.forModule(CucumberFeatureOptionsPanel.class);

    public void ColorLibrary() {

        String fColor = pref.get("featureColorPreference", featureColor);
        String sColor = pref.get("scenarioColorPreference", scenarioColor);

        pref.addPreferenceChangeListener(new PreferenceChangeListener() {

            public void preferenceChange(PreferenceChangeEvent evt) {
                if (evt.getKey().equals("featureColorPreference")) {
                    featureColor = evt.getNewValue();
                }
                if (evt.getKey().equals("scenarioColorPreference")) {
                    scenarioColor = evt.getNewValue();
                }
            }
        });
        featureColor = fColor;
        scenarioColor = sColor;
    }

    public static String getFeatureColor() {
        return pref.get("featureColorPreference", featureColor);
    }

    public static String getScenarioColor() {
        return pref.get("scenarioColorPreference", scenarioColor);
    }

    public static String getBackgroundColor() {
        return pref.get("backgroundColorPreference", backgroundColor);
    }

    public static String getStepsColor() {
        return pref.get("stepsColorPreference", stepsColor);
    }

    public static String getExamplesColor() {
        return pref.get("examplesColorPreference", examplesColor);
    }

    public static String getStringsColor() {
        return pref.get("stringsColorPreference", stringsColor);
    }
    
    public static String getPyStringsColor() {
        return pref.get("pyStringsColorPreference", pyStringsColor);
    }

    public static String getNumbersColor() {
        return pref.get("numbersColorPreference", numbersColor);
    }

    public static String getVariablesColor() {
        return pref.get("variablesColorPreference", variablesColor);
    }

    public static String getCommentsColor() {
        return pref.get("commentsColorPreference", commentsColor);
    }
}
