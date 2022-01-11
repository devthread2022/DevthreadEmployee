package com.jvt.devthread.employee.Activity.Model;

public class SelectedFeatureModel {
    String featureIcon, featureName;

    public SelectedFeatureModel() {
    }

    public String getFeatureIcon() {
        return featureIcon;
    }

    public void setFeatureIcon(String featureIcon) {
        this.featureIcon = featureIcon;
    }

    public String getFeatureName() {
        return featureName;
    }

    public void setFeatureName(String featureName) {
        this.featureName = featureName;
    }

    public SelectedFeatureModel(String featureIcon, String featureName) {
        this.featureIcon = featureIcon;
        this.featureName = featureName;
    }
}
