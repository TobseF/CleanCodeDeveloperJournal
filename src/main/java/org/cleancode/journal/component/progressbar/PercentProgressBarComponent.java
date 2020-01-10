package org.cleancode.journal.component.progressbar;

public class PercentProgressBarComponent extends ProgressBarComponent {

    private int value;
    private int maxValue;
    private boolean showDescription = false;

    public void setValue(int value) {
        this.value = value;
        getModel().setValue(String.valueOf(value));
        updateModel();
    }

    public void setMaxValue(int maxValue) {
        this.maxValue = maxValue;
        updateModel();
    }

    public void setLabel(String label) {
        getModel().setLabel(label);
    }

    public void setShowDescription(boolean showDescription) {
        this.showDescription = showDescription;
    }


    private void updateModel() {
        int progress = (maxValue == 0) ? 0 : (int) (((double) value / maxValue) * 100);
        getModel().setPercent(progress);
        if (showDescription) {
            getModel().setDescription(value + "/" + maxValue);
            getModel().setValue(progress + "%");
        }
    }
}
