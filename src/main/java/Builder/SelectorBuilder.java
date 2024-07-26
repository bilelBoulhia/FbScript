package Builder;

import BuilderInterfaces.IBuilder;

public class SelectorBuilder implements IBuilder {
    private StringBuilder elementPath;
    private String role;
    private String text;
    private String ariaLabel;
    private String className;


    private SelectorBuilder() {
        this.elementPath = new StringBuilder("//div");

    }

    public static SelectorBuilder create() {
        return new SelectorBuilder();
    }

    public SelectorBuilder withRole(String role) {
        this.role = role;
        return this;
    }

    public SelectorBuilder withSpanText(String text) {
        this.text = text;
        return this;
    }

    public SelectorBuilder withAriaLabel(String ariaLabel) {
        this.ariaLabel = ariaLabel;
        return this;
    }

    public SelectorBuilder withClass(String className) {
        this.className = className;
        return this;
    }


    public String build() {
        StringBuilder locator = new StringBuilder(elementPath);
        boolean condition = false;

        if (role != null || ariaLabel != null || className != null) {
            locator.append("[");

            if (role != null) {
                locator.append("@role='").append(role).append("'");
                condition = true;
            }

            if (ariaLabel != null) {
                if (condition) locator.append(" and ");
                locator.append("@aria-label='").append(ariaLabel).append("'");
                condition = true;
            }

            if (className != null) {
                if (condition) locator.append(" and ");
                locator.append("@class='").append(className).append("'");
            }

            locator.append("]");
        }

        if (text != null) {
            locator.append("/descendant::span[text()='").append(text).append("']");
        }


        return locator.toString();
    }
}






